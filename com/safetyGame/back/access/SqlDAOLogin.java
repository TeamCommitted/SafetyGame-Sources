package com.safetyGame.back.access;

public class SqlDAOLogin implements DAOLogin{
  private Indirizzo serverAzienda;
  public SqlDAOLogin(Indirizzo azienda){
    serverAzienda=azienda;
  }
    
  public boolean loginLimitato(String username, String password){
    //prende le credenziali amministratore e le controlla
    return true;
  }
  public boolean login(String username, String password){
    //prende le credenziali dipendente e le controlla
    return true;
  }
}
