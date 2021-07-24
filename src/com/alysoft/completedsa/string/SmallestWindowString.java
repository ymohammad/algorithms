package com.alysoft.completedsa.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given a string S and text t. Output the smallest window in the string having all characters of the text. 
 * Both the string and text contains small case letters.

Input:
First line contains T , the number of test cases and each test contains 2 lines having a string S and t.

Output:
Output the smallest window of the string containing all the characters of the text. If such window doesn`t 
exist or this task can not be done then print -1.

Constraints: 
1 <= T <= 100
1 <= N, X <= 1000

Example:
Input:
2
timetopractice
toc
zoomlazapzo
oza

Output:
toprac
apzo
 * 
 * 
 * @author ymohammad
 *
 */
public class SmallestWindowString
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String str = br.readLine();
        	String text = br.readLine();
        	
        	String smallWin = getSmallestWindow(str, text);
        	System.out.println(smallWin);
            t--;
        }
	}

	public static String getSmallestWindow(String str, String pat)
	{
		int[] textHash = new int[256];
		//int[] patternHash = new int[256];
		
		int n = str.length();
		int m = pat.length();
		
		/*
		char[] charArray = pat.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			patternHash[charArray[i]]++;
		}
		*/
		StringBuffer minLengthBuff = new StringBuffer();
		for (int i = 0; i < n; i++)
		{
			int[] patternHash = getHashArray(pat);
			int patternCount = 0;
			StringBuffer localMinLenBuff = new StringBuffer();
			boolean isCharFound = false;
			for (int j = i; j<n; j++) {
				if (patternHash[str.charAt(j)] > 0) {
					patternHash[str.charAt(j)]--;
					isCharFound = true;
					patternCount++;
					localMinLenBuff.append(str.charAt(j));
					if (patternCount == m) {
						minLengthBuff = minLengthBuff.length() == 0 ? localMinLenBuff : minLengthBuff;
						minLengthBuff = (minLengthBuff.length()>localMinLenBuff.length()) ? localMinLenBuff : minLengthBuff;
						break;
					}
				} else if (isCharFound) {
					localMinLenBuff.append(str.charAt(j));
				}
			}
		}
		return minLengthBuff.toString();
	}
	
	public static int[] getHashArray(String pat) {
		int[] hashArray = new int[256];
		char[] charArray = pat.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			hashArray[charArray[i]]++;
		}
		return hashArray;
	}
}
