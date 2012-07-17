/*
 * Name: Browser.java
 * Package: com.safetygame.desktop.logic
 * Author: Gabriele Facchin
 * Date: 
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120713 | Gabriele Facchin    | + Browser
 * |          |                     | + getInstance
 * |          |                     | + apri
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

/**
 * Classe che gestisce l'apertura del browser predefinito di sistema
 *
 * @author gfacchin 
 * @version 0.1
 */

public class Browser {
 
  private static Browser singleton = null;
  private Desktop desktop;
  private URI link;
  private String iniziouri;
  
  /**
   * Costrutture della classe Browser
   */
  private Browser(){
    try{
       desktop = Desktop.getDesktop();
    }     
    catch(UnsupportedOperationException e){System.out.println("Le funzionalitą minime, non sono disponibili. L'applicazione verra' chiusa"); System.exit(2);}
    iniziouri="http://"+ConnBack.getInstance().getServer();
  }
  
  /**
   * Metodo che ritorna l'unica istanza della classe valida
   * 
   * @return unico oggetto Browser
   */
  public static Browser getInstance(){
    if(singleton == null){
      singleton = new Browser();
    }
    return singleton;
  }
    
  public void apri(String pagina){
    try{
      link = new URI(iniziouri+pagina);
      desktop.browse(link);
    }
    catch (URISyntaxException e){System.out.println("Errore nella sintassi dell'url. Contattare l'Installatore");}
    catch (SecurityException e){System.out.println("Occorre avere il permesso per aprire il browser. Contattare l'Installatore"); System.exit(3);}
    catch (IOException e){System.out.println("Occorre avere almeno un browser predefinito nel sistema. Contattare l'Installatore"); System.exit(4);}
    catch (UnsupportedOperationException e) {System.out.println("Le funzionalitą minime, non sono disponibili. L'applicazione verra' chiusa"); System.exit(1);}
  }      
}
