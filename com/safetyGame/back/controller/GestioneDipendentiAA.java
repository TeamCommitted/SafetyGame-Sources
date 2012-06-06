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
    * @param Dip, oggetto contenente i nuovi dati del dipendente da modificare
    * @return true se l'operazione viene completata con successo, altrimenti false
    */
   public boolean modDipendente(Dipendente Dip){
        Login login = new Login(Dip.getNickname(),Dip.getPassword());
        Dipendente old = accessDip.getInfoD(login);
        boolean correct = true;
        if(!Dip.getNome().equals(old.getNome()))
            correct = accessDip.modNome(Dip, Dip.getNome());
        if(!Dip.getCognome().equals(old.getCognome()) && correct)
            correct = accessDip.modCognome(Dip, Dip.getCognome());
        if(!Dip.getEmail().equals(old.getEmail()) && correct)
            correct = accessDip.mailD(Dip, Dip.getEmail());
        if(!Dip.getRuolo().equals(old.getRuolo()) && correct)
            correct = accessDip.modImpiego(Dip, Dip.getRuolo());
        if(!Dip.getNickname().equals(old.getNickname()) && correct)
            correct = accessDip.modUsername(Dip, Dip.getNickname());
        if(!Dip.getPassword().equals(old.getPassword()) && correct)
            correct = accessDip.passD(Dip, Dip.getPassword());
        return correct;
   }
   
}