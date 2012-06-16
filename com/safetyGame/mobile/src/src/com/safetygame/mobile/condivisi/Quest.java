/*
 * Name: Quest.java
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
 * | 20120506 |Lorenzo Braghetto | + Quest
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
