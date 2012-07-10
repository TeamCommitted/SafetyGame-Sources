package com.safetyGame.desktop.logic;
import com.safetyGame.desktop.condivisi.*;


public class ControlMenu{
  ConnBack connessione;
  public ControlMenu(){
    //crea una System Tray e i menu' ad essa correlati
    connessione=ConnBack.getInstance();;
  }

  public boolean logout(){
    return connessione.logout();
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
  
  public boolean isLogged(){
    return connessione.isLogged();
  }
}
