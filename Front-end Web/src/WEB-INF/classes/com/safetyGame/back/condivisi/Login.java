/*
 * Name: Login.java
 * Package: com.safetygame.back.condivisi
 * Author: Alessandro Cornaglia
 * Date: {Data di approvazione del file}
 * Version: 0.2
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120527 |Alessandro Cornaglia | + getUsername
 * |          |                     | + setUsername
 * |          |                     | + getPassword
 * |          |                     | + setPassword
 * |          |                     | - getDipendente
 * |          |                     | - setDipendente
 * |          |                     | - getDataOra
 * |          |                     | - setDataOra
 * |          |                     | - isAutenticato
 * |          |                     | - setAutenticato
 * |          |                     | * Login
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
 package safetyGame.back.condivisi;

/**
 * Classe contenitrice dei dati di autenticazione di un utente
 * 
 * @author TeamCommitted
 * @version 0.2
 * 
 */
public class Login {
	
  private String username;
  private String password;
  
  /**
   * Costruttore con parametri della classe Login
   * 
   * @param u username utente
   * @param p password utente
   */
  public Login(String u, String p) {
    this.username = u;
    this.password = p;
  }
  
  /**
   * Costruttore senza parametri della classe Login
   */
  public Login() {
    this.username = null;
    this.password = null;
  }
  
  /**
   * metodo che consente di recuperare lo username del login
   * 
   * @return username del login
   */
  public String getUsername() {
    return username;
  }

  /**
   * metodo che consente di impostare lo username del login
   * 
   * @param username username del login da impostare
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * metodo che consente di recuperare la password del login
   * 
   * @return password del login
   */
  public String getPassword() {
    return password;
  }

  /**
   * metodo che consente di impostare la password del login
   * 
   * @param password password del login da impostare
   */
  public void setPassword(String password) {
    this.password = password;
  }
  /*INIZIO CODICE VECCHIO
    private Dipendente dipendente;// se non è ancora autenticato avrà solo i campi nick e password	
   
  private DataOra dataOra;
  private boolean autenticato;	//serve a sapere se un utente è attualmente autenticato nel sistema
  /**
   * Costruttore con parametri della classe Login
   * 
   * @param dipendente dipendente che ha effettuato il login
   * @param dataOra data e ora in cui è stato effettuato il login
   * 
   *
  public Login(Dipendente dipendente, DataOra dataora, boolean autenticato) {
    this.dipendente = dipendente; 
    this.dataOra = dataora;
    this.autenticato = autenticato;
  }
		
  /**
   * Costruttore senza parametri della classe Login
   * 
   *
  public Login() {
    this.dipendente = null;
    this.dataOra = null;
  }

  /**
   * metodo che consente di recuperare il dipendente
   * 
   * @return dipendente
   *
  public Dipendente getDipendente() {
    return dipendente;
  }

  /**
   * metodo che consente di impostare un dipendente
   * 
   * @param dipendente dipendente da impostare
   *
  public void setDipendente(Dipendente dipendente) {
    this.dipendente = dipendente;
  }

  /**
   * metodo che consente di recuperare l'ora e la data del login
   * 
   * @return data e ora del login
   *
  public DataOra getDataOra() {
    return dataOra;
  }

  /**
   * metodo che consente di impostare la data e l'ora
   * 
   * @param dataOra data e ora da impostare
   *
  public void setDataOra(DataOra dataOra) {
    this.dataOra = dataOra;
  }  
  
  /**
   * metodo che consente di conoscere se l'utente è attualmente autenticato
   * 
   * @return booleano se utente è attualmente autenticato
   *
  public boolean isAutenticato() {
	return autenticato;
  }

  /**
   * metodo che consente di impostare se un utente è attualmente autenticato
   * 
   * @param autenticato booleano se utente è attualmente autenticato
   *
  public void setAutenticato(boolean autenticato) {
    this.autenticato = autenticato;
  }
 	FINE CODICE VECCHIO*/
}
	
