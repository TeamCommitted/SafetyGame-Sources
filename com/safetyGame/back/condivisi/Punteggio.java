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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        //return x + y;
    	return 1;
    }
}
