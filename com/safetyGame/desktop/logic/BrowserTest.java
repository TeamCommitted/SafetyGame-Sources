package com.safetyGame.desktop.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class BrowserTest {

	@Test
	public void apriTest() {
	//test per verificare l'apertura del browser
	  Browser browser = Browser.getInstance();
	  browser.apri("www.google.it");
	}

}
