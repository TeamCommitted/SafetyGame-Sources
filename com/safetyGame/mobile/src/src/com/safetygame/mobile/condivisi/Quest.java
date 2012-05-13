/*
 * Name: Quest.java
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
 * | 20120306 |Lorenzo Braghetto | + Quest
 * |          |                  | + getTitle
 * |          |                  | + getTesto
 * +----------+------------------+---------------------
 *
*/
package com.safetygame.mobile.condivisi;

public class Quest {
	
	private String title;
	private String testo;
		
	public Quest(String title, String testo)
	{
		this.title = title;
		this.testo= testo;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getTesto()
	{
		return testo;
	}

}
