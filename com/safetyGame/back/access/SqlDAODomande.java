package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlDAODomande implements DAODomande{
  private Indirizzo serverDomande;
  private Indirizzo serverAzienda;
  
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
      testod= rs.getString("testo domanda");
      d.setTesto(testod);
      mobile= rs.getBoolean("mobile");
      d.setMobile(mobile);
      tempo= rs.getInt("tempo");
      d.setTempo(tempo);
      ambito= rs.getString("ambito");
      d.setAmbito(ambito);
    }
    catch(SQLException e){return null;}  
    rs=serverDomande.selezione("Risposta INNER JOIN Domanda-Risposta ON ID=IDr","*","ID="+id,"ORDER BY IDd ASC");
    Boolean trovato = false;
    ArrayList <String> risposte=new ArrayList<String>();
    String testor;
    Boolean corretta;
    int i=0;
    int contatoreCorretta=-1;
    corretta=false;
    while (!trovato){
      try{
        corretta= rs.getBoolean("risposta corretta");
        testor=rs.getString("testo");
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
  
  public SqlDAODomande(Indirizzo azienda, Indirizzo domande){
    serverAzienda=azienda;
    serverDomande=domande;
  }
    
  public Domanda getDomanda(Dipendente d){
    //ritorna una domanda
    return new Domanda();
  }
  public boolean posticipa(Dipendente d, Domanda dom){
    //posticipa il timer e salva la domanda
    return true;
  }
  public boolean rispondi(Dipendente d, Domanda dom){
    //imposta la risposta data
    return true;
  }
  
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
  
  public boolean addDomanda(Domanda d){
    //aggiunge una domanda
    return true;
  }
  public boolean remDomanda(Domanda d){
    //rimuove una domanda
    return true;
  }
  public boolean scriviSottoposta(Dipendente dip, Domanda dom){
    //che scrive sul DB che la domanda dom è stata sottoposta al Dipendente dip  
    return true;
  }
}