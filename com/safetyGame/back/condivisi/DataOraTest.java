package com.safetyGame.back.condivisi;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataOraTest {
	
  DataOra d; 
  
  /**
   * mettodo che consente di creare on oggetto Data ora con parametri  
   */
  private void init() {
	int giorno = 10;
    int mese = 9;
    int anno = 2012;
    int ora = 9;
    int minuti = 56;
 	int secondi = 49;
   	d = new DataOra(anno,mese,giorno,ora,minuti,secondi);
  }
  
  /**
   * metodo che consente di creare un oggetto DataOra senza parametri
   */
  private void initV() {
	  d = new DataOra();
  }
  
	
  @Test 
  public void testCostruttoreP() {
    init();	
    assertTrue("Il giorno non è quello atteso", d.getGiorno() == 10);
  }

  @Test
  public void testCostruttoreV() {
    initV();
    int anno = 2012;//anno attuale
    int mese = 04;//mese attuale
    int giorno = 27;//giorno attuale
    assertTrue("L'anno non è quello atteso", d.getAnno() == anno);
    assertTrue("Il mese non è quello atteso", d.getMese() == mese);
    assertTrue("Il giorno non è quello atteso", d.getGiorno() == giorno);
  }
}
