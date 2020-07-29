package com.alysoft.string.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given a string S and a Pattern P. You need to find all matches of hash of P in string S. Also, print the index (0 based) at which the pattern's hash is found. If no match is found, print -1.

Note: All the matches should have same length as pattern P.

The hash of pattern P is calculated by summing the values of characters as they appear in the alphabets table. For reference, a is 1, b is 2, ...z is 26. Now, using the mentioned values, hash of ab is 1+2=3.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains the string S. The second line contains the pattern P.

Output:
For each testcase, in a new line, print the matches and index separated by a space. All the matches should be printed in their own separate lines.

Constraints:
1 <= T <= 100
1 <= |S|, |P| <= 105

Examples:
Input:
1
bacdaabaa
aab
Output:
aab 4
aba 5
baa 6

Explanation:
Testcase1: P is aab, and S is bacdaabaa
Now, the hash of P: aab is 1+1+2=4
In the string S, the hash value of 4 is obtained by the following:
aab=1+1+2=4, at index 4
aba=1+2+1=4, at index 5
baa=2+1+1=4, at index 6
 * @author ymohammad
 *
 */
public class RollingHash
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            
            String text = br.readLine().trim();
            String pattern = br.readLine().trim();
            
            printMatchingPattern(text, pattern);
            t--;
        }
	}
	public static void printMatchingPattern(String text, String pattern)
	{
	    text = text.toLowerCase();
	    pattern = pattern.toLowerCase();
	    if (text.length() < pattern.length()) {
	        System.out.println("-1");
	        return;
	    }
	    int textLength = text.length();
	    int hashLength = pattern.length();
	    int patternHash = getHashValue(pattern.toCharArray());
	   // int[] patternCount = getCountArray(pattern, 0, hashLength);
	    //int[] textCount = getCountArray(text, 0, hashLength);
	    int matcherHash = getHashValue(text.substring(0, hashLength).toCharArray());
	    String eachHashText;
	    boolean isFound = false;
	    for (int i = 0; i<=textLength-hashLength; i++) {
	    	eachHashText = text.substring(i, i+hashLength);
	        matcherHash = getHashValue(eachHashText.toCharArray());
	        
	        if (matcherHash == patternHash) {
	            /*if (isPatternMatched(textCount, patternCount)) {
	                System.out.println (pattern + " " + i);
	                break;
	            }*/
	        	System.out.println (eachHashText + " " + i);
	        	isFound = true;
	        }
	        //matcherHash = getHashValue(matcherHash, text.charAt(i+1), text.charAt(hashLength + i -1));
	        //matcherHash += getCharValue(text.charAt(hashLength + i));
	        //matcherHash -= getCharValue(text.charAt(i));
	        //textCount[text.charAt(hashLength + i)]++;
	        //textCount[text.charAt(i)]--;
	    }
	    if (!isFound)
	    	System.out.println("-1");
	}
	private static int getHashValue(int matcherHash, char addChar, char subChar)
	{
		matcherHash += getCharValue(addChar);
		matcherHash -= getCharValue(subChar);
		return matcherHash;
	}
	public static boolean isPatternMatched(int[] textCount, int[] patternCount)
	{
	    for (int i = 0; i<256; i++) {
	        if (textCount[i] != patternCount[i]) return false;
	    }
	    return true;
	}
	public static int[] getCountArray(String text, int start, int end) {
	    int[] countArray = new int[256];
	    for (int i = start; i<end; i++) {
	        countArray[text.charAt(i)]++;
	    }
	    return countArray;
	}
	public static int getHashValue(String text, int start, int end) {
	    String subStr = text.substring(start, end);
	    return getHashValue(subStr.toCharArray());
	}
	public static int getHashValue (char[] chArray) {
	    int sum = 0;
	    for (char ch: chArray) {
	        sum += getCharValue(ch);
	    }
	    return sum;
	}
	public static int getCharValue (char ch) {
	    return (ch-'a')+1;
	}
}
