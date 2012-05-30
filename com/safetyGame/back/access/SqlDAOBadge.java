/*
 * Name: SqlDAOBadge.java
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
 * | 20120520 | Gabriele Facchin    | + SqlDAOBadge
 * |          |                     | + badgeD
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che gestisce le Badge, implementa i metodi pubblici dell'interfaccia
 * 
 * @author gfacchin
 * @version 0.1
 */

public class SqlDAOBadge implements DAOBadge{
  private Indirizzo serverAzienda;
  
  /**
   * Costruttore della classe SqlDAOBadge
   * 
   */
  
  public SqlDAOBadge(Indirizzo azienda){
    serverAzienda=azienda;
  }
  
  /**
   * Metodo che prende le badge ottenute da un Dipendente dal database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return un ArrayList di Badge che contiene le Badge di quel Dipendente
   * 
   */     
  public ArrayList<Badge> badgeD(Dipendente d){
    ResultSet rs = serverAzienda.selezione("Assegnato","IDBadge, descrizione, soglia","IDutente="+d.getId(),"");
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
