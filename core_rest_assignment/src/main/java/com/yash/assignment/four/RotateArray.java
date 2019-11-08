package com.yash.assignment.four;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {

		int array[] = { 1, 2, 3, 4, 5, 6, 7 };

		RotateArray rotateArray = new RotateArray();

		for (int i = 1; i <= 3; i++) {

			array = rotateArray.rotateElement(array);
		}
		for (int ar : array)
			System.out.print(ar + ", ");
	}

	private int[] rotateElement(int[] array) {
		int step = 3;
		int arrayTwo[] = null;

		arrayTwo = new int[array.length];
		arrayTwo[0] = array[array.length - 1];

		for (int k = 1; k < array.length; k++) {

			arrayTwo[k] = array[k - 1];

		}

		return arrayTwo;
	}

}
