package com.alysoft.geeksofgeeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given strings s1 and s2, you need to find if s2 is a rotated version of the string s1. 
 * The strings are lowercase.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. 
Then T test case follows. Each testcase contains two lines for s1 and s2.

Output:
For each testcase, in a new line, you need to print 1 if s2 is a rotated version of s1; else print 0.

Constraints:
1 <= T <= 100
1 <= |s1|,|s2| <= 100

Example:
Input:
4
geeksforgeeks
forgeeksgeeks
mightandmagic
andmagicmigth
mushroomkingdom
itsamemario
geekofgeeks
geeksgeekof
Output:
1
0
0
1

Explanation:
Ttestcase 1: s1 is geeksforgeeks, s2 is forgeeksgeeks. Clearly, s2 is a rotated version of s1 as s2 can 
be obtained by left-rotating s1 by 5 units.
 * @author ymohammad
 *
 */
public class CheckStringsRotations
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            String s1 = br.readLine();
            String s2 = br.readLine();
            int a = isRotatedStringEff(s1, s2);
            System.out.println(a);
            t--;
        }
	}

	private static int isRotatedStringEff(String s1, String s2)
	{
		if (s1 == null || s1.trim().length() == 0) return 0;
				
		if (s2 == null || s2.trim().length() == 0) return 0;	
		
		if (s1.trim().length() != s2.trim().length()) return 0;
		
		String temp = s1+s1;
		
		if (temp.indexOf(s2) != -1) {
			return 1;
		}
		return 0;
	}
	private static int isRotatedString(String s1, String s2)
	{
		if (s1 == null || s1.trim().length() == 0) return 0;
				
		if (s2 == null || s2.trim().length() == 0) return 0;	
		
		if (s1.trim().length() != s2.trim().length()) return 0;
		
		int i = 0;
		int j = 0;
		StringBuffer missingStr = new StringBuffer();
		char ch2 = s2.charAt(i);
		while (j<s1.length()) {
			char ch1 = s1.charAt(j);
			if (ch1 == ch2) {
				break;
			} else {
				missingStr.append(ch1);
			}
			j++;
		}
		
		StringBuffer completeBuff = new StringBuffer();
		while (j<s1.length()) {
			char ch1 = s1.charAt(j);
			completeBuff.append(ch1);
			j++;
		}
		completeBuff.append(missingStr.toString());
		
		if (s2.equals(completeBuff.toString())) {
			return 1;
		}
		return 0;
	}
}
