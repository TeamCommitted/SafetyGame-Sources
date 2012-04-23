/*
 * Name: Login.java
 * Package: com.safetyGame.back.condivisi
 * Author: Alessandro Cornaglia
 * Date:
 * Version: 0.1
 * Copyright: 
 * 
 * Changes:
 * +----------------+---------------+-------------------------+
 * |      Date      |   Programmer  |         Changes         |
 * +----------------+---------------+-------------------------+
 * |   2012/03/02   |    AlesCorn   | +Login()                |		
 */
 
 package com.safetyGame.back.condivisi;
 import com.safetyGame.back.controller.*;


/**
 * Classe contenitrice dei dati di autenticazione di un utente
 * 
 * @author TeamCommitted
 * @version 0.1
 * 
 */
public class Login {
	
  private Dipendente dipendente;	
  private DataOra dataOra;
	
  /**
   * Costruttore con parametri della classe Login
   * 
   * @param dipendente dipendente che ha effettuato il login
   * @param dataOra data e ora in cui è stato effettuato il login
   * 
   */
  public Login(Dipendente dipendente, DataOra dataora) {
    this.dipendente = dipendente; 
    this.dataOra = dataora;
  }
		
  /**
   * Costruttore senza parametri della classe Login
   * 
   */
  public Login() {
    dipendente = null;
    dataOra = null;
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
  
}
	
