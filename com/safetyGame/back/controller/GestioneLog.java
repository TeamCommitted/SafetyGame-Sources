/*
 * Name: GestioneLog.java
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
 * | 20120511 |Alessandro Cornaglia | +getLog
 * |          |                     | +getPercorso
 * +----------+---------------------+---------------------
 * | 20120510 |Alessandro Cornaglia | + GestioneLog
 * |          |                     | + getUpdateLog
 * |          |                     | + setUpdateLog
 * |          |                     | + scriviLogin
 * |          |                     | + scriviLogout
 * |          |                     | + scriviDomRic
 * |          |                     | + scriviDomProp
 * |          |                     | + scriviDomPost
 * |          |                     | + scriviDomRisp
 * |          |                     | + scriviModPassD
 * |          |                     | + scriviModEmailD
 * |          |                     | + scriviOttenimentoBadge
 * |          |                     | + scriviAddDip
 * |          |                     | + scriviDelDip
 * |          |                     | + scriviModDip
 * |          |                     | + scriviAddDomande
 * |          |                     | + scriviDelDomande
 * +----------+---------------------|---------------------
 *
 */ 
package com.safetyGame.back.controller;
import java.io.IOException;

import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che si occupa di gestire i log del sistema
 * 
 * @author acornagl 
 * @version v0.1
 */
public class GestioneLog{

  private UpdateLog updateLog;
  private String percorso;
  private String log;
  
  /**
   * Costruttore con parametri della classe GestioneLog
   * 
   * @param u riferimento all'oggetto UpdateLog del package access
   */
  public GestioneLog(UpdateLog u) {
    this.updateLog = u;
  }
  
  /**
   * Costruttore senza parametri della classe GestioneLog
   * 
   */
  public GestioneLog() {
    this.updateLog = null;
  }
  
  /**
   * metodo che consente di recuperare il riferimento all'oggetto di tipo UpdateLog
   * @return riferimento all'oggetto di tipo UpdateLog
   */
  public UpdateLog getUpdateLog() {
    return updateLog;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto di tipo UpdateLog
   * @param updateLog riferimento all'oggetto di tipo UpdateLog
   */
  public void setUpdateLog(UpdateLog updateLog) {
    this.updateLog = updateLog;
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo un login
   * 
   * @param l oggetto Login dovuto dall'effettuazione del login da parte di un dipendente
   */
  public void scriviLogin(Login l) {
    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    Dipendente dipendente = l.getDipendente(); //ricavo il dipendente
	
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "login.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) {System.out.println("non va"); }//bisogna decidere cosa fare se si verifica errore
    
    log = "LOGIN " + dataOra.toString() + " " + dipendente.toStringID(); //stringa contenente il log
    updateLog.scriviChiudi(log);//passo la stringa creata a updateLog
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo un logout
   * 
   * @param l oggetto Login del dipendente che ha effettuato il logout
   */
  public void scriviLogout(Login l) {
    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    Dipendente dipendente = l.getDipendente(); //ricavo il dipendente
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "logout.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
    log = "LOGOUT " + dataOra.toString() + " " + dipendente.toStringID(); //stringa contenente il log
    updateLog.scriviChiudi(log);//passo la stringa creata a updateLog
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene ricevuta da un dipendente
   * 
   * @param l oggetto Login del dipendente che riceve la domanda
   * @param d domanda che viene ricevuta dall'utente
   */
  public void scriviDomRic(Login l, Domanda d) {
    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    Dipendente dipendente = l.getDipendente(); //ricavo il dipendente
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "dRic.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
    log = "DOMANDA RICEVUTA " + dataOra.toString() + " id dip=" + dipendente.getId() + " id dom=" + d.getId();
    updateLog.scriviChiudi(log);
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene proposta ad un dipendente 
   *
   * @param l oggetto Login del dipendente che riceve la proposta di domanda
   * @param d domanda che viene proposta all'utente
   */
  public void scriviDomProp(Login l, Domanda d) {
    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    Dipendente dipendente = l.getDipendente(); //ricavo il dipendente

    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "dProp.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
    
	log = "DOMANDA PROPOSTA " + dataOra.toString() + " id dip=" + dipendente.getId() + " id dom=" + d.getId();
    updateLog.scriviChiudi(log);
  }

  /**
   *metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene posticipata da un dipendente 
   *
   * @param l oggetto Login del dipendente che posticipa una domanda
   * @param d domanda che viene posticipata dall'utente
   */
  public void scriviDomPost(Login l, Domanda d) {
    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    Dipendente dipendente = l.getDipendente(); //ricavo il dipendente

    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "dPost.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
    
	log = "DOMANDA POSTICIPATA " + dataOra.toString() + " id dip=" + dipendente.getId() + " id dom=" + d.getId();
    updateLog.scriviChiudi(log);
  }
  
  /**
   *metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene posticipata da un dipendente 
   *
   * @param l oggetto Login del dipendente che posticipa una domanda
   * @param d domanda che viene posticipata dall'utente
   */
  public void scriviDomRisp(Login l, Domanda d) {
    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    Dipendente dipendente = l.getDipendente(); //ricavo il dipendente

    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "dRisp.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
    
	log = "DOMANDA RISPOSTA " + dataOra.toString() + " id dip=" + dipendente.getId() + " id dom=" + d.getId();
    updateLog.scriviChiudi(log);
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che un dipendente modifica la propria password 
   * 
   * @param d dipendente che ha modificato la propria password
   */
  public void scriviModPassD(Dipendente d) {
    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/";
    int idDip = d.getId();
    percorso += idDip + "/" + "modPassD.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
	log = "MODIFICA PASS D " + dataOra.toString() + " id dip=" + d.getId();
    updateLog.scriviChiudi(log);
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che un dipendente modifica la propria email 
   * 
   * @param d dipendente che ha modificato la propria email
   */
  public void scriviModEmailD(Dipendente d) {
    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/";
    int idDip = d.getId();
    percorso += idDip + "/" + "modEmailD.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
    log = "MODIFICA EMAIL D " + dataOra.toString() + " id dip=" + d.getId();
    updateLog.scriviChiudi(log);
  }

  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che un dipendente ottiene un badge
   * 
   * @param d dipendente che ha ottenuto un badge
   * @param b badge ottenuto
   */
  public void scriviOttenimentoBadge(Dipendente d, Badge b) {
	DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/";
    int idDip = d.getId();
    percorso += idDip + "/" + "modOttB.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
	log = "OTTENIMENTO BADGE " + dataOra.toString() + " id dip=" + d.getId() + " badge=" + b.getNome();
    updateLog.scriviChiudi(log);
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AA aggiunge un dipendente
   * 
   * @param d dipendente aggiunto
   */
  public void scriviAddDip(Dipendente d) {
	DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/AA/AA.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
	log = "AGGIUNTO DIPENDENTE " + dataOra.toString() + " id dip=" + d.getId();
    updateLog.scriviChiudi(log);
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AA rimuove un dipendente
   * 
   * @param d dipendente rimosso
   */
  public void scriviDelDip(Dipendente d) {
	DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/AA/AA.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
	log = "RIMOSSO DIPENDENTE " + dataOra.toString() + " id dip=" + d.getId();
    updateLog.scriviChiudi(log);
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AA modifica un dipendente
   * 
   * @param d dipendente modificato
   */
  public void scriviModDip(Dipendente d) {
	DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/AA/AA.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
	log = "MODIFICATO DIPENDENTE " + dataOra.toString() + " id dip=" + d.getId();
    updateLog.scriviChiudi(log);
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AS aggiunge una o più domande
   * 
   * @param d domande aggiunte
   */
  public void scriviAddDomande(Domanda [] d) {
	DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/AS/AS.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
	//scrivo una riga per ogni domanda aggiunta
	for (int i = 0; i < d.length; i++) {
	  log = "AGGIUNTA DOMANDA " + dataOra.toString() + " id dom=" + d[i].getId();
	  updateLog.scriviChiudi(log);
	}
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AS rimuove una o più domande
   * 
   * @param d domande rimosse
   */
  public void scriviDelDomande(Domanda [] d) {
	DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/log/AS/AS.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
	//scrivo una riga per ogni domanda aggiunta
	for (int i = 0; i < d.length; i++) {
	  log = "RIMOSSA DOMANDA " + dataOra.toString() + " id dom=" + d[i].getId();
	  updateLog.scriviChiudi(log);
	}
  }
  
  /**
   * metodo che consente di visualizzare il path su cui si andrà a scrivere
   * un log
   * 
   * @return percorso
   */
  public String getPercorso() { //utile per i test
    return this.percorso;
  }
  
  /**
   * metodo che consente di visualizzare il log si andrà a scrivere
   * 
   * @return log
   */
  public String getLog() { //utile per i test
    return this.log;	
  }
/*   DataOra dataora;
   UpdateLog logGenerale; //o uno per tipo "generale" login / logout / domande / mod...
   UpdateLog utente;
   public GestioneLog(){}
   
   public void login(String username, char u){	FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void chiediDomanda(String username){	FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void posticipa(String username){	FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void rispondi(String username, String risposta){ FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }   
   public void datiD(String username){	FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void passD(String username){  FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void mailD(String username){  FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void getStat(String username){ SERVE????
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void passA(String username){ PUÒ MODIFICARE LA PASS???
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void listaD(){  SERVE???
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void addD(String username){ FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void delD(String username){ FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void nome(String username){ SOSP
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void cognome(String username){ SOSP
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void codfis(String username){ SOSP
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void username(String username){ SOSP
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void impiego(String username){ SOSP
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void trofei(String username){ SOSP
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void reset(String username){ COSA SAREBBE???
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void badgeD(String username){ FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void domandeA(){	SERVE???
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void addDomanda(){	FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void remDomanda(){	FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void logout(String username){ FATTO
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
*/   
}