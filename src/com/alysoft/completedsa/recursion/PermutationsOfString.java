package com.alysoft.completedsa.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given a string S. The task is to print all permutations of a given string.

Input:
The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.

Output:
For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.

Constraints:
1 ≤ T ≤ 10
1 ≤ size of string ≤ 5

Example:
Input:
2
ABC
ABSG

Output:
ABC ACB BAC BCA CAB CBA 
ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA

Explanation:
Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .
 
 * @author ymohammad
 *
 */
public class PermutationsOfString
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            
            String line = br.readLine();
            printPermutation(line);
            t--;
        }
	}
	public static void printPermutation(String line) {
	    StringBuffer buff = new StringBuffer();
	    char[] charArray = line.toCharArray();
	    Arrays.sort(charArray);
	    loopNPreparePermutation(new StringBuffer(String.valueOf(charArray)), new StringBuffer(), buff);
	    System.out.println(buff);
	}
	public static void loopNPreparePermutation(StringBuffer str, StringBuffer choosen, StringBuffer buff) {
	    if (str == null || str.length() == 0) {
	    	buff.append(choosen + " ");
	    	return;
	    }
	    int charLength = str.length();
	    for (int i=0; i<charLength; i++) {
	    	char ch = str.charAt(i);
	    	choosen.append(ch);
	    	loopNPreparePermutation(str.deleteCharAt(i), choosen, buff);
	    	
	    	str.insert(i, ch);
	    	choosen.deleteCharAt(choosen.length()-1);
	    }
	}
}
