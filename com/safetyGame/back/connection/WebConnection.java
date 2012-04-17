package connection;
import controller.*;
import access.*;
import condivisi.*;

public class WebConnection{
   private GestioneDati dati;
   public WebConnection(GestioneDati d){dati=d;}
    
   public boolean login(String username, String password){
      dati.login(username, password);
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
   
   public Badge[] getBadge(String username){
      return dati.getBadge(username);
   }
   
   public void modPass(String pass, String username){
      char u='d';//o a-->AA; s-->AS
      dati.modPass(pass,username,u);
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
   
   public Domanda[] getElencoDomande(boolean interne){
      Domanda[] d=dati.getElencoDomande(interne); 
      return d;
   } 
   
   public void aggiungiDomanda(int id){
      dati.aggiungiDomanda(id);
   }
   
   public void cancellaDomanda(int id){
      dati.cancellaDomanda(id);
   }
   
   public Dipendente[] getElencoDipendenti(){
      Dipendente[] d=dati.getElencoDipendenti(); 
      return d;
   }
   
   public void setTrofei(String dipendente, int n){
      dati.setTrofei(dipendente, n);
   }
   
   public boolean aggiungiDipendente(String nome, String cognome, String codfis, String mail, String impiego){
      dati.aggiungiDipendente(nome,cognome,codfis,mail,impiego);
      return true;
   }
   
   public boolean cancellaDipendente(String username){
      dati.cancellaDipendente(username);
      return true;
   }
   
   public void modNome(String username, String nome){
      dati.modNome(username, nome);
   }
   
   public void modCognome(String username, String cognome){
      dati.modCognome(username, cognome);
   }
   
   public void modCodFis(String username, String codfis){
      dati.modCodFis(username, codfis);
   }
   
   public void modUsername(String usernameOld, String username){
      dati.modUsername(usernameOld, username);
   }
   
   public void modImpiego(String username, String impiego){
      dati.modImpiego(username, impiego);
   }
}