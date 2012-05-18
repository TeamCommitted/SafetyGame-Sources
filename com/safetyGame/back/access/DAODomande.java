package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

public interface DAODomande{
   public Domanda getDomanda(String username);
   public void posticipa(String username);
   public void rispondi(String username, String risposta);
   public Domanda[] domandeA(boolean interne);
   public void addDomanda(int id);
   public void remDomanda(int id);
   
   //avrei bisogno dei seguenti metodi:
   
   /*
    * 1)getDomanda(Dipendente d):Domanda che mi restituisce una domanda per il dipendente d a cui non ha ancora risposto
    * 2)scriviSottoposta(Domanda dom, Dipendente dip):void che scrive sul DB che la domanda dom è stata sottoposta al Dipendente dip  
    *
    *grazie, corny
    */
}
