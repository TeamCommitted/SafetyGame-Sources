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
    
   public Dipendente getDati(Login l){
      Dipendente d = dati.getDati(l);
      return d;
   }
   
   public Punteggio getStat(Login l){
      Punteggio p = dati.getStat(l);
      return p;
   }
   
   public void modPass(Dipendente d){
      dati.modPass(d);
   }
   
   public void modMail(Dipendente d, String mail){
      dati.modMail(d,mail);
   }
   
   public void resetPass(Recupero r){
      dati.resetPass(r);
   }
   
   public Domanda mostraDomanda(Login l){
      Domanda d= dati.getDomanda(l);
      return d;
   }
   
   public void posticipa(Login l, Domanda d){
      dati.posticipa(l, d);
   }
   
   public boolean rispondi(Login l, Domanda d){
      dati.rispondi(l, d);
      return true;
   }
   
   public void logout(Login l){
      dati.logout(l);
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
