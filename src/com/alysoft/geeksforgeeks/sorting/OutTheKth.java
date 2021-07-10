package com.alysoft.geeksforgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array A of N integers and a number K. The task is to find the K-th largest element in the array.

Input:
First line of input contains T, number of testcases. For each testcase, there will be three lines of 
input, first of which contains size of array N, next line contains N integers, and last line contains K.

Output:
For each testcase, print the K-th largest element, if exists, else print "-1" (without quotes).
 * @author ymohammad
 *
 *Example:
Input:
1
5
1 2 3 4 5
3

Output:
3
 */
public class OutTheKth
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
			int f = Integer.parseInt(br.readLine().trim());
			int x = getLargestElement(a, n, f);
			
			System.out.println(x);
            t--;
        }
	}

	private static int getLargestElement(int[] a, int n, int f)
	{
		if (f>n || f<1) return -1;
		
		quickSort(a, 0, n-1);
		
		return a[f-1];
	}

	private static void quickSort(int[] a, int start, int end)
	{
		if (start > end) return;
		
		int pIndex = partionIndexRandom(a, start, end);
		quickSort(a, start, pIndex-1);
		quickSort(a, pIndex+1, end);
	}

	private static int partionIndexRandom(int[] a, int start, int end)
	{
		int random = ((int)Math.random()*(end-start)) + start;
		swap(a, end, random);
		return partionIndex(a, start, end);
	}

	private static void swap(int[] a, int from, int to)
	{
		int temp = a[from];
		a[from] = a[to];
		a[to] = temp;
	}

	private static int partionIndex(int[] a, int start, int end)
	{
		int pivotInd = start;
		int pivotVal = a[end];
		for (int i=start; i<end; i++) {
			if (a[i]>=pivotVal) {
				swap(a, i, pivotInd);
				pivotInd++;
			}
		}
		swap(a, pivotInd, end);
		return pivotInd;
	}
}
