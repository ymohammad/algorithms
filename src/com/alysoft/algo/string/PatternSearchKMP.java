package com.alysoft.algo.string;

/**
 * Given a string S and a pattern P of all lowercase characters. The task is to check if the pattern exists in the string or not.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains string S and next line contains pattern P.

Output:
For each testcase, print "Yes" if pattern is found in the string, and "No" if pattern is not found in the string.

Your Task:
The task is to complete the function KMPSearch() which returns true or false depending on whether pattern is present in the string or not, 
and computeLPSArray() which computes the longest prefix suffix for every index.

Constrsaints:
1 <= T <= 100
1 <= |S|, |P| <= 103

Example:
Input:
2
aabaacaadaabaaba
aaaab
aabaacaadaabaaba
caada

Output:
No
Yes

Explanation:
Testcase 1: Given pattern is found in the given string S.
Testcase 2: Given pattern is found in the given string S.
 * @author ymohammad
 *
 */
public class PatternSearchKMP
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	// Fills lps[] for given patttern pat[0..M-1] 
    void computeLPSArray(String pat, int M, int lps[]) 
    { 
	    // Your code here
	
    }
    
    boolean KMPSearch(String pat, String txt)
    {
        // Your code here
    }
}
