package com.safetyGame.desktop.logic;


public class ControlMenu{
  ConnBack connessione;
  public ControlMenu(ConnBack cb){
    //crea una System Tray e i menu' ad essa correlati
    connessione=cb;
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
