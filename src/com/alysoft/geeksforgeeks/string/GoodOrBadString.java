package com.alysoft.geeksforgeeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * In this problem, a String S is composed of lowercase alphabets and wildcard characters i.e. '?'. 
 * Here, '?' can be replaced by any of the lowercase alphabets. Now you have to classify the given String on the basis of following rules:
 * 
 * If there are more than 3 consonants together or more than 5 vowels together, the String is considered 
 * to be "BAD". A String is considered "GOOD" only if it is not “BAD”.
 * 
 * NOTE: String is considered as "BAD" if the above condition is satisfied even once. 
 * Else it is "GOOD" and the task is to make the string "BAD".
 * @author ymohammad
 *
 */
public class GoodOrBadString
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = br.readLine();
        	String consonenetStr = line.replaceAll("\\?", "t");
    		String vowelStr = line.replaceAll("\\?", "a");
    		int s = (isGoodOrBad(consonenetStr) == 0 || isGoodOrBad(vowelStr) == 0) ? 0 : 1;
			System.out.println(s);
            t--;
        }
	}

	public static int isGoodOrBad(String line)
	{
		char[] charArray = line.toCharArray();
		int vowelCount = 0;
		int consonentCount = 0;
		for (char ch: charArray) {
			
			if (isVowel(ch)) {
				vowelCount++;
				consonentCount = 0;
			} else {
				vowelCount = 0;
				consonentCount++;
			}
			
			if (vowelCount > 5 || consonentCount > 3) return 0;
		}
		return 1;
	}

	private static boolean isVowel(char ch)
	{
		boolean returnVal = false;
		switch (ch) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				returnVal = true;
				break;
		}
		return returnVal;
	}
}
