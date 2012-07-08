package com.safetyGame.desktop.logic;

public class ControlNotifica{
  String testo;
  ConnBack connessione;
  public ControlNotifica(){
    connessione=ConnBack.getInstance();
  }

  public void posticipa(){
    connessione.posticipa();
  }
  
  public void rispondi(){
    //apre il browser con la domanda
  }
}
