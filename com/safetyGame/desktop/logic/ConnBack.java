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
  
  public boolean continua(String server_da_grafica){
    boolean scritto= parser.scrivi(server_da_grafica);
    if (scritto){
      server=parser.leggi();
      if (server.trim().equals("")){
        System.out.println("Errore di lettura");
        System.exit(4);
      }
      return true;
    }
    else{
      return false;
    }
  } 
  
  public String getServer(){
    return server;
  }
    
  public boolean login(DatiLogin login){
    //back.login(login.getLogin());
    //chiama le funzioni del back - end
    loggato=login;
    return true;
  }
  
  public boolean logout(){
    //chiama le funzioni del back - end
    loggato=null;
    return false;
  }
  
  public boolean posticipa(){
    //chiama le funzioni del back - end
    return false;
  }
  
  public boolean recupera(Recupero rec){
    //chiama le funzioni del back - end
    return false;
  }
  
  public boolean isLogged(){
    return loggato!=null;
  }
}
