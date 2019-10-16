package com.yash.assignment.one;

import java.util.Arrays;
import java.util.List;

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
