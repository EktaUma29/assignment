package com.yash.assignment.two;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CountOfCharacterTest {

	CountOfCharacter countOfCharacter = new CountOfCharacter();
	
	@Test
	public void test() {

		String string = "iamyashemployee"; 
		
		String actualString = countOfCharacter.countCharacter(string);
		
		assertEquals("ia2m2y2she3plo", actualString);
	
	}

}
