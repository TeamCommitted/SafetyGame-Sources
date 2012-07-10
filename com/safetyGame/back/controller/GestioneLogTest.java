/*
 * Name: GestioneLogTest.java
 * Package: com.safetygame.back.controller
 * Author: Lorenzo Braghetto
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120531 |Lorenzo Braghetto    | * scriviLogin
 * |          |                     | * scriviLogout
 * |          |                     | * scriviDomRic
 * |          |                     | * scriviDomProp
 * |          |                     | * scriviDomPost
 * |          |                     | * scriviDomRisp
 * |          |                     | *scriviModPassD
 * |          |                     | *scriviModEmailD
 * |          |                     | *scriviOttenimentoBadge
 * +----------+---------------------+---------------------
 * | 20120527 |Lorenzo Braghetto    | + getLog
 * |          |                     | + getPercorso
 * +----------+---------------------+---------------------
 * | 20120520 |Lorenzo Braghetto    | + GestioneLog
 * |          |                     | + getUpdateLog
 * |          |                     | + setUpdateLog
 * |          |                     | + scriviLogin
 * |          |                     | + scriviLogout
 * |          |                     | + scriviDomRic
 * |          |                     | + scriviDomProp
 * |          |                     | + scriviDomPost
 * |          |                     | + scriviDomRisp
 * |          |                     | + scriviModPassD
 * |          |                     | + scriviModEmailD
 * |          |                     | + scriviOttenimentoBadge
 * |          |                     | + scriviAddDip
 * |          |                     | + scriviDelDip
 * |          |                     | + scriviModDip
 * |          |                     | + scriviAddDomande
 * |          |                     | + scriviDelDomande
 * +----------+---------------------|---------------------
 *
 */ 
package com.safetyGame.back.controller;

import java.io.File;

import com.safetyGame.back.condivisi.*;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Classe di test per oggetti di tipo GestioneLog
 * 
 * @author lbragh
 *
 */
public class GestioneLogTest {

	private GestioneLog gestioneLog;
	int idDip = -1;
	int idDom = -1;
	private final int fDip = 1; //id dip per test
	private final int fDom = 10;//id dom per test
 	private DataOra dataOra = new DataOra();
	//metodo per inizializzare l'oggetto

 	private void init() {
		gestioneLog = new GestioneLog();
		idDip = fDip;
		idDom = fDom;
	}


	@Test
	public void testLogin() { //verifico cosa succede quando uso scriviLogin()
		init(); //inizializzo il test

		Login login = new Login();
		login.setUsername("usr");
		login.setPassword("password");
		//File f = new File(".");
		//System.out.println(f.getAbsolutePath());
		gestioneLog.scriviLogin(login);

		//controllo percorso
		String percorso = gestioneLog.getPercorso();
		String percorsoCorretto = "/log/"+ login.getUsername() + "/login.txt";
		System.out.println(percorsoCorretto);
		System.out.println(percorso);
		assertTrue("percorso errato", percorso.equals(percorsoCorretto));

		//controllo log
		String log = gestioneLog.getLog();
		String logCorretto = "LOGIN "+ this.dataOra.toString()+ " " + login.getUsername();
		assertTrue("log errato", log.equals(logCorretto));
	}
/*
	@Test
	public void testLogout() { //verifico cosa succede quando uso scriviLogout()
		init();//inizializzo il test
		
		Dipendente d = new Dipendente();
		d.setId(idDip);
		boolean b = false;
		

		Login login = new Login(d,dataOra,b);
		
		gestioneLog.scriviLogout(login);
		
		//controllo percorso
		String percorso = gestioneLog.getPercorso();
		String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/logout.txt";
		assertTrue("percorso errato", percorso.equals(percorsoCorretto));
		
		//controllo log
		String log = gestioneLog.getLog();
		String logCorretto = "LOGOUT "+ this.dataOra.toString()+ " " + d.toStringID();
		
		assertTrue("log errato", log.equals(logCorretto));
	}

	@Test
	public void testDomRic() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(idDip);
	  boolean b = false;

	  Login login = new Login(dip,dataOra,b);
		
	  //inizializzo domanda fittizzia
	  Domanda dom = new Domanda();
	  dom.setId(idDom);
	  gestioneLog.scriviDomRic(login,dom);
		
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/dRic.txt";
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "DOMANDA RICEVUTA "+ this.dataOra.toString()+ " id dip=" + dip.getId() + " id dom=" + dom.getId();	
	  assertTrue("log errato", log.equals(logCorretto));
	}
	
	@Test
	public void testDomProp() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(idDip);
	  boolean b = false;

	  Login login = new Login(dip,dataOra,b);
		
	  //inizializzo domanda fittizzia
	  Domanda dom = new Domanda();
	  dom.setId(idDom);
	  gestioneLog.scriviDomProp(login,dom);
		
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/dProp.txt";	
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "DOMANDA PROPOSTA "+ this.dataOra.toString()+ " id dip=" + dip.getId() + " id dom=" + dom.getId();
	  assertTrue("log errato", log.equals(logCorretto));
	}
	
	@Test
	public void testDomPost() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(idDip);
	  boolean b = false;

	  Login login = new Login(dip,dataOra,b);
		
	  //inizializzo domanda fittizzia
	  Domanda dom = new Domanda();
	  dom.setId(idDom);
	  gestioneLog.scriviDomPost(login,dom);
		
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/dPost.txt";	
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "DOMANDA POSTICIPATA "+ this.dataOra.toString()+ " id dip=" + dip.getId() + " id dom=" + dom.getId();
	  assertTrue("log errato", log.equals(logCorretto));
	}
	
	@Test
	public void testDomRisp() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(idDip);
	  boolean b = false;

	  Login login = new Login(dip,dataOra,b);
		
	  //inizializzo domanda fittizzia
	  Domanda dom = new Domanda();
	  dom.setId(idDom);
	  gestioneLog.scriviDomRisp(login,dom);
		
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/dRisp.txt";	
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "DOMANDA RISPOSTA "+ this.dataOra.toString()+ " id dip=" + dip.getId() + " id dom=" + dom.getId();
	  assertTrue("log errato", log.equals(logCorretto));
	}

	@Test
	public void testModPassD() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(idDip);

	  gestioneLog.scriviModPassD(dip);

	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ dip.getId() + "/modPassD.txt";
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "MODIFICA PASS D "+ this.dataOra.toString()+ " id dip=" + dip.getId();
	  assertTrue("log errato", log.equals(logCorretto));
	}
	
	@Test
	public void testModEmailD() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(idDip);

	  gestioneLog.scriviModEmailD(dip);

	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ dip.getId() + "/modEmailD.txt";
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "MODIFICA EMAIL D "+ this.dataOra.toString()+ " id dip=" + dip.getId();
	  assertTrue("log errato", log.equals(logCorretto));
	}
	
	@Test
	public void testOttenimentoBadge() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(idDip);
	  
	  //inizializzo badge fittizzio
	  Badge b = new Badge();
	  b.setNome("pompiere");

	  gestioneLog.scriviOttenimentoBadge(dip,b);

	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ dip.getId() + "/modOttB.txt";
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "OTTENIMENTO BADGE "+ this.dataOra.toString()+ " id dip=" + dip.getId() + " badge=" + b.getNome();
	  assertTrue("log errato", log.equals(logCorretto));
	}
	
	@Test
	public void testAddDip() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(idDip);

	  gestioneLog.scriviAddDip(dip);
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "AGGIUNTO DIPENDENTE "+ this.dataOra.toString()+ " id dip=" + dip.getId();
	  assertTrue("log errato", log.equals(logCorretto));
	}
	
	@Test
	public void testDelDip() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(idDip);

	  gestioneLog.scriviDelDip(dip);
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "RIMOSSO DIPENDENTE "+ this.dataOra.toString()+ " id dip=" + dip.getId();
	  assertTrue("log errato", log.equals(logCorretto));
	}
	
	@Test
	public void testModDip() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(idDip);

	  gestioneLog.scriviModDip(dip);
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "MODIFICATO DIPENDENTE "+ this.dataOra.toString()+ " id dip=" + dip.getId();
	  assertTrue("log errato", log.equals(logCorretto));
	}
	
*/
}

/*
 * 		System.out.println("percorso  = "+ percorso);
 		System.out.println("percorsoc = "+ percorsoCorretto);		
 * 
 * 		System.out.println("log  = "+ log);
		System.out.println("logc = "+ logCorretto);
 */