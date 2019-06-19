package com.alysoft.algo.binarysearch;

/**
 * Given a sorted array and an element x, count the number of occurences of x.
 * @author ymohammad
 *
 */
public class NumberOccurences
{
	public static void main(String[] args) {
		int[] arr = {2, 3, 3, 3, 3, 20, 40, 50};
		System.out.println("Occurence 3:" + getOccurences(arr, 3));
		System.out.println("Occurence 40:" + getOccurences(arr, 40));
		System.out.println("Occurence 1:" + getOccurences(arr, 1));
		System.out.println("Occurence 2:" + getOccurences(arr, 2));
		System.out.println("Occurence 50:" + getOccurences(arr, 50));
		
		int[] arr1 = {3, 3, 3, 3, 3, 3, 3, 3};
		System.out.println("Occurence 3:" + getOccurences(arr1, 3));
	}
	public static int getOccurences(int[] arr, int x) {
		int n = arr.length;
		int start = getFirstOccIndex(arr, x, n);
		if (start == -1) return 0;
		
		int end = getLastOccIndex(arr, x, n);
		start = start+1;
		end = end+1;
		int size = end-start+1;
		return size;
	}
	private static int getLastOccIndex(int[] arr, int x, int n)
	{
		int start = 0;
		int end = n-1;
		while (end >= start) {
			int mid = (start+end)/2;
			if (arr[mid] == x && (mid == n-1 || arr[mid+1] != x)) {
				return mid;
			} else if (x < arr[mid]) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		return -1;
	}
	private static int getFirstOccIndex(int[] arr, int x, int n)
	{
		int start = 0;
		int end = n-1;
		
		while (end >= start) {
			int mid = (start+end)/2;
			if (arr[mid] == x && (mid == 0 || arr[mid-1] != x)) {
				return mid;
			} else if (x > arr[mid]) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return -1;
	}
}
