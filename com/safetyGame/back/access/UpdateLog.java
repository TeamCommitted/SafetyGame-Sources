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
 * | 20120422 | Gabriele Facchin    | + UpdateLog
 * |          |                     | + finalize
 * |          |                     | + scrivi
 * |          |                     | + scrivichiudi
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.access;
import java.io.*;

/**
 * Classe che gestisce l'update dei file di log di ogni utente
 * 
 * @author gfacchin
 * @version 1.0
 */

public class UpdateLog extends IOException {
  private PrintWriter out;
  
  /**
   * Costruttore della classe UpdateLog
   * 
   * @param dir percorso della directory da creare ("nomeutente")
   * @param file nome del file ("/nomefile.txt")
   * 
   */
  public UpdateLog(String dir, String file) throws IOException {
     File f= new File("com/safetyGame/back/log"+dir);
     f.mkdir();
     f.setWritable(true);
     f.setReadable(true);
     out=new PrintWriter(new File("com/safetyGame/back/log"+dir+file));
  }
  
  /**
   * Distruttore della classe UpdateLog:
   * chiude lo stream quando l'oggetto viene distrutto.
   * 
   */  
  public void finalize(){out.close();}
  
  /**
   * Metodo che scrive una determinata frase all'interno dello stream aperto
   * 
   * @param s stringa da scrivere
   */  
  public void scrivi(String s){
    synchronized (out){
      out.println(s);
      out.flush();
    } 
  }
  
  /**
    * Metodo che scrive una stringa sullo stream aperto e chiude il file
    * 
    * @param s stringa da scrivere
    */
  public synchronized void scriviChiudi(String s){
      out.println(s);
      out.flush();
      out.close();
  }
}
