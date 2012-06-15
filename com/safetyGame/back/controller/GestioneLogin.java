package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che si occupa di gestire i login nel sistema
 * 
 * @author mdallapi 
 * @version v0.1
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
   public boolean loginAdmin(Login login){
      boolean result = access.loginAmministratore(login);
      if(result) 
		   log.scriviLogin(login);
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
		   log.scriviLogin(login);
	   return result; 
   }
   
   /**
    * Metodo per segnalare al sistema il logout di un utente
    * 
    * @param l login del dipendente che ha effettuato il logout
    */
   public void logout(Login l) {
	 this.log.scriviLogout(l);
   }
}
