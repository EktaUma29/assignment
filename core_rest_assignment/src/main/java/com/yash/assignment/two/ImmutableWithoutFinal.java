package com.yash.assignment.two;

import java.io.IOException;

public class ImmutableWithoutFinal {

	public static void main(String[] args) throws Exception, IOException {

		Student string = new Student("ABC", 101);
		System.out.println(string.getName());
		System.out.println(string.regNo);
	}

}

final class Student {

	final String name;
	final int regNo;

	public Student(String name, int regNo) {
		this.name = name;
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}

	public int getRegNo() {
		return regNo;
	}

}
