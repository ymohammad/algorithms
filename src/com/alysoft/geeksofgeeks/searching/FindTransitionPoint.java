package com.alysoft.geeksofgeeks.searching;

import java.util.Scanner;

/**
 * You are given a sorted array containing only numbers 0 and 1. Find the transition point efficiently. 
 * Transition point is a point where "0" ends and "1" begins.

Input:

You have to complete the method which takes 2 argument: the array arr[] and size of array N. You should not 
read any input from stdin/console. There are multiple test cases. For each test cases, this method will be called individually.

Output:

Your function should return transition point.
 * Example:

	Input
	1
	5
	0 0 0 1 1
	
	Output
	3	
 * 
 * @author ymohammad
 *
 */
public class FindTransitionPoint
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n =sc.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
			System.out.println(transitionPoint(arr,n));
			T--;
		}	
	}
	static int transitionPoint(int arr[],int n) {
		return binarySearch(arr, 0, n-1);
    }
	private static int binarySearch(int[] arr, int start, int end)
	{
		if (start>end) return -1;
		
		int mid = (start+end)/2;
		if (mid>0 && arr[mid] == 1 && arr[mid-1]==0) {
			return mid;
		}
		if (arr[mid] == 0 && arr[mid+1] == 1) {
			return mid+1;
		}
		
		if (arr[mid] == 0) {
			return binarySearch(arr, mid+1, end);
		}
		return binarySearch(arr, start, mid-1);
	}
}
