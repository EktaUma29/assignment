package com.yash.assignment.one;

import java.time.LocalDate;

public class ChangeCurrentDate {

	public LocalDate changeDate(int days) {

		LocalDate localDate = LocalDate.now();
		LocalDate date = localDate.plusDays(days);
		return date;
	}

}
