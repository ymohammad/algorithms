package com.alysoft.geeksforgeeks.sorting;

public class RadixSort
{
	public static void radixSort(int[] arr, int n) {
		int maxVal = getMaxValue(arr);
		int exp = 1;
		while ((maxVal/exp)>0) {
			countSort(arr, n, exp);
			exp *= 10;
		}
	}
	private static void countSort(int[] arr, int n, int exp)
	{
		int[] countArr = new int[10];
		for (int x:arr) {
			countArr[(x/exp)%10]++;
		}
		
		for (int i=1; i<10; i++) {
			countArr[i] += countArr[i-1];
		}
		
		int[] output = new int[n];
		
		for (int i=n-1; i>=0; i--) {
			output[countArr[(arr[i]/exp)%10]-1] = arr[i];
			--countArr[(arr[i]/exp)%10];
		}
		for (int i = 0; i < n; i++) 
            arr[i] = output[i];
		
	}
	private static int getMaxValue(int[] arr)
	{
		int maxVal = Integer.MIN_VALUE;
		for (int x: arr) {
			if (x>maxVal) maxVal = x;
		}
		return maxVal;
	}
	public static void printArray(String msg, int[] arr) {
		System.out.print(msg);
		for (int x: arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		
		int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
		radixSort(arr, arr.length);
		printArray("Sorted Array:", arr);
	}

}
