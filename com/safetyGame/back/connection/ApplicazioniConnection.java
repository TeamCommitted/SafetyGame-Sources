/*
 * Name: ApplicazioniConnection.java
 * Package: com.safetygame.back.connection
 * Author: Lorenzo Braghetto
 * Date: {Data di approvazione del file}
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120611 | Lorenzo Braghetto   | ApplicazioniConnection
 * |          |                     | login
 * |          |                     | getDati
 * |          |                     | getStat
 * |          |                     | modPass
 * |          |                     | modMail
 * |          |                     | resetPass
 * |          |                     | mostraDomanda
 * |          |                     | posticipa
 * |          |                     | rispondi
 * |          |                     | logout
 * |          |                     | getBadge
 * +----------+---------------------+----------------------
 * 
 */ 
package com.safetyGame.back.connection;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

public class ApplicazioniConnection{
   private GestioneDati dati;
   private Parser parser; //non c'� un oggetto ma semplicemente funzioni da richiamare da libreria (Parser.funzione();)
   
   public ApplicazioniConnection(GestioneDati d, Parser p){dati = d; parser = p;}
    
   public boolean login(String username, String password){
    Login l=new Login(username,password);
    return dati.loginUser(l);
   }
    
   public Dipendente getDati(String username){
      Dipendente d = dati.getDati(username);
      return d;
   }
   
   public Punteggio getStat(String username){
      Punteggio p = dati.getStat(username);
      return p;
   }
   
   public void modPass(String pass, String username){
      dati.modPass(pass,username,'d');
   }
   
   public void modMail(String mail, String username){
      dati.modMail(mail,username);
   }
   
   public void resetPass(String username, String codfis, String mail){
      dati.resetPass(username, codfis, mail);
   }
   
   public Domanda mostraDomanda(String username){
      Domanda d= dati.getDomanda(username);
      return d;
   }
   
   public void posticipa(String username){
      dati.posticipa(username);
   }
   
   public boolean rispondi(String username, String risposta){
      dati.rispondi(username, risposta);
      return true;
   }
   
   public void logout(String username){
      dati.logout(username);
   }

  /**
    * Metodo per ottenere i dati delle badge per un dato utente
    * 
    * @param login dati dell'utente che effettua la richiesta
    * @param n numero di badge che si vuole selezionare
    * @return un ArrayList<Badge> contenente n badge ottenute dall'utente 
  */
  public ArrayList<Badge> getBadge(Login l, int n){
    return dati.getBadgeD(l,n);
  }
}
