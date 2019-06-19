package com.alysoft.geeksofgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSubArray
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
            int[] a = new int[n];
            int i = 0;
			for(String s : arrayValues) {
			    if (s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
			printMaxSubArray(a, n);
            t--;
        }
	}
	
	public static void printMaxSubArray(int a[], int n) {
		int maxSum = 0;
		int maxStartIndex = 0;
		int maxEndIndex = n-1;
		int startIndex = 0;
		int endIndex = n-1;
		
		int tempSum = 0;
		int i = 0;
		while (i<n && a[i]<0) {
			i++;
		}
		startIndex = i;
		while (i<n) {
			if (a[i] < 0) {
				if (maxSum <= tempSum) {
					maxSum = tempSum;
					maxStartIndex = startIndex;
					maxEndIndex = i-1;
				}
				tempSum = 0;
				startIndex = i+1;
				endIndex = i+1;
			} else {
				tempSum = tempSum + a[i];
				endIndex = i;
			}
			i++;
		}
		if (maxSum < tempSum) {
			maxStartIndex = startIndex;
			maxEndIndex = endIndex;
		}
		StringBuffer buff = new StringBuffer();
		for (int x = maxStartIndex; x<=maxEndIndex; x++) {
			buff.append(a[x] + " ");
		}
		System.out.println(buff.toString().trim());
	}
	private static void printArray(int[] arr)
	{
		//System.out.println();
		for (long x : arr)
			System.out.print(x + " ");
		
		System.out.println("\n");
	}
}
