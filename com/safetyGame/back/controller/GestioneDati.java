package com.safetyGame.back.controller;

import java.util.ArrayList;

import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

public class GestioneDati{
   
  private GestioneLog gestioneLog;
  private GestioneRecupero gestioneRecupero;
  private GestioneLogin gestioneLogin;
  private GestioneDomandeD gestioneDomandeD;
  private GestioneDomandeAS gestioneDomandeAS;
  private GestioneDipendentiD gestioneDipendentiD;
  private GestioneDipendentiAA gestioneDipendentiAA;
  private GestioneBadgeD gestioneBadgeD;
  private GestioneBadgeAS gestioneBadgeAS;
  private GestionePunteggiD gestionePunteggiD;
  private GestionePunteggiAA gestionePunteggiAA;

  /**
  * Metodo per ottenere tutti i badge possibili
  * @return un ArrayList<Badge> contenente tutte le badge nel database
  * 
  */
  public ArrayList<Badge> getBadgesAS() {
    return this.gestioneBadgeAS.getBadgesAS();
  }
  
  /**
    * Metodo per ottenere i dati delle badge per un dato utente
    * 
    * @param login dati dell'utente che effettua la richiesta
    * @param n numero di badge che si vuole selezionare
    * @return un ArrayList<Badge> contenente n badge ottenute dall'utente 
   */
  public ArrayList<Badge> getBadgeD(Login l, int n) {
    return this.gestioneBadgeD.getBadgeD(l, n);  
  }
  
  /**
   * Metodo per controllare se l'utente ha soddisfatto dei requisiti per ottenere un badge
   * 
   * @param l dati dell'utente che si deve controllare
   * @param D domanda risposta dall'utente
   * @return true se l'utente ha ricevuto un badge, altrimenti false    
   */
  public boolean assegnaBadge(Domanda D, Login l) {
    return this.gestioneBadgeD.assegnaBadge(D, l);
  }
  
  /**
   * Metodo per ottenere i dati dei dipendenti dell'azienda
   * @return un ArrayList<Dipendente> contenente i dipendenti dell'azienda      
   */
  public ArrayList<Dipendente> getElencoDipendenti() {
    return this.gestioneDipendentiAA.getElencoDipendenti();
  }
  
  /**
   * Metodo per aggiungere un dipendente
   * 
   * @param Dip oggetto contenente i dati del nuovo dipendente
   * @return true se l'operazione viene completata con successo, altrimenti false    
   */
  public boolean aggiungiDipendente(Dipendente Dip) {
    return this.gestioneDipendentiAA.aggiungiDipendente(Dip);
  }
  
  /**
   * Metodo per eliminare
   * 
   * @param Dip oggetto contenente i dati del dipendente da eliminare
   * @return true se l'operazione viene completata con successo, altrimenti false    
   */
  public boolean cancellaDipendente(Dipendente Dip) {
	return this.gestioneDipendentiAA.cancellaDipendente(Dip);
  }
  
  /**
   * Metodo per modificare i dati di un dipendente
   * 
   * @param newDip oggetto contenente i nuovi dati del dipendente da modificare
   * @param oldDip oggetto contenente i vecchi dati del dipendente da modificare
   * @return true se l'operazione viene completata con successo, altrimenti false
   */
  public boolean modDipendente(Dipendente newDip, Dipendente oldDip) {
	return this.gestioneDipendentiAA.modDipendente(newDip, oldDip);
  }
  
  /**
   * Metodo che consente di reperire le informazioni di un dipendente a partire
   * dal suo login
   * 
   * @param l login del dipendente
   * @return informazioni sul dipendente
   */
  public Dipendente getDati(Login l) {
    return this.gestioneDipendentiD.getDati(l);
  }
  
  /**
   * Metodo che consente la modifica della password da parte di un dipendente
   *
   * @param dip dipendente che chiede di modificare la password
   * 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modificaPass(Dipendente dip) {
	return this.gestioneDipendentiD.modificaPass(dip);
  }
  
  /**
   * Metodo che consente la modifica della mail da parte di un dipendente
   * 
   * @param dip che chiede di modificare la mail
   * @param nEmail nuovo indirizzo mail da inserire
   * 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modificaEmail(Dipendente dip, String nEmail) {
	return this.gestioneDipendentiD.modificaEmail(dip, nEmail);
  }
  
  /**
   * Metodo per ottenere la lista di tutte le domande
   * @return un ArrayList<Domande> contenente tutte le domande
   */
  public ArrayList<Domanda> getElencoDomande() {
	return this.gestioneDomandeAS.getElencoDomande();
  }
  
  /**
   * Metodo per inserire una domanda dal server domande al server dell'azienda
   * @return true se l'operazione è stata completata, altrimenti false   
   */
  public boolean addDomanda(Domanda Dom) {
    return this.gestioneDomandeAS.addDomanda(Dom);
  }
  
  /**
   * Metodo per eliminare una domanda dal server dell'azienda
   * @return true se l'operazione è stata completata, altrimenti false       
   */
  public boolean remDomanda(Domanda Dom) {
	return this.gestioneDomandeAS.remDomanda(Dom);
  }
  
  /**
   * Metodo che consente di recuperare una domanda 
   * 
   * @param l oggetto Login del dipendente che deve ricevere la domanda
   * @return domanda per il login proposto
   */
  public Domanda getDomandaD(Login l) {
	return this.gestioneDomandeD.getDomandaD(l);
  }
  
  /**
   * Metodo che si occupa di controllare la risposta data da un dipendente ad una
   * domanda e tenta di scrivere tali informazioni sul DB. Se la risposta è corretta
   * assegna il punteggio al dipendente
   * 
   * @param l Login del dipendente che ha risposto
   * @param risposta Domanda posta al dipendente contenente la risposta data
   */
  public boolean setRisposta(Login l,Domanda risposta) {
	return this.gestioneDomandeD.setRisposta(l, risposta);
  }
  
  /**
   * Metodo per il login degli utenti amministratori
   * 
   * @param login oggetto contenente i dati di login inseriti dall'utente
   */
  public boolean loginAdmin(Login login){
	return this.gestioneLogin.loginAdmin(login);
  }
   /*   
   /**
    * Costruttore della classe GestioneDati
    
   public GestioneDati() {
     //il facade crea tutti gli oggetti del package
	 this.log = new GestioneLog();
	 this.recupero = new GestioneLogin();
	 
   }
   
    * metodi preparati dal facco
    * !!!!! volta per volta scriviamo "fatto" per quelli realizzati!!!!!
    * 
    * 
    public GestioneDati(){} !!!FATTO!!!
    
   
   public boolean login(String username, String password){
      login.login(username, password);
      return true;
   }
   public boolean loginLimitato(String username, String password){
      login.loginLimitato(username, password);
      return true;
   }
   public Dipendente getDati(String username){
      return dipendentiD.getDati(username);
   }
   public Punteggio getStat(String username){
      return punteggiD.getStat(username);
   }
   public void modPass(String pass, String username, char u){
      if (u=='d')
         dipendentiD.setPass(pass,username);
      else
         dipendentiAA.setPass(pass,username);
   }
   public void modMail(String pass, String username){
      dipendentiD.setMail(pass,username);
   }
   public void resetPass(String username, String codfis, String mail){
      recupero.resetPass(username, codfis, mail);
   }
   public Domanda getDomanda(String username){
      return domandeD.getDomanda(username);
   }
   public void posticipa(String username){
      domandeD.posticipa(username);
   }
   public boolean rispondi(String username, String risposta){
      return domandeD.rispondi(username, risposta);
   }
   public void logout(String username){
      login.logout(username);
   }
   public Domanda[] getElencoDomande(boolean interne){
      return domandeAS.getElencoDomande(interne); 
   }
   public void aggiungiDomanda(int id){
      domandeAS.addDomanda(id); 
   }
   public void cancellaDomanda(int id){
      domandeAS.remDomanda(id);     
   }   
   public Dipendente[] getElencoDipendenti(){
      return dipendentiAA.getElencoDipendenti(); 
   }
   public void setTrofei(String dipendente, int n){
      punteggiAA.setTrofei(dipendente, n);
   }
   public Badge[] getBadge(String username){
      return badgeD.getBadge(username);
   }
   public boolean aggiungiDipendente(String nome, String cognome, String codfis, String mail, String impiego){
      return dipendentiAA.aggiungiDipendente(nome,cognome,codfis,mail,impiego);
   }
   public boolean cancellaDipendente(String username){
      return dipendentiAA.cancellaDipendente(username);
   }
   public void modNome(String username, String nome){
      dipendentiAA.modNome(username, nome);
   }
   public void modCognome(String username, String cognome){
      dipendentiAA.modCognome(username, cognome);
   }
   public void modCodFis(String username, String codfis){
      dipendentiAA.modCodFis(username, codfis);
   }
   public void modUsername(String usernameOld, String username){
      dipendentiAA.modUsername(usernameOld, username);
   }
   public void modImpiego(String username, String impiego){
      dipendentiAA.modImpiego(username, impiego);
   }
   
   //public void setLog(GestioneLog l){log=l;}
   public void setRecupero(GestioneRecupero r){recupero=r;}
   public void setLogin(GestioneLogin l){login=l;}
   public void setDomandeD(GestioneDomandeD d){domandeD=d;}
   public void setDomandeAS(GestioneDomandeAS d){domandeAS=d;}
   public void setDipendentiD(GestioneDipendentiD d){dipendentiD=d;}
   public void setDipendentiAA(GestioneDipendentiAA d){dipendentiAA=d;}
   public void setBadgeD(GestioneBadgeD b){badgeD=b;}
   public void setBadgeAS(GestioneBadgeAS b){badgeAS=b;}
   public void setPunteggiAA(GestionePunteggiAA p){punteggiAA=p;}
   */
}