/*
 * Name: Recupero.java
 * Package: com.safetygame.dasktop.condivisi
 * Author: Alessandro Cornaglia
 * Date: 2012/06/16
 * Version: 1.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120519 |Alessandro Cornaglia | + Recupero
 * |          |                     | + getEmail
 * |          |                     | + setEmail
 * |          |                     | + getCodFiscale
 * |          |                     | + setCodFiscale
 * +----------+---------------------|---------------------
 * | 20120717 | Gabriele Facchin    | + propagati gli 
 * |          |                     | + aggiornamenti del 
 * |          |                     | + backend 
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.desktop.condivisi;


/**
 * Classe che contiene le informazioni di un untente che chiede il recupero della password
 * 
 * @author acornagl
 * @version v1.0
 */
public class Recupero {
  
  private String email;
  private String codFiscale;
  
  /**
   * Costruttore con parametri della classe Recupero
   * 
   * @param email email del dipendente
   * @param codFiscale codice fiscale del dipendente
   */
  public Recupero(String email, String codFiscale) {
    this.email = email;
    this.codFiscale = codFiscale;
  }
  
  /**
   * Costruttore senza parametri della classe Recupero
   */
  public Recupero() {
    this.email = null;
    this.codFiscale = null;
  }

  /**
   * metodo get per recuperare la mail del dipendente
   * 
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * metodo che consente di impostare la mail di un dipendente
   * 
   * @param email email da impostare 
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * metodo get per recuperare il codice fiscale
   * 
   * @return codice fiscale
   */
  public String getCodFiscale() {
    return codFiscale;
  }

  /**
   * metodo per impostare il codice fiscale di un dipendente
   * 
   * @param codFiscale codice fiscale da impostare
   */
  public void setCodFiscale(String codFiscale) {
    this.codFiscale = codFiscale;
  }
}
