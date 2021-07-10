package com.alysoft.geeksforgeeks.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array A of integers. The task is to complete the function which returns an integer denoting 
 * the length of the longest sub-sequence such that elements 
 * in the sub-sequence are consecutive integers, the consecutive numbers can be in any order.
 * Example(To be used only for expected output):
	Input:
		2
		7
		1 9 3 10 4 20 2
		11
		36 41 56 35 44 33 34 92 43 32 42
		Output:
		4
		5
		
		Explanation:
		Testcase 1: Logest consecutive subsequence is 1, 2, 3, 4 of length 4.
 * @author ymohammad
 *
 */
public class LongestConsecutiveSubsequence
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    
			System.out.println(findLongestConseqSubseq(a, n));
		
		t--;
		}
	}

	private static int findLongestConseqSubseq(int[] a, int n)
	{
		Arrays.sort(a);
		int localMax = Integer.MIN_VALUE;
		int tempCount = 0;
		boolean isFound = false;
		for (int i = 1; i<n; i++) {
			if (a[i] == a[i-1]) continue;
			
			if (a[i]-a[i-1] == 1) {
				tempCount++;
				isFound = true;
			} else {
				localMax = Math.max(tempCount, localMax);
				tempCount = 0;
			}
		}
		localMax = Math.max(tempCount, localMax);
		if (isFound) localMax++;
		return localMax;
	}

	private static void removeDuplicates(int[] a)
	{
		
	}
}
