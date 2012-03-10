package controller;
import access.access.*;
import access.condivisi.*;

public class GestioneDomandeAS{ 
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestioneDomandeAS(SqlDAOFactory s){accesso=s;}
    
   public Domanda[] getElencoDomande(boolean interne){
      log.domandeA();
      return accesso.domandeA(interne); 
   }
   public void addDomanda(int id){
      log.addDomanda();
      accesso.addDomanda(id);
   }
   public void remDomanda(int id){
      log.remDomanda();
      accesso.remDomanda(id);
   }
}
