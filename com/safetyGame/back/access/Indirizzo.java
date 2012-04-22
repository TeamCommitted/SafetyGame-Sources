package com.safetyGame.back.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Indirizzo{
   private Connection conn;
   private Statement connettore;
   
   public Indirizzo(String database, String utente, String password){
      try {
         conn = DriverManager.getConnection("jdbc:mysql:"+database+ "user="+utente+"&password="+password);
         connettore = conn.createStatement();
      }
      catch(SQLException e){System.out.println("Impossibile creare la connessione al database: "+database);}
   }
   
   public void finalize(){
      try {
         connettore.close();
         conn.close();
      }
      catch(SQLException e){System.out.println("Errore nella chiusura del database");}
   }  
   
   public boolean inserisciRiga(String tabella, String colonne, String [] valori){
      String val="(?";
      for(int i=1;i<valori.length;i++)
         val+=",?";
      val+=")";
      try{
         PreparedStatement pstmt = conn.prepareStatement("INSERT INTO "+ tabella +" ("+ colonne.trim() +") values "+ val);
         for(int i=0; i<valori.length; i++)
            pstmt.setString(i, valori[i]);
         pstmt.execute();
         pstmt.close();
      }
      catch(SQLException e){return false;}
      return true;
   }
       
   public boolean modificaRiga(String tabella, String colonnevalori, String controlli){
      try{
         connettore.executeQuery("UPDATE "+ tabella +" SET "+ colonnevalori +" WHERE "+ controlli);
      }
      catch(SQLException e){return false;}
      return true;
   }
       
   public boolean cancellaRiga(String tabella, String controlli){
      try{
         connettore.executeQuery("DELETE FROM "+ tabella +" WHERE "+ controlli);
      }
      catch(SQLException e){return false;}
      return true;
   }
       
   public ResultSet selezione(String colonne, String tabella, String controlli){
      String where="";
      ResultSet rs;
      if (controlli!=""){
         where="WHERE " +controlli;
      }
      try{
         rs = connettore.executeQuery("SELECT "+ colonne+" FROM "+ tabella + where);
      }
      catch(SQLException e){return null;}
      return rs;
   }
}
