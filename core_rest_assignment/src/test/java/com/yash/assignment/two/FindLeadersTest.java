package com.yash.assignment.two;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FindLeadersTest {
	
	FindLeaders findLeaders = new FindLeaders();
	
	@Test
	public void shouldReturnAllLeadersInArray() {
		
		int array[] = {70, 40, 30, 60, 50};
		
		int actual = findLeaders.totalLeaders(array);
		
		assertEquals(4, actual);
		
		
	}

}
