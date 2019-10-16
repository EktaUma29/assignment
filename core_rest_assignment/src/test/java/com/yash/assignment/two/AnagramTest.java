package com.yash.assignment.two;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {
	
	Anagram angram = new Anagram();

	@Test
	public void shouldReturnTrueIfBothStringAnagram() {

		Boolean actual = angram.checkAnagram("peek", "keep");
		
		assertEquals(true, actual);
	
	}
	
	@Test
	public void shouldReturnFalseIfBothStringAreNotAnagram() {

		Boolean actual = angram.checkAnagram("peeki", "keep");
		
		assertEquals(false, actual);
	
	}

}
