package com.alysoft.completedsa.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramPalindrome
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
            verifyAnagramString(line1);
            t--;
        }
	}

	private static void verifyAnagramString(String line)
	{
		int[] asciCharArray = getAsciCharArray(line);
		boolean isOddLength = line.length()%2 == 1;
		for (int i = 0; i < asciCharArray.length; i++)
		{
			if (asciCharArray[i] == 1 ) {
				if (isOddLength) {
					isOddLength = false;
				} else {
					System.out.println("No");
					return;
				}
			} else if (asciCharArray[i]%2 > 0) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
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
