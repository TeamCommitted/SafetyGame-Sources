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
		Dipendente dip = new Dipendente(101,"wwww","nome","cognome","ale.corny@gmail.com","www","pass","Dirigente",0,"",4);
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
		assertTrue("il numero di dipendenti in elenco non corrisponde",risultato == true);
	}
	
	

}
