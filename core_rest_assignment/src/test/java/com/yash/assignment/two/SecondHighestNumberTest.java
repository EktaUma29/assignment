package com.yash.assignment.two;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SecondHighestNumberTest {

	SecondHighestNumber secondHighestNumber = new SecondHighestNumber();
	
	@Test
	public void ShouldReturnSecondHighestNumberInArray() {

		int array[] = {12, 3, 43, 42, 2, 2};
		
		int actual = secondHighestNumber.secondHighestNumber(array);
		
		assertEquals(42, actual);
		
	}

}
