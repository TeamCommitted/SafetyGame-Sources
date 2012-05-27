/*
 * Name: SqlDAOLogin.java
 * Package: com.safetygame.back.access
 * Author: Gabriele Facchin
 * Date: {Data di approvazione del file}
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120526 | Gabriele Facchin    | + SqlDAOLogin
 * |          |                     | + loginAmministratore
 * |          |                     | + loginDipendente
 * +----------+---------------------|---------------------
 *
 */

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
    String username = l.getUsername();
    String password = l.getPassword();
    ResultSet rs= serverAzienda.selezione("Amministratore","*", "nickname="+username+" AND (password="+password+" OR passmod="+password+")"); 
    try{
      String ID = rs.getString("ID");
    }
    catch(SQLException e){return false;} 
    return true;
  }
  
  public boolean loginDipendente(Login l){
    String username = l.getUsername();
    String password = l.getPassword();
    ResultSet rs= serverAzienda.selezione("Dipendente","*", "nickname="+username+", password="+password+" OR passmod="+password+")"); 
    try{
      String ID = rs.getString("ID");
    }
    catch(SQLException e){return false;} 
    return true;
  }
}
