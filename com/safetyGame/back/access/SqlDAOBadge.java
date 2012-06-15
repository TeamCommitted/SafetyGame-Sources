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
 * | 20120602 | Gabriele Facchin    | + badgeAS
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
   * Metodo che prende i badge ottenute da un Dipendente dal database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return un ArrayList di Badge che contiene i Badge di quel Dipendente
   * 
   */     
  public ArrayList<Badge> badgeD(Dipendente d){ //
    ResultSet rs = serverAzienda.selezione("Assegnato INNER JOIN Badge ON IDBadge=ID","ID, il, nome, descrizione, soglia","IDDipendente="+d.getId(),"");
    ArrayList<Badge> b = new ArrayList<Badge>();
    boolean trovato = false;
    String nomeB="";
    String descr="";
    String data="";
    int punti=0, ID=0;
    while(!trovato){
      try{
    	ID = rs.getInt("ID");  
        data=rs.getString("il");
        nomeB = rs.getString("nome");
        descr = rs.getString("descrizione");
        punti = rs.getInt("soglia");
        DataOra da = new DataOra(data);
        Badge temp=new Badge(nomeB, ID, descr,punti);
        temp.setData(da);
        b.add(temp);      
        rs.next();
      }
      catch(SQLException e){trovato=true;}  
    }
    if (b.size()==0){b=null;}
    return b;
  }
  
  /**
   * Metodo che prende i badge dal database
   * 
   * @return un ArrayList di Badge che contiene i Badge di quell'azienda
   * 
   */     
  public ArrayList<Badge> badgeAS(){//DA TESTARE
    ResultSet rs = serverAzienda.selezione("Badge","*","","");
    ArrayList<Badge> b = new ArrayList<Badge>();
    boolean trovato = false;
    String nomeB="";
    String descr="";
    int punti=0, ID=0;
    while(!trovato){
      try{
        ID=rs.getInt("ID");  
        nomeB = rs.getString("nome");
        descr = rs.getString("descrizione");
        punti = rs.getInt("soglia");
        Badge temp=new Badge(nomeB, ID, descr,punti);
        b.add(temp);      
        rs.next();
      }
      catch(SQLException e){trovato=true;}  
    }
    if (b.size()==0){b=null;}
    return b;
  }
  
  /**
   * Metodo che assegna una Badge ad un Dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param b Oggetto Badge che deve essere assegnato
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */     
  public boolean assegna(Dipendente d, Badge b){//DA TESTARE
    String valori[]=new String [2];
    valori[0]="'"+d.getId()+"'";
    valori[1]="'"+b.getId()+"'";
    DataOra data=new DataOra();
    valori[2]="'"+data.toString()+"'";
    return serverAzienda.inserisciRiga("Assegnato","IDDipendente, IDBadge, data",valori);
  }
}
