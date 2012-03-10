package controller;
import access.condivisi.*;

public class GestioneDati{
   //private GestioneLog log;
   private GestioneRecupero recupero;
   private GestioneLogin login;
   private GestioneDomandeD domandeD;
   private GestioneDomandeAS domandeAS;
   private GestioneDipendentiD dipendentiD;
   private GestioneDipendentiAA dipendentiAA;
   private GestioneBadgeD badgeD;
   private GestioneBadgeAS badgeAS;
   private GestionePunteggiD punteggiD;
   private GestionePunteggiAA punteggiAA;
   
   public GestioneDati(){}
   
   public boolean login(String username, String password){
      login.login(username, password);
      return true;
   }
   public boolean loginLimitato(String username, String password){
      login.loginLimitato(username, password);
      return true;
   }
   public Dipendente getDati(String username){
      return dipendentiD.getDati(username);
   }
   public Punteggio getStat(String username){
      return punteggiD.getStat(username);
   }
   public void modPass(String pass, String username, char u){
      if (u=='d')
         dipendentiD.setPass(pass,username);
      else
         dipendentiAA.setPass(pass,username);
   }
   public void modMail(String pass, String username){
      dipendentiD.setMail(pass,username);
   }
   public void resetPass(String username, String codfis, String mail){
      recupero.resetPass(username, codfis, mail);
   }
   public Domanda getDomanda(String username){
      return domandeD.getDomanda(username);
   }
   public void posticipa(String username){
      domandeD.posticipa(username);
   }
   public boolean rispondi(String username, String risposta){
      return domandeD.rispondi(username, risposta);
   }
   public void logout(String username){
      login.logout(username);
   }
   public Domanda[] getElencoDomande(boolean interne){
      return domandeAS.getElencoDomande(interne); 
   }
   public void aggiungiDomanda(int id){
      domandeAS.addDomanda(id); 
   }
   public void cancellaDomanda(int id){
      domandeAS.remDomanda(id);     
   }   
   public Dipendente[] getElencoDipendenti(){
      return dipendentiAA.getElencoDipendenti(); 
   }
   public void setTrofei(String dipendente, int n){
      punteggiAA.setTrofei(dipendente, n);
   }
   public Badge[] getBadge(String username){
      return badgeD.getBadge(username);
   }
   public boolean aggiungiDipendente(String nome, String cognome, String codfis, String mail, String impiego){
      return dipendentiAA.aggiungiDipendente(nome,cognome,codfis,mail,impiego);
   }
   public boolean cancellaDipendente(String username){
      return dipendentiAA.cancellaDipendente(username);
   }
   public void modNome(String username, String nome){
      dipendentiAA.modNome(username, nome);
   }
   public void modCognome(String username, String cognome){
      dipendentiAA.modCognome(username, cognome);
   }
   public void modCodFis(String username, String codfis){
      dipendentiAA.modCodFis(username, codfis);
   }
   public void modUsername(String usernameOld, String username){
      dipendentiAA.modUsername(usernameOld, username);
   }
   public void modImpiego(String username, String impiego){
      dipendentiAA.modImpiego(username, impiego);
   }
   
   //public void setLog(GestioneLog l){log=l;}
   public void setRecupero(GestioneRecupero r){recupero=r;}
   public void setLogin(GestioneLogin l){login=l;}
   public void setDomandeD(GestioneDomandeD d){domandeD=d;}
   public void setDomandeAS(GestioneDomandeAS d){domandeAS=d;}
   public void setDipendentiD(GestioneDipendentiD d){dipendentiD=d;}
   public void setDipendentiAA(GestioneDipendentiAA d){dipendentiAA=d;}
   public void setBadgeD(GestioneBadgeD b){badgeD=b;}
   public void setBadgeAS(GestioneBadgeAS b){badgeAS=b;}
   public void setPunteggiAA(GestionePunteggiAA p){punteggiAA=p;}
}