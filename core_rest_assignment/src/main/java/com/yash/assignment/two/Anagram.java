package com.yash.assignment.two;

import java.util.TreeMap;

public class Anagram {

	public Boolean checkAnagram(String string, String anotherString) {

		TreeMap<Character, Integer> stringOneMap = new TreeMap<>();
		for (char ch : string.toCharArray()) {
			stringOneMap.merge(ch, 1, Integer::sum);
		}

		TreeMap<Character, Integer> stringTwoMap = new TreeMap<>();
		for (char ch : anotherString.toCharArray()) {
			stringTwoMap.merge(ch, 1, Integer::sum);
		}

		return stringTwoMap.equals(stringOneMap);
	}

}
