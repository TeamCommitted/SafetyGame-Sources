package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

public class GestioneLog{
   DataOra dataora;
   UpdateLog logGenerale; //o uno per tipo "generale" login / logout / domande / mod...
   UpdateLog utente;
   public GestioneLog(){}
   
   public void login(String username, char u){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void chiediDomanda(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void posticipa(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void rispondi(String username, String risposta){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }   
   public void datiD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void passD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void mailD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void getStat(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void passA(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void listaD(){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void addD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void delD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void nome(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void cognome(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void codfis(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void username(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void impiego(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void trofei(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void reset(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void badgeD(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void domandeA(){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void addDomanda(){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void remDomanda(){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   public void logout(String username){
      String s="";
      logGenerale.scrivi(s);
      utente.scriviChiudi(s);
   }
   
}