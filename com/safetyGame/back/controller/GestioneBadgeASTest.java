package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.access.DAOBadge;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAOBadge;
import com.safetyGame.back.condivisi.Badge;

public class GestioneBadgeASTest {
	GestioneBadgeAS gb;
	
	private void init() {
		  String indirizzo = "127.0.0.1/ingAz";
		  String utente = "root";
		  String pass = "root";
		  Indirizzo indirizzoAz = new Indirizzo(indirizzo,utente,pass);
		  DAOBadge daoBadge = new SqlDAOBadge(indirizzoAz);
		  gb = new GestioneBadgeAS(daoBadge);
		}
	
	@Test
	public void testGetBadgeAS(){
		ArrayList<Badge> list = new ArrayList<Badge>();
		gb.getBadgesAS();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
