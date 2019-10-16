package com.yash.assignment.one;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.yash.assignment.one.FindNextNumber;

public class FindNextNumberTest {
	
	FindNextNumber findNextNumber = new FindNextNumber();
	
	@Test
	public void shouldReturnNextNumberFromtheSeries() {
		
		List<Integer> list = Arrays.asList(7, 10, 8, 11, 9, 12);
		int actual = findNextNumber.nextNumber(list);
		int expected = 10;
		
		assertEquals(expected, actual);
	}
	

}
