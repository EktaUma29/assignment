package com.yash.assignment.one;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.yash.assignment.one.ReplaceElement;
import com.yash.core.exception.NumberNotFoundException;

public class ReplaceElementTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	ArrayList<Integer> elementList;
	ArrayList<Integer> expected;

	ReplaceElement replacElement = new ReplaceElement();

	@Test
	public void shouldReturnListAfterReplaceElemet() {
		
		elementList = new ArrayList<Integer>();
		expected = new ArrayList<Integer>();
		elementList.add(55);
		elementList.add(25);
		elementList.add(368);

		ArrayList<Integer> original = replacElement.replaceElement(elementList, 25, 6);
		
		expected.add(55);
		expected.add(6);
		expected.add(368);
		
		assertEquals(expected, original);

	}

	@Test
	public void shouldThrowExceptionIfNumberNotFound() {

		elementList = new ArrayList<Integer>();
		elementList.add(55);
		elementList.add(25);
		elementList.add(368);

		expectedException.expect(NumberNotFoundException.class);
		expectedException.expectMessage("Number not Found Exception");
		
		replacElement.replaceElement(elementList, 50, 7);

	}

}
