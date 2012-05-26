package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

public class SqlDAODomande implements DAODomande{
  private Indirizzo serverDomande;
  private Indirizzo serverAzienda;
  
  public SqlDAODomande(Indirizzo azienda, Indirizzo domande){
    serverAzienda=azienda;
    serverDomande=domande;
  }
    
  public Domanda getDomanda(Dipendente d){
    //ritorna una domanda
    return new Domanda();
  }
  public boolean posticipa(Dipendente d, Domanda dom){
    //posticipa il timer e salva la domanda
    return true;
  }
  public boolean rispondi(Dipendente d, Domanda dom){
    //imposta la risposta data
    return true;
  }
  public Domanda[] domandeA(){
    //mostra le domande all'AS se sono interne all'azienda = true altrimenti = false
    Domanda[] d=new Domanda[1];
    return d;
  }
  public boolean addDomanda(Domanda d){
    //aggiunge una domanda
    return true;
  }
  public boolean remDomanda(Domanda d){
    //rimuove una domanda
    return true;
  }
  public boolean scriviSottoposta(Dipendente dip, Domanda dom){
    //che scrive sul DB che la domanda dom è stata sottoposta al Dipendente dip  
    return true;
  }
}