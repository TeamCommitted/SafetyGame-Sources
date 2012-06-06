package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

/**
 * Classe che si occupa di gestire le modifiche dati dei Dipendenti da parte di un Amministratore Azienda
 * 
 * @author mdallapi 
 * @version v0.1
 */
public class GestioneDipendentiAA{
   DAODipendenti accessDip;
   
   /**
    * Costruttore con parametri della classe GestioneDipendentiAA
    * 
    * @param accessDip riferimento alla classe che implementa l'interfaccia DAODipendenti
    *        
    */
   public GestioneDipendentiAA(DAODipendenti accessDip){
       this.accessDip = accessDip;
    }
   
    /**
    * Metodo per ottenere i dati dei dipendenti dell'azienda
    * @return un ArrayList<Dipendente> contenente i dipendenti dell'azienda      
    */
   public ArrayList<Dipendente> getElencoDipendenti(){
      return accessDip.elencoDipendenti(); 
   }
   
   /**
    * Metodo per aggiungere un dipendente
    * 
    * @param Dip, oggetto contenente i dati del nuovo dipendente
    * @return true se l'operazione viene completata con successo, altrimenti false    
    */
   public boolean aggiungiDipendente(Dipendente Dip){
      return accessDip.aggiungiDipendente(Dip);
   }
   
   /**
    * Metodo per eliminare
    * 
    * @param Dip, oggetto contenente i dati del dipendente da eliminare
    * @return true se l'operazione viene completata con successo, altrimenti false    
    */
   public boolean cancellaDipendente(Dipendente Dip){
      return accessDip.cancellaDipendente(Dip);
   }
   
   /**
    * Metodo per modificare i dati di un dipendente
    * 
    * @param newDip, oggetto contenente i nuovi dati del dipendente da modificare
    * @param oldDip, oggetto contenente i vecchi dati del dipendente da modificare
    * @return true se l'operazione viene completata con successo, altrimenti false
    */
   public boolean modDipendente(Dipendente newDip, Dipendente oldDip){
        boolean correct = true;
        if(!newDip.getNome().equals(oldDip.getNome()))
            correct = accessDip.modNome(newDip, newDip.getNome());
        if(!newDip.getCognome().equals(oldDip.getCognome()) && correct)
            correct = accessDip.modCognome(newDip, newDip.getCognome());
        if(!newDip.getEmail().equals(oldDip.getEmail()) && correct)
            correct = accessDip.mailD(newDip, newDip.getEmail());
        if(!newDip.getRuolo().equals(oldDip.getRuolo()) && correct)
            correct = accessDip.modImpiego(newDip, newDip.getRuolo());
        if(!newDip.getNickname().equals(oldDip.getNickname()) && correct)
            correct = accessDip.modUsername(newDip, newDip.getNickname());
        if(!newDip.getPassword().equals(oldDip.getPassword()) && correct)
            correct = accessDip.passD(newDip, newDip.getPassword());
        return correct;
   }
   
}