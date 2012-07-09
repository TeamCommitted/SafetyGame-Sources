package com.safetyGame.desktop.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimerTest {

	private Timer timer;
	private void init() {
	  timer =  new Timer(5000);
	}
	@Test
	public void runTest() {
	  init();
	  timer.start();
	  while (!timer.isFinito()){}
	  assertTrue("il conteggio non e' finito",timer.isFinito()==true);
	}

}
