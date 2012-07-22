/*
 * Name: GestioneLogin.java
 * Package: com.safetygame.back.controller
 * Author: Massimo Dalla Pieta'
 * Date: 2012/06/16
 * Version: 1.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120717 |Massimo Dalla Pieta' | Tutti i metodi sono
 * |          |                     | stati aggiornati assegnado
 * |          |                     | a alle variabili 
 * |          |                     | nomi significativi
 * +----------+---------------------+---------------------
 * | 20120531 |Massimo Dalla Pieta' | * GestioneLogin
 * |          |                     | * loginAdmin
 * |          |                     | * loginUser
 * |          |                     | * logout
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che si occupa di gestire i login nel sistema
 * 
 * @author mdallapi 
 * @version v1.0
 */

public class GestioneLogin{
   private DAOLogin access;
   private GestioneLog log;
   
   /**
    * Costruttore con parametri della classe GestioneLogin
    * 
    * @param access riferimento alla classe che implementa l'interfaccia DAOLogin
    * 		 log riferimento alla classe GestioneLog
    */
   public GestioneLogin(DAOLogin access, GestioneLog log){
	   this.access = access;
	   this.log = log;
   }
   
   /**
    * Metodo per il login degli utenti amministratori
    * 
    * @param login oggetto contenente i dati di login inseriti dall'utente
    */
   public boolean loginAdmin(Login login, boolean tipo){
      boolean result = access.loginAmministratore(login,tipo);
      if(result) 
		   log.scriviLoginA(login);
	   return result;
   }
   
   /**
    * Metodo per il login dei dipendenti
    * 
    * @param login oggetto contenente i dati di login inseriti dall'utente
    */
   public boolean loginUser(Login login){
	   boolean result = access.loginDipendente(login);
	   if(result) 
		   log.scriviLoginD(login);
	   return result; 
   }
   
   /**
    * Metodo per segnalare al sistema il logout di un dipendente
    * 
    * @param l login del dipendente che ha effettuato il logout
    */
   public void logoutD(Login l) {
	 this.log.scriviLogoutD(l);
   }
   
   /**
    * Metodo per segnalare al sistema il logout di un amministratore
    * 
    * @param l login dell'amministratore che ha effettuato il logout
    */
   public void logoutA(Login l) {
	 this.log.scriviLogoutA(l);
   }
}
