package com.yash.assignment.four;

import java.util.regex.Pattern;

public class BinaryNumberSum {

	public static void main(String[] args) {

		String a = "101", b = "1";
		
		BinaryNumberSum binaryNumberSum = new BinaryNumberSum();
		
		String sum = binaryNumberSum.sumOfBinary(a, b);
		
		System.out.println("Sum: " + sum);
		
	}

	public String sumOfBinary(String a, String b) {

		int b1 = Integer.parseInt(a, 2);
	    int b2 = Integer.parseInt(b, 2);
	    int sum = b1 + b2;
	    
	    return Integer.toBinaryString(sum);
		
	}

}
