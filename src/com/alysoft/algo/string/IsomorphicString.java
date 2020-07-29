package com.alysoft.algo.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
Two strings str1 and str2 are called isomorphic, if there is a one to one mapping possible for every character of str1 to every character of str2 while preserving the order.

Input:
The first line contains an integer T, depicting total number of test cases. Each test case contains two strings each in new line.

Output:
Print "1" if strings are isomorphic and "0" if not.

User Task:
The task is to complete the function areIsomorphic() which checks if two strings are isomorphic. The function returns true if strings are isomorphic else it returns false.

Constraints:
1 <= T <= 100
1 <= Length of Strings <= 103

Example:
Input:
2
aab
xxy
aab
xyz

Output:
1
0

Explanation:
Testcase 1: There are two different characters in aab and xxy, i.e a and b with frequency 2 and 1 respectively.
 * @author ymohammad
 *
 */
public class IsomorphicString
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            
            boolean a = areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
	}
	public static boolean areIsomorphic(String S1,String S2)
    {
        // Your code here
        if (S1.length() != S2.length()) return false;
        
        return isIsomorphic(S1, S2);
        
    }
    public static boolean isIsomorphic(String s1, String s2) {
		long[] countArray1 = new long[26];
		long[] countArray2 = new long[26];
		
		char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();
        
        for (char ch : s1CharArr) {
            int charInd = getCharIndex(ch);
            countArray1[charInd]++;
        }
        for (char ch : s2CharArr) {
            int charInd = getCharIndex(ch);
            countArray2[charInd]++;
        }
        int length = s1.length();
        for (int i = 0; i<length; i++) {
        	if (countArray1[getCharIndex(s1.charAt(i))] != countArray2[getCharIndex(s2.charAt(i))]) {
        		return false;
        	}
        }
        return true;
	}
	public static boolean isValExist(long[] arr, long val) {
	    for (int i = 0; i<26; i++) {
            if (arr[i] == val) {
                arr[i] = -1;
                return true;
            }
        }
        return false;
	}
	public static int getCharIndex(char ch) {
        return ch-'a';
    }
	
	public static int getCharValue (char ch) {
		int returnVal = -1;
	    switch(ch) {
		    case 'a':
		    case 'b':
		    case 'c':
		    	returnVal = 2;
		    	break;
		    case 'd':
		    case 'e':
		    case 'f':
		    	returnVal = 3;
		    	break;
		    case 'g':
		    case 'h':
		    case 'i':
		    	returnVal = 4;
		    	break;
		    case 'j':
		    case 'k':
		    case 'l':
		    	returnVal = 5;
		    	break;
		    case 'm':
		    case 'n':
		    case 'o':
		    	returnVal = 6;
		    	break;
		    case 'p':
		    case 'q':
		    case 'r':
		    case 's':
		    	returnVal = 7;
		    	break;
		    case 't':
		    case 'u':
		    case 'v':
		    	returnVal = 8;
		    	break;
		    case 'w':
		    case 'x':
		    case 'y':
		    case 'z':
		    	returnVal = 9;
		    	break;
		    default:
		    	returnVal = Integer.parseInt(String.valueOf(ch));
	    }
	    return returnVal;
	}
	static int repeatedCharacter(String S)
    {
       long[] countArray = new long[256];
       char[] charArr = S.toCharArray();
       for (char ch : charArr) {
            //int charInd = getCharIndex(ch);
            countArray[ch]++;
        }
        for (int i = 0; i<charArr.length; i++) {
            char ch = charArr[i];
            if (countArray[ch] > 1) {
                return i;
            }   
        }
        return -1;
        
        long[] countArray = new long[256];
        char[] charArr = S.toCharArray();
        for (char ch : charArr) {
             //int charInd = getCharIndex(ch);
             countArray[ch]++;
         }
         for (int i = 0; i<charArr.length; i++) {
             char ch = charArr[i];
             if (countArray[ch] == 1) {
                 return ch;
             }   
         }
         return '$';
    }
}
