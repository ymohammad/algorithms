package com.alysoft.completedsa.sorting;

public class SelectionSort
{

	public static void main(String[] args)
	{
		int[] arr = {4, 5, 2, 3, 9, 7, 10, 12, 8};
		selectionSort(arr, arr.length);
		printArray(arr);
	}

	private static void printArray(int[] arr)
	{
		for (int x: arr) {
			System.out.print(x + " ");
		}
	}

	public static void selectionSort(int[] arr, int n) {
		for (int i=0; i<n; i++) {
			int minI = i;
			int j = i+1;
			while (j<n) {
				if (arr[minI]>arr[j]) {
					minI = j;
				}
				j++;
			}
			int temp = arr[minI];
			arr[minI] = arr[i];
			arr[i] = temp;
		}
	}
	
}
