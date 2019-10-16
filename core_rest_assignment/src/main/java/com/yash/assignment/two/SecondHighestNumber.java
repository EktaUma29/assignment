package com.yash.assignment.two;

import java.util.Arrays;

public class SecondHighestNumber {

	public int secondHighestNumber(int[] array) {

		Arrays.sort(array);

		return array[array.length - 2];
	}

}
