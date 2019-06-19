package com.alysoft.geeksofgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Given an array A of positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 * 
 * Input:
	1
	9
	34 8 10 3 2 80 30 33 1
	
	Output:
	6
	
	Explanation:
	Testcase 1:  In the given array A[1] < A[7] satisfying the required condition(A[i] <= A[j]) 
	thus giving the maximum difference of j - i which is 6(7-1).
 * @author ymohammad
 *
 */
public class MaximumIndex
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
            HashMap<Long, Integer> hash = new HashMap<Long, Integer>();
			for(int i = 0; i < n; i++) {
				a[i]= Long.parseLong(arrayValues[i]);
				//hash.put(Long.parseLong(arrayValues[i]), i);
			}
				
			
			int x = getMaximumInd(a, n);
			//int x = getMaximumIndexUsingHash(hash, n);
			System.out.println(x);
            t--;
        }
	}
	public static int getMaximumInd(long[] a, int n) {
		long lMin[] = new long[n];
		long rMax[] = new long[n];
		
		lMin[0] = a[0];
		for (int i=1; i<n; i++) {
			lMin[i] = Math.min(lMin[i-1], a[i]);
		}
		System.out.println("Min Array :");
		printArray(lMin);
		
		rMax[n-1] = a[n-1];
		for (int j = n-2; j>=0; j--) {
			rMax[j] = Math.max(a[j], rMax[j+1]);
		}
		
		System.out.println("Max Array :");
		printArray(rMax);
		
		int i = 0; 
		int j = 0;
		int maxIndex = -1;
		while (i < n && j<n) {
			if (lMin[i]<rMax[j]) {
				maxIndex = Math.max(maxIndex, j-i);
				j++;
			} else {
				i++;
			}
		}
		return maxIndex;
	}
	private static int getMaximumIndexUsingHash(HashMap<Long, Integer> hash, int n)
	{
		int currentMax = -1;
		ArrayList<Long> keysList = new ArrayList<Long>(hash.keySet());
		Collections.sort(keysList);
		int j = n-1;
		for (int i = 0; i < keysList.size(); i++)
		{
			long x = keysList.get(i);
			long y = keysList.get(j);
			Integer firstIndex = hash.get(x);
			Integer secondIndex = hash.get(y);
			if (firstIndex < secondIndex && x<=y) {
				currentMax = secondIndex-firstIndex;
			}
			j--;
		}
		return currentMax;
	}
	
	private static int getMaximumIndex(long[] a, int n)
	{
		int currentMax = -1;
		for (int i = n-1; i>=0; i--) {
			for (int j = 0; j<n; j++) {
				
				if (a[j]<=a[i]) {
					if (currentMax < (i-j)) {
						currentMax = i-j;
					}
				}
			}
			if (i<n/2) {
				break;
			}
		}
		return currentMax;
	}
	
	private static void printArray(long[] arr)
	{
		//System.out.println();
		for (long x : arr)
			System.out.print(x + " ");
		
		System.out.println("\n");
	}
}
