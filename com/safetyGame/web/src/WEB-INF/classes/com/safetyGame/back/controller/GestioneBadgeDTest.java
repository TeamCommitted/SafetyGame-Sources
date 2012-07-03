package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.Badge;
import com.safetyGame.back.condivisi.Domanda;
import com.safetyGame.back.condivisi.Login;

public class GestioneBadgeDTest {
	GestioneBadgeD gb;
	
	private void init() {
		  String indirizzo1 = "127.0.0.1/ingAz";
		  String indirizzo2 = "127.0.0.1/ingDom";
		  String utente = "root";
		  String pass = "root";
		  Indirizzo indirizzoAz = new Indirizzo(indirizzo1,utente,pass);
		  Indirizzo indirizzoDom = new Indirizzo(indirizzo2,utente,pass);
		  DAOBadge daoBadge = new SqlDAOBadge(indirizzoAz);
		  DAODipendenti daoDip = new SqlDAODipendenti(indirizzoAz);
		  DAODomande daoDom = new SqlDAODomande(indirizzoAz,indirizzoDom);
		  DAOLogin daoLog = new SqlDAOLogin(indirizzoAz);
		  GestioneLog log = new GestioneLog();
		  GestioneLogin login = new GestioneLogin(daoLog,log);
		  gb = new GestioneBadgeD(daoBadge,daoDip,daoDom,log,login);
		}
	
	@Test
	public void testGetBadgeD(){
		init();
		ArrayList<Badge> listbadge = new ArrayList<Badge>();
		Login l = new Login("nick","pass");
		listbadge = gb.getBadgeD(l,1);
		System.out.print(listbadge.size());
		assertTrue("lista badge non ottenuta", !listbadge.isEmpty()); 
	}
	
	@Test
	public void testAssegnaBadge(){
		init();
		Domanda d = new Domanda();
		d.setId(1);
		d.setTipologia("Pompiere");
		Login l = new Login("nick","pass");
		assertTrue("badge non assegnata", gb.assegnaBadge(d,l)); 
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
