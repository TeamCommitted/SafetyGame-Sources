/*
 * Name: GestioneLoginTest.java
 * Package: com.safetygame.back.controller
 * Author: Massimo Dalla Pieta'
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120602 |Massimo Dalla Pieta' | + testLoginD
 * |          |                     | + testLoginA
 * |          |                     | + testLogout
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.access.DAOBadge;
import com.safetyGame.back.access.DAODipendenti;
import com.safetyGame.back.access.DAODomande;
import com.safetyGame.back.access.DAOLogin;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAOBadge;
import com.safetyGame.back.access.SqlDAODipendenti;
import com.safetyGame.back.access.SqlDAODomande;
import com.safetyGame.back.access.SqlDAOLogin;
import com.safetyGame.back.access.UpdateLog;
import com.safetyGame.back.condivisi.Badge;
import com.safetyGame.back.condivisi.Login;

public class GestioneLoginTest {
    GestioneLogin login;
    
    private void init() {
          String indirizzo1 = "127.0.0.1/ingAz";
          String utente = "root";
          String pass = "root";
          Indirizzo indirizzoAz = new Indirizzo(indirizzo1,utente,pass);
          DAOLogin daoLog = new SqlDAOLogin(indirizzoAz);
          DAODipendenti daoDip = new SqlDAODipendenti(indirizzoAz);
          UpdateLog updlog = new UpdateLog(indirizzoAz);
          GestioneLog log = new GestioneLog(updlog,daoDip);
          login = new GestioneLogin(daoLog,log);
    }
    
    @Test
    public void testLoginD(){
        init();
        Login l = new Login("nick","pass");
        assertTrue("login non effettuato", login.loginUser(l)); 
    }
    
    @Test
    public void testLoginA(){
        init();
        Login l = new Login("amministratoreAz","pass");
        assertTrue("login non effettuato", login.loginAdmin(l,true)); 
    }
    
    @Test
    public void testLogoutD(){
        init();
        Login l = new Login("nick","pass");
        login.logoutD(l);
        assertTrue("logout non effettuato", true); 
    }
    
    @Test
    public void testLogoutA(){
        init();
        Login l = new Login("amministratoreAz","pass");
        login.logoutA(l);
        assertTrue("logout non effettuato", true); 
    }


}
