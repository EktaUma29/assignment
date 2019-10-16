package com.yash.assignment.one;

import java.util.List;

public class FindNextNumber {

	public int nextNumber(List<Integer> list) {

		// +3 -2
		// 7, 10, 8, 11, 9, 12
		int value = list.get(0);

		for (int i = 1; i < list.size(); i++) {

			if (i % 2 == 0) {
				value = list.get(i) + 3;
			} else {
				value = list.get(i) - 2;
			}

		}

		return value;
	}

}
