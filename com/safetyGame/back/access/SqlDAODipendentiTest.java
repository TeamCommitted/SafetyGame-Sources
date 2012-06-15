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
	  indirizzoAz = "127.0.0.1/ingAz";//"monossido.ath.cx/teamcommitted1";//"aziendasafetygam.altervista.org";//"monossido.ath.cx";
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
      //test per la modifica da parte di un amministratore  del proprio nome
	  init();
	  Dipendente dipV = new Dipendente(25,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  String nome = "Paolo";
	  assertTrue("nome utente non modificato", (sqlD.modNome(dipV, nome)));  
	}
	
	@Test
	public void modificaDipendenteCognome() {
      //test per la modifica da parte di un amministratore  del proprio cognome
	  init();
	  Dipendente dipV = new Dipendente(25,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  String cognome = "Paolo";
	  assertTrue("cognome utente non modificato", (sqlD.modCognome(dipV, cognome)));  
	}
	
	@Test
	public void modificaDipendenteCodFisc() {
      //test per la modifica da parte di un amministratore  del proprio codice fiscale
	  init();
	  Dipendente dipV = new Dipendente(25,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  String codfisc = "crnlsn";
	  assertTrue("codice fiscale utente non modificato", (sqlD.modCodFis(dipV, codfisc)));  
	}
	
	@Test
	public void modificaDipendenteUsername() {
      //test per la modifica da parte di un amministratore  del proprio username
	  init();
	  Dipendente dipV = new Dipendente(25,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  String usern = "root";
	  assertTrue("username utente non modificato", (sqlD.modUsername(dipV, usern)));  
	}
	
	@Test
	public void modificaDipendenteImpiego() {
      //test per la modifica da parte di un amministratore  del proprio impiego
	  init();
	  Dipendente dipV = new Dipendente(25,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  String impiego = "Segretaria";
	  assertTrue("impiego utente non modificato", (sqlD.modImpiego(dipV, impiego)));  
	}
	
	@Test
	public void modificaDipendenteSetTrofei() {
      //test per la modifica da parte di un amministratore  del proprio numero di trofei
	  init();
	  Dipendente dipV = new Dipendente(25,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  int trof = 100;
	  assertTrue("numero trofei utente non modificato", (sqlD.setTrofei(dipV, trof)));  
	}
	
	@Test
	public void resetD() {
      //test per la modifica da parte di un dipendente  dopo un reset password
	  init();
//	  Dipendente dipV = new Dipendente(25,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  Recupero recupero = new Recupero("ale.corny@gmail.com","dtrftyg");
	  String pass = "pass1";
	  System.out.println(sqlD.resetD(recupero, pass));
	  assertTrue("password utente non modificato", (sqlD.resetD(recupero, pass)));  
	}
	
	@Test
	public void resetA() {
      //test per la modifica da parte di un amministratore dopo un reset password
	  init();
//	  Dipendente dipV = new Dipendente(25,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  Dipendente amm = new Dipendente(1,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  amm.setAmmAA(true);
	  Recupero recupero = new Recupero("xxx@xxx.xxx","dtrftyg");
	  String pass = "pass1";
	  assertTrue("password amministratore non modificato", (sqlD.resetA(recupero, pass)));  
	}
	
	@Test
	public void testGetInfoD(){
	  init();
	  Login l = new Login("nick","pass");
	  Dipendente d = sqlD.getInfoD(l);
	  System.out.println(d.getNome());
	  assertTrue("il dipendente non corrisponde", (sqlD.resetA(recupero, pass)));
	}
}
