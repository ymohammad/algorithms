package com.alysoft.geeksofgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChocolateDistributionProblem
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
            long[] a = new long[n];
			for(int i = 0; i < n; i++)
				a[i]= Long.parseLong(arrayValues[i]);
			
			int x = Integer.parseInt(br.readLine());
			
			distributeChocolate(a, x, n);
            t--;
        }
	}

	// Find the subarray of size m  
    // such that difference between  
    // last (maximum in case of  
    // sorted) and first (minimum in 
    // case of sorted) elements of  
    // subarray is minimum. 
	private static void distributeChocolate(long[] a, int studentCount, int n)
	{
		if (a == null || studentCount == 0 || studentCount > n || n==0) return;
		
		Arrays.sort(a);
		long minDiff = Long.MAX_VALUE;
		int firstInd = 0;
		int lastInd = 0;
		for (int i = 0; (i+studentCount-1)<n; i++) {
			if (minDiff > (a[i+studentCount-1]-a[i])) {
				minDiff = a[i+studentCount-1]-a[i];
				firstInd = i;
				lastInd = i+studentCount-1;
			}
		}
		System.out.println(minDiff);
	}
}
