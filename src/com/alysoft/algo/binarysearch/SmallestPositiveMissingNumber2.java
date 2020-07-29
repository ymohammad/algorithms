package com.alysoft.algo.binarysearch;

/**
 * You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
Note: Expected solution in O(n) time using constant extra space.

Input:
First line consists of T test cases. First line of every test case consists of N, denoting the number of elements in array. Second line of every test case consists of elements in array.

Output:
Single line output, print the smallest positive number missing.

User Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.

Constraints:
1 <= T <= 100
1 <= N <= 106
-106 <= arr[i] <= 106

Example:
Input:
2
5
1 2 3 4 5
5
0 -10 1 3 -20
Output:
6
2

Explanation:
Testcase 1: Smallest positive missing number is 6.
Testcase 2: Smallest positive missing number is 2.
 * @author ymohammad
 *
 */
public class SmallestPositiveMissingNumber2
{
	public static void main(String[] args) {
		int[] arr = {0, -10, 1, 3, -20};
		System.out.println(missingNumber(arr, arr.length));
		
		int[] arr1 = {1, 2, 3, 4, 5};
		System.out.println(missingNumber(arr1, arr1.length));
	}
	static int missingNumber(int arr[], int size)
    {
        
        // Your code here
        // You can add utility functions (if required)
        int[] possitiveArr = getPossitiveArray(arr, size);
        int n = possitiveArr.length;
        for (int i = 0; i<n; i++) {
            int x = Math.abs(possitiveArr[i])-1;
            if (x<n && possitiveArr[x]>0) {
            	possitiveArr[x] = -possitiveArr[x];
            }
        }
        for (int i = 0; i<n; i++) {
            if (possitiveArr[i]>0) {
                return (i+1);
            }
        }
        return n+1;
    }
    static int[] getPossitiveArray(int arr[], int size) {
        int start = 0;
        int end = size-1;
        while (start<=end) {
            if (arr[start]>0) {
                swap(arr, start, end);
                end--;
            } else {
                start++;
            }
        }
        int[] newArr = new int[size-start];
        int j = 0;
        for (int i=start; i<size; i++) {
            newArr[j] = arr[i];
            j++;
        }
        return newArr;
    }
    static void swap(int arr[], int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
