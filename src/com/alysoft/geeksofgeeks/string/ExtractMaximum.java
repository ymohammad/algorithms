package com.alysoft.geeksofgeeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You have been given an alphanumeric string S, extract maximum numeric value from that string. Alphabets will only be in lower case.

Input:
The first line contains a single integer T i.e. the number of test cases. T testcases follow. The first and only line consists of a String S.

Output: 
For each testcase, in a new line, print the Maximum number extracted from the string S.
 * @author ymohammad
 *
 */
public class ExtractMaximum
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
            int x = getMaximumNumber(line);
            System.out.println(x);
            t--;
        }
	}

	public static int getMaximumNumber(String line)
	{
		char[] charArray = line.toCharArray();
		int localMax = Integer.MIN_VALUE;
		StringBuffer buff = new StringBuffer();
		for (char ch: charArray) {
			if (Character.isDigit(ch)) {
				buff.append(ch);
			} else {
				if (buff.length() > 0) {
					int parseInt = Integer.parseInt(buff.toString());
					localMax = parseInt > localMax ? parseInt : localMax;
					buff = new StringBuffer();
				}
			}
		}
		if (buff.length() > 0) {
			int parseInt = Integer.parseInt(buff.toString());
			localMax = parseInt > localMax ? parseInt : localMax;
		}
		return localMax;
	}
}
