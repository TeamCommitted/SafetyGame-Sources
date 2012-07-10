package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

/**
 * Classe che si occupa di gestire la visione dei punteggi in un'azienda
 * 
 * @author mdallapi 
 * @version v0.1
 */
public class GestionePunteggiAA{ 
   private DAOPunteggi accessP;
   private DAODipendenti accessDip;
   
   /**
    * Costruttore con parametri della classe GestionePunteggiAA
    * 
    * @param accessP riferimento alla classe che implementa l'interfaccia DAOPunteggi
    *        accessDip riferimento alla classe che implementa l'interfaccia DAODipendenti
    */
   public GestionePunteggiAA(DAOPunteggi accessP, DAODipendenti accessDip){
       this.accessP = accessP;
       this.accessDip = accessDip;
    }
   
    /**
    * Metodo per ottenere i punteggi medi dell'azienda e i punteggi di tutti i dipendenti
    * 
    * @return un ArrayList<Punteggio> contenente in posizione 0 un oggetto Punteggio contenente i dati medi dell'azienda
    * e successivamente la lista dei punteggi di tutti i dipendenti.
    */
   public ArrayList<Dipendente> getPunteggi(){
       ArrayList<Dipendente> dipendenti = new ArrayList<Dipendente>();
       dipendenti.add(new Dipendente());
       dipendenti.addAll(accessDip.elencoDipendenti());
       int risposte = 0;
       int corrette = 0;
       Punteggio p = new Punteggio();
       for(int i=1; i<dipendenti.size(); i++){
           p = accessP.getGlobalStat(dipendenti.get(i));
           dipendenti.get(i).setPunteggio(p);
            risposte += p.getnDomRisp();
            corrette += p.getnRispCorr();
       }
       risposte = risposte / dipendenti.size();
       corrette = corrette / dipendenti.size();
       p.setnDomRisp(risposte);
       p.setnRispCorr(corrette);
       p.setMediaPuntiAzienda(dipendenti.get(1).getPunteggio().getMediaPuntiAzienda());
       dipendenti.get(0).setPunteggio(p);
       return dipendenti; 
    }
    
    /**
    * Metodo per modificare i trofei di un dipendente
    * 
    * @param Dip il dipendente che si vuole modificare
    *        n numero di trofei che si vuole assegnare
    * @return true se l'operazione ha successo, altrimenti false  
    */
    public boolean setTrofei(Dipendente Dip, int n){
        return accessDip.setTrofei(Dip,n);
    }
}
