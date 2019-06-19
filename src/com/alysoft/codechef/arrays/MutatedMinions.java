package com.alysoft.codechef.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Gru has not been in the limelight for a long time and is, therefore, planning something particularly nefarious. Frustrated by his minions' 
 * incapability which has kept him away from the limelight, he has built a transmogrifier — a machine which mutates minions.

Each minion has an intrinsic characteristic value (similar to our DNA), which is an integer. The transmogrifier adds an integer K to 
each of the minions' characteristic value.

Gru knows that if the new characteristic value of a minion is divisible by 7, then it will have Wolverine-like mutations.

Given the initial characteristic integers of N minions, all of which are then transmogrified, find out how many of them become Wolverine-like.
 * @author ymohammad
 *
 */
public class MutatedMinions
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine;
		while ((eachLine = br.readLine()) != null) {
			int t = Integer.parseInt(eachLine.trim());
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	        	String str = br.readLine();
	        	String[] lineSplit = str.split(" ");
	        	int n = Integer.parseInt(lineSplit[0].trim());
	        	int k = Integer.parseInt(lineSplit[1].trim());
	        	
	        	int count = 0;
	        	lineSplit = br.readLine().split(" ");
	        	for (String s : lineSplit) {
	        		if (s != null && s.trim().length()>0) {
	        			int x = Integer.parseInt(s.trim()) + k;
	        			if (x%7 == 0)
	        				count++;
	        		}
	        	}
	        	System.out.println(count);
	            t--;
	        }
	        break;
		}
	}
}
