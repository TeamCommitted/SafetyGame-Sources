package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

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
		init();
		Dipendente dip = new Dipendente(101,"wwww","nome","cognome","ale.corny@gmail.com","www","pass","Dirigente",0,"",4);
		gDipAA.aggiungiDipendente(dip);
	}

}
