package com.alysoft.algo.grokking.dc;

/**
 * Suppose you’re a farmer with a plot of land.
You want to divide this farm evenly into square plots. You want the plots
to be as big as possible. How do you figure out the largest square size you can use for a plot of
land?
 * @author ymohammad
 *
 */
public class MaxSizeSquare
{
	public static void main(String[] args) {
		System.out.println("Max Size Square (1680, 640):" + getMaxSizeSquare(1680, 640));
		System.out.println("Get sum implementation [2, 4, 6, 7]:" + getSum(new int[] {2, 4, 6, 7}, 0) );
		System.out.println("Search Element :" + searchElement(new int[] {2, 3, 4, 6, 7, 9}, 1, 0, 5));
	}
	public static int getMaxSizeSquare(int xMeters, int yMeters) {
		if (xMeters == 0) {
			return yMeters;
		} else if (yMeters == 0) {
			return xMeters;
		} else if (xMeters <= yMeters && (yMeters%xMeters) == 0) {
			return xMeters;
		} else if (yMeters <= xMeters && (xMeters%yMeters) == 0) {
			return yMeters;
		}
		
		int maxValue = Math.max(xMeters, yMeters);
		int minValue = Math.min(xMeters, yMeters);
		return getMaxSizeSquare(maxValue%minValue, minValue);
	}
	
	/**
	 * Other functions for Divide and Conquer exercise.
	 */
	public static int getSum(int[] arr, int startIndex)
	{
		if (startIndex == arr.length-1) return arr[startIndex];
		if (startIndex >= arr.length) return 0;
		
		return arr[startIndex] + getSum(arr, startIndex+1);
	}
	
	public static int searchElement(int[] arr, int x, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return -1;
		}
		int mid = startIndex+endIndex/2;
		if (arr[mid] == x) return mid;
		
		if (x < arr[mid]) {
			return searchElement(arr, x, startIndex, mid-1);
		} else {
			return searchElement(arr, x, mid+1, endIndex);
		}
	}
}
