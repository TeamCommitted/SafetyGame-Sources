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
 
 package com.safetyGame.back.condivisi;

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
    * deve prendere l'orario di oggi dall'orologio di sistema
    */
   public DataOra(){
     anno = -1;
     mese = -1;
     giorno = -1;
     ora = -1;
     minuti = -1;
     secondi = -1;
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
   
   /**
    * Metodo che aggiusta un elemento che compone la data per far si che tutti i 
    * numeri siano composti da due cifre
    * 
    * @param parteData numero da controllare
    * @return risultato numero come stringa formato da due cifre
    */
   public static String aggiusta(int parteData){
     if ( parteData < 10 ) {
	   return "0"+parteData;
     }
     return ""+parteData;
   }
   
   @Override
   public String toString() { 
     String sMese = null;
     String sGiorno = null;
     String sOra = null;
     String sMinuti = null;
     String sSecondi = null;
	 
     sMese = aggiusta(this.mese);
     sGiorno = aggiusta(this.giorno);
     sOra = aggiusta(this.ora);
     sMinuti = aggiusta(this.minuti);
     sSecondi = aggiusta(this.secondi);
	 
     return ""+anno+"/"+sMese+"/"+sGiorno+" "+sOra+":"+sMinuti+":"+sSecondi;
   }   
}
