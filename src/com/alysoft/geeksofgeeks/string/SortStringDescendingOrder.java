package com.alysoft.geeksofgeeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string S containing only lower case alphabets, the task is to sort it in lexigraphically-descending order.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a string S.

Output:
For each test case, in a new line, print the sorted string.

Constraints:
1 <= T <= 100
1 <= |S| <= 105

Example:
Input:
2
geeks
for
Output:
skgee
rof
 * @author ymohammad
 *
 */
public class SortStringDescendingOrder
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = br.readLine();
    		String s = sortStringDescending(line);
			System.out.println(s);
            t--;
        }
	}

	private static String sortStringDescending(String line)
	{
		if (line == null || line.trim().length() == 0) return line;
		
		int[] indexArray = new int[26];
		
		char[] charArray = line.toCharArray();
		
		for (char ch: charArray) {
			indexArray[getCharIndex(ch)]++;
		}
		
		StringBuffer buff = new StringBuffer();
		
		for (int j = indexArray.length-1; j>=0; j--) {
			if (indexArray[j]>0) {
				int noOfChars = indexArray[j];
				while (noOfChars>0) {
					buff.append((char)getCharForIndex(j));
					noOfChars--;
				}
			}
		}
		return buff.toString();
	}
	public static int getCharForIndex(int index) {
		return (int)'a' + index;
	}
	public static int getCharIndex(char ch) {
		return (ch - 'a');
	}
}
