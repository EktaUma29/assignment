package com.yash.assignment.four;

import java.util.Arrays;

public class MergeTwoArray {

	public static void main(String[] args) {

		int arrayOne[] = { 7, 3, 10 };
		int arrayTwo[] = { 2, 9, 8 };

		MergeTwoArray mergeTwoArray = new MergeTwoArray();

		int resultArray[] = mergeTwoArray.mergeArrays(arrayOne, arrayTwo);
		
		Arrays.sort(resultArray);

		
		for(int k=0; k<resultArray.length; k++) {
			System.out.println(resultArray[k]);
		}

	}

	private int[] mergeArrays(int[] arrayOne, int[] arrayTwo) {

		int resultArray[] = new int[arrayOne.length + arrayTwo.length];

			for (int i = 0; i < arrayOne.length; i++) {
				resultArray[i] = arrayOne[i];
				
				int k = resultArray.length;
			 for(int j = 0; j<arrayTwo.length; j++) {
			 resultArray[j+arrayOne.length] = arrayTwo[j];
			 }
		}
		return resultArray;
	}

}
