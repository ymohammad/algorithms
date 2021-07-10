package com.alysoft.geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a sorted array arr[] without duplicates, and a value x. Find the floor of x in given array.
Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of 
elements in the array and element whose floor is to be searched. Last line of input contains array elements.

Output:
Output the index of floor of x if exists, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= arr[i] <= 1018
0 <= X <= arr[n-1]

Example:
Input:
3
7 0
1 2 8 10 11 12 19
7 5
1 2 8 10 11 12 19
7 10
1 2 8 10 11 12 19

Output:
-1
1
3
 * 
 * 
 * @author ymohammad
 *
 */
public class FloorSortedArray
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            String firstLine = br.readLine().trim();
            String[] arr = firstLine.split(" ");
            int n = Integer.parseInt(arr[0].trim());
            int x = Integer.parseInt(arr[1].trim());
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			for(String s: arrayValues) {
			    if (s !=null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			int z = getFloorIndex(a, x);
			
			System.out.println(z);
            t--;
        }
	}

	public static int getFloorIndex(int[] a, int x)
	{
		int start = 0;
		int end = a.length-1;
		int floorIndex = -1;
		int floorVal = Integer.MIN_VALUE;
		while (start<end) {
			int mid = (start+end)/2;
			if (a[mid] == x) {
				floorIndex = mid;
				break;
			} else if (x < a[mid]) {
				end = mid;
			} else {
				start = mid+1;
			}
			if (a[mid]<x && a[mid]>floorVal) {
				floorVal = a[mid];
				floorIndex = mid;
			}
		}
		return floorIndex;
	}
}
