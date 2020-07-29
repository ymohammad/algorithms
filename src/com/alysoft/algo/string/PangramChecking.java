package com.alysoft.algo.string;

/**
 * Given a string check if it is Pangram or not. A pangram is a sentence containing every letter in the English Alphabet.

Input Format:
First line of input contains of an integer 'T' denoting number od test cases then T test cases follow . Each testcase contains a String 'S'.

Output Format:
For each test case print in a new line 1 if its a pangram else print 0 .

Your Task:
This is a function problem. You need to complete the function checkPanagram that takes string as parameter and returns true if string is panagram, else it returns false.

Constraints:
1 <= T <= 25
1 <= |S| <= 50

Example:
Input:
2
Bawds jog, flick quartz, vex nymph
sdfs

Output:
1
0
 * @author ymohammad
 *
 */
public class PangramChecking
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	public static boolean checkPanagram  (String s)
    {
        s = s.toLowerCase();
        int[] countArray = new int[26];
		char[] sCharArr = s.toCharArray();
        for (char ch : sCharArr) {
            if (!Character.isDigit(ch)) {
               int charInd = getCharIndex(ch);
                countArray[charInd]++; 
            }
        }
        
        for (int i = 0; i<26; i++) {
            if (countArray[i] == 0) {
                return false;
            }
        }
        return true;
    }
    public static int getCharIndex(char ch) {
        return ch-'a';
    }
}
