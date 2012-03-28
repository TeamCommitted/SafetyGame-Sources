package controller;
import access.access.*;
import access.condivisi.*;

public class GestioneDipendentiD{ 
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestioneDipendentiD(SqlDAOFactory s){accesso=s;}
   
   public Dipendente getDati(String username){
      //prelevare il timer, controllare e in caso prelevare la domanda
      log.datiD(username);
      return accesso.getInfo(username);
   }
   public void setPass(String pass, String username){
      log.passD(username);
      accesso.passD(pass,username);
   }
   public void setMail(String mail, String username){
      log.mailD(username);
      accesso.mailD(mail,username);
   }
}
