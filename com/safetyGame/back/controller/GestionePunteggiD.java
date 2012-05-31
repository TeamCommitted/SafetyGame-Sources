/*
 * Name: GestionePunteggiD.java
 * Package: com.safetygame.back.controller
 * Author: Alessandro Cornaglia
 * Date: {Data di approvazione del file}
 * Version: 0.3
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120531 |Alessandro Cornaglia | * GestionePunteggiD
 * |          |                     | * getStatistiche
 * +----------+---------------------+---------------------
 * | 20120523 |Alessandro Cornaglia | + getStatistiche
 * |          |                     | + getBadgeD
 * +----------+---------------------+---------------------
 * | 20120521 |Alessandro Cornaglia | + GestionePunteggiD
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

import java.util.ArrayList;

public class GestionePunteggiD{ 

  private DAOPunteggi daoPunteggi;
  private DAOBadge daoBadge;
  
  /**
   * Costruttore con paramentri della classe GestionePunteggiD
   * 
   * @param dP riferimento all'oggetto di tipo DAOPunteggi
   * @param dB riferimento all'oggetto di tipo DAOBadge
   */
  public GestionePunteggiD(DAOPunteggi dP, DAOBadge dB) {
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
  public Punteggio getStatistiche(Login l) {
    Punteggio ritorno = this.daoPunteggi.getPunteggio(l.getUsername());
    return ritorno;
  }
  
  /**
   * metodo che consente di recuperare i badge guadagnati dal dipendente
   *   
   * @param l login del dipendente
   * @return badge guadagnati dal dipendente
   */
  public ArrayList<Badge> getBadgeD(Login l) {//DA MODIFICARE
    Dipendente dip = l.getDipendente();
    ArrayList<Badge> badges = dip.getBadges();
    return badges;
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

