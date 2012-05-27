/*
 * Name: SqlDAOPunteggi.java
 * Package: com.safetygame.back.access
 * Author: Gabriele Facchin
 * Date: {Data di approvazione del file}
 * Version: 0.2
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120519 | Gabriele Facchin    | + SqlDAOPunteggi
 * |          |                     | + getStat
 * +----------+---------------------|---------------------
 * | 201205   | Gabriele Facchin    | + getGlobalStat
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDAOPunteggi implements DAOPunteggi{
  private Indirizzo serverAzienda;
  public SqlDAOPunteggi(Indirizzo azienda){
    serverAzienda=azienda;
  }
  
  public Punteggio getStat(Dipendente d){
    ResultSet rs = serverAzienda.selezione("Storico","punteggio","IDDipendente="+d.getId());
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
  
  public Punteggio getGlobalStat(Dipendente d){
    //prende i punteggi dipendente (statistiche)
    return new Punteggio(1);
  }
}

