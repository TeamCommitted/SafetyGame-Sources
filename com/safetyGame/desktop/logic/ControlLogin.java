package com.safetyGame.desktop.logic;

public class ControlLogin{
  String testo;
  ConnBack connessione;
  public ControlLogin(String s, ConnBack cb){
    testo= s;
    connessione=cb;
    testo="Inserisci username e password";
  }
  
  public void tryLogin(String username, String password){
    connessione.login(username,password);
  }
}
