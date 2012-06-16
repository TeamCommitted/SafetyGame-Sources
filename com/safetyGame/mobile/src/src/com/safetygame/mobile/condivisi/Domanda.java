/*
 * Name: Domanda.java
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
 * | 20120306 |Lorenzo Braghetto | + Domanda
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
	private String testo;
	private String[] risposte;
	private int punteggio;
	private int corretta;

	public Domanda(int id, String type, String testo, int punteggio, int corretta)
	{
		this.id = id;
		this.type = type;
		this.testo = testo;
		this.punteggio = punteggio;
		risposte = new String[3];
		risposte[0] = "si";
		risposte[1] = "no";
		risposte[1] = "-1";
		this.corretta = corretta;
	}

	public Domanda(int id, String type, String testo, String[] risposte, int numeroRisposte, int punteggio, int corretta)
	{
		this.id = id;
		this.type = type;
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
