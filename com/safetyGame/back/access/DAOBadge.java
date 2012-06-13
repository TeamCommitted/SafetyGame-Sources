/*
 * Name: DAOBadge.java
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
 * | 20120512 | Gabriele Facchin    |  + badgeD
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaccia che contiene i prototipi dei metodi per gestire le Badge
 * 
 * @author gfacchin
 * @version 0.1
 */

public interface DAOBadge{
  
  /**
   * Metodo che prende i badge ottenute da un Dipendente dal database
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @return un ArrayList di Badge che contiene i Badge di quel Dipendente
   * 
   */    
  public ArrayList<Badge> badgeD(Dipendente d);

  /**
   * Metodo che prende i badge dal database
   * 
   * @return un ArrayList di Badge che contiene i Badge di quell'azienda
   * 
   */  
  public ArrayList<Badge> badgeAS();
  
  /**
   * Metodo che assegna una Badge ad un Dipendente
   * 
   * @param d Oggetto Dipendente da cui si prendono le informazioni
   * @param b Oggetto Badge che deve essere assegnato
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */         
  public boolean assegna(Dipendente d, Badge b);
}
