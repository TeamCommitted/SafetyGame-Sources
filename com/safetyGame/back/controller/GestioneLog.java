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
    String percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "login.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
    
    String log = "LOGIN " + dataOra.toString() + " " + dipendente.toStringID(); //stringa contenente il log
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
    String percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "logout.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
    String log = "LOGOUT " + dataOra.toString() + dipendente.toStringID(); //stringa contenente il log
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
    String percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "dRic.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
    String log = "DOMANDA RICEVUTA" + dataOra.toString() + " id dip=" + dipendente.getId() + " id dom=" + d.getId();
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
    String percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "dProp.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
    
	String log = "DOMANDA PROPOSTA" + dataOra.toString() + " id dip=" + dipendente.getId() + " id dom=" + d.getId();
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
    String percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "dPost.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
    
	String log = "DOMANDA POSTICIPATA" + dataOra.toString() + " id dip=" + dipendente.getId() + " id dom=" + d.getId();
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
    String percorso = "/log/";
    int idDip = l.getDipendente().getId();
    percorso += idDip + "/" + "dRisp.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
    
	String log = "DOMANDA PROPOSTA" + dataOra.toString() + " id dip=" + dipendente.getId() + " id dom=" + d.getId();
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
    String percorso = "/log/";
    int idDip = d.getId();
    percorso += idDip + "/" + "ModPassD.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
	String log = "MODIFICA PASS D" + dataOra.toString() + " id dip=" + d.getId();
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
    String percorso = "/log/";
    int idDip = d.getId();
    percorso += idDip + "/" + "ModEmailD.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
	String log = "MODIFICA EMAIL D" + dataOra.toString() + " id dip=" + d.getId();
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
    String percorso = "/log/";
    int idDip = d.getId();
    percorso += idDip + "/" + "ModOttB.txt";
	try {
	  this.updateLog = new UpdateLog(percorso);
	}
	catch (IOException e) { }//bisogna decidere cosa fare se si verifica errore
	
	String log = "OTTENIMENTO BADGE " + dataOra.toString() + " id dip=" + d.getId() + " badge=" + b.getNome();
    updateLog.scriviChiudi(log);
  }
  
/*   DataOra dataora;
   UpdateLog logGenerale; //o uno per tipo "generale" login / logout / domande / mod...
   UpdateLog utente;
   public GestioneLog(){}
   
   public void login(String username, char u){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void chiediDomanda(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void posticipa(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void rispondi(String username, String risposta){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }   
   public void datiD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void passD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void mailD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void getStat(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void passA(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void listaD(){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void addD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void delD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void nome(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void cognome(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void codfis(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void username(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void impiego(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void trofei(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void reset(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void badgeD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void domandeA(){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void addDomanda(){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void remDomanda(){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void logout(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
*/   
}