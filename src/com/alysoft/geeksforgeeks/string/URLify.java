package com.alysoft.geeksforgeeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Write a method to replace all the spaces in a string S with ‘%20’. You may assume that the string 
 * has sufficient space (or allocated memory) at the end to hold the additional characters, 
 * 
 * Note: The leading and trailing spaces should be trimmed off and not replaced by %20.
 * @author ymohammad
 *
 */
public class URLify
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            String line1 = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int finalLength = getNumberSpaces(line1);
            String url = urlifyString(line1, (n+finalLength*2));
            System.out.println(url);
            t--;
        }
	}

	private static int getNumberSpaces(String line1)
	{
		line1 = line1.trim();
		String[] split = line1.split(" ");
		return split.length-1;
	}

	public static String urlifyString(String line, int n)
	{
		char[] resArray = new char[n];
		line = line.trim();
		char[] charArray = line.toCharArray();
		int j = 0;
		for (int i = 0; i < charArray.length; i++)
		{
			if (charArray[i] == ' ') {
				resArray[j++] = '%';
				resArray[j++] = '2';
				resArray[j++] = '0';
			} else {
				resArray[j++] = charArray[i];
			}
		}
		return new String(resArray);
	}
}
