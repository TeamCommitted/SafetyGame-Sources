package com.safetyGame.desktop.logic;

public class ControlLogin{
  private String testo;
  private ConnBack connessione;
  public ControlLogin(String s, ConnBack cb){
    testo= s;
    connessione=cb;
    testo="Inserisci username e password";
  }
  
  public boolean tryLogin(String username, String password){
    return connessione.login(username,password);
  }
  
  public boolean recupera(String username){
    return connessione.recupera(username);
  }
}
