package com.safetyGame.desktop.logic;
import com.safetyGame.desktop.condivisi.*;


public class ControlMenu{
  ConnBack connessione;
  Browser browser;
  
  public ControlMenu(){
    connessione=ConnBack.getInstance();
    browser=Browser.getInstance();
  }

  public void logout(){
    connessione.logout();
  }
  
  public void richiediDomanda(){
    if (connessione.mayApplyForNewQuestion()){
      browser.apri("nuovaDomanda.jsp");
      connessione.resetTimerRichiesta();
    }
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

  }
  
  public boolean isLogged(){
    return connessione.isLogged();
  }
}
