package com.yash.assignment.one;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.yash.assignment.one.FindMinMaxNumber;

public class FindMinMaxNumberTest {
	
	
	FindMinMaxNumber findMinMaxNumber = new FindMinMaxNumber();
	
	@Test
	public void shouldReturnMinAndMaxNumberFromList() {
		
		int numbers[] = {40, 10, 50, 60, 30};
		int expected[] = {10, 60};
	
		int actual[] = findMinMaxNumber.checkMinMaxNumber(numbers);
		
		assertArrayEquals(expected, actual);
		
		
	}

}
