/*
 * Name: Login.java
 * Package: com.safetyGame.back.condivisi
 * Author: Alessandro Cornaglia
 * Date:
 * Version: 0.1
 * Copyright: 
 * 
 * Changes:
 * +----------------+---------------+-------------------------+
 * |      Date      |   Programmer  |         Changes         |
 * +----------------+---------------+-------------------------+
 * |   2012/03/02   |    AlesCorn   | +Login()                |		
 */
 
 package com.safetyGame.back.condivisi;
 import com.safetyGame.back.controller.*;


/**
 * Classe contenitrice dei dati di autenticazione di un utente
 * 
 * @author TeamCommitted
 * @version 0.1
 * 
 */
public class Login {
	private String username;
	private String password;
	private DataOra dataOra;
	
	/**
	 * Costruttore della classe Login
	 * @param u username
	 * @param p password
	 * @param d oggetto DataOra
	 */
	public Login(String u,String p,DataOra d){
	   this.username = u;
	   this.password = p;
	   this.dataOra = d;
	}
	
	
}
	
