package com.alysoft.codechef.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A Little Elephant and his friends from the Zoo of Lviv like candies very much.

There are N elephants in the Zoo. The elephant with number K (1 <= K <= N) will be happy if he receives at least AK candies. 
There are C candies in all in the Zoo.

The Zoo staff is interested in knowing whether it is possible to make all the N elephants happy by giving each elephant at 
least as many candies as he wants, that is, the Kth elephant should receive at least AK candies. Each candy can be given to 
only one elephant. Print Yes if it is possible and No otherwise.

Input
The first line of the input file contains an integer T, the number of test cases. T test cases follow. Each test case consists of exactly 2 lines. 
The first line of each test case contains two space separated integers N and C, the total number of elephants and 
the total number of candies in the Zoo respectively. The second line contains N space separated integers A1, A2, ..., AN.

Example
Input:
2
2 3
1 1
3 7
4 2 2

Output:
Yes
No
 * @author ymohammad
 *
 */
public class LECANDY
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine;
		while ((eachLine = br.readLine()) != null) {
			int t = Integer.parseInt(eachLine);
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	        	String str = br.readLine();
	        	String[] lineSplit = str.split(" ");
	        	int n = Integer.parseInt(lineSplit[0].trim());
	        	int c = Integer.parseInt(lineSplit[1].trim());
	        	
	        	String akString = br.readLine();
	        	String[] split = akString.split(" ");
	        	int totalReqCandies = 0;
	        	for (String s : split) {
	        		totalReqCandies += Integer.parseInt(s.trim());
	        	}
	        	if (totalReqCandies > c) {
	        		System.out.println("No");
	        	} else {
	        		System.out.println("Yes");
	        	}
	            t--;
	        }
	        break;
		}
	}
}
