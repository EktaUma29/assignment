package com.yash.assignment.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DoubletonTest {
	
	Doubleton doubleton = new Doubleton();
	
	@Test
	public void shouldReturnTwoInstance() {
		
		Doubleton doubleton = Doubleton.getInstance();
		Doubleton doubleton1 = Doubleton.getInstance();
		
		assertEquals(Doubleton.getInstance().equals(doubleton) , Doubleton.getInstance().equals(doubleton1));
	}

}
