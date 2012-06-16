package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.access.DAOBadge;
import com.safetyGame.back.access.DAODipendenti;
import com.safetyGame.back.access.DAODomande;
import com.safetyGame.back.access.DAOLogin;
import com.safetyGame.back.access.DAOPunteggi;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAOBadge;
import com.safetyGame.back.access.SqlDAODipendenti;
import com.safetyGame.back.access.SqlDAODomande;
import com.safetyGame.back.access.SqlDAOLogin;
import com.safetyGame.back.access.SqlDAOPunteggi;
import com.safetyGame.back.condivisi.Badge;
import com.safetyGame.back.condivisi.Dipendente;
import com.safetyGame.back.condivisi.Domanda;
import com.safetyGame.back.condivisi.Login;
import com.safetyGame.back.condivisi.Punteggio;
import com.safetyGame.back.condivisi.Recupero;

public class GestioneDatiTest {
	  GestioneRecupero gestioneRecupero;
	  GestioneLogin gestioneLogin;
	  GestioneDomandeD gestioneDomandeD;
	  GestioneDomandeAS gestioneDomandeAS;
	  GestioneDipendentiD gestioneDipendentiD;
	  GestioneDipendentiAA gestioneDipendentiAA;
	  GestioneBadgeD gestioneBadgeD;
	  GestioneBadgeAS gestioneBadgeAS;
	  GestionePunteggiD gestionePunteggiD;
	  GestionePunteggiAA gestionePunteggiAA;
	  GestioneLog gestioneLog;
	  GestioneDati D;
	
	private void init() {
		  String indirizzo1 = "127.0.0.1/ingAz";
		  String indirizzo2 = "127.0.0.1/ingDom";
		  String utente = "root";
		  String pass = "root";
		  Indirizzo indirizzoAz = new Indirizzo(indirizzo1,utente,pass);
		  Indirizzo indirizzoDom = new Indirizzo(indirizzo2,utente,pass);
		  DAODipendenti daoDipendenti= new SqlDAODipendenti(indirizzoAz);
		  DAOPunteggi daoPunteggi = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
		  DAOLogin daoLogin = new SqlDAOLogin(indirizzoAz);
		  DAODomande daoDomande = new SqlDAODomande(indirizzoAz,indirizzoDom);
		  DAOBadge daoBadge = new SqlDAOBadge(indirizzoAz);
		  
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
		  D = new GestioneDati(gestioneRecupero,gestioneLogin,gestioneDomandeD,gestioneDomandeAS,gestioneDipendentiD,gestioneDipendentiAA,gestioneBadgeD, gestioneBadgeAS,gestionePunteggiD, gestionePunteggiAA);
	}
	
	@Test
	public void testGetBadgesAS() {
		D.getBadgesAS();
	}
	
	@Test
	public void testgetBadgeD() {
		D.getBadgeD(l, n);  
	}
	
	@Test
	public void testassegnaBadge() {
		D.assegnaBadge(D, l);
	}
	  
	@Test
	public void testgetElencoDipendenti() {
	   D.getElencoDipendenti();
	}
	  
	@Test
	public void testaggiungiDipendente() {
		D.aggiungiDipendente(Dip);
	}
	  
	@Test
	public void testcancellaDipendente() {
		D.cancellaDipendente(Dip);
	}
	  
	@Test
	public void testmodDipendente() {
		D.modDipendente(newDip, oldDip);
	}
	  
	@Test
	public void testgetDati() {
	    D.getDati(l);
	}
	  
	@Test
	public void testmodificaPass() {
		D.modificaPass(dip);
	}
	  
	@Test
	public void testmodificaEmail() {
		D.modificaEmail(dip, nEmail);
	}
	  
	@Test
	public void testgetElencoDomande() {
		D.getElencoDomande();
	}
	  
	@Test
	public void testaddDomanda() {
	    D.addDomanda(Dom);
	}
	  
	@Test
	public void testremDomanda() {
		D.remDomanda(Dom);
	}
	
	@Test
	public void testgetDomandaD() {
		D.getDomandaD(l);
	}
	  
	@Test
	public void testsetRisposta() {
		D.setRisposta(l, risposta);
	}
	  
	@Test
	public void testloginAdmin(){
		D.loginAdmin(login);
	}
	
	@Test
	public void testloginUser() {
		D.loginUser(login);		
	}
	
	@Test
	public void testgetPunteggi() {
		D.getPunteggi();
	}
	
	@Test
	public void testsetTrofei() {
		 D.setTrofei(Dip, n);
	}
	   
	@Test
	public void testgetStatisticheD() {
		 D.getStatisticheD(l);
	}
	   
	@Test
	public void testposticipa() {
		 D.posticipa(l, d);
	}
	   
	@Test
	public void testlogout() {
		D.logout(l);
	}
	   
	@Test
	public void testgetStatisticheGlob() {
		D.getStatisticheGlob(l);
	}
	   
	@Test
	public void testrecuperoD() {
		D.recuperoD(dip);
	}
	   
	@Test
	public void testrecuperoA() {
		D.recuperoA(amm);
	}
	   
	@Test
	public void testmodPassA(){
		D.modPassA(admin);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
