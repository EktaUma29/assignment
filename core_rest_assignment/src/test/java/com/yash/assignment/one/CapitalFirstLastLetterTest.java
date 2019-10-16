package com.yash.assignment.one;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.yash.assignment.one.CapitalFirstLastLetter;

public class CapitalFirstLastLetterTest {

	
	CapitalFirstLastLetter capitalFirstLastLetter = new CapitalFirstLastLetter();
	
	@Test
	public void shouldReturnStringWithFirstAndLastLetterCapitalOfWord() {
		
		String actual = capitalFirstLastLetter.capitalizeString("yash pune office");
		
		String expected = "YasH PunE OfficE";
		
		assertEquals(expected, actual);
	}
	
}
