package com.alysoft.algo.arrays;

public class MaximumIndex
{

	public static void main(String[] args)
	{
		//int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		int[] arr = {1, 10};
		System.out.println("Max Index :" + maxIndexDiff(arr, arr.length));
	}
	static int maxIndexDiff(int arr[], int n) { 
        
		int[] leftMinArray = new int[n];
		int[] rightMaxArray = new int[n];
		leftMinArray[0] = arr[0];
		for (int i=1; i<n; i++) {
			leftMinArray[i] = Math.min(leftMinArray[i-1], arr[i]);
		}
		
		rightMaxArray[n-1] = arr[n-1];
		for (int i=n-2; i>=0; i--) {
			rightMaxArray[i] = Math.max(rightMaxArray[i+1], arr[i]);
		}
		
		int indexDiff = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex<n && rightIndex<n) {
			int leftValue = leftMinArray[leftIndex];
			int localDiff = 0;
			while (rightIndex<n && leftValue<=rightMaxArray[rightIndex]) {
				localDiff = rightIndex-leftIndex;
				rightIndex++;
			}
			indexDiff = Math.max(indexDiff, localDiff);
			leftIndex++;
		}
		return indexDiff;
    }
}
