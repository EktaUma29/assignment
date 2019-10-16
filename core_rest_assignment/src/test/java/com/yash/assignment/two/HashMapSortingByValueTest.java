package com.yash.assignment.two;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapSortingByValueTest {
	
	HashMapSortingByValue hashMapSortingByValue = new HashMapSortingByValue();
	
	@Test
	public void shouldReturnSortedHashMapByValue() {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 38);
		map.put("E", 40);
		map.put("B", 20);
		map.put("D", 10);
		map.put("C", 58);
		
		LinkedHashMap<String, Integer> actualMap = hashMapSortingByValue.hashMapSorting(map);
		
		LinkedHashMap<String, Integer> expectedMap = new LinkedHashMap<String, Integer>();
		expectedMap.put("D", 10);
		expectedMap.put("B", 20);
		expectedMap.put("A", 38);
		expectedMap.put("E", 40);		
		expectedMap.put("C", 58);
		
		assertEquals(expectedMap.toString(), actualMap.toString());
	}

}
