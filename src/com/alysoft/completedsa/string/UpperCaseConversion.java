package com.alysoft.completedsa.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string S, write a program to title case every first letter of words in string.

Input:
The first line consists of an integer T i.e number of test cases. T testcases follow. The first and only line of each test case consists of a string S. 

Output:
For each testcase, in a new line, print the required output.

Constraints: 
1 <= T <= 100
1 <= |S| <= 1000

Example:
Input:
1
I love programming
Output:
I Love Programming
 * @author ymohammad
 *
 */
public class UpperCaseConversion
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            String line = br.readLine();
            //String[] arrayValues = line.trim().split(" ");
            printStringUpperCase(line);
            t--;
        }
	}
	private static void printStringUpperCase(String line) {
		if (line == null || line.trim().length() == 0) return;
		
		char[] charArray = line.toCharArray();
		charArray[0] = Character.toUpperCase(charArray[0]);
		int i = 0;
		while(i < charArray.length)
		{
			if (charArray[i] == ' ') {
				while (i<charArray.length && charArray[i] == ' ') {
					i++;
				}
				if (i<charArray.length) {
					charArray[i] = Character.toUpperCase(charArray[i]);
				}
			}
			
			i++;
		}
		System.out.println(new String(charArray));
	}
	private static void printStringUpperCase(String[] strArr)
	{
		if (strArr == null || strArr.length == 0) return;
		
		StringBuffer sb = new StringBuffer();
		
		for (String st: strArr) {
			sb.append(getCamelCaseStr(st) + " ");
		}
		System.out.println(sb.toString().trim());
	}

	private static String getCamelCaseStr(String st)
	{
		return Character.toUpperCase(st.charAt(0)) + st.substring(1);
	}
}
