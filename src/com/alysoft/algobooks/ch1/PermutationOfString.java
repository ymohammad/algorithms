package com.alysoft.algobooks.ch1;

public class PermutationOfString {

	public static void main(String[] args) {
		String str = "abc";
		//permutations(str, "");
		for (int x = 0; x<str.length(); x++) {
		System.out.println("Substring for " + x + " >> " + str.substring(0, x));
		System.out.println("Next Substring for " + x + " >> " + str.substring(x + 1) + "\n\n\n");
		}
	}

	public static void permutations(String str, String prefix) {
		if (str == null || str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int x = 0; x<str.length(); x++) {
				String rem = str.substring(0, x) + str.substring(x + 1);
				permutations(rem, prefix + str.charAt(x));
			}
		}
	}
}
