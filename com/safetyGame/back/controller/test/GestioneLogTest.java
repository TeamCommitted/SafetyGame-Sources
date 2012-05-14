package com.safetyGame.back.controller.test;

import com.safetyGame.back.controller.*;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestioneLogTest {

	GestioneLog gestioneLog;
	
	//metodo per inizializzare l'oggetto
	private void init() {
		gestioneLog = new GestioneLog();
	}
	@Test 
	public void testLogin() { //verifico cosa succede quando uso scriviLogin()
		int id = 1;
		String codFisc = "crnlsn89r11l736f";
		String nome = "Alessandro";
		String cognome = "Cornaglia";
		String email = "ppp.cc@vv.ve";
		String nickname = "ale";
		String password = "ciao";
		String ruolo = "stagista";
		int punti = 0;
		Dipendente d = new Dipendente(id,codFisc,nome,cognome,email,nickname,password,ruolo,punti);
		DataOra data = new DataOra();
		boolean b = true;
		Login login = new Login(d,data,b);
		
		gestioneLog.scriviLogin(login);
	}

}
