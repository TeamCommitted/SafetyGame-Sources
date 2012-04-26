package com.safetyGame.back.condivisi;

/**
 * Classe che rappresenta un badge del sistema
 * 
 * @author acornagl 
 * @version v0.1
 */

public class Badge {

  private String nome;
  
  /**
   * Costruttore con parametri della classe Badge
   * 
   * @param nome nome del trofeo
   */
  public Badge(String nome) {
    this.nome = nome;	  
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
  
}
