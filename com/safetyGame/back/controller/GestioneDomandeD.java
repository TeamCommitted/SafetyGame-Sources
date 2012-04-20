package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

public class GestioneDomandeD{
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestioneDomandeD(SqlDAOFactory s){accesso=s;}
   
   public Domanda getDomanda(String username){
      //prelevare il timer, controllare e in caso prelevare la domanda
      Dipendente d=accesso.getInfo(username);
      log.chiediDomanda(username);
      return accesso.getDomanda(username);
   }
   
   public void posticipa(String username){
      accesso.posticipa(username);
      log.posticipa(username);
   }
   public boolean rispondi(String username, String risposta){
      accesso.rispondi(username,risposta);
      log.rispondi(username,risposta);  
      return true;
   }
}
