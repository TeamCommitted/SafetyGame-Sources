/*
 * Name: DAOLogin.java
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
 * | 20120512 | Gabriele Facchin    | + loginAmministratore
 * |          |                     | + loginDipendente
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

/**
 * Interfaccia che contiene i prototipi dei metodi per gestire il login
 * 
 * @author gfacchin
 * @version 1.0
 */

public interface DAOLogin{

  /**
   * Metodo che prova il login di un Amministratore
   * 
   * @param l Oggetto Login da cui si prendono le informazioni
   * @param  tipo booleano: 1 se amministratore azienda(AA), 0 se amministratore sicurezza(AS) 
   * @return un boolean che indica se il login e` avvenuto con successo o no
   * 
   */  
  public boolean loginAmministratore(Login l, boolean tipo);
  
  /**
   * Metodo che prova il login di un Dipendente
   * 
   * @param l Oggetto Login da cui si prendono le informazioni
   * @return un boolean che indica se il login e` avvenuto con successo o no
   * 
   */    
  public boolean loginDipendente(Login l);

}
