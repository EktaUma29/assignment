package com.yash.assignment.one;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.yash.assignment.one.SpyNumber;

public class SpyNumberTest {

	SpyNumber spyNumber = new SpyNumber();
	
	@Test
	public void shouldReturnTrueIfNumberIsSpy() {
		
		boolean actual = spyNumber.checkSpyNumber(1124);
		
		assertEquals(true, actual);
		
	}
	
	@Test
	public void shouldReturnFalseIfNumberIsNotSpy() {
		
		boolean actual = spyNumber.checkSpyNumber(1424);
		
		assertEquals(false, actual);
		
	}
	
}
