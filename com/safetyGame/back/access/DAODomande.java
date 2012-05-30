/*
 * Name: DAODomande.java
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
 * | 20120512 | Gabriele Facchin    | + prendiCampiDomanda
 * |          |                     | + getDomanda
 * |          |                     | + posticipa                
 * |          |                     | + rispondi
 * |          |                     | + domandeA
 * |          |                     | + addDomanda
 * |          |                     | + remDomanda
 * |          |                     | + scriviSottoposta
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaccia che contiene i prototipi dei metodi per gestire le domande
 * 
 * @author gfacchin
 * @version 0.1
 */

public interface DAODomande{

  /**
   * Metodo che preleva una domanda per il Dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return l'oggetto Domanda che contiene una domanda
   * 
   */   
  public Domanda getDomanda(Dipendente d);
  
  /**
   * Metodo che posticipa una domanda sottoposta ad un dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione � andata o meno a buon fine
   * 
   */   
  public boolean posticipa(Dipendente d, Domanda dom);
  
  /**
   * Metodo che imposta la risposta di una domanda sottoposta ad un dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione � andata o meno a buon fine
   * 
   */   
  public boolean rispondi(Dipendente d, Domanda dom);

  /**
   * Metodo che ritorna l'elenco di Domande dell'azienda
   * 
   * @return ArrayList che contiene l'elenco di tutte le Domande
   * 
   */   
  public ArrayList<Domanda> domandeA();

  /**
   * Metodo che aggiunge una Domanda al database dell'azienda
   * 
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione � andata o meno a buon fine
   * 
   */   
  public boolean addDomanda(Domanda d);
  
  /**
   * Metodo che rimuove una Domanda dal database dell'azienda
   * 
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione � andata o meno a buon fine
   * 
   */   
  public boolean remDomanda(Domanda d);
  
  /**
   * Metodo che scrive sul database che una domanda � stata proposta al Dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione � andata o meno a buon fine
   * 
   */   
  public boolean scriviSottoposta(Dipendente dip, Domanda dom);
}
