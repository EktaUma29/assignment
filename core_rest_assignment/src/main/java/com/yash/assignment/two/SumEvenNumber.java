package com.yash.assignment.two;

import java.util.List;

public class SumEvenNumber {

	public int sumEvenNumber(List<Integer> list) {

		int sum = list.stream().filter(predicate -> predicate % 2 == 0).mapToInt(m -> m.intValue()).sum();

		return sum;
	}

}
