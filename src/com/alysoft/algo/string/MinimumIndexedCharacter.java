package com.alysoft.algo.string;

/*
 * Given a string str and another string patt. Find the character in patt that is present at the minimum index in str. If no character of patt is present in str then print ‘No character present’.

Input Format:
The first line of input contains an integer T denoting the number of test cases. Then the description of T test cases follow. Each test case contains two strings str and patt respectively.

Output Format:
Print the character in patt that is present at the minimum index in str.
Print "No character present" (without quotes) if no character of patt is present in str.

Your Task:
This is a function problem. You only need to complete the function printMinIndexCharN that prints the answer. The newline is automatically appended by the driver code.

Constraints:
1 <= T <= 105
1 <= |str|,|patt| <= 105

Example:
Input:
2
geeksforgeeks
set
adcffaet
onkl

Output:
e
No character present

Explanation:
Testcase 1: e is the character which is present in given patt "geeksforgeeks" and is first found in str "set".
 
 */
public class MinimumIndexedCharacter
{
	public static void solution(String s1, String s2){

        int[] countArray = new int[256];
		char[] sCharArr = s2.toCharArray();
		char newCh = '0';
        for (char ch : sCharArr) {
            countArray[ch]++; 
        }
        
        int s1Len = s1.length();
        for (int i = 0; i<s1Len; i++)
        {
            char ch = s1.charAt(i);
            if (countArray[ch] != 0) {
                newCh = ch;
            }
        }
        if (newCh == '0') {
            System.out.print("No character present");
        } else {
            System.out.print(newCh);
        }
    }
}
