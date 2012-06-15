/*
 * Name: GestioneDipendentiD.java
 * Package: com.safetygame.back.controller
 * Author: Alessandro Cornaglia
 * Date: {Data di approvazione del file}
 * Version: 0.2
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120531 |Alessandro Cornaglia | * GestioneDipendentiD
 * |          |                     | - getDaoFactory
 * |          |                     | - setDaoFactory
 * |          |                     | + getDaoDipendenti
 * |          |                     | + setDaoDipendenti
 * |          |                     | * getDati
 * |          |                     | * modificaPass
 * |          |                     | + modificaEmail
 * +----------+---------------------+---------------------
 * | 20120519 |Alessandro Cornaglia | + GestioneDipendentiD
 * |          |                     | + getDaoFacory
 * |          |                     | + setDaoFactory
 * |          |                     | + getGestioneLog
 * |          |                     | + setGestioneLog 
 * |          |                     | + getDati
 * |          |                     | + modificaPass
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che si occupa di gestire le interazioni che un dipendente 
 * puo' avere con il sistema
 * 
 * @author acornagl
 * @version 0.2
 *
 */
public class GestioneDipendentiD{
  private DAODipendenti daoDipendenti;
  private GestioneLog gestioneLog;
  
  /**
   * Costruttore con parametri della classe GestioneDipendentiD
   * 
   * @param d riferimento all'iggetto di tipo DAOFactory
   * @param g riferimento alla classe di tipo GestioneLog
   */
  public GestioneDipendentiD(DAODipendenti d, GestioneLog g) {
    this.daoDipendenti = d;
    this.gestioneLog = g;
  }
  
  /**
   * Costruttore senza parametri della classe GestioneDipendentiD
   */
  public GestioneDipendentiD() {
    this.daoDipendenti = null;
    this.gestioneLog = null;
  }

  /**
   * metodo che consente di recuperare il riferimento all'oggetto di tipo statico
   * DAODipendenti
   * 
   * @return riferimento all'oggetto statico DAODipendenti
   */
  public DAODipendenti getDaoDipendenti() {
    return daoDipendenti;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto di tipo statico 
   * DAOFactory
   * 
   * @param daoFactory riferimento all'oggetto di tipo DAOFactory
   */
  public void setDaoDipendenti(DAODipendenti daoDip) {
    this.daoDipendenti = daoDip;
  }

  /**
   * metodo che consente di recuperare il riferimento all'oggetto di tipo GestioneLog
   * 
   * @return riferimento all'oggetto GestioneLog
   */
  public GestioneLog getGestioneLog() {
    return gestioneLog;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto di GestioneLog 
   * 
   * @param gestioneLog riferimento all'oggetto di tipo GestioneLog
   */
  public void setGestioneLog(GestioneLog gestioneLog) {
    this.gestioneLog = gestioneLog;
  }

  /**
   * Metodo che consente di reperire le informazioni di un dipendente a partire
   * dal suo login
   * 
   * @param l login del dipendente
   * @return informazioni sul dipendente
   */
  public Dipendente getDati(Login l) {
    Dipendente ritorno = this.daoDipendenti.getInfoD(l);
	return ritorno;    
  }
  
  /**
   * Metodo che consente la modifica della password da parte di un dipendente
   *
   * @param dip dipendente che chiede di modificare la password
   * 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modificaPass(Dipendente dip) {
	//dip contiene la nuova password (il web deve controllare che la pass sia ok
	//scrivo la nuova password
	boolean esito = this.daoDipendenti.passD(dip,dip.getNuovaPass());
    if(esito) {// se tutto ok
	  //scrivo il log
      //gestioneLog.scriviModPassD(dip);
      return true;
    }
    return false;//non sono riuscito a modificare la passwrod
  }
  
  /**
   * Metodo che consente la modifica della mail da parte di un dipendente
   * 
   * @param dip che chiede di modificare la mail
   * @param nEmail nuovo indirizzo mail da inserire
   * 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modificaEmail(Dipendente dip, String nEmail) {
    boolean esito = this.daoDipendenti.mailD(dip,nEmail);
    if (esito) {// se tutto ok
      //scrivo il log
      //gestioneLog.scriviModEmailD(dip);
      return true;
    }
    return false;
  }
  
}
