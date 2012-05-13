/*
 * Name: Punteggi.java
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
 * | 20120306 |Lorenzo Braghetto | + Punteggi
 * |          |                  | + getRispostedate
 * |          |                  | + getRispostecorrette
 * |          |                  | + getRisposteerrate
 * |          |                  | + getPunti
 * |          |                  | + getBadge
 * +----------+------------------+---------------------
 *
*/
package com.safetygame.mobile.condivisi;

public class Punteggi {
	
	private String rispostedate;
	private String rispostecorrette;
	private String risposteerrate;
	private String punti;
	private String[] badges;

	
	public Punteggi(String rispostedate, String rispostecorrette, String risposteerrate, String punti, String[] badge, int numeroBadge)
	{
		this.rispostedate = rispostedate;
		this.rispostecorrette = rispostecorrette;
		this.risposteerrate = risposteerrate;
		this.punti = punti;
		this.badges = new String[numeroBadge];
		for(int i=0; i<numeroBadge; i++)
		{
			this.badges[i] = badge[i];
		}
	}
	
	public String getRispostedate()
	{
		return rispostedate;
	}
	
	public String getRispostecorrette()
	{
		return rispostecorrette;
	}
	
	public String getRisposteerrate()
	{
		return risposteerrate;
	}
	
	public String getPunti()
	{
		return punti;
	}
	
	public String[] getBadge()
	{
		return badges;
	}

}
