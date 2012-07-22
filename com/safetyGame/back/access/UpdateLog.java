/*
 * Name: UpdateLog.java
 * Package: com.safetygame.back.access
 * Author: Gabriele Facchin
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120720 | Gabriele Facchin    | + scriviLogTre
 * |          |                     | + scriviLogQuattro
 * |          |                     | - finalize
 * |          |                     | - scrivi
 * |          |                     | - scrivichiudi
 * +----------+---------------------|---------------------
 * | 20120422 | Gabriele Facchin    | + UpdateLog
 * |          |                     | + finalize
 * |          |                     | + scrivi
 * |          |                     | + scrivichiudi
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.access;
import java.io.*;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che gestisce l'update dei file di log di ogni utente
 * 
 * @author gfacchin
 * @version 1.0
 */

public class UpdateLog extends IOException {
  //private PrintWriter out;
	private Indirizzo serverAzienda;
  
  /*/**
   * Costruttore della classe UpdateLog
   * 
   * @param dir percorso della directory da creare ("nomeutente")
   * @param file nome del file ("/nomefile.txt")
   * 
   */
  /*public UpdateLog(String dir, String file) throws IOException {
     File f= new File("com/safetyGame/back/log"+dir);
     f.mkdir();
     f.setWritable(true);
     f.setReadable(true);
     out=new PrintWriter(new File("com/safetyGame/back/log"+dir+file));
  }*/
  /**
  * Costruttore della classe UpdateLog
  * @param azienda indirizzo del server aziendale
  */

  public UpdateLog(Indirizzo azienda){
	serverAzienda=azienda;
  }
  
  /*/**
   * Distruttore della classe UpdateLog:
   * chiude lo stream quando l'oggetto viene distrutto.
   * 
   */  
  /*public void finalize(){out.close();}*/
  
  /*/**
   * Metodo che scrive una determinata frase all'interno dello stream aperto
   * 
   * @param log stringa da scrivere
   */  
  /*public void scrivi(String log){
    synchronized (out){
      out.println(log);
      out.flush();
    } 
  }*/

 /**
   * Metodo che scrive un log di login o logout nelle relative tabelle
   * 
   * @param nomeTabella il nome della tabella su cui scrivere
   * 		dip il dipendente interessato
   * 		dataOra la data in cui e' stata effettuata l'azione
   */  
  public void scriviLogTre(String nomeTabella, Dipendente dip, String dataOra){
	String id = ""+dip.getId();
	String[] values = {id,dataOra}; 
    serverAzienda.inserisciRiga(nomeTabella,"IDdipendente,Data",values);
  }
  
  /*/**
    * Metodo che scrive una stringa sullo stream aperto e chiude il file
    * 
    * @param log stringa da scrivere
    */
  /*public synchronized void scriviChiudi(String log){
      out.println(log);
      out.flush();
      out.close();
  }*/

  /**
    * Metodo che scrive un log specifico nella tabella data
    * 
    * @param nomeTabella il nome della tabella su cui scrivere
    * 		dip il dipendente interessato
    * 		dataOra la data in cui e' stata effettuata l'azione
    * 		colonna la colonna contenente la descrizione
	* 		descrizione il valore contenuto nella colonna data
    */
  public void scriviLogQuattro(String nomeTabella, Dipendente dip, String dataOra, String colonna, String descrizione){
    String id = ""+dip.getId();
	String[] values = {id,dataOra,descrizione}; 
    serverAzienda.inserisciRiga(nomeTabella,"IDdipendente,Data,"+colonna,values);
  }
}
