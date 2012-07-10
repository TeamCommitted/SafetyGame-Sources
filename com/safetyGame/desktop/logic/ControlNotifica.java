/*
 * Name: ControlNotifica.java
 * Package: com.safetygame.desktop.logic
 * Author: Gabriele Facchin
 * Date: 
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120609 | Gabriele Facchin    | + ControlNotifica
 * |          |                     | + posticipa
 * +----------+---------------------|---------------------
 * | 201206 | Gabriele Facchin    | + rispondi
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;


/**
 * Classe che gestisce i controlli sulla notifica
 * 
 * @author gfacchin
 * @version 0.1
 */
public class ControlNotifica{
  ConnBack connessione;
  
  /**
   * Costruttore della classe ControlNotifica
   * 
   */
  public ControlNotifica(){
    connessione=ConnBack.getInstance();
  }
  
  /**
   * metodo che fa posticipare la domanda
   * 
   * @return boolean che indica il succeso o meno del rinvio
   */
  public void posticipa(){
    boolean b=false;
    for (int i=0; i<3 && !b; i++)
      b=connessione.posticipa();
  }
  
  /**
   * metodo che, aprendo il browser, fa accedere alla pagina con la domanda
   * 
   */  
  public void rispondi(){
    //apre il browser con la domanda --> mostra domanda
  }
}
