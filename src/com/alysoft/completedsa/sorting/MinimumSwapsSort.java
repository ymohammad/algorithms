package com.alysoft.completedsa.sorting;

import java.util.Scanner;

/**
 * Given an array of N distinct elementsA[ ], find the minimum number of swaps required to sort the array.Your are required 
 * to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.
 * 
 * Examples:

	Input : {4, 3, 2, 1}
	Output : 2
	Explanation : Swap index 0 with 3 and 1 with 2 to 
	              form the sorted array {1, 2, 3, 4}.
	
	Input : {1, 5, 4, 3, 2}
	Output : 2
 * @author ymohammad
 *
 */
public class MinimumSwapsSort
{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int[] a=new int[n];
			for(int i = 0; i<n ; i++){
				a[i]=sc.nextInt();
			}
			System.out.println(minSwaps(a,n));
		}
	}
	public static int minSwaps(int[] A, int N) {//add code here.
		int swapCount = 0;
		for (int i = 0; i<N; i++) {
			int iMin = i;
			boolean isIndChanged = false;
			for (int j = i+1; j<N; j++) {
				if (A[j] < A[iMin]) {
					iMin = j;
					isIndChanged = true;
				}
			}
			if (isIndChanged) {
				swap(A, iMin, i);
				swapCount++;
			}
		}
		return swapCount;
	}
	private static void swap(int[] a, int iMin, int i)
	{
		int temp = a[iMin];
		a[iMin] = a[i];
		a[i] = temp;
	}
}
