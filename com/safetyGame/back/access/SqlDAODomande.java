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
  public void posticipa(String username){
    //posticipa il timer e salva la domanda
  }
  public void rispondi(String username, String risposta){
    //imposta la risposta data
  }
  public Domanda[] domandeA(boolean interne){
    //mostra le domande all'AS
    Domanda[] d=new Domanda[1];
    return d;
  }
  public void addDomanda(int id){
    //aggiunge una domanda
  }
  public void remDomanda(int id){
    //rimuove una domanda
  }
  public void scriviSottoposta(Domanda dom, Dipendente dip){
    //che scrive sul DB che la domanda dom è stata sottoposta al Dipendente dip  
  }
}