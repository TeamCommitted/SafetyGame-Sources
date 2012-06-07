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
 * |          |                     | * getStatisticheD
 * |          |                     | * getBadgeD
 * +----------+---------------------+---------------------
 * | 20120523 |Alessandro Cornaglia | + getStatisticheD
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
  private DAODipendenti daoDipendenti;
  
  /**
   * Costruttore con paramentri della classe GestionePunteggiD
   * 
   * @param dP riferimento all'oggetto di tipo DAOPunteggi
   * @param dB riferimento all'oggetto di tipo DAOBadge
   * @param dD riferimento all'oggetto di tipo DAODipendenti
   */
  public GestionePunteggiD(DAOPunteggi dP, DAOBadge dB, DAODipendenti dD) {
    this.daoPunteggi = dP;
	this.daoBadge = dB;
	this.daoDipendenti = dD;
  }
  
  /**
   * Costruttore senza parametri della classe GestionePunteggiD
   */
  public GestionePunteggiD() {
    this.daoPunteggi = null;
    this.daoBadge = null;
    this.daoDipendenti = null;
  }
  
  /**
   * Metodo che consente di recuperare le statistiche di un determinato dipendente
   * 
   * @param l login del dipendente che richiede di conoscere le statistiche
   * 
   * @return statistiche del dipendente
   */
  public Punteggio getStatisticheD(Login l) {
	Dipendente dip = this.daoDipendenti.getInfoD(l);
    Punteggio ritorno = this.daoPunteggi.getStat(dip);
    return ritorno;
  }
  
  /**
   * Metodo che consente di recuperare i badge guadagnati dal dipendente
   *   
   * @param l login del dipendente
   * @return badge guadagnati dal dipendente
   */
  public ArrayList<Badge> getBadgeD(Login l) {
    Dipendente dip = this.daoDipendenti.getInfoD(l);
    ArrayList<Badge> badges = this.daoBadge.badgeD(dip);
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

