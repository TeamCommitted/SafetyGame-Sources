package com.safetyGame.back.controller;

import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

public class GestioneBadgeD{
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestioneBadgeD(SqlDAOFactory s){accesso=s;}
   public Badge[] getBadge(String username){
      log.badgeD(username);
      return accesso.badgeD(username);
   }
}
