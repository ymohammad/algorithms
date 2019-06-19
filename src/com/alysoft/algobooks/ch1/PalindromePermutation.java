package com.alysoft.algobooks.ch1;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
	A palindrome is a word or phrase that is the same forwards and backwards. A permutation
	is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
	EXAMPLE
	Input: Tact Coa
	Output: True (permutations: "taco cat", "atco eta", etc.)
 * 
 * 
 * Method 1: A palindrome string will have every character in even number of times.
 * It might have 1 character in odd numbers.
 * 
 * 
 * 
 * 
 * 
 * @author ymohammad
 *
 */
public class PalindromePermutation
{

	//Method 1
	public static boolean isPalindromePermutationStr(String str) {
		int[] table = getCharacterTable(str);
		
		return verifyPalindrome(table);
	}
	private static boolean verifyPalindrome(int[] table)
	{
		int counter = 0;
		
		for (int x: table) {
			System.out.println("Value of X:" + x);
			if (x%2 == 1) {
				counter++;
			} else {
				counter--;
			}
		}
		return counter<=1;
	}
	private static int[] getCharacterTable(String str)
	{
		int table[] = new int[128];
		for (char ch : str.toCharArray()) {
			int charNum = getCharacterNumber(ch);
			System.out.println("Character :" + ch + " >> Value :" + charNum);
			if (charNum != -1) {
				table[charNum]++;
			}
		}
		return table;
	}
	private static int getCharacterNumber(char ch)
	{
		int val = Character.getNumericValue(ch);
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		System.out.println("Character :" + ch + " - Value :" + val);
		System.out.println("Character :a - Value :" + a);
		System.out.println("Character :z - Value :" + z);
		if (a <= val && val <= z) {
			return val-a;
		} else {
			return -1;
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Tact Coa :" + isPalindromePermutationStr("Tact Coa"));
	}

}
