package com.alysoft.algo.sorting;

public class SortingTechniques
{
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pIndex = partitionArray(arr, start, end);
			quickSort(arr, start, pIndex-1);
			quickSort(arr, pIndex+1, end);
		}
	}
	private static int partitionArray(int[] arr, int start, int end)
	{
		int pivotValue = arr[end];
		int pIndex = start;
		for (int i = start; i<end; i++) {
			if (arr[i]<=pivotValue) {
				swapElement(arr, i, pIndex);
				pIndex++;
			}
		}
		swapElement(arr, pIndex, end);
		return pIndex;
	}
	public static void mergeSort(int[] arr, int n) {
		if (n <2) return;
		
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		
		for (int i = 0; i<mid; i++) {
			left[i] = arr[i];
		}
		int k = 0;
		for (int j = mid; j<n; j++) {
			right[k] = arr[j];
			k++;
		}
		
		mergeSort(left, left.length);
		mergeSort(right, right.length);
		merge(arr, left, right);
	}
	private static void merge(int[] arr, int[] left, int[] right)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < left.length && j < right.length) {
			if (left[i]<right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i<left.length) {
			arr[k] = left[i];
			k++;
			i++;
		}
		while (j<right.length) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}
	public static void insertionSort(int[] arr, int n) {
		for (int i=1; i<n; i++) {
			int hole = i;
			int holeValue = arr[hole];
			while (hole > 0 && arr[hole-1]>arr[hole]) {
				swapElement(arr, hole, hole-1);
				hole = hole-1;
			}
			arr[hole] = holeValue;
		}
	}
	public static void bubbleSort(int[] arr, int n) {
		for (int i = 0; i<n-1; i++) {
			boolean flag = false;
			for (int j = 0; j<n-i-1; j++) {
				if (arr[j]>arr[j+1]) {
					swapElement(arr, j, j+1);
					flag = true;
				}
			}
			if (!flag) break;
		}
	}
	public static void selectionSort(int[] arr, int n) {
		for (int i = 0; i<n; i++) {
			int minValueIndex = i;
			for (int j = i+1; j<n; j++) {
				if (arr[minValueIndex]>arr[j]) {
					minValueIndex = j;
				}
			}
			swapElement(arr, i, minValueIndex);
		}
	}
	public static void swapElement(int[] arr, int fromIndex, int toIndex)
	{
		int temp = arr[fromIndex];
		arr[fromIndex] = arr[toIndex];
		arr[toIndex] = temp;
	}
	public static void printArray(int[] arr) {
		for (int x: arr) {
			System.out.print(x + " ");
		}
		System.out.println("\nLength :" + arr.length);
	}
	public static void main(String[] args)
	{
		int[] arr = {2, 4, 5, 10, 1, 9, 32, 8, 11, 4, 3, 29, 45, 89, 5};
		System.out.println("Sending Array of length :" + arr.length);
		selectionSort(arr, arr.length);
		System.out.println("\nSelection Sort :");
		printArray(arr);
		
		System.out.println("\nBubble Sort :");
		int[] arr1 = {2, 4, 5, 10, 1, 9, 32, 8, 11, 4, 3, 29, 45, 89, 5};
		bubbleSort(arr1, arr1.length);
		printArray(arr1);
		
		System.out.println("\nInsertion Sort :");
		int[] arr2 = {10, 9, 8, 7, 6, 5, 4, 1, 2, 3};
		insertionSort(arr2, arr2.length);
		printArray(arr2);
		
		System.out.println("\nMerge Sort :");
		int[] arr3 = {10, 9, 8, 7, 6, 5, 4, 1, 2, 3};
		mergeSort(arr3, arr3.length);
		printArray(arr3);
		
		System.out.println("\nQuick Sort :");
		int[] arr4 = {10, 9, 8, 7, 6, 5, 4, 1, 2, 3};
		quickSort(arr4, 0, arr4.length-1);
		printArray(arr4);
		
		System.out.println("\nQuick Sort :");
		int[] arr5 = {7, 2, 1, 6, 8, 5, 3, 4};
		quickSort(arr5, 0, arr5.length-1);
		printArray(arr5);
	}
}
