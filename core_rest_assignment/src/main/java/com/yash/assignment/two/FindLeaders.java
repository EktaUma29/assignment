package com.yash.assignment.two;

public class FindLeaders {

	public int totalLeaders(int[] array) {

		int count = 1;

		for (int i = array.length - 1; i >= 1; i--) {

			if (array[i] < array[i - 1]) {
				count++;
			}

		}

		return count;
	}

}
