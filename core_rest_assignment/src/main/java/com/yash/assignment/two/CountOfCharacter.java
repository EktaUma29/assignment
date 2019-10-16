package com.yash.assignment.two;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountOfCharacter {

	public String countCharacter(String string) {
		String str = "";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (char ch : string.toCharArray()) {
			map.merge(ch, 1, Integer::sum);
		}

		for (Map.Entry<Character, Integer> mergeValue : map.entrySet()) {
			if (mergeValue.getValue() == 1)
				str = str + mergeValue.getKey();
			else
				str = str + mergeValue.getKey() + mergeValue.getValue();
		}
		return str;
	}

}
