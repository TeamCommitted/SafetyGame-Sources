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
    browser.apri("nuovaDomanda.jsp");
    //apre il browser con la pagina di richiesta della domanda
  }
  
  public void visualizzaPunteggio(){
    browser.apri("user_page.jsp");
    //apre il browser con la pagina di visualizzazione dei propri punteggi
  }
  
  public void visualizzaDati(){
    browser.apri("visualizzaDatiD.jsp");
    //apre il browser con la pagina di visualizzazione dei dati personali
  }
  
  public void modificaDati(){
    browser.apri("visualizzaDatiD.jsp");
    //apre il browser con la pagina della modifica dei dati
    
    /*
       index.jsp se ha cookie mostra i dati
       se non ha coockie --> login
       */
    
  }
  
  public boolean isLogged(){
    return connessione.isLogged();
  }
}
