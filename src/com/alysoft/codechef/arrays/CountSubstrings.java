package com.alysoft.codechef.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string S consisting of only 1s and 0s, find the number of substrings which start and end both in 1.
In this problem, a substring is defined as a sequence of continuous characters Si, Si+1, ..., Sj where 1<= i <= j <= N.

Input
First line contains T, the number of testcases. Each testcase consists of N(the length of string) in one line and string in second line.

Output
For each testcase, print the required answer in one line.
 * @author ymohammad
 *
 */
public class CountSubstrings
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine;
		while ((eachLine = br.readLine()) != null) {
			int t = Integer.parseInt(eachLine.trim());
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	        	
	        	int noOfDigits = Integer.parseInt(br.readLine().trim());
	        	String str = br.readLine();
	        	String[] lineSplit = str.split("");
	        	
	        	int[] digitsArray = new int[noOfDigits];
	        	int i = 0;
	        	int noOfOnes = 0;
	        	for (String s : lineSplit) {
	        		if (s != null && s.trim().length()>0) {
	        			digitsArray[i] = Integer.parseInt(s.trim());
	        			if (digitsArray[i] == 1) {
	        				noOfOnes++;
	        			}
	        			i++;
	        		}
	        	}
	        	//int noOfSubStrings = getSubStringCount(digitsArray, noOfDigits);
	        	int noOfSubStrings = getSubStringCount(noOfDigits, noOfOnes);
	        	System.out.println(noOfSubStrings);
	            t--;
	        }
	        break;
		}
	}
	public static int getSubStringCount(int noOfDigits, int noOfOnes) {
		int noOfSubstrings = (noOfOnes *(noOfOnes+1))/2;
		return noOfSubstrings;
	}
	public static int getSubStringCount(int[] digitsArray, int noOfDigits)
	{
		int noOfSubstrings = 0;
		for (int i=0; i<noOfDigits; i++) {
			if (digitsArray[i] == 1) {
				noOfSubstrings++;
				for (int j=i+1; j<noOfDigits; j++) {
					if (digitsArray[j] == 1) {
						noOfSubstrings++;
					}
				}
			}
		}
		return noOfSubstrings;
	}
}
