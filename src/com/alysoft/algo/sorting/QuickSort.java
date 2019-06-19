package com.alysoft.algo.sorting;

public class QuickSort
{
	public static void main(String[] args)
	{
		int[] arr = {4, 5, 2, 3, 9, 7, 10, 12, 8, 32, 78, 11, 14, 25, 54, 36, 55, 87, 12};
		//int[] arr = {5, 4, 3, 2, 1};
		quickSort(arr, 0, arr.length-1);
		printArray(arr);
	}
	public static void quickSort(int[] arr, int low, int high) {
		if (low <= high) {
			int pIndex = getPIndex(arr, low, high);
			quickSort(arr, low, pIndex-1);
			quickSort(arr, pIndex+1, high);
		}
	}

	private static int getPIndex(int[] arr, int low, int high)
	{
		int pivotVal = arr[high];
		int index = low;
		
		while (low < high) {
			if (arr[low] <= pivotVal) {
				swap(arr, low, index);
				index++;
			}
			low++;
		}
		swap(arr, index, high);
		return index;
	}

	private static void swap(int[] arr, int low, int index)
	{
		int temp = arr[low];
		arr[low] = arr[index];
		arr[index] = temp;
	}
	private static void printArray(int[] arr) {
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
