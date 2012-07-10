/*
 * Name: ApplicazioniConnection.java
 * Package: com.safetygame.back.connection
 * Author: Lorenzo Braghetto
 * Date: {Data di approvazione del file}
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120611 | Lorenzo Braghetto   | ApplicazioniConnection
 * |          |                     | login
 * |          |                     | getDati
 * |          |                     | getStat
 * |          |                     | modPass
 * |          |                     | modMail
 * |          |                     | resetPass
 * |          |                     | mostraDomanda
 * |          |                     | posticipa
 * |          |                     | rispondi
 * |          |                     | logout
 * |          |                     | getBadge
 * +----------+---------------------+----------------------
 * 
 */ 
package com.safetyGame.back.connection;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

  /**
   * Classe che si occupa di gestire la connessione da parte delle applicazioni
   * 
   * @author lbraghetto 
   * @version v0.1
   */
public class ApplicazioniConnection{
  private GestioneDati dati;
   
  
  /**
   * Costruttore della classe WebConnection
   * 
   * @param d riferimento al facade GestioneDati 
   */
  public ApplicazioniConnection(GestioneDati d){dati = d;}
    
  /**
   * Metodo per il login dei dipendenti
   * 
   * @param login oggetto contenente i dati di login inseriti dall'utente
   * @return boolean che conferma il successo o meno dell'operazione
   */
  public boolean login(String username, String password){
    Login l=new Login(username,password);
    return dati.loginUser(l);
  }
    
  /**
   * Metodo che consente di reperire le informazioni di un dipendente a partire
   * dal suo login
   * 
   * @param l login del dipendente
   * @return informazioni sul dipendente
   */
  public Dipendente getDati(Login l){
    return dati.getDati(l);
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
   * Metodo che consente la modifica della password da parte di un dipendente
   *
   * @param dip dipendente che chiede di modificare la password 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modPass(Dipendente d){
    return dati.modificaPass(d);
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
  public boolean resetPass(Recupero r){
    return dati.recuperoD(r);
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
   * Metodo che si occupa di comunicare la risposta del Dipendente
   * 
   * @param l Login del dipendente che ha risposto
   * @param risposta Domanda posta al dipendente contenente la risposta data
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   */
  public boolean rispondi(Login l, Domanda d){
    return dati.setRisposta(l, d);
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
    * Metodo per ottenere i dati dei badge per un dato utente
    * 
    * @param login dati dell'utente che effettua la richiesta
    * @param n numero di badge che si vuole selezionare
    * @return un ArrayList<Badge> contenente n badge ottenuti dall'utente 
  */
  public ArrayList<Badge> getBadge(Login l, int n){
    return dati.getBadgeD(l,n);
  }
}
