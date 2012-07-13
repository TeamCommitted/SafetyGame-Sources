package com.safetyGame.desktop.logic;
import com.safetyGame.desktop.condivisi.*;


public class ControlMenu{
  ConnBack connessione;
  Browser browser;
  
  public ControlMenu(){
    connessione=ConnBack.getInstance();
    browser=Browser.getInstance();
  }

  public boolean logout(){
    return connessione.logout();
  }
  
  public void richiediDomanda(){
    browser.apri("https://www.google.it/");
    //apre il browser con la pagina di richiesta della domanda
  }
  
  public void visualizzaPunteggio(){
    browser.apri("https://www.google.it/");
    //apre il browser con la pagina di visualizzazione dei propri punteggi
  }
  
  public void visualizzaDati(){
    browser.apri("https://www.google.it/");
    //apre il browser con la pagina di visualizzazione dei dati personali
  }
  
  public void modificaDati(){
    browser.apri("https://www.google.it/");
    //apre il browser con la pagina della modifica dei dati
  }
  
  public boolean isLogged(){
    return connessione.isLogged();
  }
}
