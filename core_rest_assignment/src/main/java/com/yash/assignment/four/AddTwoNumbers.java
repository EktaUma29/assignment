package com.yash.assignment.four;

public class AddTwoNumbers {

	public static void main(String[] args) {

		int arr[] = { 2, 7, 11, 15 };

		int result[] = new int[2];

		int target = 26;

		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

		result = addTwoNumbers.getIndices(arr, target);
		
		System.out.println("[" + result[0] + ", " + result[1] + "]");
	}

	private int[] getIndices(int[] arr, int target) {

		int start = 0;
		int end = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] + arr[i + 1] == target) {
				start = i;
				end = i+1;
			}

		}

		int result[] = {start, end}; 
		
		return result;
	}

}
