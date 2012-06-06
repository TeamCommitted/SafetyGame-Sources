/*
 * Name: Badge.java
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
 * | 20120603 |Alessandro Cornaglia | * Badge
 * |          |                     | + getId
 * |          |                     | + setId
 * |          |                     | * getSoglia
 * |          |                     | * setSoglia
 * +----------+---------------------+---------------------
 * | 20120419 |Alessandro Cornaglia | + Badge
 * |          |                     | + Badge
 * |          |                     | + getNome
 * |          |                     | + setNome
 * |          |                     | + getDescrizione
 * |          |                     | + setDescrizione
 * |          |                     | + getSoglia
 * |          |                     | + setSoglia
 * +----------+---------------------+---------------------
 *
 */
package com.safetyGame.back.condivisi;

/**
 * Classe che rappresenta un badge del sistema
 * 
 * @author acornagl 
 * @version v0.2
 */

public class Badge {

  private String nome;
  private String descrizione;
  private int soglia;
  private int id;
  
  /**
   * Costruttore con parametri della classe Badge
   * 
   * @param nome nome del badge
   * @param d descrizione del badge
   * @param s punteggio intero di soglia
   */
  public Badge(String nome,int i, String d, int s) {
    this.nome = nome;
    this.id  = i;
    this.descrizione = d;
    this.soglia = s;
  }
  
  /**
   * Costruttore senza parametri della classe Badge
   */
  public Badge() {
	  this.nome = null;
	  this.id = -1;
	  this.descrizione = null;
	  this.soglia = -1;
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
   * metodo che consente di recuperare l'id di un badge
   * @return id del badge
   */
  public int getId() {
    return id;
  }

  /**
   * metodo che consente di impostare l'id di un badge
   * @param id id da impostare 
   */
  public void setId(int id) {
    this.id = id;
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
  public int getSoglia() {
    return soglia;
  }

  /**
   * metodo che consente di impostare il punteggio minimo di soglia 
   * @param soglia che si vuole impostare
   */
  public void setSoglia(int soglia) {
    this.soglia = soglia;
  }
  
}
