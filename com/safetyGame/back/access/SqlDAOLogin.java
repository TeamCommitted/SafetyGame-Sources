package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDAOLogin implements DAOLogin{
  private Indirizzo serverAzienda;
  public SqlDAOLogin(Indirizzo azienda){
    serverAzienda=azienda;
  }
    
  public boolean loginAmministratore(Login l){
    String username = l.getDipendente().getNickname();
    String password = l.getDipendente().getPassword();
    ResultSet rs= serverAzienda.selezione("Amministratore","*", "nickname="+username+", password="+password); 
    try{
      String ID = rs.getString("ID");
    }
    catch(SQLException e){return false;} 
    return true;
  }
  
  public boolean loginDipendente(Login l){
    String username = l.getDipendente().getNickname();
    String password = l.getDipendente().getPassword();
    ResultSet rs= serverAzienda.selezione("Dipendente","*", "nickname="+username+", password="+password); 
    try{
      String ID = rs.getString("ID");
    }
    catch(SQLException e){return false;} 
    return true;
  }
}
