package com.alysoft.algo.context1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given a number N. You need to find the perfect square that is nearest to it. If two perfect squares are at the same distance to N, then print the greater perfect square.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains one line of input containing N.

Output:
For each testcase, in a new line, print the perfect square closest to N.

Constraints:
1 <= T <= 100
1 <= N <= 1014

Examples:
Input:
3
1
56
100
Output:
0
49
81

Explanation:
Testcase1: 0 and 4 are near to 1. 0 is nearest.
Testcase2: 49 and 64 are near to 56. 49 is nearest.
Testcase3: 81 and 121 are near to 100. 81 is nearest.
 * @author ymohammad
 *
 *
 *
 *HINT
 *If N is perfect square then find sqrt(N) and do +1 and -1 to get two numbers. Now find the distance of squares of these numbers with N.

If N is perfect square then find sqrt(N) and do floor and ceil to get two numbers. Now find the distance of squares of these numbers with N.

Don't forget the equality of distance condition in which you need to print the greater perfect square.
 */
public class NearestPerfectSquare
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
        	long n = Long.parseLong(br.readLine().trim());
			int x = getNearestPerfectSq(n);
			
			System.out.println(x*x);
            t--;
        }
	}
	public static int getNearestPerfectSq(long x)
	{
		if (x == 1) return 0;
		
		int sq = (int) Math.sqrt(x);
		while (sq*sq <x) {
			sq++;
		}
		int minSq;
		int maxSq;
		if (sq*sq == x) {
		    minSq = sq-1;
		    maxSq = sq+1;
		} else {
		    minSq = sq-1;
		    maxSq = sq;
		}
		long lower = x-(minSq)*(minSq);
		long higher = (maxSq*maxSq)-x;
		if (lower < higher) {
		    return minSq;
		} else {
		    return maxSq;
		}
	}
	public static int getNearestPerfectSq1(int x, int low, int high)
	{
		if (x == 1) return 0;
		
		if (low < high) {
			int mid = (low+high)/2;
		    if (mid*mid > x || (mid*mid) == x) {
		    	return getNearestPerfectSq1(x, low, mid-1);
		    } else if (mid*mid < x) {
		    	return getNearestPerfectSq1(x, mid+1, high);
		    }
		    return mid;
		} else if (low == high) {
			return high-1;
		}
	     
	    return high;
	}
}
