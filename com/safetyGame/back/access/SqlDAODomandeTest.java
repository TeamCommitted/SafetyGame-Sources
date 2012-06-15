package com.safetyGame.back.access;

import static org.junit.Assert.*;

import org.junit.Test;

import com.safetyGame.back.condivisi.Domanda;

public class SqlDAODomandeTest {
	
	private DAODomande sqlD;
	private String indirizzoAz;
	private String indirizzoDom;
	private Indirizzo ind1;
	private Indirizzo ind2;
	private String utente;
	
	
	private void init(String pass) {
	  indirizzoAz = "127.0.0.1/ingAz";
	  indirizzoDom = "127.0.0.1/ingDom";
	  utente = "root";
	  ind1 = new Indirizzo(indirizzoAz,utente,pass);
	  ind2 = new Indirizzo(indirizzoDom,utente,pass);
	  sqlD = new SqlDAODomande(ind1,ind2);
	}
	
	@Test
	public void addDomandaTest(){
		init("root");
		Domanda d = new Domanda();
		d.setId(2);
		assertTrue("Impossibile aggiungere domanda", sqlD.addDomanda(d));
	}
	
	@Test
	public void remDomandaTest(){
		init("root");
		init("root");
		Domanda d = new Domanda();
		d.setId(1);
		assertTrue("Impossibile Rimuovere Domanda", sqlD.remDomanda(d));
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
