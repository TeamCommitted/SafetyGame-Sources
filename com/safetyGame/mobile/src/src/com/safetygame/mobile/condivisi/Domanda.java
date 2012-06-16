/*
 * Name: Domanda.java
 * Package: com.safetygame.android.condivisi
 * Author: Lorenzo Braghetto
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120506 |Lorenzo Braghetto | + Domanda
 * |          |                  | + getType
 * |          |                  | + getTitle
 * |          |                  | + getTesto
 * |          |                  | + getRisposte
 * +----------+------------------+---------------------
 *
 */
package com.safetygame.mobile.condivisi;

public class Domanda {

	private int id;
	private String type;
	private String title;
	private String testo;
	private String[] risposte;
	private int punteggio;
	private int corretta;

	public Domanda(int id, String type, String title, String testo, int punteggio, int corretta)
	{
		this.id = id;
		this.type = type;
		this.title = title;
		this.testo = testo;
		this.punteggio = punteggio;
		risposte[0] = "si";
		risposte[1] = "no";
		risposte[1] = "-1";
		this.corretta = corretta;
	}

	public Domanda(int id, String type, String title, String testo, String[] risposte, int numeroRisposte, int punteggio, int corretta)
	{
		this.id = id;
		this.type = type;
		this.title = title;
		this.testo = testo;
		this.risposte = new String[numeroRisposte];
		for (int i = 0; i < numeroRisposte; i++)
		{
			this.risposte[i] = risposte[i];
		}
		this.punteggio = punteggio;
		this.corretta = corretta;
	}

	public int getId()
	{
		return id;
	}

	public String getType()
	{
		return type;
	}

	public String getTitle()
	{
		return title;
	}

	public String getTesto()
	{
		return testo;
	}

	public String[] getRisposte()
	{
		return risposte;
	}

	public int getPunteggio()
	{
		return punteggio;
	}

	public int getCorretta()
	{
		return corretta;
	}
}
