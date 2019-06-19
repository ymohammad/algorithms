package com.alysoft.algo.recursion;

import java.util.HashSet;

/**
 * Given a keypad as shown in diagram, and an N digit number. List all words which are possible by pressing these numbers.



Input Format:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. 
Each testcase contains two lines of input. The first line of each test case is N, N is the number of digits. 
The second line of each test case contains D[i], N number of digits.

Output Format:
Print all possible words from phone digits with single space.

Your Task:
This is a function problem. You just need to complete the function possibleWords that takes an array as parameter and 
prints all the possible words. The newline is automatically added by the driver code.

Constraints:
1 <= T <= 10
1 <= N <= 10
2 <=  D[i] <= 9

Example:
Input:
2
3
2 3 4
3
3 4 5

Output:
adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi
dgj dgk dgl dhj dhk dhl dij dik dil egj egk egl ehj ehk ehl eij eik eil fgj fgk fgl fhj fhk fhl fij fik fil
 * @author ymohammad
 *
 */
public class PossibleWordsFromPhoneDigits
{

	public static void main(String[] args)
	{
		int[] arr = {7, 4, 2, 9, 4};
		possibleWords(arr, arr.length);
	}
	static void possibleWords(int a[], int N)
    {
		permutationOfNumbers(a, "", 0);
    }
	private static void permutationOfNumbers(int[] a, String res, int startIndex)
	{
		if (startIndex >= a.length) {
			System.out.print(res + " ");
			return;
		}
		
		int digit = a[startIndex];
		char[] charArray = getCharArray(digit);
		for (int i = 0; i<charArray.length; i++) {
			permutationOfNumbers(a, res + charArray[i], startIndex+1);
		}
	}
	public static char[] getCharArray(int code) {
		if (code == 2) {
			return new char[]{'a', 'b', 'c'};
		} else if (code == 3) {
			return new char[]{'d', 'e', 'f'};
		} else if (code == 4) {
			return new char[]{'g', 'h', 'i'};
		} else if (code == 5) {
			return new char[]{'j', 'k', 'l'};
		} else if (code == 6) {
			return new char[]{'m', 'n', 'o'};
		} else if (code == 7) {
			return new char[]{'p', 'q', 'r', 's'};
		} else if (code == 8) {
			return new char[]{'t', 'u', 'v'};
		} else if (code == 9) {
			return new char[]{'w', 'x', 'y', 'z'};
		} else {
			return new char[]{};
		}
	}
}
