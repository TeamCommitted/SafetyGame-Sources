package com.safetyGame.back.condivisi;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrofeoAssegnatoTest {

	DataOra dd = new DataOra(2012,12,1,22,22,04);
	TrofeoAssegnato t1 = new TrofeoAssegnato();
	TrofeoAssegnato t2 = new TrofeoAssegnato("pippone", dd);
	
	
	@Test
	public void test() {
	//	//fail("Not yet implemented");
		System.out.println(t1.getDataora().toString());
	}

}
