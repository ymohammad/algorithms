package com.alysoft.algorithms.hackerrank.interviewkit;

import java.io.IOException;
import java.util.Scanner;

/**
 * Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.
 * For example, if the string s="abcac" and n=10, the substring we consider is "abcacabcac", the first 10 characters 
 * of her infinite string. There are 4  occurrences of a in the substring. 
 * 
 * Problem:  It should return an integer representing the number of occurrences of 'a' in the prefix of length 'n'
 * 			 in the infinitely repeating string.
 * constraints:
 * 1 <= |s| <= 100
 * 1 <= n <= 10^12
 * For 25% of test cases, n <= 10^6
 * @author ymohammad
 */
public class RepeatingString1
{
	/**
	 * Based on the constraints, we need long datatype for holding n value.
	 * As int will range between -2^31 to 2^31-1 (<10^10)
	 * long can hold it as it is between -2^63 to 2^63-1 (<10^19)
	 * @param args
	 */

	// Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long numberOfOcc = 0;
    	//Bruteforce method.. O(n) time complexity.
    	
    	//Here if we see.. s is of max size 100.
    	//If it is s.length<n then we need to repeat it.
    	//If 's' size is 'x' then we need n = x*y + r; (r can be zero and r<x)
    	//If 'a' is exist in 's', suppose 't' number of times then number of 'a' will be y*t + (number of 'a' in s till index r)
    	
    	//if s.length>n then just substring and loop and find number of 'a'.
    	
    	if (s.length() >= n) {
    		String newStr = s.substring(0, (int)n);
    		numberOfOcc = findAOccurence(newStr);
    	} else {
    		byte x = (byte)s.length();
    		byte r = (byte)(n%x);
    		long y = (n/x);
    		
    		byte t = findAOccurence(s);
    		numberOfOcc = (t*y) + findAOccurence(s.substring(0, r));
    	}
    	return numberOfOcc;
    }
    private static byte findAOccurence(String str) {
    	byte numberOfOcc = 0;
    	if (str == null) return numberOfOcc;
    	for (char c: str.toCharArray()) {
			if (c == 'a') numberOfOcc++;
		}
    	return numberOfOcc;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);
        scanner.close();
    }

	
}
