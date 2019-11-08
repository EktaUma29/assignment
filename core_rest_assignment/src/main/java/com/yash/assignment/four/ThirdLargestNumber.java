package com.yash.assignment.four;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ThirdLargestNumber {

	public static void main(String[] args) {

		List<Integer> array = Arrays.asList(6, 7, 2, 1, 0, 10, 10, 10, 11); // 0, 1, 2, 6, 7, 10
		
		Stream<Integer> stream = array.stream().sorted().distinct();
		
		int[] intstream = stream.mapToInt(Integer :: intValue).toArray();
		
		System.out.println(intstream[intstream.length-3]);

	}

}
