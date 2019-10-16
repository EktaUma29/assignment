package com.yash.assignment.one;

import java.util.List;

public class FindWrongNumber {

	public int wrongNumber(List<Integer> list) {

		int evenNumber = list.get(0);
		int oddNumber = list.get(1);
		int missingNumber = 0;

		// 3, 12, 8, 19, 13, 32, 18, 42, 23, 52

		for (int i = 2; i < list.size(); i++) {

			if (i % 2 == 0) {

				evenNumber = evenNumber + 5;
				if (list.get(i) != evenNumber)
					return list.get(i);
			} else {

				oddNumber = oddNumber + 10;
				if (list.get(i) != oddNumber)
					return list.get(i);
			}

		}

		return missingNumber;
	}

}
