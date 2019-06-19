package com.alysoft.geeksofgeeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string S. The task is to find the longest substring such that characters in the substrings are of the form abcdefgh...xyzabcd... 
 * The two adjacent characters should have difference of 1 and the next character should be lexiographically greater than the previous character.
 *  However, z can be followed by a, despite a not being lexiograpghically greater.
If there are multiple answers then print the first such string.
 * @author ymohammad
 *
 *Example:
	Input:
	5
	abcd
	dcba
	xyzabcghij
	acegj
	abcdfghi
	
	Output:
	abcd
	4
	d
	1
	xyzabc
	6
	a
	1
	abcd
	4
 */
public class LongestSubstring
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
				
			String x = getLongestSubstring(line);
			
			System.out.println(x);
			System.out.println(x.length());
            t--;
        }
	}

	private static String getLongestSubstring(String line)
	{
		char[] charArray = line.toCharArray();
		int maxStartInd = 0;
		int maxEndInd = 0;
		int startIndex = 0;
		int lastIndex = 0;
		for (int i=0; i<charArray.length-1; i++) {
			int a = getCharIndex(charArray[i]);
			int b = getCharIndex(charArray[i+1]);
			if (charArray[i] == 'z' && charArray[i+1]=='a') {
				lastIndex = i+1;
			} else if (b-a == 1) {
				lastIndex = i+1;
			} else {
				if ((maxEndInd-maxStartInd) < (lastIndex-startIndex)) {
					maxStartInd = startIndex;
					maxEndInd = lastIndex;
				}
				
				startIndex = i+1;
				lastIndex = startIndex;
			}
		}
		if ((maxEndInd-maxStartInd) < (lastIndex-startIndex)) {
			maxStartInd = startIndex;
			maxEndInd = lastIndex;
		}
		return line.substring(maxStartInd, maxEndInd+1);
	}
	
	public static int getCharIndex(char ch) {
		return ch-'a';
	}
}
