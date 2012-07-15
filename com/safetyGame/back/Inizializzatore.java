/*
 * Name: Inizializzatore.java
 * Package: com.safetygame.back
 * Author: Gabriele Facchin & Alessandro Cornaglia
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 *
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120612 |Alessandro Cornaglia | Inizializzatore
 * +----------+---------------------+----------------------
 * | 20120612 | Gabriele Facchin    | grafica
 * |          |                     | WebConnection
 * |          |                     | ApplicazioniConnection
 * |          |                     | main
 * |          |                     | actionPerformed
 * +----------+---------------------+----------------------
 * | 20120613 | Gabriele Facchin    | tastiera
 * +----------+---------------------+----------------------
 *
 */

package com.safetyGame.back;

import com.safetyGame.back.condivisi.*;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.access.*;
import com.safetyGame.back.connection.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

  /**
   * Classe che si occupa di gestire i log del sistema
   *
   * @author gfacchin
   * @author acornagl
   * @version v1.0
   */

public class Inizializzatore implements ActionListener{
  private Indirizzo indirizzoAz;
  private Indirizzo indirizzoDom;
  private DAODipendenti daoDipendenti;
  private DAOPunteggi daoPunteggi;
  private DAOLogin daoLogin;
  private UpdateLog updateLog;
  private DAODomande daoDomande;
  private DAOBadge daoBadge;

  private GestioneRecupero gestioneRecupero;
  private GestionePunteggiD gestionePunteggiD;
  private GestionePunteggiAA gestionePunteggiAA;
  private GestioneLog gestioneLog;
  private GestioneLogin gestioneLogin;
  private GestioneBadgeD gestioneBadgeD;
  private GestioneDomandeD gestioneDomandeD;
  private GestioneDomandeAS gestioneDomandeAS;
  private GestioneDipendentiD gestioneDipendentiD;
  private GestioneDipendentiAA gestioneDipendentiAA;
  private GestioneBadgeAS gestioneBadgeAS;
  protected GestioneDati gestioneDati;
  private static WebConnection webConnection = null;
  private static ApplicazioniConnection appConnection= null;
  private static Inizializzatore inizializzatore=null;

  private JFrame frame;
  private Label label;
  private JButton bottone;

  /**
   * Costruttore della classe WebConnection
   *
   */
   private Inizializzatore() {
     indirizzoAz = new Indirizzo("localhost/ingAz","root","");
     indirizzoDom = new Indirizzo("localhost/ingDom","root","");
     daoDipendenti = new SqlDAODipendenti(indirizzoAz);
     daoPunteggi = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
     daoLogin = new SqlDAOLogin(indirizzoAz);
     daoDomande = new SqlDAODomande(indirizzoAz,indirizzoDom);
     daoBadge = new SqlDAOBadge(indirizzoAz);

     gestioneRecupero = new GestioneRecupero(daoDipendenti);
     gestionePunteggiD = new GestionePunteggiD(daoPunteggi,daoDipendenti);
     gestionePunteggiAA = new GestionePunteggiAA(daoPunteggi,daoDipendenti);
     gestioneLog = new GestioneLog();
     gestioneLogin = new GestioneLogin(daoLogin,gestioneLog);
     gestioneBadgeD = new GestioneBadgeD(daoBadge,daoDipendenti,daoDomande, gestioneLog, gestioneLogin);
     gestioneDomandeD = new GestioneDomandeD(daoDomande,daoPunteggi,daoDipendenti,gestionePunteggiD, gestioneLog, gestioneBadgeD);
     gestioneDomandeAS = new GestioneDomandeAS(daoDomande);
     gestioneDipendentiD = new GestioneDipendentiD(daoDipendenti, gestioneLog);
     gestioneDipendentiAA = new GestioneDipendentiAA(daoDipendenti);
     gestioneBadgeAS = new GestioneBadgeAS(daoBadge);
     gestioneDati = new GestioneDati(gestioneRecupero,gestioneLogin,gestioneDomandeD,gestioneDomandeAS,gestioneDipendentiD,gestioneDipendentiAA,gestioneBadgeD, gestioneBadgeAS,gestionePunteggiD, gestionePunteggiAA);

     webConnection= new WebConnection(gestioneDati);
     appConnection= new ApplicazioniConnection(gestioneDati);

     try{
       grafica();
     }
     catch (Exception e){}
  }

  /**
   * Metodo per istanziare la grafica
   *
   */
  private void grafica(){
    frame = new JFrame("Server");
    frame.setSize(300,100);
    frame.getContentPane().setLayout(new GridLayout(2,1));
    label = new Label();
    label.setText("Server avviato, premere chiudi per chiuderlo");
    frame.getContentPane().add(label);
    bottone = new JButton("Chiudi");
    frame.getContentPane().add(bottone);
    bottone.addActionListener(this);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setVisible(true);
  }

  /**
   * Metodo per gestire l'evento del click sul bottone
   *
   * @param e l'evento da gestire
   *
   */
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==bottone)
      System.exit(0);
  }

  /**
   * Metodo per gestire la tastiera qual'ora non esistesse la grafica
   *
   */
  private void tastiera(){
    // Stampa a video
    System.out.println("L'applicazione e` in esecuzione.");
    System.out.println("Premere Q quindi INVIO per terminare l'applicazione");
    // Lettura input
    int carattere=-1;
    while (!(carattere==Character.getNumericValue('Q'))) {
      BufferedReader fBuff = new BufferedReader(new InputStreamReader(System.in));
      try{
        carattere = fBuff.read();
      }
      catch(IOException e){}
    }
  }

  /**
   * Metodo statico che ritorna il connettore web
   *
   * @return webConnection riferimento alla classe webConnection
   *
   */
  public static WebConnection getWeb() {
    if (inizializzatore==null)
      crea();
    return webConnection;
  }

  /**
   * Metodo statico che ritorna il connettore applicazioni
   *
   * @return appConnection riferimento alla classe ApplicazioniConnection
   *
   */
  public static ApplicazioniConnection getApp() {
    if (inizializzatore==null)
      crea();
    return appConnection;
  }
  
  /**
   * Metodo statico che crea l'inizializzatore
   *
   */
  private static synchronized void crea(){
    if (inizializzatore==null) 
      inizializzatore=new Inizializzatore();
  }
  
  /**
   * Metodo per avviare l'applicazione
   *
   * @param args[] array di parametri di ingresso tramite opzioni di Java
   */
  public static void main (String[] args){
    Inizializzatore i = new Inizializzatore();
    //i.tastiera();
  }
}