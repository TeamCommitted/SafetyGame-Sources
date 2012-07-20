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
 * | 20120715 | Gabriele Facchin    | + rispondi
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;
import com.safetyGame.desktop.view.Error;

/**
 * Classe che gestisce i controlli sulla notifica
 * 
 * @author gfacchin
 * @version 0.1
 */
public class ControlNotifica{
  ConnBack connessione;
  Browser browser;
  
  /**
   * Costruttore della classe ControlNotifica
   * 
   */
  public ControlNotifica(){
    connessione=ConnBack.getInstance();
    browser=Browser.getInstance();
  }
  
  /**
   * metodo che fa posticipare la domanda
   * 
   */
  public void posticipa(){
    boolean b=false;
    for (int i=0; i<3 && !b; i++)
      b=connessione.posticipa();
    if (!b) {
      new Error ("Impossibile avvisare il server della modifica oppure le domande sono terminate");
    }
    connessione.resetTimerProposta();
  }
  
  /**
   * metodo che, aprendo il browser, fa accedere alla pagina con la domanda
   * 
   */  
  public void rispondi(){
    browser.apri("nuovaDomanda.jsp");
    connessione.resetTimerProposta();
  }
}
