package com.safetyGame.desktop.logic;

public class ControlNotifica{
  String testo;
  ConnBack connessione;
  public ControlNotifica(String s, ConnBack cb){
    testo= s;
    connessione=cb;
    testo="Ti è stata proposta una domanda, vuoi rispondere?";
  }

  public void posticipa(){
    connessione.posticipa();
  }
  
  public void rispondi(){
    //apre il browser con la domanda
  }
}
