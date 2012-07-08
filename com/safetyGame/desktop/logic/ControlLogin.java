package com.safetyGame.desktop.logic;

public class ControlLogin{
  private String testo;
  private ConnBack connessione;
  public ControlLogin(){
    connessione=ConnBack.getInstance();
  }
  
  public boolean tryLogin(String username, String password){
    return connessione.login(username,password);
  }
  
  public boolean recupera(String username){
    return connessione.recupera(username);
  }
}
