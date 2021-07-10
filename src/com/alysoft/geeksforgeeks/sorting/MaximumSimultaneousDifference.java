package com.alysoft.geeksforgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an unsorted array, find the maximum difference between its two consecutive 
 * elements in its sorted form.

	Note : O(n) solution is expected.
	
	Input: First line of input contains number of testcases T. For each testcase, 
	the first line will contain N, the no of elements. The next line contains N space separated elements.
	
	Output: For each testcase, output a single number, the Maximum difference.
 * 
 * Example:
	Input:
	1
	3
	1 10 5
	
	Output:
	5
 * @author ymohammad
 *
 */
public class MaximumSimultaneousDifference
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
            int[] a = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			int x = getMaxSimultaneousDiff(a, n);
			
			System.out.println(x);
            t--;
        }
	}

	private static int getMaxSimultaneousDiff(int[] a, int n)
	{
		if (n == 2) return Math.abs(a[0]-a[1]);
		
		int maxVal = 0;
		
		peageonSort(a, n);
		for (int i=1; i<n; i++) {
			int diff = a[i]-a[i-1];
			if (diff > maxVal) {
				maxVal = diff;
			}
		}
		return maxVal;
	}

	private static void peageonSort(int[] arr, int n)
	{
		int maxValue = getMaxValue(arr);
		int minValue = getMinValue(arr);
		
		int range = maxValue-minValue+1;
		int[] countArr = new int[range];
		for (int i=0; i<n; i++) {
			countArr[arr[i]-minValue]++;
		}
		int j = 0;
		for (int i=0; i<range; i++) {
			int x = countArr[i];
			while (x>0) {
				arr[j] = minValue+i;
				x--;
				j++;
			}
		}
	}
	
	private static int getMaxValue(int[] arr)
	{
		int maxVal = Integer.MIN_VALUE;
		for (int x: arr) {
			if (x>maxVal) maxVal = x;
		}
		return maxVal;
	}
	
	private static int getMinValue(int[] arr)
	{
		int minVal = Integer.MAX_VALUE;
		for (int x: arr) {
			if (x<minVal) minVal = x;
		}
		return minVal;
	}
	public static void printArray(int[] arr) {
		StringBuffer buff = new StringBuffer();
		for (int x: arr) {
			buff.append(x + " ");
		}
		System.out.println(buff.toString().trim());
	}
}
