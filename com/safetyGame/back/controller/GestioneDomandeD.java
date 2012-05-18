/*
 * Name: GestioneDomabdeD.java
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
 * | 20120518 |Alessandro Cornaglia | + GestioneDomandeD
 * |          |                     | +getDaoFactory
 * |          |                     | +setDaoFactory
 * |          |                     | +getGestionePunteggiD
 * |          |                     | +setGestionePunteggiD
 * |          |                     | +getGestioneLog
 * |          |                     | +setGestioneLog
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

public class GestioneDomandeD{
  private DAOFactory daoFactory;
  private GestionePunteggiD gestionePunteggiD;
  private GestioneLog gestioneLog;
  
  /**
   * Costruttore con parametri della classe GestioneDomandeD
   * 
   * @param d implementazione daoFactory a seconda del database
   * @param g riferimento alla classe GestionePunteggiD
   * @param gl riferimento alla classe GestioneLog
   */
  public GestioneDomandeD(DAOFactory d, GestionePunteggiD g, GestioneLog gl) {
    this.daoFactory = d;
    this.gestionePunteggiD = g;
    this.gestioneLog = gl;
  }
  
  /**
   * metodo che consente di recuperare una domanda 
   * 
   * @param l oggetto Login del dipendente che deve ricevere la domanda
   * @return domanda per il login proposto
   */
  public Domanda getDomanda(Login l) {
	Dipendente dip = l.getDipendente();//recupero il dipendente 
    Domanda ritorno = this.daoFactory.getDomanda(dip);//recupero la domanda passandogli il dip così posso scrivere sul db che gli è stata presentata
    //scrivo che la domanda è stata sottoposta al dipendente sul DB
    this.daoFactory.scriviSottoposta(ritorno,dip);
    this.gestioneLog.scriviDomRic(l, ritorno); // scrivo il log
    return ritorno; 
  }
  
  /**
   * Costruttore senza parametri della classe GestioneDomandeD
   */
  public GestioneDomandeD() {
    this.daoFactory = null;
    this.gestionePunteggiD = null;
    this.gestioneLog = null;
  }
  
  /**
   * metodo che consente di recuperare il riferimento all'oggetto DAOFactory
   * 
   * @return daoFactory
   */
  public DAOFactory getDaoFactory() {
    return daoFactory;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto DAOFactory
   * 
   * @param daoFactory oggetto di tipo statico DAOFActory
   */
  public void setDaoFactory(DAOFactory daoFactory) {
    this.daoFactory = daoFactory;
  }

  /**
   * metodo che consente di recuperare il riferimento all'oggetto GestionePunteggiD
   * 
   * @return gestionePunteggiD
   */	
  public GestionePunteggiD getGestionePunteggiD() {
    return gestionePunteggiD;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto GestionePunteggiD
   * 
   * @param gestionePunteggiD oggetto di tipo GestionePunteggiD
   */	
  public void setGestionePunteggiD(GestionePunteggiD gestionePunteggiD) {
    this.gestionePunteggiD = gestionePunteggiD;
  }

  /**
   * metodo che consente di recuperare il riferimento all'oggetto GestioneLog
   * 
   * @return gestioneLog
   */
  public GestioneLog getGestioneLog() {
    return gestioneLog;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto GestioneLog
   * 
   * @param gestioneLog oggetto di tipo GestioneLog
   */
  public void setGestioneLog(GestioneLog gestioneLog) {
    this.gestioneLog = gestioneLog;
  }
   /*METODI SCRITTI DAL FACCO
     SqlDAOFactory accesso;
    
   GestioneLog log;
   public GestioneDomandeD(SqlDAOFactory s){accesso=s;}
   
   public Domanda getDomanda(String username){
      //prelevare il timer, controllare e in caso prelevare la domanda
      Dipendente d=accesso.getInfo(username);
      log.chiediDomanda(username);
      return accesso.getDomanda(username);
   }
   
   public void posticipa(String username){
      accesso.posticipa(username);
      log.posticipa(username);
   }
   public boolean rispondi(String username, String risposta){
      accesso.rispondi(username,risposta);
      log.rispondi(username,risposta);  
      return true;
   }
   */


}
