package com.safetyGame.back;

import com.safetyGame.back.condivisi.*;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.access.*;
import com.safetyGame.back.connection.*;

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
	 
	 private Parser parser;
	 private static WebConnection webConnection;
	 private static ApplicazioniConnection appConnection;
	 
   private Inizializzatore() { 
	 indirizzoAz = new Indirizzo("aziendasafetygam.altervista.org","aziendasafetygam","gifgiresmo40");
	 indirizzoDom = new Indirizzo("domandesafetygam.altervista.org","domandesafetgam","beptusafco87");
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
	 parser= new Parser();
	 appConnection= new ApplicazioniConnection(gestioneDati, parser);
   }
   
   public static WebConnection getWeb() {
     return webConnection;
   }
   
   public static ApplicazioniConnection getApp() {
     return appConnection;
   }
   public void main (String[] args){
     Inizializzatore i = new Inizializzatore();
     System.pause();
   }
}