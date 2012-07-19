/*
 * Name: Pacchetto.java
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
 * | 20120717 | Gabriele Facchin    | + login
 * |          |                     | + logout
 * |          |                     | + mostra_domanda
 * |          |                     | + posticipa
 * |          |                     | + recupera
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;
import com.safetyGame.desktop.condivisi.*;
import java.rmi.*;

/**
 * Interfaccia comune per lo scambio di dati tra client e server RMI
 * 
 * @author gfacchin
 * @version 0.1
 */
public interface Pacchetto extends Remote{

  /**
   * metodo che consente di effettuare il login
   * 
   * @param user lo username
   * @param pass la password
   * @return true se il login e' effettuato, false altrimenti
   */
  public boolean login(String user, String pass) throws RemoteException;

  /**
   * metodo che consente di effettuare il logout
   * 
   * @param login l'oggetto login che individua il dipendente loggato
   */
  public void logout(Login login) throws RemoteException;

  /**
   * metodo che consente di prelevare una domanda
   * 
   * @param login l'oggetto login che individua il dipendente loggato
   * @return domanda la prima domanda disponibile per il dipendente
   */
  public Domanda mostra_domanda(Login login) throws RemoteException;

  /**
   * metodo che consente di posticipare la domanda
   * 
   * @param login l'oggetto login che individua il dipendente loggato
   * @param domanda la domanda da posticipare
   * @return true se la domanda e' stata posticipata, false altrimenti
   */
  public boolean posticipa(Login login,Domanda domanda) throws RemoteException;

  /**
   * metodo che consente di effettuare il ripristino della password
   * 
   * @param recupero l'oggetto recupero contenente i dati richiesti per il ripristino dela password
   * @return true se la password e' stata reimpostata, false altrimenti
   */
  public boolean recupera(Recupero recupero) throws RemoteException;
}
