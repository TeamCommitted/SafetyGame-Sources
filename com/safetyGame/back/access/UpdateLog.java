package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.io.*;

public class UpdateLog{
  private PrintWriter out;

  public UpdateLog(){}
  
  public void login(String s){
    DataOra oggi=new DataOra();
    synchronized (out){
      try{out=new PrintWriter(new File("generali/login.txt"));}
      catch(Exception e){System.out.println("errore in apertura del file generale login");}
      out.println(oggi + " l'utente " + s + " ha effettuato l'accesso.");
      out.flush();
      out.close();
      try{out=new PrintWriter(new File("utenti/"+s+".txt"));}
      catch(Exception e){System.out.println("errore in apertura del file utenti");}
      out.println(oggi + " login.");
      out.flush();
      out.close();
    } 
  }
  
  public void chiediDomanda(String s){}
  public void posticipa(String s){}
  public void rispondi(String s){}
  public void datiD(String s){}
  public void passD(String s){}
  public void mailD(String s){}
  public void getStat(String s){}
  public void passA(String s){}
  public void listaD(String s){}
  public void addD(String s){}
  public void delD(String s){}
  public void nome(String s){}
  public void cognome(String s){}
  public void codfis(String s){}
  public void username(String s){}
  public void impiego(String s){}
  public void trofei(String s){}
  public void reset(String s){}
  public void badgeD(String s){}
  public void domandeA(String s){}
  public void addDomanda(String s){}
  public void remDomanda(String s){}
  
  public void logout(String s){
    DataOra oggi=new DataOra();
    synchronized (out){
      try{out=new PrintWriter(new File("generali/logout.txt"));}
      catch(Exception e){System.out.println("errore in apertura del file generale logout");}
      out.println(oggi + " l'utente " + s + " si è sconnesso.");
      out.flush();
      out.close();
      try{out=new PrintWriter(new File("utenti/"+s+".txt"));}
      catch(Exception e){System.out.println("errore in apertura del file utente");}
      out.println(oggi + " logout.");
      out.flush();
      out.close();
    } 
  }
}