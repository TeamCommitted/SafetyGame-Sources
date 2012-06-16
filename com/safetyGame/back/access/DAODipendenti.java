/*
 * Name: DAODipendenti.java
 * Package: com.safetygame.back.access
 * Author: Gabriele Facchin
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120512 | Gabriele Facchin    | + getInfoD
 * |          |                     | + getInfoA
 * |          |                     | + resetPassD                
 * |          |                     | + resetPassA
 * |          |                     | + passD
 * |          |                     | + passA
 * |          |                     | + mailD
 * |          |                     | + elencoDipendenti
 * |          |                     | + aggiungiDipendente
 * |          |                     | + cancellaDipendente
 * |          |                     | + modNome
 * |          |                     | + modCognome
 * |          |                     | + modCodFis
 * |          |                     | + modUsername
 * |          |                     | + modImpiego
 * |          |                     | + setTrofei
 * |          |                     | + resetA
 * |          |                     | + resetD
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaccia che contiene i prototipi dei metodi per gestire un dipendente
 * 
 * @author gfacchin
 * @version 1.0
 */

public interface DAODipendenti{
  
  /**
   * Metodo che prende le informazioni di un Dipendente dal database
   * 
   * @param l Oggetto Login da cui si prendono le informazioni
   * @return l'oggetto Dipendente istanziato se presente nel db, altrimenti null
   * 
   */     
  public Dipendente getInfoD(Login l);
  
  /**
   * Metodo che prende le informazioni di un Amministratore dal database
   * 
   * @param l Oggetto Login da cui si prendono le informazioni
   * @return l'oggetto Dipendente (amministratore) istanziato se presente nel db, altrimenti null
   * 
   */   
  public Dipendente getInfoA(Login l);
  
  /**
   * Metodo che resetta il campo password modificata di un Dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean resetPassD(Dipendente d);
  
  /**
   * Metodo che resetta il campo password modificata di un Amministratore
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean resetPassA(Dipendente d);
  
  /**
   * Metodo che setta il campo password di un Dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param pass la stringa della nuova password del Dipendente
   * @return boolean che indica se l'operazione e' andata o meno a buon fine
   * 
   */   
  public boolean passD(Dipendente d, String pass);

  /**
   * Metodo che setta il campo password (e il campo data pass) di un Amministratore
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param pass la stringa della nuova password dell'Amministratore
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean passA(Dipendente d, String pass);
  
  /**
   * Metodo che setta il campo mail di un Dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param mail la stringa della nuova email del Dipendente
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean mailD(Dipendente d, String mail);

  /**
   * Metodo che ritorna l'elenco dei Dipendenti dell'Azienda
   * 
   * @return un ArrayList che contiene tutti i dipendenti
   * 
   */   
  public ArrayList<Dipendente> elencoDipendenti();

  /**
   * Metodo che aggiunge un Dipendente al database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean aggiungiDipendente(Dipendente d);
  
  /**
   * Metodo che cancella un Dipendente al database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean cancellaDipendente(Dipendente d);
  
  /**
   * Metodo che modifica il nome di un Dipendente al database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param nome stringa contenente il nuovo nome
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modNome(Dipendente d, String nome);
  
  /**
   * Metodo che modifica il cognome di un Dipendente al database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param cognome stringa contenente il nuovo cognome
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modCognome(Dipendente d, String cognome);
  
  /**
   * Metodo che modifica il codice fiscale di un Dipendente al database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param codfis stringa contenente il nuovo codice fiscale
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modCodFis(Dipendente d, String codfis);

  /**
   * Metodo che modifica lo username di un Dipendente al database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param username stringa contenente il nuovo username
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modUsername(Dipendente d, String username);

  /**
   * Metodo che modifica l'impiego di un Dipendente al database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param impiego stringa contenente il nuovo impiego
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modImpiego(Dipendente d, String impiego);
  
  /**
   * Metodo che modifica i trofei di un Dipendente al database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param n intero contenente il nuovo ammontare trofei
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean setTrofei(Dipendente d, int n);
  
  /**
   * Metodo che resetta la password (casuale) di un Dipendente
   * 
   * @param r Oggetto Recupero da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean resetD(Recupero r, String p);
  
  /**
   * Metodo che resetta la password (casuale) di un Amministratore
   * 
   * @param r Oggetto Recupero da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean resetA(Recupero r, String p);
}