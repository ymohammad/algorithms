package com.alysoft.geeksforgeeks.string;

import java.util.Scanner;

/**
 * Given a string, find the longest substring which is palindrome in Linear time O(N).

Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. 
The only line of each test case contains a string.

Output:
For each test case print the Longest Palindromic Substring.

Constraints:
1 <= T <= 100
1 <= N <= 50

Example:
Input:
2
babcbabcbaccba
forgeeksskeegfor

Output:
abcbabcba
geeksskeeg
 * @author ymohammad
 *
 */
public class LongestPalindromicSubstring
{
	public static void main(String[] args)
	{	Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			String str = sc.next();
			findLongestPalindromicString(str);
			longestPalSubstr(str);
			t--;
		}
		sc.close();
	}
	static void printSubStr(String str, int low, int high) { 
        System.out.println(str.substring(low, high + 1)); 
    } 
  
    // This function prints the longest palindrome substring 
    // of str[]. 
    // It also returns the length of the longest palindrome 
    static int longestPalSubstr(String str) { 
        int n = str.length();   // get length of input string 
  
        // table[i][j] will be false if substring str[i..j] 
        // is not palindrome. 
        // Else table[i][j] will be true 
        boolean table[][] = new boolean[n][n]; 
  
        // All substrings of length 1 are palindromes 
        int maxLength = 1; 
        for (int i = 0; i < n; ++i) 
            table[i][i] = true; 
  
        // check for sub-string of length 2. 
        int start = 0; 
        for (int i = 0; i < n - 1; ++i) { 
            if (str.charAt(i) == str.charAt(i + 1)) { 
                table[i][i + 1] = true; 
                start = i; 
                maxLength = 2; 
            } 
        } 
          
        // Check for lengths greater than 2. k is length 
        // of substring 
        for (int k = 3; k <= n; ++k) { 
              
                  // Fix the starting index 
            for (int i = 0; i < n - k + 1; ++i)  
            { 
                // Get the ending index of substring from 
                // starting index i and length k 
                int j = i + k - 1; 
  
                // checking for sub-string from ith index to 
                // jth index iff str.charAt(i+1) to  
                // str.charAt(j-1) is a palindrome 
                if (table[i + 1][j - 1] && str.charAt(i) ==  
                                          str.charAt(j)) { 
                    table[i][j] = true; 
  
                    if (k > maxLength) { 
                        start = i; 
                        maxLength = k; 
                    } 
                } 
            } 
        } 
        System.out.print("Longest palindrome substring is; "); 
        printSubStr(str, start, start + maxLength - 1); 
          
        return maxLength; // return length of LPS 
    }
	/**
	 * Using Dynamic Program.. it gives O(n2)
	 * @param t
	 */
	public static void findLongestPalindromicString(String t) {
		int maxLength = 1;
		int startIndex = 0;
		
		int n = t.length();
		
		if (n == 1 || n == 0) {
			System.out.println(t);
			return;
		}
		
		boolean[][] palindromMatrix = new boolean[n][n];
		
		//length 1 string are true.
		for (int i = 0; i<n; i++) {
			palindromMatrix[i][i] = true;
		}
		
		//2 chars length palindrom
		for (int i = 0; i<n-1; i++) {
			if (t.charAt(i) == t.charAt(i+1)) {
				palindromMatrix[i][i+1] = true;
				startIndex = i;
				maxLength = 2;
			}
		}
		
		//more than 2 char palindrom string
		for (int locLength = 3; locLength <= n; locLength++) {
			
			for (int i = 0; i<n-locLength+1; i++) {
				int j = i+locLength-1;
				
				if (t.charAt(i) == t.charAt(j) && palindromMatrix[i+1][j-1]) {
					palindromMatrix[i][j] = true;
					startIndex = i;
					maxLength = locLength;
				}
			}
		}
		System.out.println(t.substring(startIndex, startIndex + maxLength));
	}
	public static void findLongestPalindromicStringBruteForce(String t)
    {
		StringBuffer maxValue = new StringBuffer();
		getLogestPalindromicStr(t, 0, t.length()-1, maxValue);
		System.out.println(maxValue);
    }
	private static String getLogestPalindromicStr(String t, int startIndex, int endIndex, StringBuffer maxValue)
	{
		if (t.length() == 0) return t;
		
		if (maxValue.length() >= t.length()/2) return maxValue.toString();
		
		int i = startIndex;
		int j = endIndex;
		
		while (i < j) {
			if (t.charAt(i) != t.charAt(j)) {
				
				String str1 = getLogestPalindromicStr(t, startIndex, j-1, maxValue);
				String str2 = getLogestPalindromicStr(t, i+1, endIndex, maxValue);
				return (str1.length() > str1.length() ? str1 : str2);
			}
			i++;
			j--;
		}
		StringBuffer sBuff = new StringBuffer();
		while (startIndex <= endIndex) {
			sBuff.append(t.charAt(startIndex));
			startIndex++;
		}
		if (sBuff.length() > maxValue.length()) {
			maxValue.delete(0, maxValue.length());
			maxValue.append(sBuff);
		}
		return sBuff.toString();
	} 
}
