package com.alysoft.geeksforgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an integer array of which both first half and second half are sorted. The task is to merge two sorted halves of 
 * the array into a single sorted array.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains an integer n which 
denotes the number of elements in the array a[]. Next line contains space separated n elements in the array a[].

Output:
Print the sorted array with space separated values.
 * 
 * Example:
Input:
2
6
2 3 8 -1 7 10
5
-4 6 9 -1 3

Output:
-1 2 3 7 8 10 
-4 -1 3 6 9 
 * @author ymohammad
 *
 */
public class SortHalfSorted
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
				
			int[] x = getSortedArray(a, n);
			printArray(x);
            t--;
        }
	}
	
	public static int[] getSortedArray(int[] a, int n)
	{
		if (n < 2) return a;
		
		int[] returnArr = new int[n];
		int mid = n/2;
		if (mid < n && a[mid-1]>a[mid]) {
			mid = mid-1;
		}
		int i = 0;
		int j = mid+1;
		int k = 0;
		while (i<=mid && j<n) {
			if (a[i]<=a[j]) {
				returnArr[k] = a[i];
				i++;
			} else {
				returnArr[k] = a[j];
				j++;
			}
			k++;
		}
		while (i<=mid) {
			returnArr[k] = a[i];
			i++;
			k++;
		}
		while (j<n) {
			returnArr[k] = a[j];
			j++;
			k++;
		}
		return returnArr;
	}

	private static void printArray(int[] arr)
	{
	    StringBuffer buff = new StringBuffer();
		for (int x: arr) {
			buff.append(x + " ");
		}
		System.out.println(buff.toString().trim());
	}
}
