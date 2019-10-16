package com.yash.assignment.two;

public class Doubleton {

	private static Doubleton instance[] = new Doubleton[2];
	private static int index = 0;

	static {
		instance[0] = new Doubleton();
		instance[1] = new Doubleton();
	}

	public static Doubleton getInstance() {

		return instance[(index++) % 2];
	}

}
