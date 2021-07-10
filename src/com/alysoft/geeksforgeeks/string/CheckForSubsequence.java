package com.alysoft.geeksforgeeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckForSubsequence
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
            String[] arrayValues = line.trim().split(" ");
            int x = checkSubSequence(arrayValues[0], arrayValues[1]);
            System.out.println(x);
            t--;
        }
	}

	private static int checkSubSequence(String a, String b)
	{
		if (a == null || a.trim().length() == 0) return 0;
		if (b == null || b.trim().length() == 0) return 0;
		
		int aLength = a.length();
		int bLength = b.length();
		
		if (aLength > bLength) return 0;
		
		int i = 0; 
		int j = 0;
		int foundCount = 0;
		while (i<aLength && j<bLength) {
			char aChar = a.charAt(i);
			while (j<bLength) {
				if (b.charAt(j) == aChar) {
					foundCount++;
					j++;
					break;
				}
				j++;
			}
			i++;
		}
		if (foundCount == aLength) return 1;
		
		return 0;
	}
}
