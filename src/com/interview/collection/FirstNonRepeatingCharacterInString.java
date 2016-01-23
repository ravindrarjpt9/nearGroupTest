package com.interview.collection;

public class FirstNonRepeatingCharacterInString {

	public static void main(String[] args) {
		String input = "HELLOH";
		int i = 0;
		int j = 0;
		int found = 0;
		while (i < input.length()) {
		for (j = 0; j < input.length(); j++) {
		if (input.charAt(i) == input.charAt(j)) {
		found++;
		if (found > 1) {
		found = 0;
		break;
		}
		}
		}
		
		
		if (found == 1) {
		System.out.println(input.charAt(i));
		break;
		}
		i++;
		}
		}
}
