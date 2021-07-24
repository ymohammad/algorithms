package com.alysoft.completedsa.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string S. The task is to find the first repeated character in it. We need to find the character that occurs more than once and whose index of first occurrence is smallest. S contains only lowercase letters.
Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains a string S.

Output:
For each test case in a new line print the first repeating character in the string. If no such character exist print -1.

Constraints:
1 <= T <= 100
1 <= |S| <=104

Example:
Input:
2
geeksforgeeks
hellogeeks

Output:
e
l
 * @author ymohammad
 *
 */
public class FindFirstRepeatedCharacter
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
            char x = getFirstRepeatingChar(line);
            if (x == '0') {
            	System.out.println("-1");
            } else {
            	System.out.println(x);
            }
            
            t--;
        }
	}

	private static char getFirstRepeatingChar(String str)
	{
		if (str == null || str.trim().length() == 0) return '0';
		
		int asciChar[] = new int[129];
		char[] charArray = str.toCharArray();
		for (char ch: charArray) {
			if (asciChar[ch]==1) {
				return ch;
			} else {
				asciChar[ch] = asciChar[ch]+1;
			}
		}
		return '0';
	}
}
