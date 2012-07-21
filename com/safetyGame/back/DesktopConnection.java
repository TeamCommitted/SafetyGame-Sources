/*
 * Name: DesktopConnection.java
 * Package: com.safetygame.back.connection
 * Author: Gabriele Facchin
 * Date: 
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120717 | Gabriele Facchin    | + DesktopConnection
 * |          |                     | + login
 * |          |                     | + logout
 * |          |                     | + mostra_domanda
 * |          |                     | + posticipa
 * |          |                     | + recupera
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back;
import com.safetyGame.back.condivisi.*;
import com.safetyGame.back.controller.GestioneDati;
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

/**
 * Implementazione dell'interfaccia per eseguire le corrette azioni del desktop
 * 
 * @author gfacchin
 * @version 0.1
 */
public class DesktopConnection extends UnicastRemoteObject implements Pacchetto{
  GestioneDati dati;
  
  /**
   * Costruttore della classe DesktopConnection
   * 
   * @param gestDati riferimento al facade GestioneDati 
   */
  public DesktopConnection(GestioneDati gestione) throws RemoteException{
    dati=gestione;
  }
 
  /**
   * metodo che consente di effettuare il login
   * 
   * @param user lo username
   * @param pass la password
   * @return true se il login e` effettuato, false altrimenti
   */
  public boolean login(String user, String pass) throws RemoteException{
    Login l=new Login(user,pass);
    return dati.loginUser(l);
  }
  
  /**
   * metodo che consente di effettuare il logout
   * 
   * @param login l'oggetto login che individua il dipendente loggato
   */
  public void logout(Login login) throws RemoteException{
    dati.logout(login);
  }
  
  /**
   * metodo che consente di prelevare una domanda
   * 
   * @param login l'oggetto login che individua il dipendente loggato
   * @return domanda la prima domanda disponibile per il dipendente
   */
  public Domanda mostra_domanda(Login login) throws RemoteException{    
    return dati.getDomandaD(login);
  }
  
  /**
   * metodo che consente di posticipare la domanda
   * 
   * @param login l'oggetto login che individua il dipendente loggato
   * @param domanda la domanda da posticipare
   * @return true se la domanda e` stata posticipata, false altrimenti
   */
  public boolean posticipa(Login login, Domanda domanda) throws RemoteException{
    return dati.posticipa(login, domanda);
  }
  
  /**
   * metodo che consente di effettuare il ripristino della password
   * 
   * @param recupero l'oggetto recupero contenente i dati richiesti per il ripristino dela password
   * @return true se la password e` stata reimpostata, false altrimenti
   */
  public boolean recupera(Recupero recupero) throws RemoteException{
    return dati.recuperoD(recupero);
  }
}
