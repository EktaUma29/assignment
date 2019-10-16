package com.yash.assignment.one;

public class SpyNumber {

	public boolean checkSpyNumber(int number) {

		int sum = 0, multi = 1;

		while (number > 0) {

			int digit = number % 10;
			number = number / 10;
			sum = sum + digit;
			multi = multi * digit;
		}

		if (sum == multi) {
			return true;
		} else {
			return false;
		}

	}

}
