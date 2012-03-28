package controller;
import access.access.*;

public class GestioneLog{
   DataOra dataora;
   UpdateLog log;
   public GestioneLog(UpdateLog u){log=u;}
   
   public void login(String username, char u){
      String s="";
      log.login(s);
   }
   public void chiediDomanda(String username){
      String s="";
      log.chiediDomanda(s);
   }
   public void posticipa(String username){
      String s="";
      log.posticipa(s);
   }
   public void rispondi(String username, String risposta){
      String s="";
      log.rispondi(s);
   }   
   public void datiD(String username){
      String s="";
      log.datiD(s);      
   }
   public void passD(String username){
      String s="";
      log.passD(s);
   }
   public void mailD(String username){
      String s="";
      log.mailD(s);
   }
   public void getStat(String username){
      String s="";
      log.getStat(s);
   }
   public void passA(String username){
      String s="";
      log.passA(s);
   }
   public void listaD(){
      String s="";
      log.listaD(s);
   }
   public void addD(String username){
      String s="";
      log.addD(s);
   }
   public void delD(String username){
      String s="";
      log.delD(s);
   }
   public void nome(String username){
      String s="";
      log.nome(s);
   }
   public void cognome(String username){
      String s="";
      log.cognome(s);
   }
   public void codfis(String username){
      String s="";
      log.codfis(s);
   }
   public void username(String username){
      String s="";
      log.username(s);
   }
   public void impiego(String username){
      String s="";
      log.impiego(s);
   }
   public void trofei(String username){
      String s="";
      log.trofei(s);
   }
   public void reset(String username){
      String s="";
      log.reset(s);
   }
   public void badgeD(String username){
      String s="";
      log.badgeD(s);
   }
   public void domandeA(){
      String s="";
      log.domandeA(s);
   }
   public void addDomanda(){
      String s="";
      log.addDomanda(s);
   }
   public void remDomanda(){
      String s="";
      log.remDomanda(s);
   }
   public void logout(String username){
      String s="";
      log.logout(s);
   }
   
}