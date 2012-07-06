package com.safetyGame.back.controller;

import static org.junit.Assert.*;
import com.safetyGame.back.access.*;
import org.junit.Test;

import com.safetyGame.back.condivisi.*;
import com.safetyGame.back.access.DAODipendenti;
import com.safetyGame.back.access.DAODomande;
import com.safetyGame.back.access.DAOPunteggi;
import com.safetyGame.back.access.Indirizzo;

public class GestioneDomandeDTest {

	private DAODomande daoDomande;
    private DAOPunteggi daoPunteggi;
	private DAODipendenti daoDipendenti;
	private DAOBadge daoBadge;
	private GestionePunteggiD gestionePunteggiD;
	private GestioneLog gestioneLog;
	private GestioneBadgeD gestioneBadge;
	private GestioneLogin gestioneLogin;
	private Indirizzo indirizzoAz;
	private Indirizzo indirizzoDom;
	private DAOLogin daoLogin;
	private GestioneDomandeD gestioneDomandeD;
	
	private void init() {
	  indirizzoAz = new Indirizzo("127.0.0.1/ingAz","root","root");
	  indirizzoDom = new Indirizzo("127.0.0.1/ingDom","root","root");
	  daoDomande = new SqlDAODomande(indirizzoAz,indirizzoDom);  
	  daoPunteggi = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
	  daoDipendenti = new SqlDAODipendenti(indirizzoAz);
	  gestionePunteggiD = new GestionePunteggiD(daoPunteggi,daoDipendenti);
	  gestioneLog = new GestioneLog();
	  daoBadge = new SqlDAOBadge(indirizzoAz);
	  daoLogin = new SqlDAOLogin(indirizzoAz);
	  gestioneLogin = new GestioneLogin(daoLogin,gestioneLog);
	  gestioneBadge = new GestioneBadgeD(daoBadge,daoDipendenti,daoDomande,gestioneLog,gestioneLogin);
	  gestioneDomandeD = new GestioneDomandeD(daoDomande,daoPunteggi,daoDipendenti,gestionePunteggiD,gestioneLog,gestioneBadge);
	}
	
	@Test
	public void getDomandaTest() {
	//test che verifica il recupero di una domanda
	  init();
	  Login l = new Login("nick","pass");
	  Domanda dom = gestioneDomandeD.getDomandaD(l);
	  assertTrue("non viene ritornata domanda corretta", dom.getId()==2);
	}
	
	@Test
	public void setRispostaTest() {
	//test che verifica il recupero di una domanda
	  init();
	  Login l = new Login("nick","pass");
	  Domanda dom = new Domanda();
	  dom.setId(1);
	  dom.setRispostaData(1);
	  dom.setPunteggio(new Punteggio(50));
	  boolean b = gestioneDomandeD.setRisposta(l, dom);
	  assertTrue("non viene rsegnata la risposta corretta", b);
	}
	
	@Test
	public void posticipaTest() {
	//test che verifica il recupero di una domanda
	  init();
	  Login l = new Login("nick","pass");
	  Domanda dom = new Domanda();
	  dom.setId(1);
	  boolean b = gestioneDomandeD.posticipa(l, dom);
	  assertTrue("non viene rsegnata la risposta corretta", b);
	}

}
