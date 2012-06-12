package com.safetyGame.back;

import com.safetyGame.back.access.condivisi.*;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.access.*;

public class Inizializzatore{
	
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
	 
	 private GestioneDati gestioneDati;
	 
   public Inizializzatore() { 
	 indirizzoAz = new Indirizzo("aziendasafetygam.altervista.org","aziendasafetygam","gifgiresmo40");
	 indirizzoDom = new Indirizzo("domandesafetygam.altervista.org","domandesafetgam","beptusafco87");
	 daoDipendenti = new SqlDAODipendenti(indirizzoAz);
	 daoPunteggi = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
	 daoLogin = new SqlDAOLogin(indirizzoAz);
	 updateLog = null;
	 try{ updateLog = new UpdateLog("attenzione/attenzione.txt");} catch (Exception e){}
	 daoDomande = new SqlDAODomande(indirizzoAz,indirizzoDom);
	 daoBadge = new SqlDAOBadge(indirizzoAz);
	 
	 gestioneRecupero = new GestioneRecupero(daoDipendenti);
	 
	 gestionePunteggiD = new GestionePunteggiD(daoPunteggi,daoDipendenti);
	 
	 gestionePunteggiAA = new GestionePunteggiAA(daoPunteggi,daoDipendenti);
	 
	 gestioneLog = new GestioneLog(updateLog);
	 
	 gestioneLogin = new GestioneLogin(daoLogin,gestioneLog);
	 
	 gestioneBadgeD = new GestioneBadgeD(daoBadge,daoDipendenti,daoDomande, gestioneLog, gestioneLogin);
	 
	 gestioneDomandeD = new GestioneDomandeD(daoDomande,daoPunteggi,daoDipendenti,gestionePunteggiD, gestioneLog, gestioneBadgeD);
	 
	 gestioneDomandeAS = new GestioneDomandeAS(daoDomande);
	 
	 gestioneDipendentiD = new GestioneDipendentiD(daoDipendenti, gestioneLog);
	 
	 gestioneDipendentiAA = new GestioneDipendentiAA(daoDipendenti);
	 
	 gestioneBadgeAS = new GestioneBadgeAS(daoBadge);
	 
	 gestioneDati = new GestioneDati(gestioneRecupero,gestioneLogin,gestioneDomandeD,gestioneDomandeAS,gestioneDipendentiD,gestioneDipendentiAA,gestioneBadgeD, gestioneBadgeAS,gestionePunteggiD, gestionePunteggiAA);
   }
   
   public GestioneDati getDati() {
     return this.gestioneDati;
   }
   public void main (String[] args){
      // inizializzatore degli oggetti da passare ad ogni oggetto partendo dal basso
      //System.out.println("ciao");
	   Inizializzatore i = new Inizializzatore();
	   System.out.println("ciao");
   }
}