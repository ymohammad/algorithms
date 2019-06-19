package com.alysoft.geeksofgeeks.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Given two sorted arrays A and B. The task is to complete the function max_path_sum that takes 4 argument, 
 * the first two arguments represent the 2 arrays A[] and B[] and the last two arguments l1, l2 denote the size of array A and B respectively. 
 * The function returns the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays .

	Note: You can switch from one array to another array only at common elements.
	
	2
	5 4
	2 3 7 10 12
	1 5 7 8 
	3 3
	1 2 4
	1 2 7
	
	Output
	35 
	10
	
	Explanation:
	Testcase 1: For first test case the path will be 1+5+7+10+12 = 35.
	Testcase 2: For second test case the path will be 1+2 +7=10.
 * @author ymohammad
 *
 */
public class MaxSumPathInTwoArrays
{

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int ar1[] = new int[m];
			int ar2[] = new int[n];
			for(int i=0; i<m; i++)
				ar1[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				ar2[i] = sc.nextInt();
		
		System.out.println(maxPathSum(ar1,ar2));
		T--;
		}
	}
	public static int maxPathSum(int ar1[], int ar2[])
    {
		int m = ar1.length;
		int n = ar2.length;
		int result = 0, sum1 = 0, sum2 = 0, i = 0, j = 0;
		
		while (i < m && j < n) {
			if (ar1[i]<ar2[j]) {
				sum1 += ar1[i];
				i++;
			} else if (ar1[i] > ar2[j]) {
				sum2 += ar2[j];
				j++;
			} else {
				result += Math.max(sum1, sum2);
				sum1 = 0;
				sum2 = 0;
				while (i < m && j < n && ar1[i] == ar2[j]) {
					result += ar1[i];
					i++; j++;
				}
			}
		}
		while (i<m) {
			sum1 += ar1[i];
			i++;
		}
		while (j<n) {
			sum2 += ar2[j];
			j++;
		}
		result += Math.max(sum1, sum2);
		return result;
    }
	public static int maxPathSum1(int ar1[], int ar2[])
    {
		int sum = 0;
		int sum1 = 0; 
		int sum2 = 0;
		
		int l1 = ar1.length;
		int l2 = ar2.length;
		int[] maxArray = (l1 > l2)? ar1 : ar2;
		int[] minArray = (l1 > l2)? ar2 : ar1;
	
		HashMap<Integer, Integer> minValuesSet = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> maxValuesSet = new HashMap<Integer, Integer>();
		
		for (int x : minArray) {
			sum1 = sum1 + x;
			minValuesSet.put(x, sum1);
		}
		for (int y : maxArray) {
			sum2 = sum2 + y;
			maxValuesSet.put(y, sum2);
		}
		
		System.out.println(" minValuesSet :" + minValuesSet);
		System.out.println(" maxValuesSet :" + maxValuesSet);
		sum1 = 0;
		sum2 = 0;
		int prevSum1 = 0;
		int prevSum2 = 0;
		for (int x : minArray) {
		
			if (maxValuesSet.containsKey(x)) {
				if (prevSum1 != 0 && prevSum1 != prevSum2) {
					prevSum1 = minValuesSet.get(x) - prevSum1;
					prevSum2 = maxValuesSet.get(x) - prevSum2;
				} else {
					prevSum1 = minValuesSet.get(x);
					prevSum2 = maxValuesSet.get(x);
				}
				
				System.out.println("FOund common index :" + x + " prevSum1 :" + prevSum1 + " >>> prevSum2 :" + prevSum2);
				sum += Math.max(prevSum2, prevSum1);
				System.out.println("SUm Value :" + sum);
			}
		}
		
		prevSum1 = minValuesSet.get(minArray[minArray.length-1]) - prevSum1;
		prevSum2 = maxValuesSet.get(maxArray[maxArray.length-1]) - prevSum2;
		System.out.println("FOund common index :final prevSum1 :" + prevSum1 + " >>> prevSum2 :" + prevSum2);
		sum += Math.max(prevSum2, prevSum1);
		return sum;
    }
	/*
	public static int maxPathSum(int ar1[], int ar2[])
    {
		int l1 = ar1.length;
		int l2 = ar2.length;
		int[] maxArray = (l1 > l2)? ar1 : ar2;
		int[] minArray = (l1 > l2)? ar2 : ar1;

		int sum = 0;
		int startIndex = Math.abs(l2-l1);
		if (startIndex > 0) {
			int temp = maxArray.length-startIndex;
			while (temp < maxArray.length) {
				sum = sum + maxArray[temp];
				temp++;
			}
		} else {
			int n = minArray.length;
			minArray = (minArray[n-1] < maxArray[n-1]) ? minArray : maxArray;
			maxArray = (minArray[n-1] < maxArray[n-1]) ? maxArray : minArray;
		}
		
		return loopNPrintSum(sum, minArray, maxArray);
    }*/
	public static int loopNPrintSum(int sum, int[] minArray, int[] maxArray) {
		boolean isArraySwitch = false;
		for (int i = (minArray.length-1); i>=0; i--) {
			if (!isArraySwitch) {
				sum = sum + maxArray[i];
			} else {
				sum = sum + minArray[i];
			}
			if (maxArray[i] == minArray[i]) {
				isArraySwitch = true;
			}
		}
		return sum;
	}
}
