package com.alysoft.algo.string;

/**
 * Given a string S and a pattern P both of lowercase characters. The task is to check if the given pattern exists in the given string or not.

Input:
First line of input contains number of testcases T. For each testcase, first line will the string and second line will be the pattern to be searched.

Output:
For each testcase, print "Yes" if pattern exists or "No" if doesn't.

User Task:
The task is to complete the function search() which finds the pattern in the given string. The function takes pattern and string as 
parameters and returns either true or false. Return true if pattern exists else return false.

Constraints:
1 <= T <= 100
1 <= |S|, |P| <= 103

Example:
Input:
2
aabaacaadaabaaabaa
aaba
aabaacaadaabaaabaa
ccda

Output:
Yes
No

Explanation:
Testcase 1: Given pattern aaba is found in the string at index 0.
Testcase 2: Given pattern ccda doesn't exists in the string at all.
 * @author ymohammad
 *
 */
public class NaivePatternSearch
{

	public static void main(String[] args)
	{
		//String txt = "lkjsdfhaiuehaoewiuraoikdehjakdsfhlsjdkihalieushralkehfailuewhfaklfjsdhfliuewahf";
		String txt = "wahf";
		String pat = "ahf";		
		System.out.println(search(pat, txt));
	}
	static boolean search(String pat, String txt)
    {
            // Your code here
        int txtLen = txt.length();
        int patLen = pat.length();
        for (int i = 0; i<=txtLen-patLen; i++) {
            int m = i;
            int j = 0;
            for (j = 0; j<patLen; j++) {
                if (txt.charAt(m) == pat.charAt(j)) {
                    m++;
                } else {
                    break;
                }
            }
            if (patLen == j) {
                return true;
            }
        }
        return false;
    }
}
