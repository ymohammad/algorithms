package com.alysoft.completedsa.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Find and print the uncommon characters of the two given strings S1 and S2. Here uncommon character means 
 * that either the character is present in one string or it is present in other string but not in both. 
 * The strings contains only lowercase characters and can contain duplicates.
 * 
 * Input: The first line of input contains an integer T denoting the number of test cases. 
 * Then T test cases follow. Each test case contains two strings in two subsequent lines.
 * Output:
 * For each testcase, in a new line, print the uncommon characters of the two given strings in sorted order.
 * @author ymohammad
 *
 */
public class UncommonCharacters
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
            String line2 = br.readLine();
            printUncommonCharacters(line1, line2);
            t--;
        }
	}

	private static void printUncommonCharacters(String line1, String line2)
	{
		int[] line1Char = getAsciCharArray(line1);
		int[] line2Char = getAsciCharArray(line2);
		int[] res = new int[256];
		
		for (int i = 0; i < line1Char.length; i++)
		{
			
			if (line1Char[i] > 0 && line2Char[i]==0) {
				res[i]++;
			}
		}
		for (int i = 0; i < line2Char.length; i++)
		{
			if (line2Char[i]>0 && line1Char[i]==0) {
				res[i]++;
			}
		}
		
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < res.length; i++)
		{
			if (res[i]>0) {
				buff.append((char)i);
			}
		}
		System.out.println(buff.toString());
	}
	public static int[] getAsciCharArray(String line) {
		int[] line1Char = new int[256];
		char[] char1Array = line.toCharArray();
		for (char ch: char1Array) {
			line1Char[ch]++;
		}
		return line1Char;
	}
}
