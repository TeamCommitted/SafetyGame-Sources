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
 * | 20120608 |Alessandro Cornaglia | - gestioneBadgeD
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

/**
 * Classe che si occupa di gestire i punteggi dei dipendenti
 * @author acornagl
 *
 */
public class GestionePunteggiD{ 

  private DAOPunteggi daoPunteggi;
  private DAODipendenti daoDipendenti;
  
  /**
   * Costruttore con paramentri della classe GestionePunteggiD
   * 
   * @param dP riferimento all'oggetto di tipo DAOPunteggi
   * @param dB riferimento all'oggetto di tipo DAOBadge
   * @param dD riferimento all'oggetto di tipo DAODipendenti
   */
  public GestionePunteggiD(DAOPunteggi dP, DAODipendenti dD) {
    this.daoPunteggi = dP;
	this.daoDipendenti = dD;
  }
  
  /**
   * Costruttore senza parametri della classe GestionePunteggiD
   */
  public GestionePunteggiD() {
    this.daoPunteggi = null;
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
   * Metodo che consente di recuperare le statistiche globali
   * 
   * @param l login del dipendente che richiede di conoscere le statistiche
   * @return statistiche globali
   */
  public Punteggio getStatisticheGlob(Login l) {
	  Dipendente dip = this.daoDipendenti.getInfoD(l);
	  Punteggio ritorno = this.daoPunteggi.getGlobalStat(dip);
	  return ritorno;
  }
}

