package com.alysoft.algo.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a sorted array arr[] of size N without duplicates, and given a value x. 
 * Find the floor of x in given array. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements in the array and element whose floor is to be searched. Last line of input contains array elements.

Output:
Output the index of floor of x if exists, else print -1.

User Task:
The task is to complete the function findFloor() which finds the floor of x.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
1 ≤ arr[i] ≤ 1018
0 ≤ X ≤ arr[n-1]

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

Explanation:
Testcase 1: No element less than 0 is found. So output is "-1".
Testcase 2: Number less than 5 is 2, whose index is 1(0-based indexing).
 * @author ymohammad
 *
 */
public class FloorInSortedArray
{
	public static void main (String[] args)throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           System.out.println(findFloor(arr, 0, n-1, x));
          
        }
    }
	static int findFloor(long arr[], int left, int right, long x)
    {
		//x = 5
		//1 2 3 4 6
		//1 2 8 10 11 12 19
		if (left > right) return -1;
		
		long k = arr[right];
		if ( k <= x) {
			return right;
		}
		k = arr[left];
		if ( k > x) {
			return -1;
		}
        
		int mid = (left+right)/2;
		if (arr[mid] == x) {
			return mid;
		} else if (arr[mid] < x) {
			if ((mid+1) <= right && arr[mid+1] > x) {
				return mid;
			} 
			return findFloor(arr, mid+1, right, x);
		} else {
			if ((mid-1) >= left && arr[mid-1] <= x) {
				return mid-1;
			} 
			return findFloor(arr, left, mid-1, x);
		}
    }
}
