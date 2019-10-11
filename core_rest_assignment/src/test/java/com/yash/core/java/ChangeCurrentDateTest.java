package com.yash.core.java;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ChangeCurrentDateTest {
	
	
	ChangeCurrentDate changeCurrentDate = new ChangeCurrentDate();
	
	@Test
	public void shouldChangeCurrentDateWithNumberOFDaysGiven() {
		
		
		LocalDate actualDate = changeCurrentDate.changeDate(23);
		LocalDate expectedDate = LocalDate.now().plusDays(23);
		String datecheck = "2019-11-01";
		
		assertEquals(expectedDate, actualDate);
		
	}

}
