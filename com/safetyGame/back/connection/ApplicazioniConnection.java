package connection;
import controller.*;
import access.condivisi.*;

public class ApplicazioniConnection{
   private GestioneDati dati;
   private Parser parser; //non c'è un oggetto ma semplicemente funzioni da richiamare da libreria (Parser.funzione();)
   
   public ApplicazioniConnection(GestioneDati d){dati = d;}
    
   public boolean login(String username, String password){
      dati.loginLimitato(username, password);
      return true;
   }
    
   public Dipendente getDati(String username){
      Dipendente d = dati.getDati(username);
      return d;
   }
   
   public Punteggio getStat(String username){
      Punteggio p = dati.getStat(username);
      return p;
   }
   
   public void modPass(String pass, String username){
      dati.modPass(pass,username,'d');
   }
   
   public void modMail(String mail, String username){
      dati.modMail(mail,username);
   }
   
   public void resetPass(String username, String codfis, String mail){
      dati.resetPass(username, codfis, mail);
   }
   
   public Domanda mostraDomanda(String username){
      Domanda d= dati.getDomanda(username);
      return d;
   }
   
   public void posticipa(String username){
      dati.posticipa(username);
   }
   
   public boolean rispondi(String username, String risposta){
      dati.rispondi(username, risposta);
      return true;
   }
   
   public void logout(String username){
      dati.logout(username);
   }
}