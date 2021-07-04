package com.alysoft.algo.sorting.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * You are given an array of integers. Consider absolute difference between all the pairs of the the elements. 
 * You need to find Kth smallest absolute difference.If the size of the array is N then value of K will be less than N and more than or equal to 1.

Note: All the differences between pairs are considered to be different.

Input:
First line of input contains number of testcases T. The 1st line of each testcase contains a two integers N and K denoting the 
number of elements in the array A  and difference you need to output . The 2nd line of each testcase, contains N space separated integers 
denoting the elements of the array A.

Output:
For each test case, Output Kth smallest absolute difference.

Constraints:
1<= T <= 102
2 <= N <= 105
1 <= K < N
0 <= A[i] <= 105

Example:
Input :
1
6 2
1 3 4 1 3 8
Output :
0

1
7 5
1 2 3 4 5 999 99999
Explanation :
Testcase1: First smallest difference is 0 , between the pair (1,1) and second smallest absolute difference 
difference is also 0 between the pairs (3,3).
 * @author ymohammad
 *
 */
public class KthSmallestDifference
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int n = Integer.parseInt(arrayValues[0].trim());
            int k = Integer.parseInt(arrayValues[1].trim());
            line = br.readLine();
            arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			int x = getKSmallestAbsoluteDifference(a, n, k);
			System.out.println(x);
            t--;
        }
	}
	private static int getKSmallestAbsoluteDifference(int[] arr, int n, int k)
	{
		int possibleCount = (n*(n-1))/2;
		if (k > possibleCount) return 0;
		
		Arrays.sort(arr);
		
		int maxValue = Math.abs(arr[0]-arr[n-1]);
		int minValue = Math.abs(arr[0]-arr[1]);
		
		int currentMin = -1;
		for (int i = 1; i<n-2; i++) {
			currentMin = Math.abs(arr[i]-arr[i+1]);
			if (currentMin < minValue) {
				minValue = currentMin;
			}
			
			while (minValue<maxValue) {
				int mid = (minValue+maxValue)/2;
				int x = findPairsCount(arr, n, mid);
				if (x < k) {
					minValue = mid+1;
				} else {
					maxValue = mid;
				}
			}
			return minValue;
		}
		return currentMin;
	}
	private static int findPairsCount(int[] arr, int n, int mid)
	{
		return 0;
	}
	private static int getKSmallestAbsoluteDifference1(int[] arr, int n, int k)
	{
		if (n == 1) return arr[0];
		
		Arrays.sort(arr);
		int currentMin = -1;
		for (int i = 0; i<n; i++) {
			if (i == 0) {
				currentMin = Math.min(Math.abs(arr[i]-arr[i+1]), Math.abs(arr[i]-arr[n-1]));
			} else if (i == n) {
				currentMin = Math.min(Math.abs(arr[n-1]-arr[n-2]), Math.abs(arr[n-1]-arr[0]));
			} else {
				currentMin = Math.min(Math.abs(arr[i]-arr[i+1]), Math.abs(arr[i]-arr[i-1]));
			}
			if (i == k) {
				return currentMin;
			}
		}
		return -1;
	}

}
