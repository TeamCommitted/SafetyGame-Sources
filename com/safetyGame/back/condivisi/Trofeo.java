package com.safetyGame.back.condivisi;

/**
 * Classe che rappresenta un trofeo del sistema
 * 
 * @author acornagl 
 * @version v0.1
 */

public class Trofeo {

  private String nome;
  
  /**
   * Costruttore con parametri della classe Trofeo
   * 
   * @param nome nome del trofeo
   */
  public Trofeo(String nome) {
    this.nome = nome;	  
  }
  
  /**
   * Costruttore senza parametri della classe Trofeo
   */
  public Trofeo() {
	  this.nome = null;
  }

  /**
   * metodo che consente di recuperare il nome di un trofeo
   * @return nome del trofeo
   */
  public String getNome() {
    return nome;
  }

  /**
   * metodo che consente di impostare il nome di un trofeo
   * @param nome nome che si vuole assegnare ad un trofeo
   */
  public void setNome(String nome) {
    this.nome = nome;
  }
  
}
