
package com.safetyGame.desktop.logic;
/**
 * ConnBack2.java
 *
 * @author 
 * @version 0.1
 */
public class ConnBack {
    
  private static ConnBack singleton = null;
  private boolean loggato;
    
  /** 
   * Costrutture della classe ConnBack
   */
  private ConnBack() {
    loggato=false;
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
    
      public boolean login(String username, String password){
    //chiama le funzioni del back - end
    return false;
  }
  
  public boolean logout(String username){
    //chiama le funzioni del back - end
    return false;
  }
  
  public boolean posticipa(){
    //chiama le funzioni del back - end
    return false;
  }
  
  public boolean recupera(String username){
    //chiama le funzioni del back - end
    return false;
  }
  
  public boolean isLogged(){
    return loggato;
  }
}
