package com.yash.assignment.one;

import java.util.Arrays;

public class FindMinMaxNumber {

	public int[] checkMinMaxNumber(int[] numbers) {

		Arrays.sort(numbers);

		int array[] = { numbers[0], numbers[numbers.length - 1] };

		return array;
	}

}
