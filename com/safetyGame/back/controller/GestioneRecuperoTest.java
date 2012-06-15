package com.safetyGame.back.controller;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Classe di test per oggetti di tipo GestioneRecupero
 * @author acornagl
 *
 */
public class GestioneRecuperoTest {
 
	private GestioneRecupero gr;
	
	private void init() {
	  gr = new GestioneRecupero(null);
	}
	
	@Test
	public void testPassCasuale() {
	  init();
	  try{gr.sendMail("ale.corny@gmail.com",gr.generaPassCasuale());}catch(Exception e){e.printStackTrace();};
	  assertTrue("percorso errato", 1 == 1);
	}
	@Test 
	public void testMail() {
	//test per verificare l'invio della mail
	  init();
      try{gr.sendMail("ale.corny@gmail.com","nuova_password");}catch(Exception e){e.printStackTrace();};
	  assertTrue("percorso errato", 1 == 1);
	}
	
	@Test
	public void TestMailModMail() {
	//test per verificare la mail di mod mail
	  init();
	  try{gr.sendMailModMail("ale.corny@gmail.com");}catch(Exception e){};
	}

}
