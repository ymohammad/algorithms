package com.alysoft.algo.sorting;

/**
 * Given an array arr[] of N integers which is closer sorted (defined below) and an element x. The task is to find index of the element x 
 * if it is present. If not present, then print -1.

Closer Sorted: First array is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e, may be to 
the arr[i+1] or arr[i-1].

Expected Time Complexity: O(Log N)

Input Format:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements in the array. 
Next line contains the array elements. Last line contains the element to be searched.

Output Format:
Output the index at which the element is present (0-based), if present, else print "-1".

Your Task:
This is a function problem. You only need to complete the function closer() that arr, N, and x as parameters and returns the index. 
If element is not present, return -1.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= arr[i] <= 106

Example:
Input:
1
5
3 2 10 4 40
2

Output:
1

Explanation:
Testcase 1: 2 is present at index 1 (0-based indexing) in the given array.
 * @author ymohammad
 *
 */
public class CloserToSort
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
