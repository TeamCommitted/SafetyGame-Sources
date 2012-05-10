package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che si occupa di gestire i log del sistema
 * 
 * @author acornagl 
 * @version v0.1
 */
public class GestioneLog{

  private UpdateLog updateLog;
  
  /**
   * Costruttore con parametri della classe GestioneLog
   * 
   * @param u riferimento all'oggetto UpdateLog del package access
   */
  public GestioneLog(UpdateLog u) {
    this.updateLog = u;
  }
  
  /**
   * Costruttore senza parametri della classe GestioneLog
   * 
   */
  public GestioneLog() {
    this.updateLog = null;
  }
  
  /**
   * metodo che consente di recuperare il riferimento all'oggetto di tipo UpdateLog
   * @return riferimento all'oggetto di tipo UpdateLog
   */
  public UpdateLog getUpdateLog() {
    return updateLog;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto di tipo UpdateLog
   * @param updateLog riferimento all'oggetto di tipo UpdateLog
   */
  public void setUpdateLog(UpdateLog updateLog) {
    this.updateLog = updateLog;
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log
   * 
   * @param l oggetto Login dovuto dall'effettuazione del login da parte di un dipendente
   */
  public void scriviLogin(Login l) {
    DataOra dataOra = new DataOra(); // ricavo data ed ora attuali
    Dipendente dipendente = l.getDipendente(); //ricavo il dipendente
    String log = "LOGIN" + dataOra.toString() + dipendente.toStringID();
    updateLog.scrivi(log);//passo la stringa creata a updateLog
  }

/*   DataOra dataora;
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
*/   
}