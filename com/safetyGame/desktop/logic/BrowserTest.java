package com.safetyGame.desktop.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class BrowserTest {

	@Test
	public void apriTest() {
	//test per verificare l'apertura del browser
	  Browser.getInstance().apri("www.google.it");
	  //se apre il browser predefinito all'url indicata è corretto
	}
	
	@Test
	public void leggiTest() {
	//test per verificare l'apertura del browser
	  char letto = Browser.getInstance().leggi("www.google.it");
	  assertTrue("Fallimento di lettura",letto != 'e');
	  //se apre il browser predefinito all'url indicata è corretto
	}

}
