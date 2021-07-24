package com.alysoft.completedsa.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string S consisting of lowercase Latin Letters. Find the first non repeating character in S.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases.
Each case begins with a single integer N denoting the length of string. The next line contains the string S.

Output:
For each testcase, print the first non repeating character present in string. 
Print -1 if there is no non repeating character.

Constraints:
1 <= T <= 900
1 <= N <= 104

Example:
Input : 
3
5  
hello
12
zxvczbtxyzvy
6
xxyyzz

Output :
h
c
-1
 * @author ymohammad
 *
 */
public class NonRepeatingCharacter
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();
            String ch = getRepeatingCharacter(line, n);
            System.out.println(ch);
            t--;
        }
	}

	public static String getRepeatingCharacter(String line, int n)
	{
		if (line == null || line.trim().length() == 0) return line;
		
		int[] indexArray = new int[26];
		
		for (int i = 0; i < n; i++) {
			indexArray[getCharIndex(line.charAt(i))]++;
		}
		
		for (int i = 0; i < n; i++) {
			char ch = line.charAt(i);
			if(indexArray[getCharIndex(ch)] == 1) {
				return String.valueOf(ch);
			}
		}
		return "-1";
	}
	public static int getCharIndex(char ch) {
		return (ch - 'a');
	}
}
