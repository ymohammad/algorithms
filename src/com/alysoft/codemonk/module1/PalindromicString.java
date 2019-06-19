package com.alysoft.codemonk.module1;

import java.util.Scanner;

/**
 * You have been given a String S. You need to find and print whether this string is a palindrome or not. 
 * If yes, print "YES" (without quotes), else print "NO" (without quotes).

Input Format
The first and only line of input contains the String S. The String shall consist of lowercase English alphabets only.

Output Format
Print the required answer on a single line.

Constraints 

Note
String S consists of lowercase English Alphabets only.
 * @author ymohammad
 *
 */
public class PalindromicString
{

	public static void main(String[] args)
	{
		//Scanner
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();                 // Reading input from STDIN
        String reverseStr = getReverseStr(str);
        System.out.println();
        if (str.equals(reverseStr)) {
        	System.out.println("YES");
        } else {
        	System.out.println("NO");
        }
	}

	private static String getReverseStr(String str)
	{
		char[] charArray = str.toCharArray();
		char[] returnChar = new char[str.length()];
		int curIndex = 0;
		for (int i = charArray.length-1; i>=0; i--) {
			returnChar[curIndex] = charArray[i];
			curIndex++;
		}
		return new String(returnChar);
	}
	
	/**
	 * Another approach. Here, we are not doing most of the looping.
	 * Eg: aba
	 * Eg: sqfopldohhwnbhhpnbxiwzvkybggkgtftvvaqpejznlxluatcppctaulxlnzjepqavvtftgkggbykvzwixbnphhbnwhhodlpofqs
	 * @param word
	 */
	public static void checkPalindromic(String word) {
        int j = word.length() - 1;
        String result = "YES";
        for(int i = 0; i < j  / 2; i++) {
            if(word.charAt(i) != word.charAt(j)) {
                result = "NO";
            }
            j--;
        }
        System.out.println(result);
	}

}
