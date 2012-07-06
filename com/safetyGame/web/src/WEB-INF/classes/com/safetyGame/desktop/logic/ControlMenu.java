package com.safetyGame.desktop.logic;


/**
 * Write a description of class ControlMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlMenu{
  ConnBack connessione;
  public ControlMenu(ConnBack cb){
    //crea una System Tray e i menù ad essa correlati
    connessione=cb;
  }
  
  public boolean login(String username, String password) {
    return connessione.login(username,password);
  }

  public boolean logout(String username){
    return connessione.logout(username);
  }
  
  public void richiediDomanda(){
    //apre il browser con la pagina di richiesta della domanda
  }
  
  public void visualizzaPunteggio(){
    //apre il browser con la pagina di visualizzazione dei propri punteggi
  }
  
  public void visualizzaDati(){
    //apre il browser con la pagina di visualizzazione dei dati personali
  }
  
  public void modificaDati(){
    //apre il browser con la pagina della modifica dei dati
  }
}
