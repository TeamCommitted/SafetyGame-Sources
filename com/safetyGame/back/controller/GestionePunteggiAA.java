package controller;
import access.access.*;

public class GestionePunteggiAA{ 
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestionePunteggiAA(SqlDAOFactory s){accesso=s;}
   
   public boolean setTrofei(String username, int n){
      log.trofei(username);
      return accesso.trofei(username,n);
   }
}
