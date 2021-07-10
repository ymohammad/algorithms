package com.alysoft.geeksforgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array A of positive integers. Count number of smaller elements on right side of each array.

Input:
The first line of input contains an integer T denoting the number of test cases. 
The first line of each test case is N,N is the size of array. The second line of each test case contains N input arr[i].

Output:
Print the countSmaller array.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= Ai  <= 108

Example:
Input:
2
7
12 1 2 3 0 11 4
5
1 2 3 4 5

Output:
6 1 1 1 0 1 0
0 0 0 0 0

Explanation:
Testcase 1: 6 elements are greater than 1 on its right side in original array. 
Similarly 1 element is greater than 4 on its right side in original array.
 * @author ymohammad
 *
 */
public class CountSmallerElements
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] arrayValues = line.split(" ");
            int[] a = new int[n];
			for(int i = 0; i < n; i++)
				a[i]= Integer.parseInt(arrayValues[i]);
			
			printSmallerElementsCount(a, n);
			
            t--;
        }
	}

	private static void printSmallerElementsCount(int[] a, int n)
	{
		if (n == 0) return;
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i<n; i++) {
			int currentVal = a[i];
			int counter = 0;
			int j = i+1;
			while (j < n) {
				if (a[j]<currentVal) counter++;
				j++;
			}
			sb.append(counter + " ");
		}
		System.out.println(sb.toString().trim());
	}
}
