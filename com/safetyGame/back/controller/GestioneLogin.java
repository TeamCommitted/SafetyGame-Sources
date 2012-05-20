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
    * @param a riferimento alla classe che implementa l'interfaccia DAOLogin
    * 		 l riferimento alla classe GestioneLog
    */
   public GestioneLogin(DAOLogin a, GestioneLog l){
	   access = a;
	   log = l;
   }
   
   /**
    * Metodo per il login degli utenti amministratori
    * 
    * @param login oggetto contenente i dati di login inseriti dall'utente
    */
   public boolean loginAdmin(Login login){
      return access.loginLimitato(login);
   }
   
   /**
    * Metodo per il login dei dipendenti
    * 
    * @param login oggetto contenente i dati di login inseriti dall'utente
    */
   public boolean loginUser(Login login){
	   boolean result = access.loginLimitato(login);
	   if(result)
		   log.login(login);
	   return result; 
   }
}
