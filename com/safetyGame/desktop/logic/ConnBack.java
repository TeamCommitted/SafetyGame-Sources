/*
 * Name: ConnBack.java
 * Package: com.safetygame.desktop.logic
 * Author: Gabriele Facchin
 * Date: 
 * Version: 0.2
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120711 | Gabriele Facchin    | + ConnBack
 * |          |                     | + getIstance
 * +----------+---------------------|---------------------
 * | 20120720 | Gabriele Facchin    | + continuaParser
 * |          |                     | + continuaRMI
 * |          |                     | + getServer
 * |          |                     | + login
 * |          |                     | + logout
 * |          |                     | + preleva_domanda
 * |          |                     | + posticipa
 * |          |                     | + recupera
 * |          |                     | + notificaDomanda
 * |          |                     | + mayApplyForNewQuestion
 * |          |                     | + resetTimerRichiesta
 * |          |                     | + resetTimerProposta
 * |          |                     | + isLogged
 * |          |                     | + userLoggato
 * |          |                     | + passUserLoggato
 * +----------+---------------------|---------------------
 *
 */


package com.safetyGame.desktop.logic;

import com.safetyGame.desktop.condivisi.*;
import com.safetyGame.desktop.view.Notifica;
import com.safetyGame.desktop.view.Richiesta;
import com.safetyGame.desktop.view.Error;
import java.io.*;
import java.rmi.*;
import java.net.UnknownHostException;

/**
 * ConnBack.java
 *
 * @author gfacchin
 * @version 0.2
 */

public class ConnBack {
    
  private static ConnBack singleton = null;
  private DatiLogin loggato;
  private String server;
  private Parser parser;
  private Pacchetto pack;
  private Domanda da_rispondere;
  private Timer timer_proponi;
  private Timer timer_chiedi;
  private long tempo_proposta=120000; //2 minuti
  private long tempo_richiesta=300000; //5 minuti
  private boolean pop; // evita che si possa effettuare il logout quando vi sono finestre di nuova domanda aperte
    
  /** 
   * Costrutture iniziale della classe ConnBack, chiede la stringa del server se non è stata impostata.
   */
  private ConnBack() {
    loggato=null;
    parser=new Parser();
    timer_chiedi=new Timer(0,0);
    timer_proponi=new Timer(0,1);
    timer_proponi.start();
    timer_chiedi.start();
    pop=false;
    if (!parser.isOpen()){
       Richiesta domanda_server=new Richiesta();
    }
    else{
      server=parser.leggi();
      if (server.trim().equals("")){
        Richiesta domanda_server=new Richiesta();
      }
      else{
        continuaRMI();
      }
    }
  }
    
  /**
   * Metodo che ritorna l'unica istanza della classe valida
   * 
   * @return unico oggetto ConnBack 
   * 
   */
  public static ConnBack getInstance(){
    if(singleton == null){
      singleton = new ConnBack();
    }
    return singleton;
  }

  /**
   * Metodo fa continuare la costruzione dell'oggetto ConnBack (seconda parte) una volta che è stata ottenuta la stringa con l'indirizzo del server.
   * Inserisce nel file server.txt l'indirizzo
   * 
   * @return booleano che indica la corretta scrittura nel file server (true)
   * 
   */  
  public boolean continuaParser(String server_da_grafica){
    boolean scritto= parser.scrivi(server_da_grafica);
    if (scritto){
      server=parser.leggi();
      if (server.trim().equals("")){
        System.out.println("Errore di lettura");
        System.exit(5);
      }
      return true;
    }
    else{
      return false;
    }
  } 
  
  /**
   * Metodo che continua la creazione dell'oggetto ConnBack creando la connessione al server RMI
   * 
   */  
  public void continuaRMI(){
     try{
         pack= (Pacchetto) Naming.lookup("rmi://localhost/Pacchetto");
     }
     catch(Exception e){ //remote-bound-io-etc..
         System.out.println("Errore nella creazione della connessione al server RMI"); 
         System.exit(9);
     }
     //il server dei dati e' aperto
  } 
  
  /**
   * Metodo che ritorna il server
   * 
   * @return string contenente l'indirizzo del server
   * 
   */  
  public String getServer(){
    return server;
  }
  
  /**
   * Metodo che effettua il login con il backend e istanzia le corrette variabili per l'applicazione
   * 
   * @return boolean che indica se il login è stato o meno fatto
   * 
   */  
  public boolean login(DatiLogin login){ 
    boolean prova_login;
    try{
      prova_login=pack.login(login.getUsername(), login.getPassword());
    }
    catch(RemoteException e){prova_login=false;}
    if (prova_login){
      loggato=login;
      resetTimerRichiesta();
      resetTimerProposta();
    }
    return prova_login;
  }
  
  /**
   * Metodo che effettua il logout con il backend e cambia i valori corretti delle variabili per l'applicazione
   * 
   * @return boolean che indica se il logout è stato o meno fatto
   * 
   */   
  public void logout(){ 
    if (!pop){
      try{
        pack.logout(loggato.getLogin());
        loggato=null;
        timer_proponi.setTempo(0);
        timer_chiedi.setTempo(0);
      }
      catch(RemoteException e){
        new Error ("Logout sul server non avvenuto, l'applicazione effettuerà comunque il logout");
      }
    }
  }
  
  /**
   * Metodo che richiede una domanda al backend
   * 
   */  
  private void preleva_domanda(){
    try{
      da_rispondere=pack.mostra_domanda(loggato.getLogin());
    }
    catch(RemoteException e){da_rispondere=null;}
  }
  
  /**
   * Metodo che avvisa il backend che una domanda è stata posticipata
   * 
   * @return boolean che indica se il beckend è stato o meno avvisato della scelta di posticipare la domanda da parte del dipendente
   * 
   */  
  public boolean posticipa(){
    if (da_rispondere==null){
      preleva_domanda();
    }
    if (da_rispondere==null){
      return false;
    }
    else{
      boolean posticipata;
      try{
        posticipata=pack.posticipa(loggato.getLogin(),da_rispondere);
      }
      catch(RemoteException e){posticipata=false;}
      return posticipata;
    }
  }
  
  /**
   * Metodo che invia i dati per il recupero della password
   * 
   * @return boolean che indica se la password è stata rigenerata correttamente o no
   * 
   */  
  public boolean recupera(Recupero rec){
    boolean recuperata;
    try{
      recuperata=pack.recupera(rec);
    }
    catch(RemoteException e){recuperata=false;}
    return recuperata;
  }
  
  /**
   * Metodo che crea la notifica di una nuova domanda
   * 
   */  
  public void notificaDomanda(){
    if (isLogged()){
      Notifica n=new Notifica(new ControlNotifica());
      pop=true;
    }
  }
  
  /**
   * Metodo che verifica la possibilità di richiedere una domanda
   * 
   * @return boolean che indica se è possibile richiedere una domanda o no
   * 
   */  
  public boolean mayApplyForNewQuestion(){
    if (pop)
      return false;
    return timer_chiedi.isFinito();
  }

  /**
   * Metodo che resetta il timer della domanda richiesta dal dipendente
   * 
   */  
  public void resetTimerRichiesta(){
    timer_chiedi.setTempo(tempo_richiesta);
  }
  
  /**
   * Metodo che resetta il timer della domanda proposta dall'applicazione
   * 
   */  
  public void resetTimerProposta(){
    timer_proponi.setTempo(tempo_proposta);
    da_rispondere=null;
    pop=false;
  }
  
  /**
   * Metodo che indica se un dipendete è loggato o no
   * 
   * @return boolean true se il dipendente è loggato, false altrimenti
   * 
   */  
  public boolean isLogged(){
    return loggato!=null;
  }
  
  /**
   * Metodo che ritorna lo username del dipendente loggato
   * 
   * @return string contenente l'username
   * 
   */  
  public String userLoggato(){
    if (isLogged())
      return  loggato.getUsername();
    return "";
  }
  
  /**
   * Metodo che ritorna la password del dipendente loggato
   * 
   * @return string contenente la password
   * 
   */  
  public String passUserLoggato(){
    if (isLogged())
      return loggato.getPassword();
    return "";
  }
}
