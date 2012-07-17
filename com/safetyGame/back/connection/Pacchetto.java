package com.safetyGame.back.connection;
import com.safetyGame.back.condivisi.*;
import java.rmi.*;

/**
 * Write a description of interface Pacchetto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Pacchetto extends Remote{
   public boolean login(String user, String pass) throws RemoteException;
   public void logout(Login login) throws RemoteException;
   public Domanda mostra_domanda(Login login) throws RemoteException;
   public boolean posticipa(Login login,Domanda domanda) throws RemoteException;
   public boolean recupera(Recupero recupero) throws RemoteException;
}
