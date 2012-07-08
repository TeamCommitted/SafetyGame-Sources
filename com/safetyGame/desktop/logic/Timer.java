/*
 * Name: Timer.java
 * Package: com.safetygame.desktop.logic
 * Author: Gabriele Facchin
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120610 | Gabriele Facchin    | + Timer
 * |          |                     | + run
 * |          |                     | + setTempo
 * |          |                     | + getFinito
 * |          |                     | + getTempo
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;

/**
 * Classe che gestisce il timer per le domande
 * 
 * @author gfacchin
 * @version 1.0
 */
public class Timer extends Thread{
  private int tempo;
  private boolean finito=false;
  private boolean cambiato=false;

  /**
   * Costruttore della classe Timer
   * 
   */
  public Timer(int t){
    tempo = t;
  }

  /**
   * metodo che fa partire il thread e quindi il conteggio
   * 
   */
  public void run(){
    while (true){
      while(!finito){
        int tempocopia=tempo;
        int attesa=tempocopia/10;
        while(tempocopia>0){
          try{sleep(attesa);}
          catch(InterruptedException e){tempocopia+=attesa-1;}
          tempocopia-=attesa;
          System.out.println(tempocopia/1000);
          if (cambiato){
            tempocopia=0;
          }
        }
        finito=true;
        if (cambiato){
          finito=false;
          cambiato=false;
        }
      }
      try{sleep(10000);}
      catch(InterruptedException e){}
    }
  }
  
  /**
   * metodo che consente di reimpostare il tempo d'attesa
   * @param t nuovo tempo di attesa
   */
  public void setTempo(int t){
    tempo=t;
    cambiato=true;
    finito=false;
  }
  
  /**
   * metodo che consente di recuperare lo stato del conteggio
   * @return finito
   */
  public boolean getFinito(){
    return finito;
  }
  
  /**
   * metodo che consente di recuperare il tempo con cui e` stato impostato il thread
   * @return tempo
   */
  public int getTempo(){
    return tempo;
  }
}
