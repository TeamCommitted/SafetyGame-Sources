package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

//gestire i controlli in ogni funzione per ogni cosa

public class GestioneLogin{
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestioneLogin(SqlDAOFactory s, GestioneLog l){accesso=s; log=l;}
   
   public boolean loginLimitato(String username, String password){
      boolean b = accesso.loginLimitato(username,password);
      if (b)
        log.login(username,'d');
      return b; 
   }
   
   public boolean login(String username, String password){
      boolean b = accesso.login(username,password);
      char u='d'; //oppure s-->AS; a-->AA
      if (b)
        log.login(username,u);
      return b; 
   }
   
   public void logout(String username){
      accesso.logout(username);
      log.logout(username);
   }
}
