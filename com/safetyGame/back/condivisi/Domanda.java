package com.safetyGame.back.condivisi;

/**
 * Classe che rappresenta una domanda del sistema
 * 
 * @author acornagl 
 * @version v0.1
 */
public class Domanda{
  private int id;
  private Punteggio punteggio;
  private String tipologia;
  
  /**
   * Costruttore con parametri della classe Domanda
   * 
   * @param id id della domanda
   * @param punteggio punteggio della domanda
   * @param tipologia tipologia della domanda
   */
  public Domanda(int id, Punteggio punteggio, String tipologia) {
    this.id = id;
    this.punteggio = punteggio;
    this.tipologia = tipologia;
  }
  
  /**
   * Costruttore senza parametri della classe Domanda
   * 
   */
  public Domanda() {
    this.id = -1; //assegno alla nuova domanda un id illegale
    this.punteggio = null;
    this.tipologia = null;
  }

  /**
   * metodo che consente il recupero dell'id di una domanda
   * 
   * @return id domanda
   */
  public int getId() {
	return id;
  }

  /**
   * metodo che consente di impostare l'id di una domanda
   * 
   * @param id id da impostare
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * metodo che consente di recuperare il punteggio di una domanda
   * 
   * @return punteggio della domanda
   */
  public Punteggio getPunteggio() {
    return punteggio;
  }

  /**
   * metdodo che consente di impostare il punteggio di una domanda
   * 
   * @param punteggio punteggio che si vuole impostare
   */
  public void setPunteggio(Punteggio punteggio) {
    this.punteggio = punteggio;
  }

  /**
   * metodo che consente di recuperare la tipologia di una domanda
   * 
   * @return tipolologia della domanda
   */
  public String getTipologia() {
    return tipologia;
  }

  /**
   * metodo che consente di impostare la tipologia di una domanda
   * 
   * @param tipologia tipologia che si vuole impostare
   */
  public void setTipologia(String tipologia) {
    this.tipologia = tipologia;
  }

}
