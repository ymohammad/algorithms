package com.alysoft.algo.codechef.mock1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * Lapindrome is defined as a string which when split in the middle, gives two halves having the same characters and same frequency of each character. If there are odd number of characters in the string, we ignore the middle character and check for lapindrome. For example gaga is a lapindrome, since the two halves ga and ga have the same characters with same frequency. Also, abccab, rotor and xyzxy are a few examples of lapindromes. Note that abbaab is NOT a lapindrome. The two halves contain the same characters but their frequencies do not match. 
Your task is simple. Given a string, you need to tell if it is a lapindrome.

Input:
First line of input contains a single integer T, the number of test cases.
Each test is a single line containing a string S composed of only lowercase English alphabet.
Output:
For each test case, output on a separate line: "YES" if the string is a lapindrome and "NO" if it is not.
Constraints:
1 ≤ T ≤ 100
2 ≤ |S| ≤ 1000, where |S| denotes the length of S
Example:
Input:
6
gaga
abcde
rotor
xyzxy
abbaab
ababc


Output:
YES
NO
YES
YES
NO
NO
 * @author ymohammad
 *
 */
public class Lapindromes
{
	public static void main(String[] args) throws Exception {
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	            // Input the size of the array
	            String line = br.readLine();
	            String isLapindrome = checkStringIsLapindrome(line);
	            System.out.println(isLapindrome);
	            t--;
	        }
		} 
		catch (Exception e)
		{
		}
	}

	private static String checkStringIsLapindrome(String line)
	{
		int n = line.length();
		int mid = n/2;
		char[] left = new char[256];
		char[] right = new char[256];
		
		for (int i = 0; i<mid; i++) {
			char ch = line.charAt(i);
			left[ch]++;
		}
		mid = (n%2 == 0) ? mid : mid+1;
		for (int i = mid; i<n; i++) {
			char ch = line.charAt(i);
			right[ch]++;
		}
		for (int i = 0; i<256; i++) {
			if (left[i] != right[i]) {
				return "NO";
			}
		}
		return "YES";
	}
}
