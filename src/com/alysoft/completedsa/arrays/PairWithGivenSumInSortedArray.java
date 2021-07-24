package com.alysoft.completedsa.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * You are given an array A of size N. You need to find all pairs in the array that sum to a number K. 
 * If no such pair exists then output will be -1. The elements of the array are distinct and are in sorted order.
	Note: (a,b) and (b,a) are considered same. Also, an element cannot pair with itself, i.e., (a,a) is invalid.
 * @author ymohammad
 *
 */
public class PairWithGivenSumInSortedArray
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] arrayValues = line.split(" ");
            int[] a = new int[n];
			for(int i = 0; i < n; i++)
				a[i]= Integer.parseInt(arrayValues[i]);
			
			int k = Integer.parseInt(br.readLine());
			usingTwoPointerTech(a, n, k);
            t--;
        }
	}

	private static void printPossibleAllValues(int[] arr, int n, int k)
	{
		HashSet<Integer> valuesSet = new HashSet<Integer>();
		
		for (int a: arr) {
			valuesSet.add(a);
		}
		boolean isFound = false;
		for (int a: arr) {
			int b = k-a;
			if (valuesSet.contains(b)) {
				if (a != b) {
					System.out.println(a + " " + b + " " + k);
					valuesSet.remove(a);
					valuesSet.remove(b);
					isFound = true;
				}
			} else {
				valuesSet.add(a);
			}
		}
		if (!isFound) {
			System.out.println("-1");
		}
	}
	private static void usingTwoPointerTech(int[] a, int n, int k) {
		int i = 0;
		int j = n-1;
		
		boolean isFound = false;
		while (i<j) {
			if (a[i] + a[j] < k) {
				i++;
			} else if (a[i]+a[j]>k) {
				j--;
			} else {
				isFound = true;
				System.out.println(a[i] + " " + a[j] + " " + k);
				i++;
				j--;
			}
		}
		if (!isFound) System.out.println("-1");
	}
}
