package com.yash.assignment.one;

public class CapitalFirstLastLetter {

	public String capitalizeString(String string) {

		string = string.toLowerCase();
		String finalString = "";
		String str[] = string.split(" ");
		for (int i = 0; i < str.length; i++) {

			str[i] = str[i].substring(0, 1).toUpperCase() + str[i].substring(1, str[i].length() - 1)
					+ str[i].substring(str[i].length() - 1).toUpperCase();

			finalString = finalString.concat(str[i] + " ");

		}

		return finalString.trim();
	}

}
