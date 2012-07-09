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
  private boolean finito;
  private boolean cambiato;

  /**
   * Costruttore della classe Timer
   * 
   */
  public Timer(int t){
    tempo = t;
    finito=false;
    cambiato=false;
  }

  /**
   * metodo che fa partire il thread e quindi il conteggio alla rovescia
   * 
   */
  public void run(){
	int conta = 0;  //riga corny
    while (true){System.out.println("ciclo");
      while(!finito){conta++; System.out.println("numero timer="+conta);//riga corny
        int tempocopia=tempo;
        int attesa=tempocopia/10;
        while(tempocopia>0){
          try{sleep(attesa);}
          catch(InterruptedException e){tempocopia+=attesa-1;}
          tempocopia-=attesa;
          if (cambiato){ //come fa ad entrarci????
            tempocopia=0;
          }
        }
        finito=true; 
        System.out.println("finito ="+finito);
        if (cambiato){//come fa ad entarci??? 
        	System.out.println("sono entrato");
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
   * 
   * @param t nuovo tempo di attesa
   */
  public void setTempo(int t){
    tempo=t;
    cambiato=true;
    finito=false;
  }
  
  /**
   * metodo che consente di recuperare lo stato del conteggio
   * 
   * @return finito
   */
  public boolean isFinito(){
    return finito;
  }
  
  /**
   * metodo che consente di recuperare il tempo con cui e` stato impostato il thread
   * 
   * @return tempo
   */
  public int getTempo(){
    return tempo;
  }
}
