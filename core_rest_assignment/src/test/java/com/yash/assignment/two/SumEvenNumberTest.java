package com.yash.assignment.two;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SumEvenNumberTest {
	
	SumEvenNumber sumEvenNumber = new SumEvenNumber();

	@Test
	public void test() {
		
		List<Integer> list = Arrays.asList(12, 3, 4, 6, 10);
		
		int actual = sumEvenNumber.sumEvenNumber(list);
		
		assertEquals(32, actual);
	}

}
