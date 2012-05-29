package com.safetyGame.back.access;
/*
 * Name: DAOFactory.java
 * Package: com.safetygame.back.access
 * Author: Gabriele Facchin
 * Date: {Data di approvazione del file}
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120526 | Gabriele Facchin    | + creaDAOLogin
 * |          |                     | + creaDAODipendenti
 * |          |                     | + creaDAODomande
 * |          |                     | + creaDAOBadge
 * |          |                     | + creaDAOPunteggi
 * +----------+---------------------|---------------------
 *
 */

/**
 * Classe che definisce i metodi che tutte le implementazioni del Factory dovranno implementare
 * 
 * @author gfacchin
 * @version 0.1
 */
public abstract class DAOFactory{
  /**
   * Prototipo del metodo che la Factory implementare per creare l'oggetto DAOLogin
   * 
   * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
   * 
   */   
  public abstract DAOLogin creaDAOLogin(Indirizzo azienda);

  /**
   * Prototipo del metodo che la Factory implementare per creare l'oggetto DAODipendenti
   * 
   * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
   * 
   */   
  public abstract DAODipendenti creaDAODipendenti(Indirizzo azienda);
  
  /**
   * Prototipo del metodo che la Factory implementare per creare l'oggetto DAODomande
   * 
   * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
   * 
   */   
  public abstract DAODomande creaDAODomande(Indirizzo azienda, Indirizzo domande);
  
  /**
   * Prototipo del metodo che la Factory implementare per creare l'oggetto DAOBadge
   * 
   * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
   * 
   */   
  public abstract DAOBadge creaDAOBadge(Indirizzo azienda);
  
  /**
   * Prototipo del metodo che la Factory implementare per creare l'oggetto DAOPunteggi
   * 
   * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
   * 
   */   
  public abstract DAOPunteggi creaDAOPunteggi(Indirizzo azienda, Indirizzo Domande);
}
