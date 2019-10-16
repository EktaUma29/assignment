package com.yash.assignment.two;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapSortingByValue {

	public LinkedHashMap<String, Integer> hashMapSorting(HashMap<String, Integer> map) {

		LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(linkedHashMap, hashMap) -> linkedHashMap, LinkedHashMap::new));

		return sortedMap;
	}

}
