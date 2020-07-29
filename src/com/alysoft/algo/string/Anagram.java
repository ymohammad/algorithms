package com.alysoft.algo.string;

/**
 * Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are anagram of each other or not. 
 * An anagram of a string is another string that contains same characters, only the order of characters can be different. For example, “act” 
 * and “tac” are anagram of each other.

Input: 
The first line of input contains an integer T denoting the number of test cases. Each test case consist of two strings in 'lowercase' only, 
in a single line.

Output:
Print "YES" without quotes if the two strings are anagram else print "NO".

User Task:
The task is to complete the function  isAnagram() which checks if the two strings are anagram of each other. The function returns true 
if the strings are anagram else it returns false.

Constraints:
1 ≤ T ≤ 300
1 ≤ |s| ≤ 1016

Example:
Input:
2
geeksforgeeks forgeeksgeeks
allergy allergic

Output:
YES
NO

Explanation:
Testcase 1: Both the string have same characters with same frequency. So, both are anagrams.
Testcase 2: Characters in both the strings are not same, so they are not anagrams.
 * @author ymohammad
 *
 */
public class Anagram
{
	public static void main(String[] args) {
		String s1 = "zzzzz";
		String s2 = "aaaaa";
		isAnagram(s1, s2);
	}
	public static boolean isAnagram(String s1,String s2)
    {
        
        long[] s1Count = new long[27];
        long[] s2Count = new long[27];
        char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();
        for (char ch : s1CharArr) {
            int charInd = getCharIndex(ch);
            s1Count[charInd]++;
        }
        for (char ch : s2CharArr) {
            int charInd = getCharIndex(ch);
            s2Count[charInd]++;
        }
        for (int i = 0; i<27; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }
	public static boolean isSame(String s1, String s2) {
		long[] countArray = new long[26];
		char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();
        for (char ch : s1CharArr) {
            int charInd = getCharIndex(ch);
            countArray[charInd]++;
        }
        for (char ch : s2CharArr) {
            int charInd = getCharIndex(ch);
            countArray[charInd]--;
        }
        for (int i = 0; i<26; i++) {
            if (countArray[i] != 0) {
                return false;
            }
        }
        return true;
	}
    public static int getCharIndex(char ch) {
        return ch-'a';
    }
}
