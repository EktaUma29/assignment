package com.yash.assignment.one;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.yash.assignment.one.CountVowels;

public class CountVowelsTest {
	
	
	CountVowels countVowel = new CountVowels();
	
	@Test
	public void shouldReturnNumberOfVowels() {
		
		String string = "includeHelp";
		Long expected = 4l;
		Long actual = countVowel.countVowel(string);
		
		assertEquals(expected, actual);
		
	}

}
