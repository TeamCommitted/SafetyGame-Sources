/*
 * Name: Indirizzo.java
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
 * | 20120422 | Gabriele Facchin    | + Indirizzo
 * |          |                     | + finalize
 * |          |                     | + inserisciRiga
 * |          |                     | + modificaRiga
 * |          |                     | + cancellaRiga
 * |          |                     | + selezione
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.access;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

/**
 * Classe che gestisce l'accesso ad un database. I metodi implementati sono per un database SQL
 * 
 * @author gfacchin
 * @version 0.1
 */
public class Indirizzo{
   private Connection conn;
   private Statement connettore;
   
  /**
   * Costruttore della classe Indirizzo
   * 
   * @param database URI al database
   * @param utente nickname con cui effettuare l'accesso al database
   * @param password password con cui effettuare l'accesso al database
   * 
   */
  public Indirizzo(String database, String utente, String password){
    try {
      final String driver="com.mysql.jdbc.Driver";
      Class.forName(driver);
      conn = DriverManager.getConnection("jdbc:mysql://"+database+ "?user="+utente  + "&password=" + password);
      connettore = conn.createStatement();
    }
    catch(SQLException e){System.out.println("Impossibile creare la connessione al database: "+database);}
    catch(ClassNotFoundException e){System.out.println("Impossibile creare la connessione al database: "+database);}
  }
  
  /**
   * Distruttore della classe Indirizzo:
   * prova a rilasciare (chiudere) la connessione al database quando l'oggetto viene distrutto.
   * se non ci riesce scrive sullo standard output un errore. 
   * 
   */  
  public void finalize(){
    try {
      connettore.close();
      conn.close();
    }
    catch(SQLException e){System.out.println("Errore nella chiusura del database");}
  }  
  
  /**
   * Metodo che inserisce una tupla di valori all'interno delle colonne della tabella selezionata 
   * 
   * @param valori array di valori delle colonne della tupla
   * @return completamento o meno dell'inserimento
   * 
   */   //SISTEMARE CODICE SPORCO
  public boolean inserisciRiga(String tabella, String colonne, String [] valori){
    String val="("+valori[0];
    for(int i=1;i<valori.length;i++)
      val+=", "+valori[i];
    val+=");";
    try{
      PreparedStatement pstmt = conn.prepareStatement("INSERT INTO "+ tabella +" ("+ colonne.trim() +") values "+ val);
      pstmt.executeUpdate();
      pstmt.close();
    }
    catch(SQLException e){return false;}
    return true;
  }
       
  /**
   * Metodo che modifica una tupla
   * 
   * @param tabella tabella da modificare
   * @param colonnevalori le colonne a cui modificare i valori (scritte come col1=val1, col2=val2...)
   * @param controlli criteri su cui effettuare la modifica
   * @return completamento o meno della modifica
   * 
   */   
  public boolean modificaRiga(String tabella, String colonnevalori, String controlli){
    try{
      connettore.executeUpdate("UPDATE "+ tabella +" SET "+ colonnevalori +" WHERE "+ controlli+";");
    }
    catch(SQLException e){System.out.println(e.getMessage());return false;}
    return true;
  }
      
  /**
   * Metodo che elimina una tupla
   * 
   * @param tabella tabella da modificare
   * @param controlli criteri su cui effettuare la cancellazione
   * @return completamento o meno della cancellazione
   * 
   */  
  public boolean cancellaRiga(String tabella, String controlli){
    if (controlli.trim()==""){
      return false;
    }
    try{
      connettore.executeQuery("DELETE FROM "+ tabella +" WHERE "+ controlli);
    }
    catch(SQLException e){return false;}
    return true;
  }
       
  /**
   * Metodo che ritorna una tupla
   * 
   * @param tabella tabella da esaminare
   * @param colonne le colonne di cui interessano i valori (indicate con col1, col2...)
   * @param controlli criteri su cui effettuare la visita
   * @param extra contiene tutte le clausole aggiuntive per una query
   * @return rs insieme delle righe ottenute dal risultato della query, null se non esistono risultati
   * 
   */  
  public ResultSet selezione(String tabella, String colonne, String controlli, String extra){
    String where="";
    ResultSet rs=null;
    if (controlli!=""){
      where=" WHERE " +controlli;
    }
    try{
    	System.out.println("SELECT "+ colonne+" FROM "+ tabella + where + extra+";");
      rs = connettore.executeQuery("SELECT "+ colonne+" FROM "+ tabella + where + extra+";");
    }
    catch(SQLException e){System.out.println("errori selezione"+e.getMessage());return null;}
    System.out.println("risultato="+rs.toString());
    return rs;
  }
}
