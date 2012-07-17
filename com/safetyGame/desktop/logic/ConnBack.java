/*
 * Name: ConnBack.java
 * Package: com.safetygame.desktop.logic
 * Author: Gabriele Facchin
 * Date: 
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120711 | Gabriele Facchin    | + ConnBack
 * |          |                     | + getIstance
 * +----------+---------------------|---------------------
 * | 201207 | Gabriele Facchin    | + 
 * +----------+---------------------|---------------------
 *
 */


package com.safetyGame.desktop.logic;

import com.safetyGame.desktop.condivisi.*;
import com.safetyGame.desktop.view.Richiesta;
import java.io.*;
import java.rmi.*;
import java.net.UnknownHostException;

/**
 * ConnBack.java
 *
 * @author gfacchin
 * @version 0.1
 */
public class ConnBack {
    
  private static ConnBack singleton = null;
  private DatiLogin loggato;
  private String server;
  private Parser parser;
  private Pacchetto pack;
  private Domanda da_rispondere;
    
  /** 
   * Costrutture della classe ConnBack
   */
  private ConnBack() {
    loggato=null;
    parser=new Parser();
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
  
  public void continuaRMI(){
     try{
         pack= (Pacchetto) Naming.lookup("rmi://"+server.trim()+"/Pacchetto");
     }
     catch(Exception e){System.out.println("Errore nella creazione della connessione al server RMI"); System.exit(9);} //remote-bound-io-etc..
     //il server dei dati e' aperto
  } 
  
  public String getServer(){
    return server;
  }
  
  public boolean login(DatiLogin login){
    boolean prova_login;
    try{
      prova_login=pack.login(login.getUsername(), login.getPassword());
    }
    catch(RemoteException e){prova_login=false;}
    if (prova_login)
      loggato=login;
    return prova_login;
  }
  
  public void logout(){
    try{
      pack.logout(loggato.getLogin());
      loggato=null;
    }
    catch(RemoteException e){}
  }
  
  private void preleva_domanda(){
    try{
      da_rispondere=pack.mostra_domanda(loggato.getLogin());
    }
    catch(RemoteException e){da_rispondere=null;}
  }
  
  public boolean posticipa(){
    preleva_domanda();
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
  
  public boolean recupera(Recupero rec){
    boolean recuperata;
    try{
      recuperata=pack.recupera(rec);
    }
    catch(RemoteException e){recuperata=false;}
    return recuperata;
  }
  
  public boolean isLogged(){
    return loggato!=null;
  }
}
