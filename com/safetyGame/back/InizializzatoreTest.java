/*
 * Name: DAOBadge.java
 * Package: com.safetygame.back.access
 * Author: Alessandro Cornaglia
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120512 | Alessandro Cornaglia|  + test
 * +----------+---------------------|---------------------
 *
 */

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
