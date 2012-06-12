package com.safetyGame.back;

import com.safetyGame.back.access.condivisi.*;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.access.*;

public class Inizializzatore{
   public Inizializzatore() { 
	 Indirizzo indirizzoAz = new Indirizzo("aziendasafetygam.altervista.org","aziendasafetygam","gifgiresmo40");
	 Indirizzo indirizzoDom = new Indirizzo("domandesafetygam.altervista.org","domandesafetgam","beptusafco87");
	 DAODipendenti daoDipendenti = new SqlDAODipendenti(indirizzoAz);
	 DAOPunteggi daoPunteggi = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
	 DAOLogin daoLogin = new SqlDAOLogin(indirizzoAz);
	 UpdateLog updateLog = null;
	 try{ updateLog = new UpdateLog("attenzione/attenzione.txt");} catch (Exception e){}
	 DAODomande daoDomande = new SqlDAODomande(indirizzoAz,indirizzoDom);
	 DAOBadge daoBadge = new SqlDAOBadge(indirizzoAz);
	 
	// DAODipendenti daoDipendenti = new SqlDAODipendenti(indirizzoAz);
	 
	 GestioneRecupero gestioneRecupero = new GestioneRecupero(daoDipendenti);
	 
	 GestionePunteggiD gestionePunteggiD = new GestionePunteggiD(daoPunteggi,daoDipendenti);
	 
	 GestionePunteggiAA gestionePunteggiAA = new GestionePunteggiAA(daoPunteggi,daoDipendenti);
	 
	 GestioneLog gestioneLog = new GestioneLog(updateLog);
	 
	 GestioneLogin gestioneLogin = new GestioneLogin(daoLogin,gestioneLog);
	 
	 GestioneBadgeD gestioneBadgeD = new GestioneBadgeD(daoBadge,daoDipendenti,daoDomande, gestioneLog, gestioneLogin);
	 
	 GestioneDomandeD gestioneDomandeD = new GestioneDomandeD(daoDomande,daoPunteggi,daoDipendenti,gestionePunteggiD, gestioneLog, gestioneBadgeD);
	 
	 GestioneDomandeAS gestioneDomandeAS = new GestioneDomandeAS(daoDomande);
	 
	 GestioneDipendentiD gestioneDipendentiD = new GestioneDipendentiD(daoDipendenti, gestioneLog);
	 
	 GestioneDipendentiAA gestioneDipendentiAA = new GestioneDipendentiAA(daoDipendenti);
	 
	 GestioneBadgeAS gestioneBadgeAS = new GestioneBadgeAS(daoBadge);
	 
	 GestioneDati gestioneDati = new GestioneDati(gestioneRecupero,gestioneLogin,gestioneDomandeD,gestioneDomandeAS,gestioneDipendentiD,gestioneDipendentiAA,gestioneBadgeD, gestioneBadgeAS,gestionePunteggiD, gestionePunteggiAA);
   }
   public void main (String[] args){
      // inizializzatore degli oggetti da passare ad ogni oggetto partendo dal basso
      //System.out.println("ciao");
	   Inizializzatore i = new Inizializzatore();
   }
}