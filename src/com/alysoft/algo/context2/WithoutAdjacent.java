package com.alysoft.algo.context2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array arr[] of N positive integers. The task is to find a subsequence with maximum sum such that there should be 
 * no adjacent elements from the array in the subsequence.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains size of array N. Next line 
contains N elements of the array space seperated.

Output:
For each testcase, print the maximum sum of the subsequence.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= arr[i] <= 106

Example:
Input:
2
3
1 2 3
3
1 20 3

Output:
4
20

Explanation:
Testcase 1: Elements 1 and 3 form a subsequence with maximum sum and no elements in the subsequence are adjacent in the array.
Testcase 2: Element 20 from the array forms a subsequence with maximum sum.
 * @author ymohammad
 *
 */
public class WithoutAdjacent
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
				
			int x = getMaxSumWithoutAdjacent(n, a);
			
			System.out.println(x);
            t--;
        }
	}

	private static int getMaxSumWithoutAdjacent(int n, int[] arr)
	{
		int maxInclusive = arr[0];
		int maxExclusive = 0;
		int temp;
		for (int i = 1; i<n; i++) {
			temp = Integer.max(maxInclusive, maxExclusive);
			maxInclusive = maxExclusive + arr[i];
			maxExclusive = temp;
		}
		return Integer.max(maxExclusive, maxInclusive);
	}
	public static int FindMaxSum(int n, int arr[]) 
    { 
        int maxInclusive = arr[0]; 
        int maxExclusive = 0; 
        int temp; 
        int i; 
  
        for (i = 1; i < n; i++) 
        { 
            /* current max excluding i */
            temp = Integer.max(maxInclusive, maxExclusive); //(maxInclusive > maxExclusive) ? maxInclusive : maxExclusive; 
  
            /* current max including i */
            maxInclusive = maxExclusive + arr[i]; 
            maxExclusive = temp; 
        } 
  
        /* return max of incl and excl */
        return Integer.max(maxInclusive, maxInclusive); //((maxInclusive > maxExclusive) ? maxInclusive : maxExclusive); 
    }
}
