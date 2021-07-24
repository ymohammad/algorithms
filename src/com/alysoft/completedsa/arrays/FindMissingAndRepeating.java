package com.alysoft.completedsa.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an unsorted array of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' 
 * occurs twice in array. Find these two numbers.
 * 
 * Note: If you find multiple answers then print the Smallest number found. 
 * Also, expected solution is O(n) time and constant extra space.
 * @author ymohammad
 *
 */
public class FindMissingAndRepeating
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
            String line = br.readLine().trim();
            String[] arrayValues = line.split(" ");
            int[] a = new int[n+1];
			for(int i = 0; i < arrayValues.length; i++)
				a[i+1]= Integer.parseInt(arrayValues[i].trim());
			
			int findDuplicate = findDuplicate(a, n);
			int findMissing = findMissing(a, n);
			System.out.println(findDuplicate + " " + findMissing);
			//printArray(a);
            t--;
        }
	}

	private static int findMissing(int[] a, int n)
	{
		int missingElement = a.length+1;
		for (int i = 0; i<a.length; i++) {
			if (a[i]>0) {
				missingElement = Math.min(missingElement, i);
			}
		}
		return missingElement;
	}

	public static int findDuplicate(int[] a, int n) {
		int minDuplicate = n+1;
		
		for (int i=0; i<n+1; i++) {
			if (a[Math.abs(a[i])] < 0) {
				minDuplicate = Math.min(Math.abs(a[i]), minDuplicate);
			} else {
				a[Math.abs(a[i])] = -1 * a[Math.abs(a[i])];
			}
		}
		return minDuplicate;
	}
	
	private static void printArray(int[] arr)
	{
		//System.out.println();
		for (long x : arr)
			System.out.print(x + " ");
		
		System.out.println("\n");
	}
}
