package com.alysoft.geeksforgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array A of N non-negative integers representing height of blocks at index i as Ai 
 * where the width of each block is 1. 
 * Compute how much water can be trapped in between blocks after raining.
 * @author ymohammad
 *
 */
public class TrappingRainWater
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
			
			int x = getRainWaterValue(a, n);
			
			System.out.println(x);
            t--;
        }
	}

	private static int getRainWaterValue(int[] a, int n)
	{
		int[] left = new int[n];
		int[] right = new int[n];
		
		left[0] = a[0];
		right[n-1] = a[n-1];
		int i = 1;
		while (i<n) {
			left[i] = Math.max(a[i], left[i-1]);
			i++;
		}
		//printArray(left);
		int j = n-2;
		while (j>=0) {
			right[j] = Math.max(a[j], right[j+1]);
			j--;
		}
		//printArray(right);
		int total = 0;
		int k = 1;
		while (k < n) {
			int leftMax = left[k];
			int rightMax = right[k];
			total += Math.max(Math.min(leftMax, rightMax)-a[k], 0);
			k++;
		}
		return total;
	}
	
	public static int getMax(int[] a, int startInd, int endInd) {
		int max = 0;
		for (int i =startInd; i <= endInd; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}
	private static void printArray(int[] arr)
	{
		//System.out.println();
		for (long x : arr)
			System.out.print(x + " ");
		
		System.out.println("\n");
	}
}
