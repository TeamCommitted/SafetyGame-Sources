package com.safetyGame.back.controller;

import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

/**
 * Classe che si occupa di gestire il recupero di badge di un dipendente 
 * 
 * @author mdallapi 
 * @version v0.1
 */
public class GestioneBadgeD{
   private DAOBadge accessB;
   private DAODipendenti accessDip;
   private DAODomande accessDom;
   private GestioneLog log;
   private GestioneLogin login;
   
   /**
    * Costruttore con parametri della classe GestioneLogin
    * 
    * @param access riferimento alla classe che implementa l'interfaccia DAOBadge
    * 		 log riferimento alla classe GestioneLog
    * 		 login riferimento alla classe GestioneLogin
    */
   public GestioneBadgeD(DAOBadge accessB,DAODipendenti accessDip, DAODomande accessDom, GestioneLog log, GestioneLogin login){
	   this.accessB = accessB;
	   this.accessDip = accessDip;
	   this.accessDom = accessDom;
	   this.log = log;
	   this.login = login;
   }
   
   /**
    * Metodo per ottenere i dati delle badge per un dato utente
    * 
    * @param login dati dell'utente che effettua la richiesta
    * 		 n numero di badge che si vuole selezionare
    * 		 
    */
   public ArrayList<Badge> getBadge(Login l, int n){
      if(login.loginUser(l)){
    	  Dipendente d = accessDip.getInfoD(l);
    	  ArrayList<Badge> list = accessB.badgeD(d);
    	  if(list.isEmpty())
    		  return null;
    	  else{
    		  ArrayList<Badge> result = null;
    		  int i = 0;
    		  while(i<list.size() && i<n){
    			  result.add(list.get(i));
    		  	  i++;
    		  }
    		  return result;
    	  }
      }
      else
    	  return null;
   }
   public boolean assegnaBadge(Domanda D, Login l){
	   Dipendente dip = accessDip.getInfoD(l);
	   ArrayList<Domanda> risposte = accessDom.domande(dip,null);
	   ArrayList<Badge> badge = accessB.badgeAS();
	   boolean trovato = false;
	   int i = 0;
	   boolean result = false;
	   while(i < badge.size() && trovato == false){
	       Badge test = badge.get(i);
		   if(test.getDescrizione().equals("TotaleRisposte"))
		       if(test.getSoglia().getPunti() == risposte.size()){
		           accessB.assegna(dip,test);
		           trovato = true;
		           result = true;
		       }
		   i++;
	   }
	   risposte = accessDom.domande(dip,D);
	   trovato = false;
	   i = 0;
	   while(i < badge.size() && trovato == false){
	       Badge test = badge.get(i);
		   if(test.getDescrizione().equals(D.getTipologia()))
		       if(test.getSoglia().getPunti() == risposte.size()){
		           accessB.assegna(dip,test);
		           trovato = true;
		           result = true;
		       }
		   i++;
	   }
	   return result;
   }
}
