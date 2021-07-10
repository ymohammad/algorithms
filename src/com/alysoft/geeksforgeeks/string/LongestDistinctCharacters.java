package com.alysoft.geeksforgeeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given a string S, find length of the longest substring with all distinct characters.  
 * For example, for input "abca", the output is 3 as "abc" is the longest substring with 
 * all distinct characters.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is String str.

Output:
Print length of smallest substring with maximum number of distinct characters.
Note: The output substring should have all distinct characters.

Example:
Input:
2
abababcdefababcdab
geeksforgeeks

Output:
6
7
 * @author ymohammad
 *
 */
public class LongestDistinctCharacters
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
            int ch = getLongestDistanceChar(line, line.length());
            System.out.println(ch);
            t--;
        }
	}
	public static int getLongestDistanceChar(String line, int n)
	{
		if (line == null || line.trim().length() == 0) return 0;
		
		int[] indexArray = new int[26];
		
		int maxDistance = 0;
		int localDistance = 0;
		int i = 0;
		while (i < n) {
			if (indexArray[getCharIndex(line.charAt(i))] == 0) {
				indexArray[getCharIndex(line.charAt(i))]++;
				localDistance++;
				i++;
			} else {
				Arrays.fill(indexArray, 0);
				maxDistance = localDistance > maxDistance ? localDistance : maxDistance;
				localDistance = 0;
				i = getLastOccurenceIndex(line, i);
			}
		}
		maxDistance = localDistance > maxDistance ? localDistance : maxDistance;
		return maxDistance;
	}
	private static int getLastOccurenceIndex(String line, int i)
	{
		if (i == 0) return i+1;
		
		char currentChar = line.charAt(i);
		i--;
		while (i>=0) {
			if (currentChar == line.charAt(i)) {
				break;
			}
			i--;
		}
		return i+1;
	}
	public static int getCharIndex(char ch) {
		return (ch - 'a');
	}
}
