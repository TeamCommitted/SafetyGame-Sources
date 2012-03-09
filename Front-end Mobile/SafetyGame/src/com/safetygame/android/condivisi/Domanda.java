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
package com.safetygame.android.condivisi;

public class Domanda {
	
	private String type;
	private String title;
	private String testo;
	private String[] risposte;
	
	public Domanda(String type, String title, String testo)
	{
		this.type = type;
		this.title = title;
		this.testo= testo;
	}
	
	public Domanda(String type, String title, String testo, String[] risposte, int numeroRisposte)
	{
		this.type = type;
		this.title = title;
		this.testo= testo;
		this.risposte = new String[numeroRisposte];
		for(int i=0; i<numeroRisposte; i++)
		{
			this.risposte[i] = risposte[i];
		}
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
}
