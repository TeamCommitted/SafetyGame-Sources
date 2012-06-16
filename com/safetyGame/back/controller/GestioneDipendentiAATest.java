/*
 * Name: GestioneDipendentiAATest.java
 * Package: com.safetygame.back.controller
 * Author: Giorgio Maggiolo
 * Date: {Data di approvazione del file}
 * Version: 0.3
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120611 |Giorgio Maggiolo     | + modPassATest
 * |          |                     | + GestioneDipendentiAATest
 * |          |                     | + getElencoDipendentiTest
 * |          |                     | + aggiungiDipendenteTest
 * |          |                     | + cancellaDipendenteTest
 * |          |                     | + modDipendenteTest
 * +----------+---------------------+----------------------
 * 
 */ 

package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

import java.util.ArrayList;

public class GestioneDipendentiAATest {
    private GestioneDipendentiAA gDipAA;
    private DAODipendenti dDip;
    private Indirizzo indAz;

    private void init(){
      indAz = new Indirizzo("127.0.0.1/ingAz","root","root");
      dDip = new SqlDAODipendenti(indAz);
      gDipAA = new GestioneDipendentiAA(dDip);
    }
    
    
	@Test
	public void aggiungiDipTest() {
	//test che verifica che venga aggiunto un dipendente al DB
		init();
		Dipendente dip = new Dipendente(50,"ewdrftygyh","Vario","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
		boolean risultato = gDipAA.aggiungiDipendente(dip);
		assertTrue("dipendente non aggiunto",risultato == true);
	}
	
	@Test
	public void elencoDipTest() {
	//test che verifica l'elenco dei dipendenti presenti nel DB
		init();
		ArrayList<Dipendente> risultato_elenco = gDipAA.getElencoDipendenti();
		int numero_dip = 1;//nel DB al momento
		assertTrue("il numero di dipendenti in elenco non corrisponde",numero_dip == risultato_elenco.size());
	}
	
	@Test
	public void rimuoviDipTest() {
	//test che verifica la rimozione di un utente dal DB
		init();
		DAODipendenti sqlDip = new SqlDAODipendenti(indAz);
		Login l = new Login("nick","pass");
		Dipendente dip = sqlDip.getInfoD(l);
		boolean risultato = gDipAA.cancellaDipendente(dip);
		assertTrue("rimozione dipendente non riuscita",risultato == true);
	}
	
	@Test
	public void modDipTest() {
	//test che verifica la modifica di un dipendente dal DB
		init();
		DAODipendenti sqlDip = new SqlDAODipendenti(indAz);
		Login l = new Login("nick","pass");
		Dipendente dip = sqlDip.getInfoD(l);
		Dipendente dipMod = sqlDip.getInfoD(l);//costuisco dipendente da modificare
		dipMod.setNome("nuovoNome");
		boolean risultato = gDipAA.modDipendente(dipMod,dip);
		System.out.println(risultato);
		assertTrue("modifica dipendente non riuscita",risultato == true);
	}
	
	@Test
	public void modPassATest() {
	//test che verifica la modifica della password da parte di un amministratore
		init();
		DAODipendenti sqlDip = new SqlDAODipendenti(indAz);
		Login l = new Login("amministratoreAz","pass");
		Dipendente dip = sqlDip.getInfoA(l);
		dip.setNuovaPass("nuovaPass");
		boolean risultato = gDipAA.modPassA(dip);
		assertTrue("modifica password amministratore non riuscita",risultato == true);
	}

}
