package com.alysoft.algo.codechef.mock1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Given a string S consisting of only 1s and 0s, find the number of substrings which start and end both in 1.
In this problem, a substring is defined as a sequence of continuous characters Si, Si+1, ..., Sj where 1 ≤ i ≤ j ≤ N.

Input
First line contains T, the number of testcases. Each testcase consists of N(the length of string) in one line and string in second line.

Output
For each testcase, print the required answer in one line.

Constraints
1 ≤ T ≤ 105
1 ≤ N ≤ 105
Sum of N over all testcases ≤ 105
Example
Input:
2
4
1111
5
10001

Output:
10
3
Explanation
#test1: All substrings satisfy.
#test2: Three substrings S[1,1], S[5,5] and S[1,5] satisfy.
 * @author ymohammad
 *
 */
public class CountSubstrings
{
	public static void main(String[] args) throws Exception {
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
	        while (t > 0)
	        {
	            int n = Integer.parseInt(br.readLine());
	            int[] oneNZeroArr = new int[n];
	            
	            String line = br.readLine();
	            String[] split = line.split("");
	            int i = 0;
	            int count = 0;
	            while (i < n) {
	            	oneNZeroArr[i] = Integer.parseInt(split[i]);
	            	if (oneNZeroArr[i] == 1) {
	            		count++;
	            	}
	            	i++;
	            }
	            long noOfMatching = getSubStringCount(oneNZeroArr, n, count);
	            System.out.println(noOfMatching);
	            t--;
	        }
		} 
		catch (Exception e)
		{
		}
	}

	private static long getSubStringCount(int[] oneNZeroArr, long n, long count)
	{
		long totalSubstrigs = (count*(count+1))/2;
		return totalSubstrigs;
	}
}
