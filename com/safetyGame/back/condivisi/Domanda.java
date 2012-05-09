package com.safetyGame.back.condivisi;

/**
 * Classe che rappresenta una domanda del sistema
 * 
 * @author acornagl 
 * @version v0.1
 */
import java.util.*;

public class Domanda{
  private int id;
  private Punteggio punteggio;
  private String tipologia;
  private ArrayList<String> risposte;
  private int corretta;
  private String testo;
  private int rispostaData;
  
  /**
   * Costruttore con parametri della classe Domanda
   * 
   * @param i id della domanda
   * @param p punteggio della domanda
   * @param ti tipologia della domanda
   * @param r ArrayList di risposte
   * @param c numero risposta corretta
   * @param te testo della domanda
   * @param rd risposta data dal dipendente alla domanda
   */
  public Domanda(int i, Punteggio p, String ti, ArrayList<String> r, int c, String te, int rd) {
    this.id = i;
    this.punteggio = p;
    this.tipologia = ti;
    this.risposte = r;
    this.corretta = c;
    this.testo = te;
    this.rispostaData = rd;
  }
  
  /**
   * Costruttore senza parametri della classe Domanda
   * 
   */
  public Domanda() {
    this.id = -1; //assegno alla nuova domanda un id illegale
    this.punteggio = null;
    this.tipologia = null;
    this.risposte = new ArrayList<String>();
    this.corretta = -1;
    this.testo = null;
    this.rispostaData = -1;
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
  
  /**
   * metodo che consente di recuperare le risposte di una domanda
   * 
   * @return insieme delle risposte
   */
  public ArrayList<String> getRisposte() {
    return risposte;
  }

  /**
   * metodo che consente di impostare l'insieme delle risposte di una domanda
   * 
   * @param risposte insieme delle risposte che si vuole assegnare ad una domanda
   */
  public void setRisposte(ArrayList<String> risposte) {
    this.risposte = risposte;
  }

  /**
   * metodo che consente di recuperare l'indice della risposta corretta
   * 
   * @return indice della risposta corretta
   */
  public int getCorretta() {
    return corretta;
  }

  /**
   * metodo che consente di impostare l'indice della risposta corretta
   * 
   * @param corretta indice della risposta corretta che si vuole assegnare
   */
  public void setCorretta(int corretta) {
    this.corretta = corretta;
  }

  /**
   * metodo che consente di recuperare il testo di una domanda
   * 
   * @return testo della domanda
   */
  public String getTesto() {
    return testo;
  }

  /**
   * metodo che consente di impostare il testo di una domanda
   * 
   * @param testo testo che si vuole assegnare alla domanda
   */
  public void setTesto(String testo) {
    this.testo = testo;
  }

  /**
   * metodo che consente di recuperare l'indice della risposta data da un dipendente alla
   * domanda
   * 
   * @return indice della risposta data alla domanda
   */
  public int getRispostaData() {
    return rispostaData;
  }

  /**
   * metodo che consente di impostare l'indice della risposta data ad una domanda
   * 
   * @param rispostaData indice della risposta data ad una domanda
   */
  public void setRispostaData(int rispostaData) {
    this.rispostaData = rispostaData;
  }

}
