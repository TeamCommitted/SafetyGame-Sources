package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

public class SqlDAOLogin implements DAOLogin{
  private Indirizzo serverAzienda;
  public SqlDAOLogin(Indirizzo azienda){
    serverAzienda=azienda;
  }
    
  public boolean loginAmministratore(Login l){
    //prende le credenziali amministratore e le controlla
    return true;
  }
  public boolean loginDipendente(Login l){
    //prende le credenziali dipendente e le controlla
    return true;
  }
}
