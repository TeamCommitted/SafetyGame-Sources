package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDAOPunteggi implements DAOPunteggi{
  public SqlDAOPunteggi(){}
    //scusa facco, l'indirizzo non lo metti dentro al costruttore?
    //come faccio a saperlo io?, corny
  public Punteggio getStat(String username, Indirizzo serverAzienda){
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
  
  public boolean trofei(String username, int n, Indirizzo serverAzienda){
    boolean b= serverAzienda.modificaRiga("Dipendente","trofei="+n,"nickname="+username);
    return b;
  }
}

