package com.safetyGame.desktop.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimerTest {

	private Timer timer;
	private void init() {
	  timer =  new Timer(6000);
	}
	@Test
	public void runTest() {
	//test del run del timer
	  init();
	  timer.start();
	 /* while(!timer.getFinito()){
	  try{timer.start();}catch(Exception e){System.out.println("www");System.out.println(e.getMessage());}
	  
	  System.out.println(timer.getFinito());}*/
	}

}
