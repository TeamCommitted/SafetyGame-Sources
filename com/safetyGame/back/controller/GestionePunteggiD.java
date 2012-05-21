/*
 * Name: GestionePunteggiD.java
 * Package: com.safetygame.back.controller
 * Author: Alessandro Cornaglia
 * Date: {Data di approvazione del file}
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120521 |Alessandro Cornaglia | +GestionePunteggiD
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

public class GestionePunteggiD{ 

  private DAOFactory daoPunteggi;
  private DAOFactory daoBadge;
  
  /**
   * Costruttore con paramentri della classe GestionePunteggiD
   * 
   * @param dP riferimento all'oggetto di tipo SqlDAOPunteggi
   * @param dB riferimento all'oggetto di tipo SqlDAOBadge
   */
  public GestionePunteggiD(DAOFactory dP, DAOFactory dB) {
    this.daoPunteggi = dP;
	this.daoBadge = dB;
  }
  
  /**
   * Costruttore senza parametri della classe GestionePunteggiD
   */
  public GestionePunteggiD() {
    this.daoPunteggi = null;
    this.daoBadge = null;
  }
  
  /**
   * metodo che consente di recuperare le statistiche di un determinato dipendente
   * 
   * @param l login del dipendente che richiede di conoscere le statistiche
   * 
   * @return statistiche del dipendente
   */
  public Punteggio[] getStatistiche(Login l) {
    /*
     * Ordine dei dati delle statistiche
     * 0 : proprio Punteggio
     * 1 :  
     */
  }
/*PARTE CREATA DAL FACCO
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestionePunteggiD(SqlDAOFactory s){accesso=s;}
    
   public Punteggio getStat(String username){
      log.getStat(username);
      return accesso.getStat(username);
   }
   */
}

