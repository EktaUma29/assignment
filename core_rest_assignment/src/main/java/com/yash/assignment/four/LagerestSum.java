package com.yash.assignment.four;

public class LagerestSum {

	public static void main(String[] args) {

		int array[] = {-2, -3, 4, -1, -2, 1, 5, -3 };
		
		LagerestSum lagerestSum = new LagerestSum();
		
		int sum = lagerestSum.sum(array);
		
		System.out.println(sum);

	}

	private int sum(int[] array) {

		int sum = 0;
		int endSum = 0;
		
		for(int i=0; i<array.length; i++) {
			
			sum = sum + array[i];
			
			if(sum > endSum)
				endSum = sum;
			if(sum < 0)
				sum =0;
			
		}
		
		return endSum;
	}

}
