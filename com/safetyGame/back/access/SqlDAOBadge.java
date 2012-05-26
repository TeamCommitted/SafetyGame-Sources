package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class SqlDAOBadge implements DAOBadge{
  private Indirizzo serverAzienda;
  
  public SqlDAOBadge(Indirizzo azienda){
    serverAzienda=azienda;
  }
   
  public ArrayList<Badge> badgeD(String username){
    ResultSet rs = serverAzienda.selezione("IDBadge, descrizione, soglia","Assegnati","IDutente="+username);
    ArrayList<Badge> b = new ArrayList<Badge>();
    boolean trovato = false;
    String nomeB="";
    String descr="";
    int punti=0;
    while(!trovato){
      try{
        nomeB = rs.getString("IDbadge");
        descr = rs.getString("descrizione");
        punti = rs.getInt("soglia");
        Badge temp=new Badge(nomeB,descr, new Punteggio(punti));
        b.add(temp);      
      }
      catch(SQLException e){trovato=true;}  
    }
    return b;
  }
}
