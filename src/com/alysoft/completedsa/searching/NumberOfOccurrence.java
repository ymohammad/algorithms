package com.alysoft.completedsa.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a sorted array A of size N and a number X, you need to find the number of occurrences of X in A.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. 
Each testcase contains two lines of input: The first line contains N and X(element whose occurrence needs to be counted). 
The second line contains the elements of the array separated by spaces.

Output:
For each testcase, print the count of the occurrences of X in the array, if count is zero then print -1.
 * @author ymohammad
 *
 */
public class NumberOfOccurrence
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            String line = br.readLine();
			String[] split = line.split(" ");	
			int n = Integer.parseInt(split[0].trim());
			int k = Integer.parseInt(split[1].trim());
			
			int[] arr = new int[n];
			line = br.readLine();
			split = line.split(" ");
			int i=0;
			for (String s: split) {
				arr[i] = Integer.parseInt(s.trim());
				i++;
			}
			
			int x = getCount(arr, n, k);
			System.out.println(x);
            t--;
        }
	}

	private static int getCount(int[] arr, int n, int k)
	{
		int count = 0;
		for (int i=0; i<n; i++) {
			if (arr[i]== k) {
				count++;
			} else if (count > 0) {
				break;
			}
		}
		return count == 0 ? -1 : count;
	}
	private static int getCount1(int[] arr, int n, int k)
	{
		int mid = n/2;
		int start = 0;
		while (mid >0 && mid < n) {
			if (arr[mid] == k) {
				int count = 1;
				int i = mid-1;
				while (i>=0) {
					if (arr[i] == k) {
						count++;
					} else {
						break;
					}
					i--;
				}
				i = mid+1;
				while (i<n) {
					if (arr[i] == k) {
						count++;
					} else {
						break;
					}
					i++;
				}
				return count;
			} else {
				if (mid == n-1 || mid == 0) {
					break;
				}
				mid = (start + n)/2;
			}
			start = mid;
		}
		return -1;
	}
}
