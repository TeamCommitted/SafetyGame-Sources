/*
 * Name: WebConnection.java
 * Package: com.safetygame.back.connection
 * Author: Gabriele Facchin
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120708 | Alessandro Cornaglia| + getElencoRuoli
 * +----------+---------------------+---------------------
 * | 20120609 | Gabriele Facchin    | + WebConnection
 * |          |                     | + loginDip
 * |          |                     | + loginAdmin 
 * |          |                     | + getDati 
 * |          |                     | + getPunteggio 
 * |          |                     | + getStat 
 * |          |                     | + getBadge
 * |          |                     | + modPassD 
 * |          |                     | + modPassA 
 * |          |                     | + modMail 
 * |          |                     | + resetPassD 
 * |          |                     | + resetPassA  
 * |          |                     | + mostraDomanda
 * |          |                     | + setRisposta 
 * |          |                     | + posticipa 
 * |          |                     | + logout 
 * |          |                     | + getElencoDomande 
 * |          |                     | + cancellaDomanda 
 * |          |                     | + aggiungiDomanda 
 * |          |                     | + getElencoDipendenti 
 * |          |                     | + setTrofei 
 * |          |                     | + aggiungiDipendente 
 * |          |                     | + cancellaDipendente 
 * |          |                     | + modInfoDipendente 
 * |          |                     | + getBadgesAS 
 * |          |                     | + assegnaBadge 
 * |          |                     | + getPunteggi 
 * +----------+---------------------+----------------------
 * 
 */ 
package com.safetyGame.back.connection;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

  /**
   * Classe che si occupa di gestire la connessione da parte del web
   * 
   * @author gfacchin 
   * @version v0.1
   */
public class WebConnection{
  private GestioneDati dati;
  /**
   * Costruttore della classe WebConnection
   * 
   * @param d riferimento al facade GestioneDati 
   */
  public WebConnection(GestioneDati d){dati=d;}
    
  /**
   * Metodo per il login dei dipendenti
   * 
   * @param login oggetto contenente i dati di login inseriti dall'utente
   * @return boolean che conferma il successo o meno dell'operazione
   */
  public boolean loginDip(String username, String password){
    Login l=new Login(username,password);
    return dati.loginUser(l);
  }

  /**
   * Metodo per il login degli utenti amministratori
   * 
   * @param login oggetto contenente i dati di login inseriti dall'utente
   * @return boolean che conferma il successo o meno dell'operazione
   */
  public boolean loginAdmin(String username, String password, boolean tipo){
    Login l=new Login(username,password);
    return dati.loginAdmin(l,tipo);
  }
    
  /**
   * Metodo che consente di reperire le informazioni di un dipendente a partire
   * dal suo login
   * 
   * @param l login del dipendente
   * @return informazioni sul dipendente
   */
  public Dipendente getDati(Login l){
    return dati.getDatiD(l); 
  }
  
  /**
   * Metodo che consente di reperire le informazioni di un amministratore a partire
   * dal suo login
   * 
   * @param l login dell'amministratore
   * @return informazioni sull'amministratore
   */
  public Dipendente getDatiA(Login l){
    return dati.getDatiA(l); 
  }
   
   /**
    * Metodo che consente di recuperare le statistiche di un determinato dipendente
    * 
    * @param l login del dipendente che richiede di conoscere le statistiche
    * @return statistiche del dipendente
    */
  public Punteggio getPunteggio(Login l){
    return dati.getStatisticheD(l);
  }

   /**
    * Metodo che consente di recuperare le statistiche globali
    * 
    * @param l login del dipendente che richiede di conoscere le statistiche
    * @return statistiche globali
    */ 
  public Punteggio getStat(Login l){
    return dati.getStatisticheGlob(l);
  }

  /**
    * Metodo per ottenere i dati dei badge per un dato utente
    * 
    * @param login dati dell'utente che effettua la richiesta
    * @param n numero di badge che si vuole selezionare
    * @return un ArrayList<Badge> contenente n badge ottenuti dall'utente 
  */
  public ArrayList<Badge> getBadge(Login l, int n){
    return dati.getBadgeD(l,n);
  }

  /**
   * Metodo che consente la modifica della password da parte di un dipendente
   *
   * @param dip dipendente che chiede di modificare la password 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modPassD(Dipendente dip){
    return dati.modificaPass(dip);
  }
   
  /**
   * Metodo che consente la modifica della password da parte di un amministratore
   *
   * @param dip Dipendente contenente i dati di un Amministratore che chiede di modificare la password 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modPassA(Dipendente dip){
    return dati.modPassA(dip);
  }
   
  /**
   * Metodo che consente la modifica della mail da parte di un dipendente
   * 
   * @param d Dipendente che chiede di modificare la mail
   * @param mail nuovo indirizzo mail da inserire
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modMail(Dipendente d, String mail){
    return dati.modificaEmail(d,mail);
  }
     
  /**
   * Metodo che consente la rigenerazione della password per un dipendente
   * 
   * @param d Dipendente che chiede di modificare la mail
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean resetPassD(Recupero r){
    return dati.recuperoD(r);
  }
   
  /**
   * Metodo che consente la rigenerazione della password per un amministratore
   * 
   * @param d Dipendente che chiede di modificare la mail
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean resetPassA(Recupero r){
    return dati.recuperoA(r);
  }
   
  /**
   * Metodo che consente di recuperare una domanda 
   * 
   * @param l oggetto Login del dipendente che deve ricevere la domanda
   * @return domanda per il login proposto
   */
  public Domanda mostraDomanda(Login l){
    return dati.getDomandaD(l);
  }
  
  /**
   * Metodo che si occupa di comunicare la risposta del Dipendente
   * 
   * @param l Login del dipendente che ha risposto
   * @param risposta Domanda posta al dipendente contenente la risposta data
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   */
  public boolean setRisposta(Login l,Domanda risposta) {
	return dati.setRisposta(l, risposta);
  }
   
   /**
    * Metodo per posticipare una domanda
    * 
    * @param l login del dipendente
    * @param d domanda posticipata
    * @return true se la domanda è stata posticipata correttamente, false altrimenti
    */
  public boolean posticipa(Login l, Domanda d){
    return dati.posticipa(l, d);
  }

   /**
    * Metodo per segnalare al sistema il logout di un utente
    * 
    * @param l login del dipendente che ha effettuato il logout
    */
  public void logout(Login l){
    dati.logout(l);
  }
   
  /**
   * Metodo per ottenere la lista di tutte le domande
   * 
   * @return un ArrayList<Domande> contenente tutte le domande
   */
  public ArrayList<Domanda> getElencoDomande(){
    return dati.getElencoDomande();
  }
  
  /**
   * Metodo per inserire una domanda dal server domande al server dell'azienda
   * 
   * @return true se l'operazione è stata completata, altrimenti false   
   */
  public boolean aggiungiDomanda(Domanda d){
    return dati.addDomanda(d);
  }
  
  /**
   * Metodo per eliminare una domanda dal server dell'azienda
   * 
   * @return true se l'operazione è stata completata, altrimenti false       
   */   
  public boolean cancellaDomanda(Domanda d){
    return dati.remDomanda(d);
  }

  /**
   * Metodo per ottenere i dati dei dipendenti dell'azienda
   * 
   * @return un ArrayList<Dipendente> contenente i dipendenti dell'azienda      
   */
  public ArrayList<Dipendente> getElencoDipendenti(){
    return dati.getElencoDipendenti();
  }
  
  /**
   * Metodo per modificare i trofei di un dipendente
   * 
   * @param Dip il dipendente che si vuole modificare
   * @param n numero di trofei che si vuole assegnare
   * @return true se l'operazione ha successo, altrimenti false  
   */
  public boolean setTrofei(Dipendente d, int n){
    return dati.setTrofei(d, n);
  }
   
  /**
   * Metodo per aggiungere un dipendente
   * 
   * @param Dip oggetto contenente i dati del nuovo dipendente
   * @return true se l'operazione viene completata con successo, altrimenti false    
   */
  public boolean aggiungiDipendente(Dipendente d){
    return dati.aggiungiDipendente(d);
  }
   
  /**
   * Metodo per eliminare un Dipendente
   * 
   * @param Dip oggetto contenente i dati del dipendente da eliminare
   * @return true se l'operazione viene completata con successo, altrimenti false    
   */
  public boolean cancellaDipendente(Dipendente d){
    return dati.cancellaDipendente(d);
  }

  /**
   * Metodo per modificare i dati di un dipendente
   * 
   * @param newDip oggetto contenente i nuovi dati del dipendente da modificare
   * @param oldDip oggetto contenente i vecchi dati del dipendente da modificare
   * @return true se l'operazione viene completata con successo, altrimenti false
   */
  public boolean modDipendente(Dipendente dOld, Dipendente dNew){
    return dati.modDipendente(dNew, dOld);
  }
   
  /**
  * Metodo per ottenere tutti i badge possibili
  * @return un ArrayList<Badge> contenente tutti i badge nel database
  * 
  */
  public ArrayList<Badge> getBadgesAS() {
    return dati.getBadgesAS();
  }
  
  /**
   * Metodo per assegnare un badge
   * 
   * @param l dati dell'utente che si deve controllare
   * @param D domanda risposta dall'utente
   * @return true se l'utente ha ricevuto un badge, altrimenti false    
   */
  public boolean assegnaBadge(Domanda D, Login l) {
    return dati.assegnaBadge(D, l);
  }

  /**
   * Metodo per ottenere i punteggi medi dell'azienda e i punteggi di tutti i dipendenti
   * 
   * @return un ArrayList<Punteggio> contenente in posizione 0 un oggetto Punteggio contenente i dati medi dell'azienda
   * e successivamente la lista dei punteggi di tutti i dipendenti.
   */
  public ArrayList<Dipendente> getPunteggi() {
	return dati.getPunteggi();
  }
  
  /**
   * Metodo per recuperare lista dei ruoli aziendali
   * 
   * @return lista ruoli aziendali
   */
  public ArrayList<String> getElencoRuoli() {
    return dati.getElencoRuoli();
  }
}