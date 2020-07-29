package com.alysoft.algo.string;

/**
 * Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by 2 places.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. In the next two line are 
two string a and b respectively.

Output:
For each test case in a new line print 1 if the string 'a' can be obtained by rotating string 'b' by two places else print 0.

User Task:
The task is to complete the function isRotated() which checks if given strings can be formed by rotations. The function returns true if 
string 1 can be obtained by rotating string 2 by two places, else it returns false.

Constraints:
1 <= T <= 50
1 <= length of a, b < 100

Example:
Input:
2
amazon
azonam
geeksforgeeks
geeksgeeksfor

Output:
1
0

Explanation:
Testcase 1: amazon can be rotated anti-clockwise by two places, which will make it as azonam.
Testcase 2: geeksgeeksfor can't be formed by any rotation from the given word geeksforgeeks.
 * @author ymohammad
 *
 */
public class StringRotatedTwoPlaces
{

	public static void main(String[] args)
	{
		String s1 = "amazon";
		String s2 = "azonam";
		System.out.println(isRotated(s1, s2));
	}
	public static boolean isRotated(String s1, String s2){
        
        // Your code here
        if (s1.length() != s2.length()) return false;
        
        if (!isSame(s1, s2)) return false;
        
        //Anti-Clock Wise
        String a = rotatClock(s1, s1.length());
        if (a.equals(s2)) return true;
        
        a = rotatAntiClock(s1, s1.length());
        if (a.equals(s2)) return true;
        
        return false;
        
    }
	public static String rotatClock(String s, int n) {
		char[] array = s.toCharArray();
        for (int t = 0; t<2; t++) {
        	char ch = array[n-1];
        	for (int i = n-2; i>=0; i--) {
        		array[i+1] = array[i];
        	}
        	array[0] = ch;
        }
        return new String(array);
	}
	public static String rotatAntiClock(String s, int n) {
		char[] array = s.toCharArray();
        for (int t = 0; t<2; t++) {
        	char ch = array[0];
        	for (int i = 1; i<n; i++) {
        		array[i-1] = array[i];
        	}
        	array[n-1] = ch;
        }
        return new String(array);
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
