package com.yash.assignment.one;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.yash.assignment.one.FindWrongNumber;

public class FindWrongNumberTest {

	
	// 3,  12, 8, 19, 13, 32, 18, 42, 23, 52
	FindWrongNumber findWrongNumber = new FindWrongNumber();
	
	@Test
	public void shouldReturnWrongNumberFromSeries() {
		
		List<Integer> list = Arrays.asList(3,  12, 8, 19, 13, 32, 18, 42, 23, 52);
		
		int actual = findWrongNumber.wrongNumber(list);
		
		assertEquals(19, actual);
		
		
	}
	
	@Test
	public void shouldReturnWrongNumberFromSeriesOdd() {
		
		List<Integer> list = Arrays.asList(3,  12, 10, 22, 13, 32, 18, 42, 23, 52);
		
		int actual = findWrongNumber.wrongNumber(list);
		
		assertEquals(10, actual);
		
		
	}
	
	@Test
	public void shouldReturnZeroIfSeriesIsPerfect() {
		
		List<Integer> list = Arrays.asList(3,  12, 8, 22, 13, 32, 18, 42, 23, 52);
		
		int actual = findWrongNumber.wrongNumber(list);
		
		assertEquals(0, actual);
		
		
	}
	
}
