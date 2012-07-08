package com.safetyGame.desktop.logic;

import java.io.*;

public class Parser{
  
  private File file=null;
  private FileReader in;
  private boolean aperto;

  public Parser(){
    file=new File("server.txt");
    apri();
  }

  public boolean isOpen(){
    return aperto;
  }
  
  public void finalize(){
    try{in.close();}
    catch(IOException e){}
  }
  
  public String leggi(){
    int carattere;
    try{carattere=in.read();}
    catch(IOException e){carattere =-1;}
    String s="";
    while(carattere==-1){
      char c= (char) carattere;
      s+=c;
      try{carattere=in.read();}
      catch(IOException e){carattere=-1;}
    }
    return s;
  }
  
  private void apri(){
    aperto=true;
    try{in= new FileReader(file);}
    catch (FileNotFoundException e){aperto=false;}
  }
    
  public boolean scrivi(String s){
    if (file==null){
      PrintWriter out=null;
      try{out=new PrintWriter(file);} 
      catch(Exception e){return false;}    
      out.println(s);
      out.flush();
      out.close();
      apri();
      return true;
    }
    else return false;
  }
}
