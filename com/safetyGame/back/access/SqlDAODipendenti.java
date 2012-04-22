package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;

public class SqlDAODipendenti implements DAODipendenti{
   public SqlDAODipendenti(){}
   public Dipendente getInfo(String username){
      //preleva dal database tutte le info del dipendente
      ResultSet rs=null;
      return new Dipendente();
   }
   public void passD(String pass, String username){
      //cambia la password dipendente
   }
   public void passA(String pass, String username){
      //cambia la password amministratore
   }
   public void mailD(String mail, String username){
      //cambia la mail dipendente
   }
   public Punteggio getStat(String username){
      //prende i punteggi dipendente
      return new Punteggio();
   }
   public Dipendente[] elencoDipendenti(){
      //prende i vari dipendenti e li ritorna
      Dipendente[] d=new Dipendente[1];
      return d;
   }
   public boolean aggiungiDipendente(String nome, String cognome, String codfis, String mail, String impiego){
      //aggiunge un dipendente
      return true;
   }
   public boolean cancellaDipendente(String username){
      //cancella un dipendente
      return true;
   }
   public void modNome(String username, String nome){
      //modifica il nome di un dipendente
   }
   public void modCognome(String username, String cognome){
      //modifica il cognome di un dipendente
   }
   public void modCodFis(String username, String codfis){
      //modifica il codfis di un dipendente
   }
   public void modUsername(String usernameOld, String username){
      //modifica il l'username di un dipendente
   }
   public void modImpiego(String username, String impiego){
      //modifica il l'impiego di un dipendente
   }
   public void trofei(String username, int n){
      //modifica il totale dei trofei di un dipendente
   }
   public void reset(String username, String codfis, String mail){
      //modifica la password generandola randomicamente
   }
}
