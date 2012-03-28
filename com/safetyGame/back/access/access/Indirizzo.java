package access.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;


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
   
   public Indirizzo(String indirizzo){
   }
   
   public void finalize(){
      try {
         connettore.close();
         conn.close();
      }
      catch(SQLException e){System.out.println("Errore nella chiusura del database");}
   }  
   
   public boolean inserisciRigaSql(String tabella, String colonne, String [] valori){
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
       
   public boolean modificaRigaSql(String tabella, String colonnevalori, String controlli){
      try{
         connettore.executeQuery("UPDATE "+ tabella +" SET "+ colonnevalori +" WHERE "+ controlli);
      }
      catch(SQLException e){return false;}
      return true;
   }
       
   public boolean cancellaRigaSql(String tabella, String controlli){
      try{
         connettore.executeQuery("DELETE FROM "+ tabella +" WHERE "+ controlli);
      }
      catch(SQLException e){return false;}
      return true;
   }
       
   public ResultSet selezioneSql(String colonne, String tabella, String controlli){
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
      
   public boolean inserisciRigaXml(String tabella, String colonne, String [] valori){
      return true;
   }
   
   public boolean modificaRigaXml(String tabella, String colonnevalori, String controlli){
      return true;
   }
   
   public boolean cancellaRigaXml(String tabella, String controlli){
      return true;
   }
   
   public ResultSet selezioneXml(String colonne, String tabella, String controlli){
      return null;
   }   
}
