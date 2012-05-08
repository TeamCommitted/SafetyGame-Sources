package com.safetyGame.back.condivisi;

/**
 * Classe che rappresenta un badge del sistema
 * 
 * @author acornagl 
 * @version v0.1
 */

public class Badge {

  private String nome;
  private String descrizione;
  private Punteggio soglia;
  
  /**
   * Costruttore con parametri della classe Badge
   * 
   * @param nome nome del badge
   * @param d descrizione del badge
   * @param p punteggio di soglia
   */
  public Badge(String nome, String d, Punteggio p) {
    this.nome = nome;
    this.descrizione = d;
    this.soglia = p;
  }
  
  /**
   * Costruttore senza parametri della classe Badge
   */
  public Badge() {
	  this.nome = null;
  }

  /**
   * metodo che consente di recuperare il nome di un badge
   * @return nome del badge
   */
  public String getNome() {
    return nome;
  }

  /**
   * metodo che consente di impostare il nome di un badge
   * @param nome nome che si vuole assegnare ad un badge
   */
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  /**
   * metodo che consente di recuperare la descrizione di un badge
   * @return descrizione del badge
   */
  public String getDescrizione() {
    return descrizione;
  }

  /**
   * metodo che consente di impostare la descrizione di un badge
   * @param descrizione che si vuole assegnare
   */
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * metodo che consente di recuperare il punteggio di soglia del badge
   * @return punteggio di soglia per aggiudicarsi il badge
   */
  public Punteggio getSoglia() {
    return soglia;
  }

  /**
   * metodo che consente di impostare il punteggio minimo di soglia 
   * @param soglia che si vuole impostare
   */
  public void setSoglia(Punteggio soglia) {
    this.soglia = soglia;
  }
  
}
