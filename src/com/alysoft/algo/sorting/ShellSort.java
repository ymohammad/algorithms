package com.alysoft.algo.sorting;

public class ShellSort
{

	public static void main(String[] args)
	{
		int arr[] = {12, 34, 54, 2, 3, 1, 6, 17, 45, 99, 0, -1, -2};
		performShellSort(arr, arr.length);
		printArray(arr);
	}
	private static void printArray(int[] arr)
	{
		for (int x: arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	public static void performShellSort(int[] arr, int n)
	{
		int swapCount = 0;
		int loopCount = 0;
		/*
		int gap = getGap(n);
		while (gap > 0) {
			int i = 0;
			loopCount++;
			while (i < n && (i+gap)<n)
			{
				loopCount++;
				if (arr[i]>arr[i+gap]) {
					swapElements(arr, i, i+gap);
					swapCount++;
				}
				i++;
			}
			gap = getGap(gap);
		}
		*/
		System.out.println("Total Swap for gap :" + swapCount);
		System.out.println("Total loopCount for gap :" + loopCount);
		swapCount = 0;
		loopCount = 0;
		for (int i = 1; i<n; i++) {
			int temp = arr[i];
			int holeIndex = i;
			loopCount++;
			while (holeIndex>0 && arr[holeIndex-1]>temp) {
				swapElements(arr, holeIndex, holeIndex-1);
				holeIndex--;
				swapCount++;
				loopCount++;
			}
			arr[holeIndex] = temp;
		}
		System.out.println("Total Swap for gap :" + swapCount);
		System.out.println("Total loopCount for gap :" + loopCount);
	}
	private static void swapElements(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static int getGap(int n)
	{
		if (n<=0) return 0;
		
		return n/2;
	}
}
