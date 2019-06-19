package com.alysoft.geeksofgeeks.sorting;

public class MergeSort
{
	public static void main(String[] args)
	{
		//int[] arr = {4, 5, 2, 3, 9, 7, 10, 12, 8, 32, 78, 11, 14, 25, 54, 36, 55, 87, 12};
		int[] arr = {};
		mergeSort(arr, arr.length);
		printArray(arr);
	}

	private static void printArray(int[] arr)
	{
		for (int x: arr) {
			System.out.print(x + " ");
		}
	}
	
	public static void mergeSort(int[] arr, int n) {
		if (n<2) return;
		
		int mid = (n)/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		
		for (int i=0; i<mid; i++) {
			left[i] = arr[i];
		}
		for (int i=mid; i<n; i++) {
			right[i-mid] = arr[i];
		}
		mergeSort(left, left.length);
		mergeSort(right, right.length);
		merge(left, right, arr);
	}

	private static void merge(int[] left, int[] right, int[] finalArr)
	{
		int n = left.length;
		int m = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while (i<n && j<m) {
			if (left[i]<right[j]) {
				finalArr[k] = left[i];
				i++;
			} else {
				finalArr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i<n) {
			finalArr[k] = left[i];
			i++;
			k++;
		}
		while (j<m) {
			finalArr[k] = right[j];
			j++;
			k++;
		}
	}
}
