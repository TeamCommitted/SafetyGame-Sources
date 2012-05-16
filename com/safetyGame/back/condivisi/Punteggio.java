/*
 * Name: Punteggio.java
 * Package: com.safetygame.back.condivisi
 * Author: Alessandro Cornaglia
 * Date: {Data di approvazione del file}
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120424 |Alessandro Cornaglia | + Punteggio
 * |          |                     | + getPunti
 * |          |                     | + setPunti
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.condivisi;


/**
 * Classe che rappresenta un generico punteggio. Può essere associata
 * sia ad una domanda che ad un dipendente
 * 
 * @author acornagl 
 * @version 0.1
 */
public class Punteggio {
  private int punti;
  
  /**
   * Costruttore senza parametri della classe Punteggio
   */
  public Punteggio() {
    this.punti = 0;
  }
  
  /**
   * Costruttore della classe Punteggio
   * 
   * @param punti punti da assegnare al nuovo oggetto 
   */
  public Punteggio( int punti ){
	  this.punti = punti;
  }

  /**
   * metodo che consente di recuperare i punti
   * @return punti
   */
  public int getPunti() {
    return punti;
  }

  /**
   * metodo che consente di modificare i punti
   * 
   * @param punti punti da assegnare all'oggetto
   */
  public void setPunti(int punti) {
    this.punti = punti;
  }
}
