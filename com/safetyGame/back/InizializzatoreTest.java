package com.safetyGame.back;

import static org.junit.Assert.*;
import com.safetyGame.back.condivisi.*;
import org.junit.Test;

public class InizializzatoreTest {

	private Inizializzatore iniz;
	
	private void init() {
	  iniz = new Inizializzatore();
	}
	@Test
	public void test() {
		init();
		Login login = new Login("nick","pass");
		System.out.println(iniz.gestioneDati.loginUser(login));
		System.out.println(iniz.getWeb().loginDip("nick", "passo"));
		
	}

}
