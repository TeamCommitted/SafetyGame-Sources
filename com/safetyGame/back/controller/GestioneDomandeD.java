/*
 * Name: GestioneDomabdeD.java
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
 * | 20120531 |Alessandro Cornaglia | * GestioneDomandeD
 * |          |                     | - getDaoFactory
 * |          |                     | - setDaoFactory
 * |          |                     | - getDaoDomande
 * |          |                     | - setDaoDomande
 * |          |                     | * getDomanda
 * |          |                     | * setRisposta
 * +----------+---------------------+---------------------
 * | 20120518 |Alessandro Cornaglia | + GestioneDomandeD
 * |          |                     | + getDaoFactory
 * |          |                     | + setDaoFactory
 * |          |                     | + getGestionePunteggiD
 * |          |                     | + setGestionePunteggiD
 * |          |                     | + getGestioneLog
 * |          |                     | + setGestioneLog
 * +----------+---------------------+---------------------
 * | 20120519 |Alessandro Cornaglia | + setRisposta
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

public class GestioneDomandeD{
  private DAODomande daoDomande;
  private DAOPunteggi daoPunteggi;
  private GestionePunteggiD gestionePunteggiD;
  private GestioneLog gestioneLog;
  
  
  /**
   * Costruttore con parametri della classe GestioneDomandeD
   * 
   * @param d implementazione daoDomande a seconda del database
   * @param dp implementazione daoPunteggi a seconda del database
   * @param g riferimento alla classe GestionePunteggiD
   * @param gl riferimento alla classe GestioneLog
   */
  public GestioneDomandeD(DAODomande d, DAOPunteggi dp, GestionePunteggiD g, GestioneLog gl) {
    this.daoDomande = d;
    this.daoPunteggi = dp;
    this.gestionePunteggiD = g;
    this.gestioneLog = gl;
  }
  
  /**
   * Costruttore senza parametri della classe GestioneDomandeD
   */
  public GestioneDomandeD() {
    this.daoDomande = null;
    this.daoPunteggi = null;
    this.gestionePunteggiD = null;
    this.gestioneLog = null;
  }
  
  /**
   * metodo che consente di recuperare il riferimento all'oggetto DAODomande
   * 
   * @return daoDomande
   */
  public DAODomande getDaoDomande() {
    return daoDomande;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto DAODomande
   * 
   * @param daoFactory oggetto di tipo statico DAODomande
   */
  public void setDaoDomande(DAODomande daoDom) {
    this.daoDomande = daoDom;
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
  
  /**
   * metodo che consente di recuperare una domanda 
   * 
   * @param l oggetto Login del dipendente che deve ricevere la domanda
   * @return domanda per il login proposto
   */
  public Domanda getDomanda(Login l) {//DA MODIFICARE
	Dipendente dip = l.getDipendente();//recupero il dipendente 
    Domanda ritorno = this.daoDomande.getDomanda(dip);//recupero la domanda passandogli il dip così posso scrivere sul db che gli è stata presentata
    //scrivo che la domanda è stata sottoposta al dipendente sul DB
    this.daoDomande.scriviSottoposta(ritorno,dip);
    this.gestioneLog.scriviDomRic(l, ritorno); // scrivo il log
    return ritorno; 
  }
  
  /**
   * metodo che si occupa di controllare la risposta data da un dipendente ad una
   * domanda e tenta di scrivere tali informazioni sul DB. Se la risposta è corretta
   * assegna il punteggio al dipendente
   * 
   * @param l Login del dipendente che ha risposto
   * @param risposta Domanda posta al dipendente contenente la risposta data
   */
  public void setRisposta(Login l,Domanda risposta) {//DA MODIFICARE
    //Dal login ricavo il dipendente
	Dipendente dip = l.getDipendente();
	//Ricavo Punteggio della domanda
	Punteggio punti = risposta.getPunteggio();
	//Domanda contiene la risposta dell'utente
	int rispostaData = risposta.getRispostaData();
	//scrivoil log che l'utente ha risposto
	gestioneLog.scriviDomRisp(l, risposta);
	
	//scrivo sul DB che l'utente ha risposto alla domanda
	daoDomande.scriviHaRisposto(dip.risposta);
	
	//controllo se la risposta è corretta
	if ( rispostaData == risposta.getCorretta()) {
	  //se la risposta è corretta, allora devo assegnare il punteggio al dipendente
	  //->assegno punteggio al dipendente
	  daoPunteggi.addPunteggio(dip,punti);//o metodo opportuno
	}
  }
  
   /*METODI SCRITTI DAL FACCO
     SqlDAOFactory accesso;
    
   GestioneLog log;
   public GestioneDomandeD(SqlDAOFactory s){accesso=s;}
   
   public Domanda getDomanda(String username){   FATTO!
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
