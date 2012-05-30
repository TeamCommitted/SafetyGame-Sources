/*
 * Name: DAODomande.java
 * Package: com.safetygame.back.access
 * Author: Gabriele Facchin
 * Date: {Data di approvazione del file}
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120528 | Gabriele Facchin    | + SqlDAODomande
 * |          |                     | + prendiCampiDomanda
 * |          |                     | + getDomanda
 * |          |                     | + posticipa                
 * |          |                     | + rispondi
 * |          |                     | + domandeA
 * |          |                     | + addDomanda
 * |          |                     | + remDomanda
 * |          |                     | + scriviSottoposta
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe che gestisce le Domande, implementa i metodi pubblici dell'interfaccia
 * 
 * @author gfacchin
 * @version 0.1
 */

public class SqlDAODomande implements DAODomande{
  private Indirizzo serverDomande;
  private Indirizzo serverAzienda;
  
  /**
   * Costruttore della classe SqlDAODomande
   */
  public SqlDAODomande(Indirizzo azienda, Indirizzo domande){
    serverAzienda=azienda;
    serverDomande=domande;
  }
  
  /**
   * Metodo che prende i campi di una Domanda
   * 
   * @param id intero che identifica la domanda
   * @return l'oggetto Domanda con i campi corretti
   * 
   */   
  private Domanda prendiCampiDomanda(int id){
    ResultSet rs=serverDomande.selezione("Tipologia as t INNER JOIN Domanda as d ON d.tipologia=t.tipologia","*","ID="+id,"");
    Domanda d=new Domanda();
    Punteggio p;
    String tipologia, testod, ambito;
    Boolean mobile;
    int tempo;
    try{
      d.setId(id);
      p=new Punteggio(rs.getInt("punteggio"));
      d.setPunteggio(p);
      tipologia= rs.getString("tipologia");
      d.setTipologia(tipologia);
      testod= rs.getString("testo_domanda");
      d.setTesto(testod);
      mobile= rs.getBoolean("mobile");
      d.setMobile(mobile);
      tempo= rs.getInt("tempo");
      d.setTempo(tempo);
      ambito= rs.getString("ambito");
      d.setAmbito(ambito);
    }
    catch(SQLException e){return null;}  
    rs=serverDomande.selezione("Risposta INNER JOIN Domanda_Risposta ON ID=IDr","*","ID="+id,"ORDER BY IDr ASC");
    Boolean trovato = false;
    ArrayList <String> risposte=new ArrayList<String>();
    String testor;
    Boolean corretta;
    int i=0;
    int contatoreCorretta=-1;
    corretta=false;
    while (!trovato){
      try{
        corretta= rs.getBoolean("risposta_corretta");
        testor=rs.getString("testo_risposta");
        risposte.add(testor);
      }
      catch(SQLException e){trovato=true;}
      if (corretta){
        contatoreCorretta=i;
      }
      i++;
    }
    d.setCorretta(contatoreCorretta);
    d.setRisposte(risposte);
    return d;
  }
  
  /**
   * Metodo che preleva una domanda per il Dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return l'oggetto Domanda che contiene una domanda
   * 
   */   
  public Domanda getDomanda(Dipendente d){
    ResultSet rs=serverAzienda.selezione("Storico","ID","IDdipendente="+d.getId()+" AND punteggio=-1","");
    int id=-1;
    boolean domanda=true;
    try{
      id=rs.getInt("ID");
    }
    catch(SQLException e){domanda=false;}  
    if (!domanda){//non c'è una domanda non risposta, devo prelevare una nuova domanda, mi costruisco un insieme di domande corrette per l'utente (errate + non risposte)
      rs=serverAzienda.selezione("Storico as s RIGHT JOIN Domanda as d ON s.IDdomanda=d.ID","d.ID","IDdipendente="+d.getId()+" AND (punteggio=0 OR punteggio=null)","");
      ArrayList<Integer> idQuery = new ArrayList<Integer>();
      boolean trovato=false;
      while(!trovato){
        try{
          id=rs.getInt("ID");
          idQuery.add(id);
        }
        catch(SQLException e){trovato=true;}
      }
      Random r=new Random();
      id=r.nextInt(idQuery.size());
      id=idQuery.get(id);
    }
    //c'è una domanda all'interno dello storico a cui l'utente non ha ancora risposto (id non modificato) oppure ne ho prelevata una (id modificato)
    return prendiCampiDomanda(id);
  }
  
  /**
   * Metodo che posticipa una domanda sottoposta ad un dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione è andata o meno a buon fine
   * 
   */   
  public boolean posticipa(Dipendente d, Domanda dom){
    return serverAzienda.modificaRiga("Storico","punteggio=-1","IDdipendente="+d.getId()+" AND IDdomanda="+dom.getId());
  }
  
  /**
   * Metodo che imposta la risposta di una domanda sottoposta ad un dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione è andata o meno a buon fine
   * 
   */   
  public boolean rispondi(Dipendente d, Domanda dom){
    int punti;
    if(dom.getRispostaData()==-1){
      punti=0;
    }
    else{
      if(dom.getRispostaData()==dom.getCorretta()){
        punti=dom.getPunteggio().getPunti();
      }
      else{
        punti=(dom.getPunteggio().getPunti())/2;
      }
    }
    return serverAzienda.modificaRiga("Storico","punteggio="+punti,"IDdipendente="+d.getId()+" AND IDdomanda="+dom.getId());
  }

  /**
   * Metodo che ritorna l'elenco di Domande dell'azienda
   * 
   * @return ArrayList che contiene l'elenco di tutte le Domande
   * 
   */   
  public ArrayList<Domanda> domandeA(){
    ResultSet rs=serverAzienda.selezione("Domanda","ID","","ORDER BY ID ASC");
    ArrayList<Integer> id = new ArrayList<Integer>();
    boolean trovato = false;
    int ID;
    while(!trovato){
      try{
        ID = rs.getInt("ID");
        id.add(ID);      
        rs.next();
      }
      catch(SQLException e){trovato=true;}  
    }
    //ho preso tutte le domande del database interno dell'azienda
    ArrayList <Domanda> domande=new ArrayList<Domanda>();
    int i=0;
    Domanda d=prendiCampiDomanda(i);
    while(d!=null){
      domande.add(d);
      i++;
      d=prendiCampiDomanda(i);
    }
    trovato=false;
    for (i=0; i<domande.size(); i++){
      for (int j=0; j<id.size() || !trovato; j++){
        if(domande.get(i).getId() == id.get(j)){
          trovato=true;
          domande.get(i).setInternaAzienda(true);
        }
      }
      trovato = false;
    }
    return domande;
  }

  /**
   * Metodo che aggiunge una Domanda al database dell'azienda
   * 
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione è andata o meno a buon fine
   * 
   */   
  public boolean addDomanda(Domanda d){
    String s[]=new String[0];
    s[0]=""+d.getId();
    return serverAzienda.inserisciRiga("Domanda","ID",s);
  }
  
  /**
   * Metodo che rimuove una Domanda dal database dell'azienda
   * 
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione è andata o meno a buon fine
   * 
   */   
  public boolean remDomanda(Domanda d){
    return serverAzienda.cancellaRiga("Domanda","ID="+d.getId());
  }
  
  /**
   * Metodo che scrive sul database che una domanda è stata proposta al Dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione è andata o meno a buon fine
   * 
   */   
  public boolean scriviSottoposta(Dipendente dip, Domanda dom){
    return serverAzienda.modificaRiga("Storico","punteggio=0","IDdipendente="+dip.getId()+" AND IDdomanda="+dom.getId());
  }
}