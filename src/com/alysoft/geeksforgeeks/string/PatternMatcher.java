package com.alysoft.geeksforgeeks.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PatternMatcher
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            String pattern = br.readLine();
            String text = br.readLine();
				
			int x = isPatternConverable(pattern, text);
			
			System.out.println(x);
            t--;
        }
	}

	private static int isPatternConverable(String pattern, String text)
	{
		if (pattern.equals(text)) return 1;
		
		int p = pattern.length();
		int t = text.length();
		
		if (p>=t) return 0;
		
		StringBuffer buff = new StringBuffer(pattern);
		while (p<=t) {
			buff.append(pattern);
			if (buff.toString().equals(text)) {
				return 1;
			}
			p = buff.length();
		}
		return 0;
	}
}
