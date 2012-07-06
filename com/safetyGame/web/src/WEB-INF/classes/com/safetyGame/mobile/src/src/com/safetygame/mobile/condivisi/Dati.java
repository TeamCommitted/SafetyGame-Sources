/*
 * Name: Dati.java
 * Package: com.safetygame.android.condivisi
 * Author: Lorenzo Braghetto
 * Date: {Data di approvazione del file}
 * Version: 0.2
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120306 |Lorenzo Braghetto | + Dati
 * |          |                  | + getNome
 * |          |                  | + getCognome
 * +----------+------------------+---------------------
 *
*/

package com.safetygame.mobile.condivisi;

public class Dati {
	
	private String nome;
	private String cognome;
	
	public Dati(String nome, String cognome)
	{
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public String getCognome()
	{
		return cognome;
	}

}
