package com.safetyGame.desktop.logic;

public class Timer extends Thread{
  int tempo;
  boolean logout=false;
  boolean finito=false;

  public Timer(int t){
    tempo = t;
  }

  public void run(){
    while (true){
      while(!logout){
        finito = false;
        int tempocopia=tempo;
        while(tempocopia<=0){
          try{wait(10000);}
          catch(InterruptedException e){}
          tempocopia-=10000;
        }
        finito=true;
        while (finito)
          try{wait();}
          catch(InterruptedException e){}
      }
      try{sleep(10000);}
      catch(InterruptedException e){}
    }
  }
  
  public void setLogout(){
    logout=true;
  }
  
  public void resetLogout(){
    logout=true;
  }
  
  public void setTempo(int t){
    tempo=t;
  }
  
  public int getTempo(){
    return tempo;
  }
}
