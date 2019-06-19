package com.alysoft.algo.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A sorted array arr[] of size N which is rotated at some unknown point. The task is to find the minimum element in it. 
 * All the elements in the array are distinct.

Note: Expected time complexity is O(logN).

Input:
The first line of input contains an integer T denoting the number of test cases. 
Each test case contains the number of elements in the array arr[] as N and next line contains space separated n elements in the array arr[].

Output:
Print an integer which denotes the minimum element in the array.

User Task:
The task is to complete the function minNumber() which finds the minimum in sorted and rotated array.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= arr[i] <= 107

Example:
Input:
2
10
2 3 4 5 6 7 8 9 10 1
5
3 4 5 1 2

Output:
1
1

1
11
6 7 8 9 10 11 12 2 3 4 5
Explanation:
Testcase 1: The array is rotated once anti-clockwise. So minium element is at last index (n-1) which is 1.
 * @author ymohammad
 *
 */
public class MinimumNumberInSortedRotatedArray
{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            long n = Long.parseLong(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[(int)n];
            
            for(long i = 0; i < n; i++)
              arr[(int)i] = Integer.parseInt(st[(int)i]);
              
            System.out.println(minNumber(arr,0,n-1));
            
        }
	}
	static long minNumber(int arr[], long low, long high)
    {
		int rotatePointIndex = getRotateIndex(arr, arr.length);
		if (rotatePointIndex != -1)
			return arr[rotatePointIndex];
		return arr[0]; //array is not rotated.
    }

	private static int getRotateIndex(int[] arr, int length)
	{
		int start = 0;
		int end = length-1;
		
		while (start <= end) {
			int mid = (start+end)/2;
			if ((mid+1) <= end && arr[mid] > arr[mid+1]) {
				return mid+1;
			} else if ((mid-1)>= start && arr[mid] < arr[mid-1]) {
				return mid;
			} else {
				if (arr[mid] > arr[end]) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			}
		}
		return -1;
	}
}
