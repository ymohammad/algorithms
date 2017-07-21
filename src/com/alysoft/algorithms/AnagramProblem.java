package com.alysoft.algorithms;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * A word is an anagram of another if you can arrange its characters to produce
 * the second word.
 * 
 * Given two strings determines if they are anagrams of each other.
 * 	-	'earth' and 'heart' are anagrams
 *  -	'silent' and 'listen' are anagrams
 *  -	'foo' and 'bar' are not anagrams.
 */
public class AnagramProblem {
	
	/**
	 * Method 1: Create a Permutation Method to get all combinations. We could do that by creating a loop over
	 * 			 all the permutations of string s1, and for each permutation, if it is equal to the second string, 
	 * 			 then the two strings are an anagram, and we return "true." Otherwise, after the loop, we simply 
	 * 			 return false because the strings are not an anagram. Although such an implementation would work, 
	 * 			 in this case, the complexity of the algorithm will be equal to the possible permutations of s1, 
	 * 			 so of an order of n!, where n is the number of characters in the string.
	 * 
	 * Method 2: Convert to Characters array, sort, join and make a string and compare. If you read into the requirements, 
	 * 			 you can realize that instead of doing actual rearrangements, you simply need to check if they have exactly 
	 * 			 the same characters. One quick way of checking the equality between two sets of characters in strings is simply
	 * 			 to break the strings into their characters, sort them, and then join them again. We do the same for the second string. 
	 * 			 Finally, we check if the strings are equal. If these sorted character strings are equal, then the original strings 
	 * 			 were anagrams. The complexity in this case would be driven by the sort function, which is of the order n log(n).
	 * 
	 * Method 3: We can have a hash map which stores the character count. For first string, we increment the character count if found
	 * 			 For the second string, we will decrement the character count. At the end, we just compare both the counts to make sure everything is checked.
	 * 			 Time complexity for this algorithm would be O(n).
	 * 
	 * @param firstWord
	 * @param secondWord
	 */
	public static boolean anagramTest(String firstWord, String secondWord) {
		//Lets implement the Method 3.
		
		//Basic case, if both strings are not equal then it will not make anagram
		if (firstWord.length() != secondWord.length()) {
			return false;
		}
		
		HashMap<Character, Integer> charatCountMap = new HashMap<Character, Integer>();
		
		for (int eachCharInd = 0; eachCharInd < firstWord.length(); eachCharInd++) {
			Character eachChar = firstWord.charAt(eachCharInd);
			int charCount = charatCountMap.containsKey(eachChar) ? (charatCountMap.get(eachChar) + 1) : 1;
			charatCountMap.put(eachChar, charCount);
		}
		//System.out.println(charatCountMap);
		for (int eachCharInd = 0; eachCharInd < secondWord.length(); eachCharInd++) {
			Character eachChar = secondWord.charAt(eachCharInd);
			if (!charatCountMap.containsKey(eachChar)) {
				return false;
			}
			
			int charCount = charatCountMap.get(eachChar) - 1;
			charatCountMap.put(eachChar, charCount);
		}
		
		ArrayList<Integer> values = new ArrayList<Integer>(charatCountMap.values());
		
		for (Integer eachInt : values) {
			if (eachInt != 0) {
				return false;
			}
		}
		return true;
	}
	private static void test(String firstWord, String secondWord) {
		System.out.printf("Anagram Test for '%s' and '%s' is : %s", firstWord, secondWord, anagramTest(firstWord, secondWord) + "\n");
	}
	
	public static void main(String[] args) {
		test("earth", "heart");
		test("foo", "bar");
		test("listen", "silent");
		test("normal", " ");
		test("empty", "types");
		test("geeksquiz", "zuiqkeegs");
		test("geeksforgeeks", "forgeeksgeeks");
		test("abcd", "cdab");
	}
}
