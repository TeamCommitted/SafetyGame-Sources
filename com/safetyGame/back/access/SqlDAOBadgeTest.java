package com.safetyGame.back.access;

import static org.junit.Assert.*;

import com.safetyGame.back.condivisi.*;

import java.util.ArrayList;
import org.junit.Test;

public class SqlDAOBadgeTest {

	private DAOBadge daoBadge;
	private Indirizzo indirizzoAz;
	
	private void init() {
	  String indirizzo = "127.0.0.1/ingAz";
	  String utente = "root";
	  String pass = "root";
	  indirizzoAz = new Indirizzo(indirizzo,utente,pass);
	  daoBadge = new SqlDAOBadge(indirizzoAz);
	}
	
	@Test
	public void testBadgeD() {
	  init();
	  ArrayList<Badge> lista = new ArrayList<Badge>();
	  Dipendente dip =  new Dipendente(1,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  lista = daoBadge.badgeD(dip);
	  Badge ottenuto = new Badge("Re dei pompieri",1,"tanti punti su incendio",100);
	  int numero_badge_ottenuti = 2;
	  assertTrue("lista badge ottenuti non corrispondo", (ottenuto.getId()==lista.get(0).getId())); 
	  assertTrue("lista badge ottenuti non corrispondo", (numero_badge_ottenuti == daoBadge.badgeD(dip).size()));
	}
	
	@Test
	public void badgeAS() {
	  init();
	  ArrayList<Badge> lista = new ArrayList<Badge>();
	  Dipendente dip =  new Dipendente(1,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  lista = daoBadge.badgeD(dip);
	  Badge ottenuto = new Badge("Re dei pompieri",1,"tanti punti su incendio",100);
	  int numero_badge_ottenuti = 2;
	  assertTrue("lista badge ottenuti non corrispondo", (ottenuto.getId()==lista.get(0).getId())); 
	  assertTrue("lista badge ottenuti non corrispondo", (numero_badge_ottenuti == daoBadge.badgeD(dip).size()));
	}

}
