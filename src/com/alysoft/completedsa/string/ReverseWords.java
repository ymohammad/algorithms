package com.alysoft.completedsa.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWords
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
            String ch = getReverseString(line);
            System.out.println(ch);
            t--;
        }
	}

	public static String getReverseString(String line)
	{
		String[] splitWords = line.split("\\.");
		int n = splitWords.length;
		StringBuffer sBuff = new StringBuffer();
		for (int i = n-1; i >= 0; i--) {
			sBuff.append(splitWords[i]);
			if (i != 0) {
				sBuff.append(".");
			}
		}
		return sBuff.toString();
	}
}
