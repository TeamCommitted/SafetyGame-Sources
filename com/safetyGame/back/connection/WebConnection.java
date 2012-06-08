package com.safetyGame.back.connection;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

public class WebConnection{
   private GestioneDati dati;
   public WebConnection(GestioneDati d){dati=d;}
    
   public boolean loginDip(String username, String password){
      Login l=new Login(username,password);
      return dati.loginUser(l);
   }
   
   public boolean loginAdmin(String username, String password){
      Login l=new Login(username,password);
      return dati.loginAdmin(l);
   }
    
   public Dipendente getDati(Login l){
      return dati.getDati(l); 
   }
   
   public Punteggio getPunteggio(Login l){
     return dati.getStatisticheD(l);
   }
   
   public Punteggio getStat(Login l){
      return dati.getStatisticheGlob(l);
   }// MANCA
   
   public ArrayList<Badge> getBadge(Login l, int n){
      return dati.getBadgeD(l,n);
   }
   
   public boolean modPassD(Dipendente dip){
      //return dati.modPassD(dip);
	 return dati.modificaPass(dip);
   }
   
   public boolean modPassA(Dipendente newDip, Dipendente oldDip){
      //return dati.modPassA(dip);
	 return dati.modDipendente(newDip, oldDip);
   }
   
   public boolean modMail(Dipendente d, String mail){
      return dati.modificaEmail(d,mail);
   }
   
   public boolean resetPass(Recupero r){
      return dati.recupero(r);
   }
   
   public Domanda mostraDomanda(Login l){
      return dati.getDomandaD(l);
   }
   
   public void posticipa(String username){
      dati.posticipa(username);
   }// MANCA
   
   public boolean rispondi(Login l, String risposta){
      return dati.rispondi(l, risposta);
   }
   
   public boolean logout(Login l){
      return dati.logout(l);
   }// MANCA
   
   public ArrayList<Domanda> getElencoDomande(){
      return dati.getElencoDomande();
   }
   
   public boolean aggiungiDomanda(Domanda d){
      return dati.addDomanda(d);
   }
   
   public boolean cancellaDomanda(Domanda d){
      return dati.remDomanda(d);
   }
   
   public ArrayList<Dipendente> getElencoDipendenti(){
      return dati.getElencoDipendenti();
   }
   
   public boolean setTrofei(Dipendente d, int n){
      return dati.setTrofei(d, n);
   }
   
   public boolean aggiungiDipendente(Dipendente d){
      return dati.aggiungiDipendente(d);
   }
   
   public boolean cancellaDipendente(Dipendente d){
     return dati.cancellaDipendente(d);
   }
   
   public boolean modInfoDipendente(Dipendente dOld, Dipendente dNew){
      return dati.modDipendente(nDip, dOld);
   }
}