package com.safetyGame.back.access;

import static org.junit.Assert.*;

import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

import org.junit.Test;

public class SqlDAODipendentiTest {

	private DAODipendenti sqlD;
	private String indirizzoAz;
	private Indirizzo ind;
	private String utente;
	private String pass;
	
	
	private void init() {
	  indirizzoAz = "127.0.0.1/ing";//"monossido.ath.cx/teamcommitted1";//"aziendasafetygam.altervista.org";//"monossido.ath.cx";
	  utente = "root";//"teamcommitted";//"aziendasafetygam";//"teamcommitted";
	  pass = "root";//"team";//"gifgiresmo40";//""team";
	  System.out.println("cetto");
	  ind = new Indirizzo(indirizzoAz,utente,pass);
	  System.out.println("cetto");
	  sqlD = new SqlDAODipendenti(ind);
	  System.out.println("cetto");
	}
	
	
	@Test
	public void aggiuntaUtente() {
	  //test per l'aggiunta di un dipendente al DB Azienda	
	  init();
	  Dipendente dip = new Dipendente();
	  dip.setNickname("cetto");
	  Punteggio punt = new Punteggio();
	  dip.setPunteggio(punt);
	  dip.setCodFiscale("tcryvgtu");
	  dip.setCognome("caccola");
	  dip.setEmail("aaa@aaa.com");
	  dip.setBadges(new ArrayList<Badge>());
	  dip.setNome("dio");
	  dip.setId(1);
	  Dipendente dipp = new Dipendente(1,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  assertTrue("utente non aggiunto", (sqlD.aggiungiDipendente(dipp)));
	  
	}

}
