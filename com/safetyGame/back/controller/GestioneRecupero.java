package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

public class GestioneRecupero{ 
   DAODipendenti accessDip;
   GestioneLog log;
   
   public GestioneRecupero(DAODipendenti accessDip, GestioneLog log){
       this.accessDip = accessDip;
       this.log = log;
   }
   
   public boolean recupero(String username, String codfis, String mail){
      log.reset(username);
      accesso.reset(username, codfis, mail);
   }
}
