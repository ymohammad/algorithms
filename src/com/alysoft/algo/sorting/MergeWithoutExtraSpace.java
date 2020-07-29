package com.alysoft.algo.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted 
 * arrays into one sorted array (in non-decreasing order).

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

Input: arr1[] = {10};
       arr2[] = {2, 3};
Output: arr1[] = {2}
        arr2[] = {3, 10}  

Input: arr1[] = {1, 5, 9, 10, 15, 20};
       arr2[] = {2, 3, 8, 13};
Output: arr1[] = {1, 2, 3, 5, 8, 9}
        arr2[] = {10, 13, 15, 20} 
Input Format:
First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, 
denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. 
Third line of each test case contains Y space separated integers, denoting the second array Q.

Output Format:
For each test case, print (X + Y) space separated integer representing the merged array.

Your Task:
This is a function problem. You only need to complete the function merge() that takes n and m as parameters.

Constraints:
1 <= T <= 100
1 <= X, Y <= 5*104
0 <= arr1i, arr2i <= 109

Example:
Input:
2
4 5
1 3 5 7
0 2 6 8 9
2 3
10 12
5 18 20

Output:
0 1 2 3 5 6 7 8 9
5 10 12 18 20

Explanation:
Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.

 
 * @author ymohammad
 *
 */
public class MergeWithoutExtraSpace
{
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    int arr1[] = new int[n];
		    int arr2[] = new int[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Integer.parseInt(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
	public static void merge(int arr1[], int arr2[], int n, int m) 
    {
		int gap = m+n;
		gap = getGap(gap);
		int i = 0;
		int j = 0;
		
		while (gap>0) {
			//swap elements in the first array.
			for (i = 0; i+gap<n; i++) {
				if (arr1[i] > arr1[i+gap]) {
					swap(arr1, i, i+gap);
				}
			}
			
			//Swap elements in second arrays
			j = gap > n ? (gap-n) : 0;
			while (j<m && i<n) {
				if (arr1[i]>arr2[j]) {
					int temp = arr2[j];
					arr2[j] = arr1[i];
					arr1[i] = temp;
				}
				i++;
				j++;
			}
			if (j<m) {
				for (j = 0; j+gap<n; j++) {
					if (arr2[j] > arr2[j+gap]) {
						swap(arr2, j, j+gap);
					}
				}
			}
			gap = getGap(gap);
		}
		
    }
	public static void merge1(int arr1[], int arr2[], int n, int m) 
    {
		/*
		int gap = m+n;
		gap = getGap(gap);
		int i = 0;
		int j = 0;
		
		while (gap>0) {
			//swap elements in the first array.
			for (i = 0; i+gap<n; i++) {
				if (arr1[i] > arr2[i+gap]) {
					swap(arr1, i, i+gap);
				}
			}
			
			//Swap elements in both arrays
			j = gap > n ? (gap-n) : 0;
			while (j<)
		}*/
		int totalSize = n+m;
		int i = 1;
		int x = i;
		while(i<totalSize) {
			
			int temp;
			if (i<n) {
				temp = arr1[x];
			} else {
				temp = arr2[x-n];
			}
			int holeIndex = i;
			while (holeIndex>0 && getArrElm(arr1, arr2, holeIndex-1)>temp) {
				swapElements(arr1, arr2, holeIndex, holeIndex-1);
				holeIndex--;
			}
			setElement(arr1, arr2, holeIndex, temp);
			x++;
		}
    }
	private static void setElement(int[] arr1, int[] arr2, int givenIndex, int temp)
	{
		int n = arr1.length;
		if (givenIndex>=n) {
			arr2[givenIndex-n-1] = temp;
		} else {
			arr1[givenIndex] = temp;
		}
	}
	private static void swapElements(int[] arr1, int[] arr2, int fromIndex, int toIndex)
	{
		int n = arr1.length;
		int m = arr2.length;
		if (toIndex>=n && fromIndex>=n) {
			swap(arr2, toIndex-fromIndex-1, toIndex-n-1);
		} else if (toIndex>=n && fromIndex<n) {
			int temp = arr2[toIndex-n];
			arr2[toIndex-n] = arr1[fromIndex];
			arr1[fromIndex] = temp;
		} else if (toIndex<n && fromIndex<n) {
			swap(arr1, toIndex, fromIndex);
		} else if (toIndex<n && fromIndex>=n) {
			int temp = arr2[fromIndex-n];
			arr2[fromIndex-n] = arr1[toIndex];
			arr1[toIndex] = temp;
		} else {
			System.out.println("INvalid case.." + fromIndex + ", " + toIndex);
		}
	}
	private static int getArrElm(int[] arr1, int[] arr2, int i)
	{
		int n = arr1.length;
		int m = arr2.length;
		if (i>=n) {
			return arr2[i-n];
		} else {
			return arr1[i];
		}
	}
	private static void swap(int[] arr, int i, int j)
	{
		int temp  = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static int getGap(int gap) {
		if (gap<=1) return 0;
		
		return (gap/2)+(gap%2);
	}
}
