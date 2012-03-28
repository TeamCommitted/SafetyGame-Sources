/*
 * Name: DataOra.java
 * Package: com.safetyGame
 * Author: TeamCommitted
 * Date:
 * Version: 0.1
 * Copyright: 
 * 
 * Changes:
 * +----------------+---------------+-------------------------+
 * |      Date      |   Programmer  |         Changes         |
 * +----------------+---------------+-------------------------+
 * |   2012/03/02   |    AlesCorn   | +DataOra()              |		
 */
 
 package controller;

/**
 * Classe che rappresenta una data ed un'orario
 * 
 * @author TeamCommitted
 * @version 0.1
 * 
 */
public class DataOra {
   private int anno;
   private int mese;
   private int giorno;
   private int ora;
   private int minuti;
   private int secondi;   
   /**
    * Costruttore della classe DataOra
    * @param a anno
    * @param me mese
    * @param g giorno
    * @param o ora
    * @param mi minuti
    * @param s secondi
    * 
    */
   public DataOra(int a,int me,int g,int o,int mi,int s){
      anno = a;
      mese = me;
      giorno = g;
      ora = o;
      minuti = mi;
      secondi = s;
   }
   /**
    * metodo get per ottenere l'anno
    * @return anno 
    */
   public int getAnno() {
      return anno;
   }
   /**
    * metodo per impostare l'anno
    * 
    */
   public void setAnno(int anno) {
      this.anno = anno;
   }
   /**
    * metodo get per ottenere il mese
    * @return mese 
    */
   public int getMese() {
      return mese;
   }
   /**
    * metodo per impostare il mese
    *  
    */
   public void setMese(int mese) {
      this.mese = mese;
   }
   /**
    * metodo get per ottenere il giorno
    * @return giorno
    */
   public int getGiorno() {
      return giorno;
   }
   /**
    * metodo per impostare il giorno
    *  
    */
   public void setGiorno(int giorno) {
      this.giorno = giorno;
   }
   /**
    * metodo get per ottenere l'ora
    * @return ora
    */
   public int getOra() {
      return ora;
   }
   /**
    * metodo per impostare l'ora
    * 
    */
   public void setOra(int ora) {
      this.ora = ora;
   }
   /**
    * metodo get per ottenere i minuti
    * @return minuti
    */
   public int getMinuti() {
      return minuti;
   }
   /**
    * metodo per impostare i minuti
    * 
    */
   public void setMinuti(int minuti) {
      this.minuti = minuti;
   }
   /**
    * metodo get per ottenere i secondi
    * @return secondi
    */
   public int getSecondi() {
      return secondi;
   }
   /**
    * metodo per impostare i secondi
    * 
    */
   public void setSecondi(int secondi) {
      this.secondi = secondi;
   }
   
   @Override
   public String toString() {
      return ""+anno+"/"+"mese"+"/"+giorno+" "+ora+":"+minuti+":"+secondi;
   }   
}

