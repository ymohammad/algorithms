package com.alysoft.geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is the time of Christmas and Santa wants to distribute gifts to M children. He has N number of boxes, 
 * and each box contains some chocolates. Now, Santa wants to distribute N boxes to M children keeping in mind that 
 * distribution should be as fair as possible. To fairly distribute the gift boxes, Santa wants to minimize the maximum number 
 * of choclates gifted to a child.

Formally, given M number of children and N boxes, where each box contains some amount of chocolates. 
The task is to minimize the maximum number of chocolate gifted to a child.

Input:
First line of input contains number of testcases T. For each testcase, there will be three lines of input. 
First line contains N number of gift boxes, next line contains choclates in each of the N boxes. Last line contains number of children.

Output:
For each testcase, print the minimum number of maximum chocolate a child get.

Example:
Input:
1
4
12 34 67 200
3

Output:
200

Explanation:
Testcase 1: Minimum 200 chocolates will be given to a child which gets the maximum number of chocolate.
 * @author ymohammad
 *
 */
public class SantaAndGift
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            long[] a = new long[n];
            long totalChoclates = 0L;
            long startVal = 0L;
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Long.parseLong(s.trim());
			        totalChoclates += a[i];
			        startVal = Math.max(startVal, a[i]);
			        i++;
			    }
			}
			int m = Integer.parseInt(br.readLine().trim());
			System.out.println(getMinimizeChoclate(a, n, m, startVal, totalChoclates));
            t--;
        }
	}

	private static long getMinimizeChoclate(long[] a, int n, int m, long startVal, long totalChoclates)
	{
		if (m>n) return -1;
		
		long start = startVal;
		long end = totalChoclates;
		long finalAns = -1;
		while (start<end) {
			long mid = (start+end)/2;
			if (isValidConfig(a, n, m, mid)) {
				end = mid-1;
				finalAns = mid;
			} else {
				start = mid+1;
			}
		}
		return finalAns;
	}

	private static boolean isValidConfig(long[] a, int n, int m, long mid)
	{
		long localSum = 0;
		int noOfChild = 0;
		for (int i=0; i<n; i++) {
			if (localSum+a[i] > mid) {
				noOfChild++;
				localSum = a[i];
			} else {
				localSum += a[i];
			}
			if (noOfChild == m) {
				return false;
			}
		}
		return true;
	}
}
