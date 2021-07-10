package com.alysoft.geeksforgeeks.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string s, recursively remove adjacent duplicate characters from the string s. 
 * The output string should not have any adjacent duplicates.
 

Input:
The first line of input contains an integer T, denoting the no of test cases. Then T test cases follow. 
Each test case contains a string str.

Output:
For each test case, print a new line containing the resulting string.

Constraints:
1<=T<=100
1<=Length of string<=50

Example:
Input:
3
geeksforgeek
acaaabbbacdddd
mississipie

Output:
gksforgk
acac
mipie

 * geeksforgeek
 * gksforgk
 * 
 * acaaabbbacdddd
 * acabac
 * 
 * 
 * @author ymohammad
 *
 */
public class RemoveAdjacentDuplicates
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            String line = br.readLine();
            removeAdjacentDuplicatesNPrint(line);
            t--;
        }
	}

	private static void removeAdjacentDuplicatesNPrint(String line)
	{
		if (line == null || line.trim().length() == 0) {
			System.out.println(line);
			return;
		}
		
		StringBuffer buff = new StringBuffer(line);
		boolean isRemoved = false;
		int i = 0;
		int n = buff.length()-1;
		while (i< n) {
			if (buff.charAt(i) == buff.charAt(i+1)) {
				char ch = buff.charAt(i);
				isRemoved = true;
				while (i > -1 && i<buff.length() && buff.charAt(i) == ch) {
					buff.deleteCharAt(i);
				}
				
				n = buff.length()-1;
				if (i-1 < 0) {
					i = 0;
				}
				
			} else {
				i++;
			}
		}
		if (!isRemoved) {
			System.out.println(buff.toString());
		} else {
			removeAdjacentDuplicatesNPrint(buff.toString());
		}
	}
}
