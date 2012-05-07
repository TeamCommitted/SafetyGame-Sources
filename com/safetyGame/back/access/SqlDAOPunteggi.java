package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;

public class SqlDAOPunteggi implements DAOPunteggi{
  public SqlDAOPunteggi(){}
    
  public Punteggio getStat(String username, Indirizzo serverAzienda){
    ResultSet rs = serverAzienda.selezione("punteggio","Storico","IDdipendente="+username);
    int totale=0;
    while(rs.next()){
      totale+= Integer.parseInt(rs.getString("IDbadge"));
    }
    return new Punteggio(totale);
  }
  
  public boolean trofei(String username, int n, Indirizzo serverAzienda){
    boolean b= serverAzienda.modificaRiga("Dipendente","trofei="+n,"nickname="+username);
    return b;
  }
}

