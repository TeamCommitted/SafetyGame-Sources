/*
 * Name: GestionePunteggiD.java
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
 * | 20120608 |Alessandro Cornaglia | + logout
 * |          |                     | * getBadgeD
 * |          |                     | + getStatisticheGlob
 * +----------+---------------------+---------------------
 * | 20120607 |Alessandro Cornaglia | + GestioneDati
 * |          |                     | + getBadgeAS
 * |          |                     | + getBadgeD
 * |          |                     | + assegnaBadgeD
 * |          |                     | + getElencoDipendenti
 * |          |                     | + aggiungiDipendente
 * |          |                     | + cancellaDipendente
 * |          |                     | + modDipendente
 * |          |                     | + getBadgeASgetDati
 * |          |                     | + modificaPass
 * |          |                     | + modificaEmail
 * |          |                     | + getElencoDomande
 * |          |                     | + getBadgeAS
 * |          |                     | + addDomanda
 * |          |                     | + remDomanda
 * |          |                     | + getDomandaD
 * |          |                     | + setRisposta
 * |          |                     | + loginAdmin
 * |          |                     | + loginUser
 * |          |                     | + getPunteggi
 * |          |                     | + setTrofei
 * |          |                     | + getStatisticheD
 * |          |                     | + posticipa
 * +----------+---------------------+----------------------
 * 
 */ 
package com.safetyGame.back.controller;

import java.util.ArrayList;

import com.safetyGame.back.condivisi.*;

/**
 * Classe GestioneDati, facade del package controller del back-end
 * @author acornagl
 * @version = 0.1
 */
public class GestioneDati{
   
  private GestioneRecupero gestioneRecupero;
  private GestioneLogin gestioneLogin;
  private GestioneDomandeD gestioneDomandeD;
  private GestioneDomandeAS gestioneDomandeAS;
  private GestioneDipendentiD gestioneDipendentiD;
  private GestioneDipendentiAA gestioneDipendentiAA;
  private GestioneBadgeD gestioneBadgeD;
  private GestioneBadgeAS gestioneBadgeAS;
  private GestionePunteggiD gestionePunteggiD;
  private GestionePunteggiAA gestionePunteggiAA;

  /**
   * Costruttore, con parametri, della classe GestioneDati 
   * 
   * @param gr riferimento ad oggetto di tipo GestioneRecupero
   * @param gl riferimento ad oggetto di tipo GestioneLogin
   * @param gdd riferimento ad oggetto di tipo GestioneDomandeD
   * @param gda riferimento ad oggetto di tipo GestioneDomandeAS
   * @param gdip riferimento ad oggetto di tipo GestioneDipendentiD
   * @param gdipa riferimento ad oggetto di tipo GestioneDipendentiAA
   * @param gbd riferimento ad oggetto di tipo GestioneBadgeD
   * @param gba riferimento ad oggetto di tipo GestioneBadgeAS
   * @param gpd riferimento ad oggetto di tipo GestionePunteggiD
   * @param gpaa riferimento ad oggetto di tipo GestionePunteggiAA
   */
  public GestioneDati(GestioneRecupero gr,GestioneLogin gl, GestioneDomandeD gdd, GestioneDomandeAS gda, GestioneDipendentiD gdip, GestioneDipendentiAA gdipa, GestioneBadgeD gbd, GestioneBadgeAS gba, GestionePunteggiD gpd, GestionePunteggiAA gpaa) {
	this.gestioneRecupero = gr;
	this.gestioneLogin = gl;
	this.gestioneDomandeD = gdd;
	this.gestioneDomandeAS = gda;
	this.gestioneDipendentiD = gdip;
	this.gestioneDipendentiAA = gdipa;
	this.gestioneBadgeD = gbd;
	this.gestioneBadgeAS = gba;
	this.gestionePunteggiD = gpd;
	this.gestionePunteggiAA = gpaa;
  }
  
  /**
   * Costruttore senza parametri della classe GestioneDati
   */
  public GestioneDati() {
	this.gestioneRecupero = null;
	this.gestioneLogin = null;
	this.gestioneDomandeD = null;
	this.gestioneDomandeAS = null;
	this.gestioneDipendentiD = null;
	this.gestioneDipendentiAA = null;
	this.gestioneBadgeD = null;
	this.gestioneBadgeAS = null;
	this.gestionePunteggiD = null;
	this.gestionePunteggiAA = null;  
  }
  /**
  * Metodo per ottenere tutti i badge possibili
  * @return un ArrayList<Badge> contenente tutte le badge nel database
  * 
  */
  public ArrayList<Badge> getBadgesAS() {
    return this.gestioneBadgeAS.getBadgesAS();
  }
  
  /**
    * Metodo per ottenere i dati delle badge per un dato utente
    * 
    * @param login dati dell'utente che effettua la richiesta
    * @param n numero di badge che si vuole selezionare
    * @return un ArrayList<Badge> contenente n badge ottenute dall'utente 
   */
  public ArrayList<Badge> getBadgeD(Login l, int n) {
    return this.gestioneBadgeD.getBadgeD(l, n);  
  }
  
  /**
   * Metodo per controllare se l'utente ha soddisfatto dei requisiti per ottenere un badge
   * 
   * @param l dati dell'utente che si deve controllare
   * @param D domanda risposta dall'utente
   * @return true se l'utente ha ricevuto un badge, altrimenti false    
   */
  public boolean assegnaBadge(Domanda D, Login l) {
    return this.gestioneBadgeD.assegnaBadge(D, l);
  }
  
  /**
   * Metodo per ottenere i dati dei dipendenti dell'azienda
   * @return un ArrayList<Dipendente> contenente i dipendenti dell'azienda      
   */
  public ArrayList<Dipendente> getElencoDipendenti() {
    return this.gestioneDipendentiAA.getElencoDipendenti();
  }
  
  /**
   * Metodo per aggiungere un dipendente
   * 
   * @param Dip oggetto contenente i dati del nuovo dipendente
   * @return true se l'operazione viene completata con successo, altrimenti false    
   */
  public boolean aggiungiDipendente(Dipendente Dip) {
    return this.gestioneDipendentiAA.aggiungiDipendente(Dip);
  }
  
  /**
   * Metodo per eliminare
   * 
   * @param Dip oggetto contenente i dati del dipendente da eliminare
   * @return true se l'operazione viene completata con successo, altrimenti false    
   */
  public boolean cancellaDipendente(Dipendente Dip) {
	return this.gestioneDipendentiAA.cancellaDipendente(Dip);
  }
  
  /**
   * Metodo per modificare i dati di un dipendente
   * 
   * @param newDip oggetto contenente i nuovi dati del dipendente da modificare
   * @param oldDip oggetto contenente i vecchi dati del dipendente da modificare
   * @return true se l'operazione viene completata con successo, altrimenti false
   */
  public boolean modDipendente(Dipendente newDip, Dipendente oldDip) {
	return this.gestioneDipendentiAA.modDipendente(newDip, oldDip);
  }
  
  /**
   * Metodo che consente di reperire le informazioni di un dipendente a partire
   * dal suo login
   * 
   * @param l login del dipendente
   * @return informazioni sul dipendente
   */
  public Dipendente getDati(Login l) {
    return this.gestioneDipendentiD.getDati(l);
  }
  
  /**
   * Metodo che consente la modifica della password da parte di un dipendente
   *
   * @param dip dipendente che chiede di modificare la password
   * 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modificaPass(Dipendente dip) {
	return this.gestioneDipendentiD.modificaPass(dip);
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
	return this.gestioneDipendentiD.modificaEmail(dip, nEmail);
  }
  
  /**
   * Metodo per ottenere la lista di tutte le domande
   * @return un ArrayList<Domande> contenente tutte le domande
   */
  public ArrayList<Domanda> getElencoDomande() {
	return this.gestioneDomandeAS.getElencoDomande();
  }
  
  /**
   * Metodo per inserire una domanda dal server domande al server dell'azienda
   * @return true se l'operazione è stata completata, altrimenti false   
   */
  public boolean addDomanda(Domanda Dom) {
    return this.gestioneDomandeAS.addDomanda(Dom);
  }
  
  /**
   * Metodo per eliminare una domanda dal server dell'azienda
   * @return true se l'operazione è stata completata, altrimenti false       
   */
  public boolean remDomanda(Domanda Dom) {
	return this.gestioneDomandeAS.remDomanda(Dom);
  }
  
  /**
   * Metodo che consente di recuperare una domanda 
   * 
   * @param l oggetto Login del dipendente che deve ricevere la domanda
   * @return domanda per il login proposto
   */
  public Domanda getDomandaD(Login l) {
	return this.gestioneDomandeD.getDomandaD(l);
  }
  
  /**
   * Metodo che si occupa di controllare la risposta data da un dipendente ad una
   * domanda e tenta di scrivere tali informazioni sul DB. Se la risposta è corretta
   * assegna il punteggio al dipendente
   * 
   * @param l Login del dipendente che ha risposto
   * @param risposta Domanda posta al dipendente contenente la risposta data
   */
  public boolean setRisposta(Login l,Domanda risposta) {
	return this.gestioneDomandeD.setRisposta(l, risposta);
  }
  
  /**
   * Metodo per il login degli utenti amministratori
   * 
   * @param login oggetto contenente i dati di login inseriti dall'utente
   */
  public boolean loginAdmin(Login login){
	return this.gestioneLogin.loginAdmin(login);
  }
  
  /**
   * Metodo per il login dei dipendenti
   * 
   * @param login oggetto contenente i dati di login inseriti dall'utente
   */
  public boolean loginUser(Login login) {
	return this.gestioneLogin.loginUser(login);		
  }
  
  /**
   * Metodo per ottenere i punteggi medi dell'azienda e i punteggi di tutti i dipendenti
   * 
   * @return un ArrayList<Punteggio> contenente in posizione 0 un oggetto Punteggio contenente i dati medi dell'azienda
   * e successivamente la lista dei punteggi di tutti i dipendenti.
   */
  public ArrayList<Dipendente> getPunteggi() {
	return this.gestionePunteggiAA.getPunteggi();
  }
  
  /**
   * Metodo per modificare i trofei di un dipendente
   * 
   * @param Dip il dipendente che si vuole modificare
   *        n numero di trofei che si vuole assegnare
   * @return true se l'operazione ha successo, altrimenti false  
   */
   public boolean setTrofei(Dipendente Dip, int n) {
	 return this.gestionePunteggiAA.setTrofei(Dip, n);
   }
   
   /**
    * Metodo che consente di recuperare le statistiche di un determinato dipendente
    * 
    * @param l login del dipendente che richiede di conoscere le statistiche
    * 
    * @return statistiche del dipendente
    */
   public Punteggio getStatisticheD(Login l) {
	 return this.gestionePunteggiD.getStatisticheD(l);
   }
   
  
   /**
    * Metodo che si occupa di controllare quando una domanda viene posticipata
    * @param l login del dipendente
    * @param d domanda posticipata
    * @return true se la domanda è stata posticipata correttamente, false altrimenti
    */
   public boolean posticipa(Login l, Domanda d) {
	 return this.gestioneDomandeD.posticipa(l, d);
   }
   
   /**
    * Metodo per segnalare al sistema il logout di un utente
    * 
    * @param l login del dipendente che ha effettuato il logout
    */
   public void logout(Login l) {
	 this.gestioneLogin.logout(l);
   }
   
   /**
    * Metodo che consente di recuperare le statistiche globali
    * 
    * @param l login del dipendente che richiede di conoscere le statistiche
    * @return statistiche globali
    */
   public Punteggio getStatisticheGlob(Login l) {
	 return this.gestionePunteggiD.getStatisticheGlob(l);
   }
}