package com.alysoft.geeksofgeeks.arrays;

import java.util.Scanner;

/**
 * Given an array A[], Your task is to complete the function printDuplicates which prints the duplicate elements 
 * of the given array. If no duplicate element is found  print -1. 
 * 
 * Note: Auxiliary Space must be O(1) and Time complexity must be O(n).
 * 
 * Constraints:
 * 1<=T<=100
 * 1<=N<=50
 * 0<=A[]<N
 * 
 * Method 1: This could be done using Hashing but extra space can't be used here.
 * 
 * Method 2: If we see the constraints, the array values are between o and N. If N is 5 then A[] would be 0 to 4.
 * Example: A[] = {0, 4, 4, 2, 2}
 * 
 * @author ymohammad
 *
 */
public class FindDuplicatesInAnArray
{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			printDuplicatesWithPercentage(a,n);
			System.out.println();
		}
	}
	
	private static void printDuplicatesWithPercentage(int[] a, int n) {
		if (n <= 1) {
			System.out.print("-1");
			return;
		}
		
		boolean isDuplicateFound = false;
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i<n; i++) {
			int foundInd = a[i]%n;
			System.out.println("Index i :" + i + " >>> Modulus :" + foundInd + " >>>> value a["+foundInd+"]:" + a[foundInd] + ">>> current val a[" + i + "]:" + a[i]);
			
			if (a[foundInd] >= n) {
				
				//Check it is the second or third repitation. If it is third then value will be greater than 2*n.
				if (a[foundInd] < 2*n) {
					sb.append(a[i]%n + " ");
					isDuplicateFound = true;
				}
			}
			a[foundInd] = a[foundInd] + n;
			printArray(a);
		}
		
		if (!isDuplicateFound) {
			System.out.print("-1");
			return;
		}
		System.out.println(sb.toString().trim());
	}
	private static void printDuplicatesWithNativeApp(int[] a, int n) {
		if (n <= 1) {
			System.out.print("-1");
			return;
		}
		
		for (int i = 0; i < n; i++)
		{
			if (a[Math.abs(a[i])] >= 0) {
				a[Math.abs(a[i])] = -1*a[Math.abs(a[i])];
			} else {
				System.out.print(Math.abs(a[i]) + " ");
			}
		}
		
	}
	private static void printDuplicates(int[] a, int n)
	{
		if (n <= 1) {
			System.out.print("-1");
			return;
		}
			

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++)
		{
			int ind = a[i] % n;
			a[ind] = a[ind] + n;
			if (a[ind] / n == 2)
			{
				sb.append(ind + " ");
			}
		}
		if (sb.length() == 0) {
			System.out.print("-1");
			return;
		}
		System.out.print(sb.toString().trim());
	}
	private static void printArray(int[] arr)
	{
		//System.out.println();
		for (long x : arr)
			System.out.print(x + " ");
		
		System.out.println("\n");
	}

}
