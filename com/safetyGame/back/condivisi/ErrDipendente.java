/*
 * Name: ErrDipendente.java
 * Package: com.safetyGame.back.condivisi
 * Author: 
 * Date: 
 * Version: 0.1
 * Copyright:
 */
package com.safetyGame.back.condivisi;

/**
 * Classe che contiene i codici d'errore generati dalla classe 
 * Dipendente
 * 
 * @author acornagl 
 * @version 0.1
 * 
 */

public class ErrDipendente extends Error {

  private int nErrore;
/*
 * lista errori:
 * 1 => errore inserimento trofeo
 */
  
  /**
   * Costruttore della classe ErrDipendente
   * 
   * @param err codice d'errore
   */
  public ErrDipendente( int err ) {
    this.nErrore = err;
  }

}
