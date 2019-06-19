package com.alysoft.algo.arrays;

/**
 * Given an array arr[] of N distinct integers, check if this array is Sorted (non-increasing or non-decreasing) and 
 * Rotated counter-clockwise. Note that input array may be sorted in either increasing or decreasing order, then rotated.
A sorted array is not considered as sorted and rotated, i.e., there should be at least one rotation.

Input:
The first line of input contains number of testcases T. Each testcase contains 2 lines, the first line contains N, the number 
of elements in array, and second line contains N space separated elements of array.

Output:
Print "Yes" if the given array is sorted and rotated, else Print "No", without Inverted commas.

User Task:
The task is to complete the function checkRotatedAndSorted() which checks if an array is sorted and rotated clockwise.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= A[i] <= 106

Example:
Input:
4
4
3 4 1 2
3
1 2 3
4
10 20 30 14
5
30 20 10 50 25

Output:
Yes
No
No
No

Explanation:
Testcase 1: The array is sorted (1, 2, 3, 4) and rotated twice (3, 4, 1, 2).
Testcase 2: The array is sorted (1, 2, 3) is not rotated.
Testcase 3: The array is sorted (10, 20, 30, 14) is not sorted and rotated as 14 is greater than 10.
 * @author ymohammad
 *
 */
public class ArraySortedAndRotated
{

	public static void main(String[] args)
	{
		//int[] arr = {3, 4, 1, 2};
		//int[] arr = {1, 2, 3};
		//int[] arr = {10, 20, 30, 14};
		int[] arr = {55, 52, 48, 35, 32, 30, 27, 23, 19, 17, 7, 2, 1, 9996, 9994, 9992, 9986, 9983, 9981};
		System.out.println("Is sorted :" + checkRotatedAndSorted(arr, arr.length));
	}
	public static boolean checkRotatedAndSorted(int arr[], int num){
        
		int d = -1;
		int i = 0;
		while (i<num-1 && arr[i]<arr[i+1]) {
			i++;
		}
		if (i == (num-1)) return false;
		
		if (i != 0) {
			d = i+1;
		}
		
		if (d == -1) {
			i = 0;
			while (i<num-1 && arr[i]>arr[i+1]) {
				i++;
			}
			if (i == (num-1)) return false;
			
			if (i != 0) {
				d = i+1;
			}
		}
		
		if (d == -1) return false;
		
		//reverseArray(arr, 0, num-1);
		reverseArray(arr, 0, d-1);
		reverseArray(arr, d, num-1);
		return isArraySorted(arr, num);
    }
	private static boolean isArraySorted(int[] arr, int n)
	{
		int i = 0;
		while (i<n-1 && arr[i]<arr[i+1]) {
			i++;
		}
		if (i == (n-1)) return true;
		
		i = 0;
		while (i<n-1 && arr[i]>arr[i+1]) {
			i++;
		}
		if (i == (n-1)) return true;
		
		return false;
	}
	private static void reverseArray(int[] arr, int low, int high)
	{
		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}
}
