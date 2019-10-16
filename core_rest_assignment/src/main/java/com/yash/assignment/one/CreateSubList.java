package com.yash.assignment.one;

import java.util.ArrayList;
import java.util.List;

public class CreateSubList {

	public List<Integer> subList(ArrayList<Integer> arrayList, int fromIndex, int toIndex) {

		List<Integer> subList = arrayList.subList(fromIndex, toIndex);

		return subList;
	}

}
