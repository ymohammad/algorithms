package com.alysoft.algo.string;

/**
 * Given a string S and a pattern P (of distinct characters) consisting of lowercase characters. The task is to check if pattern P exists 
 * in the given string S or not.

Note : Pattern has distinct characters. There might be repetitions in text.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains string S and next line contains pattern P.

Output:
For each testcase, print "Yes" if pattern is found in the given string, else print "No".

User Task:
The task is to complete the function search() which finds for the pattern with distinct characters. The function takes string and pattern as 
parameters and returns either true or false. Return true if pattern is found else return false.

Constraints:
1 <= T <= 100
1 <= |S|, |P| <= 103

Example:
Input:
2
abceabcdabceabcd
abcd
abceabcdabceabcd
gfhij

Output:
Yes
No

Explanation:
Testcase 1: Given pattern abcd is present at index 4.
Testcase 2: Given pattern gfhij is not found in the string.
 * @author ymohammad
 *
 */
public class DistinctPatternSearch
{

	public static void main(String[] args)
	{
		String txt = "abcabcd";
		String pat = "abcd";
		System.out.println(search(pat, txt));
	}
	static boolean search(String pat, String txt)
    {
		int txtLen = txt.length();
		int patLen = pat.length();
		for (int i = 0; i<=txtLen-patLen;)
		{
			int j;
			int m = i;
			for (j=0; j<patLen; j++) {
				char textChar = txt.charAt(m);
				char patChar = pat.charAt(j);
				if (textChar == patChar) {
					m++;
				} else {
					break;
				}
			}
			if (j == patLen) {return true;}
			else {
				i = (j==0) ? i+1 : i + j;
			}
		}
		return false;
    }
}
