package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;

public class SqlDAODipendenti implements DAODipendenti{
  private Indirizzo serverAzienda;

  public SqlDAODipendenti(Indirizzo azienda){
    serverAzienda=azienda;
  }
  
  public Dipendente getInfoD(Login l){
    //preleva dal database tutte le info del dipendente
    return new Dipendente();
  }
  
  public Dipendente getInfoA(Login l){
    //preleva dal database tutte le info dell'amministratore
    return new Dipendente();
  }
  
  public boolean passD(Dipendente d, String pass){
    //cambia la password dipendente
    return true;
  }
  
  public boolean passA(Dipendente d, String pass){
    //cambia la password amministratore
    return true;
  }
  
  public boolean mailD(Dipendente d, String mail){
    //cambia la mail dipendente
    return true;
  }
  
  public Dipendente[] elencoDipendenti(){
    //prende i vari dipendenti e li ritorna
    Dipendente[] d=new Dipendente[1];
    return d;
  }
  
  public boolean aggiungiDipendente(Dipendente d){
  //String nome, String cognome, String codfis, String mail, String impiego
    //aggiunge un dipendente
    return true;
  }
  
  public boolean cancellaDipendente(Dipendente d){
    //cancella un dipendente
    return true;
  }
  
  public boolean modNome(Dipendente d, String nome){
    //modifica il nome di un dipendente
    return true;
  }
  
  public boolean modCognome(Dipendente d, String cognome){
    //modifica il cognome di un dipendente
    return true;
  }
  
  public boolean modCodFis(Dipendente d, String codfis){
    //modifica il codfis di un dipendente
    return true;
  }

  public boolean modUsername(Dipendente d, String username){
    //modifica il l'username di un dipendente
    return true;
  }
  
  public boolean modImpiego(Dipendente d, String impiego){
    //modifica il l'impiego di un dipendente
    return true;
  }
  
  public boolean setTrofei(Dipendente d, int n){
    boolean b= serverAzienda.modificaRiga("Dipendente","trofei="+n,"ID="+d.getId());
    return b;
  }
  
  public boolean resetD(Recupero r){
    //modifica la password generandola randomicamente
    return true;
  }
  
  public boolean resetA(Recupero r){
    //modifica la password generandola randomicamente
    return true;
  }
}
