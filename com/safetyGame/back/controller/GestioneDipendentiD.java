/*
 * Name: GestioneDipendentiD.java
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
 * | 20120519 |Alessandro Cornaglia | +GestioneDipendentiD
 * |          |                     | +getDaoFacory
 * |          |                     | +setDaoFactory
 * |          |                     | +getGestioneLog
 * |          |                     | +setGestioneLog 
 * |          |                     | +getDati
 * |          |                     | +modificaPass
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

public class GestioneDipendentiD{
  private DAOFactory daoFactory;
  private GestioneLog gestioneLog;
  
  /**
   * Costruttore con parametri della classe GestioneDipendentiD
   * 
   * @param d riferimento all'iggetto di tipo DAOFactory
   * @param g riferimento alla classe di tipo GestioneLog
   */
  public GestioneDipendentiD(DAOFactory d, GestioneLog g) {
    this.daoFactory = d;
    this.gestioneLog = g;
  }
  
  /**
   * Costruttore senza parametri della classe GestioneDipendentiD
   */
  public GestioneDipendentiD() {
    this.daoFactory = null;
    this.gestioneLog = null;
  }

  /**
   * metodo che consente di recuperare il riferimento all'oggetto di tipo statico
   * DAOFactory
   * 
   * @return riferimento all'oggetto statico DAOFactory
   */
  public DAOFactory getDaoFactory() {
    return daoFactory;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto di tipo statico 
   * DAOFactory
   * 
   * @param daoFactory riferimento all'oggetto di tipo DAOFactory
   */
  public void setDaoFactory(DAOFactory daoFactory) {
    this.daoFactory = daoFactory;
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

  public Dipendente getDati(Login l) {
	  //che dati deve ritornare??? solo il dipendente?
	  return l.getDipendente();
  }
  
  public boolean modificaPass(Dipendente dip) {
	//dip contiene la nuova password (il web deve controllare che la pass sia ok
	//scrivo la nuova password
    daoFactory.modificaPassword(dip,dip.getPassword());
    
    //scrivo il log
    gestioneLog.scriviModPassD(dip);
    return true;
  }
  
/*   CODICE FACCO
 * 	
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestioneDipendentiD(SqlDAOFactory s){accesso=s;}
   
   public Dipendente getDati(String username){
      //prelevare il timer, controllare e in caso prelevare la domanda
      log.datiD(username);
      return accesso.getInfo(username);
   }
   public void setPass(String pass, String username){
      log.passD(username);
      accesso.passD(pass,username);
   }
   public void setMail(String mail, String username){
      log.mailD(username);
      accesso.mailD(mail,username);
   }
*/
}
