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

/**
 * ConnBack.java
 *
 * @author gfacchin
 * @version 0.1
 */
public class ConnBack {
    
  private static ConnBack singleton = null;
  private DatiLogin loggato;
    
  /** 
   * Costrutture della classe ConnBack
   */
  private ConnBack() {
    loggato=null;
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
    
  public boolean login(DatiLogin login){
    //back.login(login.getLogin());
    //chiama le funzioni del back - end
      loggato=login;
    return false;
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
