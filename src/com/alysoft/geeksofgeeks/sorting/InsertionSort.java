package com.alysoft.geeksofgeeks.sorting;

public class InsertionSort
{

	public static void main(String[] args)
	{
		int[] arr = {4, 5, 2, 3, 9, 7, 10, 12, 8};
		insertionSort(arr, arr.length);
		printArray(arr);
	}

	private static void printArray(int[] arr)
	{
		for (int x: arr) {
			System.out.print(x + " ");
		}
	}
	public static void insertionSort(int[] arr, int n) {
		
		for(int j=1; j<n; j++) {
			int hole = j;
			int newValue = arr[j];
			while (hole > 0 && arr[hole-1]>newValue) {
				arr[hole] = arr[hole-1];
				hole = hole-1;
			}
			arr[hole] = newValue;
		}
	}
}
