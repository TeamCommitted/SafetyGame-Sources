package com.safetyGame.back.access;
import java.io.*;

public class UpdateLog extends IOException {
  private PrintWriter out;
  
  public UpdateLog(String s) throws IOException {
     out=new PrintWriter(new File("s"));
  }
  
  public void finalize(){out.close();}
  
  public void scrivi(String s){
    synchronized (out){
      out.println(s);
      out.flush();
    } 
  }
  
  public void scriviChiudi(String s){
    synchronized (out){
      out.println(s);
      out.flush();
      out.close();
    } 
  }
}