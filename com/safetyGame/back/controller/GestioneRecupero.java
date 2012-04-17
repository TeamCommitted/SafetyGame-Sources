package controller;
import access.*;
import condivisi.*;

public class GestioneRecupero{ 
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestioneRecupero(SqlDAOFactory s){accesso=s;}
   
   public void resetPass(String username, String codfis, String mail){
      log.reset(username);
      accesso.reset(username, codfis, mail);
   }
}
