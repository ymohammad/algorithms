package com.alysoft.completedsa.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
	Note: Expected solution in O(n) time using constant extra space.

	Input:
	First line consists of T test cases. First line of every test case consists of N, denoting the number of elements in array. 
	Second line of every test case consists of elements in array.
	
	Output:
	Single line output, print the smallest positive number missing.
 * 
 * Example:
	Input:
	2
	5
	1 2 3 4 5
	5
	0 -10 1 3 -20
	Output:
	6
	2
 * @author ymohammad
 *
 */
public class SmallestPositiveMissingNumber
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
			for(String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			int x = getLeastPossitiveMissingNumber(a, n);
			
			System.out.println(x);
            t--;
        }
	}

	private static int getLeastPossitiveMissingNumber(int[] a, int n)
	{
		int possitveIndex = prepareSegregatedArray(a, n);
		//printArray(a);
		//System.out.println("Index start possitive number :" + possitveIndex);
		
		//Make all the elements which are visited as negative.
		for (int i=0; i<possitveIndex; i++) {
			int x = Math.abs(a[i]);
			if (x-1 <possitveIndex && a[x-1]>0) {
				a[x-1] = -a[x-1];
			}
		}
		int i=0;
		//Here once we find the index whose value is positive then the missing element is i+1 (as index is zero based).
		for (i=0; i<possitveIndex; i++) {
			if (a[i] > 0) {
				return i+1;
			}
		}
		return i+1;
	}

	private static int prepareSegregatedArray(int[] a, int n)
	{
		int nonPosInd = 0;
		for (int i=0; i<n; i++) {
			if (a[i]>0) {
				int temp = a[i];
				a[i] = a[nonPosInd];
				a[nonPosInd] = temp;
				nonPosInd++;
			}
		}
		return nonPosInd;
	}

	private static void printArray(int[] a)
	{
		for (int x: a) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
