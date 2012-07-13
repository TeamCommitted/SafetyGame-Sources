package com.safetyGame.desktop.logic;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class Browser {
 
  private static Browser singleton = null;
  private Desktop desktop;
  private URI link;
  
  /** Creates a new instance of Singleton
   * Declared private to prevent an instance being created other than using the getInstance method
   */
  private Browser(){
    try{
       desktop = Desktop.getDesktop();
    }     
    catch(UnsupportedOperationException e){System.out.println("Le funzionalità minime, non sono disponibili. L'applicazione verra' chiusa"); System.exit(1);}
  }
  
  /**Static method getInstance is used to initialise the singleton object
   *All calls to getInstance will return the same singleton object
   */
  public static Browser getInstance(){
    if(singleton == null){
      singleton = new Browser();
    }
    return singleton;
  }
    
  public void apri(String uri){
    try{
      link = new URI(uri);
      desktop.browse(link);
    }
    catch (URISyntaxException e){System.out.println("Errore nella sintassi dell'url. Contattare l'Installatore");}
    catch (SecurityException e){System.out.println("Occorre avere il permesso per aprire il browser. Contattare l'Installatore"); System.exit(2);}
    catch (IOException e){System.out.println("Occorre avere almeno un browser predefinito nel sistema. Contattare l'Installatore"); System.exit(3);}
    catch (UnsupportedOperationException e) {System.out.println("Le funzionalità minime, non sono disponibili. L'applicazione verra' chiusa"); System.exit(1);}
  }      
}