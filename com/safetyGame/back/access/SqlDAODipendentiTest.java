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
	  ind = new Indirizzo(indirizzoAz,utente,pass);
	  sqlD = new SqlDAODipendenti(ind);
	}
	
	
	@Test
	public void aggiuntaUtenteOk() {
	  //test per l'aggiunta di un dipendente al DB Azienda	
	  init();
	  Dipendente dipp = new Dipendente(1,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  assertTrue("utente non aggiunto", (sqlD.aggiungiDipendente(dipp)));  
	}

	@Test
	public void aggiuntaUtenteBad() {
	  //test per l'aggiunta di un dipendente al DB Azienda con parametri non corretti	
	  init();
	  
	  Dipendente dipp = new Dipendente(1,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  assertTrue("utente non aggiunto", (sqlD.aggiungiDipendente(dipp)));  
	}
	
	@Test
	public void modificaDipendenteNome() {
	  init();
	  Dipendente dipV = new Dipendente(25,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  String nome = "Paolo";
	  assertTrue("nome utente non modificato", (sqlD.modNome(dipV, nome)));  
	}
}
