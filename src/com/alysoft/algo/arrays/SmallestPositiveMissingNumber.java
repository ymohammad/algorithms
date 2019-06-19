package com.alysoft.algo.arrays;

/**
 * You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
Note: Expected solution in O(n) time using constant extra space.

Input:
First line consists of T test cases. First line of every test case consists of N, denoting the number of elements in array. 
Second line of every test case consists of elements in array.

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
public class SmallestPositiveMissingNumber
{

	public static void main(String[] args)
	{
		int[] arr = {0, -10, 1, 3, -20};
		//int[] arr = {1, 2, 3, 4, 5};
		System.out.println(missingNumber(arr, arr.length));
	}
	static int missingNumber(int arr[], int size)
    {
        int high = size-1;
        int index = 0;
        while (index<high) {
            if (arr[index]<=0) {
                swap(arr, index, high);
                high--;
            } else {
                index++;
            }
        }

        for (int i=0; i<=index; i++) {
            int currVal = Math.abs(arr[i]);
            if ((currVal-1) <=index && arr[currVal-1]>0) {
                arr[currVal-1] = arr[currVal-1]*-1;
            }
        }
        for (int i=0; i<=index; i++) {
            if (arr[i] > 0) {
                return i+1;
            }
        }
        return index+2;
    }
    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
