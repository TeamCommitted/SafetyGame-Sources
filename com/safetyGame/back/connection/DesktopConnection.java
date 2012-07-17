package com.safetyGame.back.connection;
import com.safetyGame.back.condivisi.*;
import com.safetyGame.back.controller.GestioneDati;
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

/**
 * Write a description of class DesktopConnection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DesktopConnection implements Pacchetto{
  GestioneDati dati;
  
  public DesktopConnection(GestioneDati gestione) throws RemoteException{
    dati=gestione;
  }
 
  public boolean login(String user, String pass) throws RemoteException{
    Login l=new Login(user,pass);
    return dati.loginUser(l);
  }
  
  public void logout(Login login) throws RemoteException{
    dati.logout(login);
  }
  
  public Domanda mostra_domanda(Login login) throws RemoteException{    
    return dati.getDomandaD(login);
  }
  
  public boolean posticipa(Login login, Domanda domanda) throws RemoteException{
    return dati.posticipa(login, domanda);
  }
  
  public boolean recupera(Recupero recupero) throws RemoteException{
    return dati.recuperoD(recupero);
  }
}
