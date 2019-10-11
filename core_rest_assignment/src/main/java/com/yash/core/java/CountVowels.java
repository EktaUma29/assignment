package com.yash.core.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CountVowels {

	public Long countVowel(String string) {

		List<String> vowel = Arrays.asList("a", "e", "i", "o", "u");

		Long count = 0l;

		for (int i = 0; i < string.length(); i++) {
			
			char ch = string.charAt(i);
			String str = Character.toString(ch);
			count += vowel.stream().filter(p -> p.equalsIgnoreCase(str)).count();
		}
		
		return count;
	}

}
