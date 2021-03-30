package com.nagarro;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void test() {
		Main obj=new Main();
		try {
			Main.main(null);
		}
		catch(Exception e)
		{
			fail("Not yet implemented");
		}
	}

}
