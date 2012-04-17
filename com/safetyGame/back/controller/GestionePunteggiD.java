package controller;
import access.*;
import condivisi.*;

public class GestionePunteggiD{ 
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestionePunteggiD(SqlDAOFactory s){accesso=s;}
    
   public Punteggio getStat(String username){
      log.getStat(username);
      return accesso.getStat(username);
   }
}

