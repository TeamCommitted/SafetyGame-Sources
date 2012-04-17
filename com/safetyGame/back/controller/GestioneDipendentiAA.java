package controller;
import access.*;
import condivisi.*;

public class GestioneDipendentiAA{
   SqlDAOFactory accesso;
   GestioneLog log;
   public GestioneDipendentiAA(SqlDAOFactory s){accesso=s;}
   
   public void setPass(String pass, String username){
      accesso.passA(pass, username);
      log.passA(username);
   }
   public Dipendente[] getElencoDipendenti(){
      log.listaD();
      return accesso.elencoDipendenti(); 
   }
   public boolean aggiungiDipendente(String nome, String cognome, String codfis, String mail, String impiego){
      log.addD(nome);
      return accesso.aggiungiDipendente(nome,cognome,codfis,mail,impiego);
   }
   public boolean cancellaDipendente(String username){
      log.delD(username);
      return accesso.cancellaDipendente(username);
   }
   public void modNome(String username, String nome){
      accesso.modNome(username, nome);
      log.nome(username);
   }
   public void modCognome(String username, String cognome){
      accesso.modCognome(username, cognome);
      log.cognome(username);
   }
   public void modCodFis(String username, String codfis){
      accesso.modCodFis(username, codfis);
      log.codfis(username);
   }
   public void modUsername(String usernameOld, String username){
      accesso.modUsername(usernameOld, username);
      log.username(username);
   }
   public void modImpiego(String username, String impiego){
      accesso.modImpiego(username, impiego);
      log.impiego(username);
   }
}