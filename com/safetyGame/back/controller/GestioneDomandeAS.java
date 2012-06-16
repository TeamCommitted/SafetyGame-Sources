/*
 * Name: GestioneDomandeAS.java
 * Package: com.safetygame.back.controller
 * Author: Massimo Dalla Pieta'
 * Date: {Data di approvazione del file}
 * Version: 0.3
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120607 |Alessandro Cornaglia | + getElencoDomande
 * |          |                     | + addDomanda
 * |          |                     | + remDomanda
 * |          |                     | + GestioneDomandeAS
 * +----------+---------------------+----------------------
 * 
 */ 

package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

/**
 * Classe che si occupa di gestire tutte le azioni dovute dall'interazione 
 * fra un AmministratoreSicurezza ed una domanda del sistema
 * @author mdallapi 
 * @version v0.1
 */
public class GestioneDomandeAS{ 
   private DAODomande accessDom;
   
   /**
    * Costruttore con parametri della classe GestioneDomandeAs
    * 
    * @param accessDom riferimento alla classe che implementa l'interfaccia DAODomande
    *        
    */
   public GestioneDomandeAS(DAODomande accessDom){
       this.accessDom=accessDom;
    }
   
    /**
    * Metodo per ottenere la lista di tutte le domande
    * @return un ArrayList<Domande> contenente tutte le domande
    */
   public ArrayList<Domanda> getElencoDomande(){
      return accessDom.domandeA(); 
   }
   
   /**
    * Metodo per inserire una domanda dal server domande al server dell'azienda
    * @return true se l'operazione � stata completata, altrimenti false   
    */
   public boolean addDomanda(Domanda Dom){
      return accessDom.addDomanda(Dom);
   }
   
   /**
    * Metodo per eliminare una domanda dal server dell'azienda
    * @return true se l'operazione � stata completata, altrimenti false       
    */
   public boolean remDomanda(Domanda Dom){
      return accessDom.remDomanda(Dom);
   }
}
