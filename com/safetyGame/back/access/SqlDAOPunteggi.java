package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDAOPunteggi implements DAOPunteggi{
  private Indirizzo serverAzienda;
  public SqlDAOPunteggi(Indirizzo azienda){
    serverAzienda=azienda;
  }
  
  public Punteggio getStat(String username){
    ResultSet rs = serverAzienda.selezione("punteggio","Storico","IDdipendente="+username);
    int totale=0;
    boolean finito = false;
    while(!finito){
      try{
        totale+= Integer.parseInt(rs.getString("IDbadge"));
        rs.next();
      }
      catch (SQLException e){finito = true;}
    }
    return new Punteggio(totale);
  }
  
  public boolean trofei(String username, int n){
    boolean b= serverAzienda.modificaRiga("Dipendente","trofei="+n,"nickname="+username);
    return b;
  }
}

