/*
 * Name: Login.java
 * Package: com.safetygame.back.condivisi
 * Author: Alessandro Cornaglia
 * Date: {Data di approvazione del file}
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120424 |Alessandro Cornaglia | + Login
 * |          |                     | + getDipendente
 * |          |                     | + setDipendente
 * |          |                     | + getDataOra
 * |          |                     | + setDataOra
 * |          |                     | + isAutenticato
 * |          |                     | + setAutenticato
 * +----------+---------------------|---------------------
 *
 */
 package com.safetyGame.back.condivisi;

/**
 * Classe contenitrice dei dati di autenticazione di un utente
 * 
 * @author TeamCommitted
 * @version 0.1
 * 
 */
public class Login {
	
  private Dipendente dipendente;// se non è ancora autenticato avrà solo i campi nick e password	
  private DataOra dataOra;
  private boolean autenticato;	//serve a sapere se un utente è attualmente autenticato nel sistema
  /**
   * Costruttore con parametri della classe Login
   * 
   * @param dipendente dipendente che ha effettuato il login
   * @param dataOra data e ora in cui è stato effettuato il login
   * 
   */
  public Login(Dipendente dipendente, DataOra dataora, boolean autenticato) {
    this.dipendente = dipendente; 
    this.dataOra = dataora;
    this.autenticato = autenticato;
  }
		
  /**
   * Costruttore senza parametri della classe Login
   * 
   */
  public Login() {
    this.dipendente = null;
    this.dataOra = null;
  }

  /**
   * metodo che consente di recuperare il dipendente
   * 
   * @return dipendente
   */
  public Dipendente getDipendente() {
    return dipendente;
  }

  /**
   * metodo che consente di impostare un dipendente
   * 
   * @param dipendente dipendente da impostare
   */
  public void setDipendente(Dipendente dipendente) {
    this.dipendente = dipendente;
  }

  /**
   * metodo che consente di recuperare l'ora e la data del login
   * 
   * @return data e ora del login
   */
  public DataOra getDataOra() {
    return dataOra;
  }

  /**
   * metodo che consente di impostare la data e l'ora
   * 
   * @param dataOra data e ora da impostare
   */
  public void setDataOra(DataOra dataOra) {
    this.dataOra = dataOra;
  }  
  
  /**
   * metodo che consente di conoscere se l'utente è attualmente autenticato
   * 
   * @return booleano se utente è attualmente autenticato
   */
  public boolean isAutenticato() {
	return autenticato;
  }

  /**
   * metodo che consente di impostare se un utente è attualmente autenticato
   * 
   * @param autenticato booleano se utente è attualmente autenticato
   */
  public void setAutenticato(boolean autenticato) {
    this.autenticato = autenticato;
  }

}
	
