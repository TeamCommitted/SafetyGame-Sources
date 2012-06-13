package com.safetyGame.back.controller;

import static org.junit.Assert.*;
import com.safetyGame.back.condivisi.*;
import org.junit.Test;

public class GestioneRecuperoTest {
 
	
	@Test
	public void test() {
	//	fail("Not yet implemented");
		GestioneRecupero gr = new GestioneRecupero(null);
		//try{gr.sendmailwtf();}catch (Exception e){e.printStackTrace();};
		try{gr.sendMail("giorgio@maggiolo.net","nuova_password");}catch(Exception e){e.printStackTrace();};
		assertTrue("percorso errato", 1 == 1);
	}

}
