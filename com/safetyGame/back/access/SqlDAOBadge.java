package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlDAOBadge implements DAOBadge{
  private Indirizzo serverAzienda;
  
  public SqlDAOBadge(Indirizzo azienda){
    serverAzienda=azienda;
  }
   
  public ArrayList<Badge> badgeD(Dipendente d){
    ResultSet rs = serverAzienda.selezione("Assegnato","IDBadge, descrizione, soglia","IDutente="+d.getId());
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
        Badge temp=new Badge(nomeB, descr, new Punteggio(punti));
        b.add(temp);      
        rs.next();
      }
      catch(SQLException e){trovato=true;}  
    }
    if (b.size()==0){b=null;}
    return b;
  }
}
