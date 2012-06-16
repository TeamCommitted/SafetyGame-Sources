/*
 * Name: DAOPunteggi.java
 * Package: com.safetygame.back.access
 * Author: Gabriele Facchin
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120512 | Gabriele Facchin    | + getStat
 * |          |                     | + getGlobalStat
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

/**
 * Interfaccia che contiene i prototipi dei metodi per gestire i punteggi
 * 
 * @author gfacchin
 * @version 1.0
 */

public interface DAOPunteggi{

  /**
   * Metodo che prende il punteggio di un Dipendente dal database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return l'oggetto Punteggio contenente il totale del punteggio del Dipendente
   * 
   */    
  public Punteggio getStat(Dipendente d);
  
  /**
   * Metodo che genera le statistiche dato un Dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return l'oggetto Punteggio contenente le statistiche dei dipendenti (e dell'azienda) a lui vicini
   * 
   */    
  public Punteggio getGlobalStat(Dipendente dip);

}
