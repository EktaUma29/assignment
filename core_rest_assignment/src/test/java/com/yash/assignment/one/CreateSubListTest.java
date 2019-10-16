package com.yash.assignment.one;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.yash.assignment.one.CreateSubList;

public class CreateSubListTest {

	CreateSubList createSubList = new CreateSubList();
	
	@Test
	public void shouldReturnSubListFromListBasedOnNumber() {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(2);
		arrayList.add(1);
		arrayList.add(4);
		arrayList.add(6);
		arrayList.add(3);
		
		List<Integer> actualList = createSubList.subList(arrayList, 2, 5);
		
		List<Integer> expected = Arrays.asList(4, 6, 3);
		
		assertEquals(expected, actualList);
		
	}
}
