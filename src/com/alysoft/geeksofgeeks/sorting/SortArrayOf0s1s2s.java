package com.alysoft.geeksofgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. 
Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines 
contains the elements of the array A separated by spaces.

Output: 
For each testcase, print the sorted array.
 * 
 * Example:
	Input :
	2
	5
	0 2 1 2 0
	3
	0 1 0
	
	Output:
	0 0 1 2 2
	0 0 1
 * 
 * @author ymohammad
 *
 */
public class SortArrayOf0s1s2s
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
				
			//int[] x = getSortedArray(a, n);
			inPlaceSorting(a, n);
			printArray(a);
            t--;
        }
	}
	public static void inPlaceSorting(int[] a, int n) {
		if (n < 1) return;
		
		int i = 0;
		int j = 0;
		int k = n-1;
		while (j<=k) {
			int val = a[j];
			if (val == 0) {
				swap(a, i, j);
				i++;
				j++;
			} else if (val == 1) {
				j++;
			} else {
				swap(a, j, k);
				k--;
			}
			//printArray(a);
		}
	}
	private static void swap(int[] a, int from, int to) {
		int temp = a[from];
		a[from] = a[to];
		a[to] = temp;
	}
	private static int[] getSortedArray(int[] a, int n)
	{
		if (n < 1) return a;
		
		int[] countArr = new int[3];
		for (int x: a) {
			countArr[x]++;
		}
		
		//int[] resultArr = new int[n];
		int k = 0;
		for (int i = 0; i<3; i++) {
			int x = countArr[i];
			while (x > 0) {
				if (i == 0) {
					a[k] = 0;
				} else if (i == 1) {
					a[k] = 1;
				} else {
					a[k] = 2;
				}
				k++;
				x--;
			}
		}
		return a;
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
