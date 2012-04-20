package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

public class GestioneRecupero{ 
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestioneRecupero(SqlDAOFactory s){accesso=s;}
   
   public void resetPass(String username, String codfis, String mail){
      log.reset(username);
      accesso.reset(username, codfis, mail);
   }
}
