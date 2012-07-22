/*
 * Name: GestioneLog.java
 * Package: com.safetygame.back.controller
 * Author: Alessandro Cornaglia
 * Date: 2012/06/16
 * Version: 1.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120712 |Alessandro Cornaglia | Tutti i metodi sono
 * |          |                     | stati aggiornati assegnado
 * |          |                     | a alle variabili 
 * |          |                     | nomi significativi
 * +----------+---------------------+---------------------
 * | 20120531 |Alessandro Cornaglia | * scriviLogin
 * |          |                     | * scriviLogout
 * |          |                     | * scriviDomRic
 * |          |                     | * scriviDomProp
 * |          |                     | * scriviDomPost
 * |          |                     | * scriviDomRisp
 * |          |                     | *scriviModPassD
 * |          |                     | *scriviModEmailD
 * |          |                     | *scriviOttenimentoBadge
 * +----------+---------------------+---------------------
 * | 20120525 |Alessandro Cornaglia | + getLog
 * |          |                     | + getPercorso
 * +----------+---------------------+---------------------
 * | 20120517 |Alessandro Cornaglia | + GestioneLog
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

import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che si occupa di gestire i log del sistema
 * 
 * @author acornagl 
 * @version v1.0
 */
public class GestioneLog{

  private UpdateLog updateLog;
  private DAODipendenti daoDipendenti;
    
  /**
   * Costruttore senza parametri della classe GestioneLog
   * 
   */
  public GestioneLog(UpdateLog upLog, DAODipendenti daoDip) {
   updateLog= upLog;
   daoDipendenti = daoDip;
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
   * @param login oggetto Login dovuto dall'effettuazione del login da parte di un dipendente
   */
  public void scriviLoginD(Login login) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogLoginD";
	Dipendente dip = daoDipendenti.getInfoD(login);
    this.updateLog.scriviLogTre(nomeTabella,dip,dataOra.toString());
   /* DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
   	
    //creo path del file da scrivere e creo UpdateLog
    this.percorso = "/login.txt";
   
	try {
	  this.updateLog = new UpdateLog("/"+login.getUsername(),this.percorso);
	}
	catch (IOException e) {System.out.println("non va"); }//bisogna decidere cosa fare se si verifica errore
    
    log = "LOGIN " + dataOra.toString() + " " + login.getUsername(); //stringa contenente il log
    updateLog.scriviChiudi(log);//passo la stringa creata a updateLog*/
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo un login amministratore
   * 
   * @param login oggetto Login dovuto dall'effettuazione del login da parte di un dipendente
   */
  public void scriviLoginA(Login login) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogLoginA";
	Dipendente dip = daoDipendenti.getInfoA(login);
    this.updateLog.scriviLogTre(nomeTabella,dip,dataOra.toString());
   /* DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
   	
    //creo path del file da scrivere e creo UpdateLog
    this.percorso = "/login.txt";
   
	try {
	  this.updateLog = new UpdateLog("/"+login.getUsername(),this.percorso);
	}
	catch (IOException e) {System.out.println("non va"); }//bisogna decidere cosa fare se si verifica errore
    
    log = "LOGIN " + dataOra.toString() + " " + login.getUsername(); //stringa contenente il log
    updateLog.scriviChiudi(log);//passo la stringa creata a updateLog*/
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo un logout
   * 
   * @param login oggetto Login del dipendente che ha effettuato il logout
   */
  public void scriviLogoutD(Login login) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogLogoutD";
	Dipendente dip = daoDipendenti.getInfoD(login);
    this.updateLog.scriviLogTre(nomeTabella,dip,dataOra.toString());
    /*DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/logout.txt";

    try {
	  this.updateLog = new UpdateLog("/"+login.getUsername(),percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

    log = "LOGOUT " + dataOra.toString() + " " + login.getUsername(); //stringa contenente il log
    updateLog.scriviChiudi(log);//passo la stringa creata a updateLog
    */
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo un logout amministratore
   * 
   * @param login oggetto Login dell'amministratore che ha effettuato il logout
   */
  public void scriviLogoutA(Login login) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogLogoutA";
	Dipendente dip = daoDipendenti.getInfoA(login);
    this.updateLog.scriviLogTre(nomeTabella,dip,dataOra.toString());
    /*DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/logout.txt";

    try {
	  this.updateLog = new UpdateLog("/"+login.getUsername(),percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

    log = "LOGOUT " + dataOra.toString() + " " + login.getUsername(); //stringa contenente il log
    updateLog.scriviChiudi(log);//passo la stringa creata a updateLog
    */
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene ricevuta da un dipendente
   * 
   * @param login oggetto Login del dipendente che riceve la domanda
   * @param dom domanda che viene ricevuta dall'utente
   */
  public void scriviDomRic(Login login, Domanda dom) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogRicevuta";
	Dipendente dip = daoDipendenti.getInfoD(login);
	String colonna = "IDdomanda";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,""+dom.getId());
    /*DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso =  "/dRic.txt";

    try {
	  this.updateLog = new UpdateLog("/"+login.getUsername(),percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

    log = "DOMANDA RICEVUTA " + dataOra.toString() + " usr=" + login.getUsername() + " id dom=" + dom.getId();
    updateLog.scriviChiudi(log);*/
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene proposta ad un dipendente 
   *
   * @param login oggetto Login del dipendente che riceve la proposta di domanda
   * @param dom domanda che viene proposta all'utente
   */
  public void scriviDomProp(Login login, Domanda dom) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "LogProposta";
	Dipendente dip = daoDipendenti.getInfoD(login);
	String colonna = "IDdomanda";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,""+dom.getId());  
	  /*
    DataOra dataOra = new DataOra();
	String nomeTabella = "LogProposta";
    this.updateLog.scriviLogQuattro(nomeTabella,login,dataOra.toString(),dom.getId());
	/*  DataOra dataOra = new DataOra(); // ricavo data ed ora attuali

    //creo path del file da scrivere e creo UpdateLog
    percorso = "/dProp.txt";

    try {
	  this.updateLog = new UpdateLog("/"+login.getUsername(),percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
    
	log = "DOMANDA PROPOSTA " + dataOra.toString() + " usr=" + login.getUsername() + " id dom=" + dom.getId();
    updateLog.scriviChiudi(log);
    */
  }

  /**
   *metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene posticipata da un dipendente 
   *
   * @param login oggetto Login del dipendente che posticipa una domanda
   * @param dom domanda che viene posticipata dall'utente
   */
  public void scriviDomPost(Login login, Domanda dom) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogPosticipa";
	Dipendente dip = daoDipendenti.getInfoD(login);
	String colonna = "IDdomanda";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,""+dom.getId());
/*	DataOra dataOra = new DataOra();
	String nomeTabella = "LogPosticipa";
    this.updateLog.scriviLogQuattro(nomeTabella,login,dataOra.toString(),dom.getId());  
  /*  DataOra dataOra = new DataOra(); // ricavo data ed ora attuali

    //creo path del file da scrivere e creo UpdateLog
    percorso = "/dPost.txt";
    
	try {
	  this.updateLog = new UpdateLog("/"+login.getUsername(),percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
    
	log = "DOMANDA POSTICIPATA " + dataOra.toString() + " usr=" + login.getUsername() + " id dom=" + dom.getId();
    updateLog.scriviChiudi(log);*/
  }
  
  /**
   *metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene posticipata da un dipendente 
   *
   * @param login oggetto Login del dipendente che posticipa una domanda
   * @param dom domanda che viene posticipata dall'utente
   */
  public void scriviDomRisp(Login login, Domanda dom) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "LogRisposta";
	Dipendente dip = daoDipendenti.getInfoD(login);
	String colonna = "IDdomanda";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,""+dom.getId());
   /* DataOra dataOra = new DataOra(); // ricavo data ed ora attuali

    //creo path del file da scrivere e creo UpdateLog
    percorso = "/dRisp.txt";

    try {
	  this.updateLog = new UpdateLog("/"+login.getUsername(),percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
    
	log = "DOMANDA RISPOSTA " + dataOra.toString() + " usr=" + login.getUsername() + " id dom=" + dom.getId();
    updateLog.scriviChiudi(log);*/
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che un dipendente modifica la propria password 
   * 
   * @param dip dipendente che ha modificato la propria password
   */
  public void scriviModPassD(Dipendente dip) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "LogModificaDip";
	String operazione = "pass";
	String colonna = "TipoModifica";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,"'"+operazione+"'");
/*    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    String usr = dip.getNickname(); //ricavo il nick del dipendente, utile per il path
    percorso = "/modPassD.txt";

    try {
	  this.updateLog = new UpdateLog("/"+dip.getNickname(),percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

	log = "MODIFICA PASS D " + dataOra.toString() + " id dip=" + dip.getId();
    updateLog.scriviChiudi(log);*/
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che un dipendente modifica la propria email 
   * 
   * @param dip dipendente che ha modificato la propria email
   */
  public void scriviModEmailD(Dipendente dip) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "LogModificaDip";
	String operazione = "mail";
	String colonna = "TipoModifica";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,"'"+operazione+"'");
	  /*
    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    String usr = dip.getNickname(); //ricavo il nick del dipendente, utile per il path
    percorso = "/modEmailD.txt";
    
	try {
	  this.updateLog = new UpdateLog("/"+dip.getNickname(),percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

    log = "MODIFICA EMAIL D " + dataOra.toString() + " id dip=" + dip.getId();
    updateLog.scriviChiudi(log);*/
  }

  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che un dipendente ottiene un badge
   * 
   * @param dip dipendente che ha ottenuto un badge
   * @param badge badge ottenuto
   */
  public void scriviOttenimentoBadge(Dipendente dip, Badge badge) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "OttenimentoBadge";
	String colonna = "IdBadge";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,""+badge.getId());
	/*DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    String usr = dip.getNickname(); //ricavo il nick del dipendente, utile per il path
    percorso = "/modOttB.txt";
	try {
	  this.updateLog = new UpdateLog("/"+dip.getNickname(),percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

	log = "OTTENIMENTO BADGE " + dataOra.toString() + " id dip=" + dip.getId() + " badge=" + badge.getNome();
    updateLog.scriviChiudi(log);*/
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AA aggiunge un dipendente
   * 
   * @param dip dipendente aggiunto
   */
  public void scriviAddDip(Dipendente dip) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "ModDipendente";
	String operazione = "aggiungi";
	String colonna = "Operazione";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,"'"+operazione+"'");
	/*  
	DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/AA.txt";
	try {
	  this.updateLog = new UpdateLog("/AA",percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

	log = "AGGIUNTO DIPENDENTE " + dataOra.toString() + " id dip=" + dip.getId();
    updateLog.scriviChiudi(log);*/
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AA rimuove un dipendente
   * 
   * @param dip dipendente rimosso
   */
  public void scriviDelDip(Dipendente dip) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "ModDipendente";
	String operazione = "elimina";
	String colonna = "Operazione";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,"'"+operazione+"'");
	  /*
	DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/AA.txt";
	try {
	  this.updateLog = new UpdateLog("/AA",percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

	log = "RIMOSSO DIPENDENTE " + dataOra.toString() + " id dip=" + dip.getId();
    updateLog.scriviChiudi(log);*/
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AA modifica un dipendente
   * 
   * @param dip dipendente modificato
   */
  public void scriviModDip(Dipendente dip) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "ModDipendente";
	String operazione = "modifica";
	String colonna = "Operazione";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,"'"+operazione+"'");
	/*DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/AA.txt";
	try {
	  this.updateLog = new UpdateLog("/AA",percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

	log = "MODIFICATO DIPENDENTE " + dataOra.toString() + " id dip=" + dip.getId();
    updateLog.scriviChiudi(log);*/
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AS aggiunge una o più domande
   * 
   * @param dom domande aggiunte
   */
  public void scriviAddDomande(Domanda [] dom) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "AddRemDomanda";
	String operazione = "add";
	for(int i = 0; i< dom.length; i++) {
      this.updateLog.scriviLogDomande(nomeTabella,dataOra.toString(),""+dom[i].getId(),"'"+operazione+"'");
	}
	/*DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/AS.txt";
	try {
	  this.updateLog = new UpdateLog("/AS",percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

	//scrivo una riga per ogni domanda aggiunta
	for (int i = 0; i < dom.length; i++) {
	  log = "AGGIUNTA DOMANDA " + dataOra.toString() + " id dom=" + dom[i].getId();
	  updateLog.scriviChiudi(log);
	}*/
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AS rimuove una o più domande
   * 
   * @param dom domande rimosse
   */
  public void scriviDelDomande(Domanda [] dom) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "AddRemDomanda";
	String operazione = "del";
	for(int i = 0; i< dom.length; i++) {
		this.updateLog.scriviLogDomande(nomeTabella,dataOra.toString(),""+dom[i].getId(),"'"+operazione+"'");
	}
	/*DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    
    //creo path del file da scrivere e creo UpdateLog
    percorso = "/AS.txt";
	try {
	  this.updateLog = new UpdateLog("/AS",percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore

	//scrivo una riga per ogni domanda aggiunta
	for (int i = 0; i < dom.length; i++) {
	  log = "RIMOSSA DOMANDA " + dataOra.toString() + " id dom=" + dom[i].getId();
	  updateLog.scriviChiudi(log);
	}*/
  }

}