package com.yash.assignment.one;

import java.util.ArrayList;

import com.yash.core.exception.NumberNotFoundException;

public class ReplaceElement {

	public ArrayList<Integer> replaceElement(ArrayList<Integer> elementList, int oldValue, int newValue) {

		int indexOldValue = elementList.indexOf(oldValue);

		if (elementList.contains(oldValue) == true) {
			elementList.set(indexOldValue, newValue);

		} else {

			throw new NumberNotFoundException("Number not Found Exception");

		}
		return elementList;
	}

}
