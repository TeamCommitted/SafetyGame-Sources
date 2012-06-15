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

/**
 * Classe che gestisce i login, implementa i metodi pubblici dell'interfaccia
 * 
 * @author gfacchin
 * @version 0.1
 */

public class SqlDAOLogin implements DAOLogin{
  private Indirizzo serverAzienda;
  
  /**
   * Costruttore della classe SqlDAOLogin
   * 
   */
  
  public SqlDAOLogin(Indirizzo azienda){
    serverAzienda=azienda;
  }

  /**
   * Metodo che prova il login di un Amministratore
   * 
   * @param l Oggetto Login da cui si prendono le informazioni
   * @return un boolean che indica se il login e` avvenuto con successo o no
   * 
   */    
  public boolean loginAmministratore(Login l){//
    String username = l.getUsername();
    String password = l.getPassword();
    ResultSet rs= serverAzienda.selezione("Amministratore","*", "nickname='"+username+"' AND (password='"+password+"' OR passmod='"+password+"')",""); 
    try{
      int ID = rs.getInt("ID");
    }
    catch(SQLException e){return false;} 
    return true;
  }
  
  /**
   * Metodo che prova il login di un Dipendente
   * 
   * @param l Oggetto Login da cui si prendono le informazioni
   * @return un boolean che indica se il login e` avvenuto con successo o no
   * 
   */    
  public boolean loginDipendente(Login l){//
    String username = l.getUsername();
    String password = l.getPassword();
    ResultSet rs= serverAzienda.selezione("Dipendente","*", "nickname='"+username+"' AND (password='"+password+"' OR passmod='"+password+"')",""); 
    try{
      int ID = rs.getInt("ID");
    }
    catch(SQLException e){return false;} 
    return true;
  }
}
