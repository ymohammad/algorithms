package com.alysoft.completedsa.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given two strings S1 and S2 as input, the task is to merge them alternatively i.e. 
 * the first character of S1 then the first character of S2 and so on till the strings end.
 * 
 * NOTE: Add the whole string if other string is empty.

	Input:
	The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
	Each test case contains two strings S1 and S2.
	
	Output:
	For each test case, in a new line, print the merged string.
	
	Constraints:
	1 <= T <= 100
	1 <= |S1|, |S2| <= 104
	
	Example:
	Input:
	2
	Hello Bye
	abc def
	
	Output:
	HBeylelo
	adbecf
 * @author ymohammad
 *
 */
public class MergeTwoStrings
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = br.readLine();
	        String[] split = line.split(" ");
	        String s1 = split[0];
	        String s2 = split[1];
    		String s = getMergeString(s1, s2);
			System.out.println(s);
            t--;
        }
	}

	private static String getMergeString(String s1, String s2)
	{
		StringBuffer buff = new StringBuffer();
		int i = 0; int j = 0;
		int s1Len = s1.length();
		int s2Len = s2.length();
		
		while (i<s1Len || j<s2Len) {
			
			if (i<s1Len) {
				buff.append(s1.charAt(i));
				i++;
			}
			if (j<s2Len) {
				buff.append(s2.charAt(j));
				j++;
			}
		}
		
		return buff.toString();
	}
}
