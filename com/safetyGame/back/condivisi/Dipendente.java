/*
 * Name: Dipendente.java
 * Package: com.safetyGame.back.condivisi
 * Author: 
 * Date: 
 * Version: 0.1
 * Copyright:
 */

package com.safetyGame.back.condivisi;

import java.util.ArrayList;
/**
 * Classe che rappresenta un dipendente dell'azienda
 * 
 * @author acornagl 
 * @version 0.1
 * 
 */

public class Dipendente {
	
  private String codFiscale;
  private ArrayList<Trofeo> trofei;
  private Punteggio punteggio;
  private String nome;
  private String cognome;
  private String email;
  private String nickname;
  private String password;
  private String ruolo;

  /**
   * Costruttore della classe Dipendente, senza parametri
   */
  public Dipendente() {
    this.codFiscale = null;
    this.trofei = new ArrayList<Trofeo>();
    this.punteggio = null;
    this.nome = null;
    this.cognome = null;
    this.email = null;
    this.nickname = null;
    this.password = null;
    this.ruolo = null;
  }
  
  /**
   * Costruttore della classe Dipendente con parametri
   * 
   * @param cf codice fiscale
   * @param n nome
   * @param c cognome
   * @param e email
   * @param nn nickname
   * @param p password
   * @param r ruolo 
   */
  public Dipendente(String cf, String n, String c, String e, String nn, String p, String r, int pu) {
    this.codFiscale = cf;
    this.nome = n;
    this.cognome = c;
    this.email = e;
    this.nickname = nn;
    this.password = p;
    this.ruolo = r;
    this.trofei = new ArrayList<Trofeo>();
    this.punteggio = new Punteggio(pu);
  }

  /**
   * metodo get per codice fiscale
   * 
   * @return codice fiscale
   */
  public String getCodFiscale() {
    return codFiscale;
  }

  /**
   * metodo per inserire o modificare il codice fiscale
   * 
   * @param codFiscale codice fiscale da settare
   */
  public void setCodFiscale(String codFiscale) {
    this.codFiscale = codFiscale;
  }

  /**
   * metodo che restituisce la lista di trofei di un dipendente
   * 
   * @return lista di trofei
   */
  public ArrayList<Trofeo> getTrofei() {
    return trofei;
  }

  /**
   * metodo che consente di aggiungere un trofeo ad un dipendente
   *  
   * @param trofeo trofeo da aggiungere
   * @throws ErrDipendente
   */
  public void addTrofeo(Trofeo trofeo) throws ErrDipendente{
    boolean inserito = false;
    inserito = this.trofei.add(trofeo);
    if ( !inserito ) {  //se non è stato inserito allora sollevo eccezz.
    	throw new ErrDipendente(1){};
    }	
  }

  /**
   * metodo che consente di recuperare il punteggio di un dipendente
   * 
   * @return punteggio del dipendente
   */
  public Punteggio getPunteggio() {
    return punteggio;
  }

  /**
   * metodo che consente di settare il punteggio di un dipendente
   * 
   * @param punteggio punteggio da settare
   */
  public void setPunteggio(Punteggio punteggio) {
    this.punteggio = punteggio;
  }

  /**
   * metodo che consente di recuperare il nome del dipendente
   * 
   * @return nome dipendente
   */
  public String getNome() {
    return nome;
  }

  /**
   * metodo che consente di settare il nome del dipendente
   * 
   * @param nome da impostare
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * metodo che consente di recuperare il cognome del dipendente
   * 
   * @return cognome dipendente
   */
  public String getCognome() {
    return cognome;
  }

  /**
   * metodo che consente di settare il cognome del dipendente
   * 
   * @param cognome da impostare
   */
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * metodo che consente di recuperare la email del dipendente
   * 
   * @return email dipendente
   */
  public String getEmail() {
    return email;
  }

  /**
   * metodo che consente di impostare l'indirizzo email del dipendente
   *
   * @param email da impostare
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * metodo che consente di recuperare il nickname del dipendente
   * 
   * @return nickname dipendente
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * metodo che consente di impostare il nickname del dipendente
   * 
   * @param nickname da impostare
   */
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  /**
   * metodo che consente di recuperare la password del dipendente
   * 
   * @return password del dipendente
   */
  public String getPassword() {
    return password;
  }

  /**
   * metodo che consente di impostare la password del dipendente
   * 
   * @param password da impostare
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * metodo che consente di recuperare il ruolo del dipendente
   * 
   * @return ruolo del dipendente
   */
  public String getRuolo() {
    return ruolo;
  }

  /**
   * metodo che consente di impostare il ruolo del dipendente
   * 
   * @param ruolo da impostare
   */
  public void setRuolo(String ruolo) {
    this.ruolo = ruolo;
  }
}