package com.safetyGame.desktop.logic;

public class Parser{
    public Parser(){
      //apre la comunicazione verso un file txt in cui vengono immessi i dati del back-end
      //se non riesce ad aprire in lettura il file --> non esiste il file --> bisogna chiedere all'utente di inserire l'indirizzo
    }

    public String leggi(){
      //legge la stringa dei dati del server dal file aperto
      return "";
    }
    
    public boolean scrivi(String s){
      //scrive, in caso di insuccesso nell'apertura del file in lettura, la stringa contenente i dati per l'accesso al server. 
      //se non esiste il file in scrittura, esso viene creato dal metodo di java
      return false;
    }
}
