package com.alysoft.algo.sorting;

public class SortingOnesTwosAndThrees
{
	public static void main(String[] args) {
		int[] arr = {1, 0, 0, 0, 1, 1, 2, 2, 2, 2, 0, 0, 1, 1};
		sortArray(arr, arr.length);
		printArray(arr);
		
		int[] arr1 = {0, 1, 2, 0, 1};
		sortArray(arr1, arr1.length);
		printArray(arr1);
	}
	public static void sortArray(int[] arr, int n) {
		int lo = 0;
		int hi = n-1;
		int mid = 0;
		while(mid<=hi) 
		{
			if (arr[mid] == 0) 
			{
				swap(arr, mid, lo);
				lo++;
				mid++;
			} else if (arr[mid] == 2) {
				swap(arr, mid, hi);
				hi--;
			} else {
				mid++;
			}
		}
	}

	private static void swap(int[] arr, int i, int s)
	{
		int temp = arr[i];
		arr[i] = arr[s];
		arr[s] = temp;
	}
	private static void printArray(int[] arr) {
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
