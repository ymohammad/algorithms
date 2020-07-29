package com.alysoft.algo.binarysearch;

/**
 * Given a binary sorted non-increasing array arr of size N. You need to print the count of 1's in the binary array.

Input:
The input line contains T, denotes the number of testcases. Each input contains two lines. The first line contains N(size of binary array). The second line contains N elements of binary array separated by space.

Output:
For each testcase in new line, print the count 1's in binary array.

User Task:
The task is to complete the function countOne() which return count of 1s in the input array.

Constraint:
1 <= T <= 100
1 <= N <= 5*106
0 <= arr[i] <= 1

Example:
Input:
1
8
1 1 1 1 1 0 0 0

Output:
5

Explanation:
Testcase 1: Number of 1's in given binary array : 1 1 1 1 1 0 0 0 is 5.
 * @author ymohammad
 *
 */
public class Count1inBinaryArray
{
	static int arr[] = new int[5000001];
	public static void main(String[] args) {
		int[] a = {1, 1, 1, 1, 1, 0, 0, 0};
		int index = 0;
		for (int i : a) {
			arr[index]  = i;
			index++;
		}
		int n = a.length;
		System.out.println("Count Ones :" + countOnes(n));
	}
	public static int countOnes(int n){
        int start = 0; //getStartIndexOfOne(n);
        int lastIndex = getMaxInd(n);
        return lastIndex+1;
    }

	private static int getLastIndexOfOne(int n)
	{
		int start = 0;
		int end = n-1;
		
		int mid = (start+end)/2;
		while (start <= end) {
			if (arr[mid] == 1 && arr[mid+1] == 0) {
				return mid;
			} else if (arr[mid] < 1){
				end = mid-1;
			} else {
				start = mid+1;
			}
			mid = (start+end)/2;
		}
		return -1;
	}
	public static int getMaxInd(int n) {
        int low = 0;
        int high = n-1;
        while (high>=low) {
            int mid = (low+high)/2;
            if (arr[mid] == 1 &&(mid == n-1 || arr[mid+1] == 0)) {
                return mid;
            } else if (arr[mid] == 1){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return 0;
    }
	private static int getStartIndexOfOne(int n)
	{
		int start = 0;
		int end = n-1;
		
		int mid = (start+end)/2;
		while (start <= end) {
			if (arr[mid] == 1 && (mid-1)>=start && arr[mid-1] == 0) {
				return mid;
			} else if (arr[mid] < 1){
				start = mid+1;
			} else {
				end = mid-1;
			}
			mid = (start+end)/2;
		}
		return -1;
	}
}
