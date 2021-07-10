package com.alysoft.geeksforgeeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeString
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
        	int n = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();
            //String[] arrayValues = line.trim().split(" ");
            checkStringPalindrome(line, n);
            t--;
        }
	}

	private static void checkStringPalindrome(String line, int n)
	{
		int i = 0;
		int j = n-1;
		
		while(i<j) {
			if (line.charAt(i) != line.charAt(j)) {
				System.out.println("No");
				return;
			}
			i++;
			j--;
		}
		System.out.println("Yes");
	}
}
