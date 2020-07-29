package com.alysoft.algo.sorting;

/**
 * Given an array of N elements and a number K. The task is to arrange array elements according to the absolute difference with K, i. e., element having minimum difference comes first and so on.
Note : If two or more elements are at equal distance arrange them in same sequence as in the given array.

Input Format:
First line of input contains a single integer T which denotes the number of test cases. Then T test cases follows. 
First line of test case contains two space separated integers N and K. Second line of each test case contains N space separated integers.

Output Format:
For each test case print the given array in the order as described above.

Your Task:
This is a functional problem. You only need to complete the function sortABS(). The printing is done automatically by the driver code.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= K <= 105

Example:
Input:
3
5 7
10 5 3 9 2
5 6
1 2 3 4 5
4 5
2 6 8 3

Output:
5 9 10 3 2
5 4 3 2 1
6 3 2 8

Explanation:
Testcase 1: Sorting the numbers accoding to the absolute difference with 7, we have array elements as 5, 9, 10, 3, 2.
 
 * @author ymohammad
 *
 */
public class SortByAbsoluteDifference
{
	public static void main(String[] args)
	{
		int[] arr = {10, 5, 3, 9, 2};
		int k = 7;
		sortABS(arr, arr.length, k);
		printArray(arr);
		
		int[] arr1 = {1, 2, 3, 4, 5};
		k = 6;
		sortABS(arr1, arr1.length, k);
		printArray(arr1);
	}
	private static void printArray(int[] arr)
	{
		for (int x : arr) {
			System.out.print(x + " ");
		}
	}
	static void sortABS(int arr[], int n,int k)
    {
        // add your code here
		PairPoint[] pointArray = new PairPoint[n];
		for (int i = 0; i<n; i++) {
			PairPoint p = new PairPoint(arr[i], Math.abs(arr[i]-k));
			pointArray[i] = p;
		}
		mergeSort(pointArray, n);
		for (int i = 0; i<n; i++) {
			arr[i] = pointArray[i].getA();
		}
    }
	
	
	private static void mergeSort(PairPoint[] pointArray, int n)
	{
		if (n<2) return;
		
		int mid = n/2;
		PairPoint[] leftArr = new PairPoint[mid];
		PairPoint[] rightArr = new PairPoint[n-mid];
		
		for (int i = 0; i<mid; i++) {
			leftArr[i] = pointArray[i];
		}
		for (int i = 0; i<rightArr.length; i++) {
			rightArr[i] = pointArray[mid+i];
		}
		mergeSort(leftArr, leftArr.length);
		mergeSort(rightArr, rightArr.length);
		merge(pointArray, leftArr, rightArr);
	}

	private static void merge(PairPoint[] pointArray, PairPoint[] leftArr, PairPoint[] rightArr)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		int n = leftArr.length;
		int m = rightArr.length;
		while (i<n && j <m) {
			PairPoint p = leftArr[i];
			if (p.getB() <= rightArr[j].getB()) {
				pointArray[k] = p;
				i++;
			} else {
				pointArray[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i<n) {
			pointArray[k] = leftArr[i];
			i++; 
			k++;
		}
		while (j<m) {
			pointArray[k] = rightArr[j];
			j++; 
			k++;
		}
	}

	static class PairPoint {
		private int a = -1;
		private int b = -1;
		public PairPoint(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int getA() {
			return this.a;
		}
		public int getB() {
			return this.b;
		}
	}
}
