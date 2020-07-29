package com.alysoft.algo.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string S consisting of uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such 
 * that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted 
 * and vice versa.

Input Format:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of 
each test case contains a single integer N denoting the length of string. The second line contains a string S of length N, consisting of 
uppercase and lowercase characters.

Output Format:
For each testcase, in a new line, print the answer.

Your Task:
This is a function problem. You only need to complete the function caseSort that returns sorted string.

Constraints: 
1 ≤ T ≤ 50
1 ≤ N ≤ 103

Example:
Input:
1
12
defRTSersUXI

Output:
deeIRSfrsTUX

Explanation:
Testcase 1: Sorted form of given string with the same case of character as that in original string.
 * @author ymohammad
 *
 */
public class CaseSpecificSorting
{

	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = caseSort(str);
    	        System.out.println(sortedStr);
    	    }
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
	public static String caseSort(String str) {
		int[] lowerCaseCount = new int[26];
		int[] upperCaseCount = new int[26];
		
		int len = str.length();
		for (int i = 0; i<len; i++) {
			char ch = str.charAt(i);
			if (isUpperCase(ch)) {
				upperCaseCount[ch-'A']++;
			} else {
				lowerCaseCount[ch-'a']++;
			}
		}
		char[] charArray = new char[len];
		int low = 0;
		int up = 0;
		
		for (int i = 0; i<len; i++) {
			char ch = str.charAt(i);
			if (isUpperCase(ch)) {
				while (up<26 && upperCaseCount[up] == 0) {
					up++;
				}
				charArray[i] = (char)('A'+up);
				upperCaseCount[up]--;
			} else {
				while (low<26 && lowerCaseCount[low] == 0) {
					low++;
				}
				charArray[i] = (char)('a'+low);
				lowerCaseCount[low]--;
			}
		}
		return new String(charArray);
    }
	
	public static boolean isUpperCase(char ch) {
		int x = ch-'A';
		return (x>=0 && x<26);
	}
}
