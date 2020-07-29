package com.alysoft.algo.sorting;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array A[] of N elements. The task is to complete the function which returns true if triplets exists 
 * in array A whose sum is zero else returns false.

Input Format:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. The first line of
 each test case contains an integer N, denoting the number of elements in array. The second line of each test case contains N space 
 separated values of the array.

Output:
For each test case, output will be 1 if triplet exists else 0.

Your Task:
Your task is to complete the function findTriplets() which check if the triplet with sum 0 exists or not. This is of boolean type 
which returns either true of false.

Constrains:
1 <= T <= 100
1 <= N <= 106
-106 <= A <= 106

Example:
Input:
2
5
0 -1 2 -3 1
3
1 2 3

Output:
1
0

Explanation:
Testcase 1: 0, -1 and 1 forms a triplet with sum equal to 0.
Testcase 2: No triplet exists which sum to 0.
 
 * @author ymohammad
 *
 */
public class FindTripletsWithZeroSum
{

	public static void main(String[] args)
	{
		int[] arr = {49, -73, 33, -47, 97, -96, 67, 6, 81, -24, 26, 73, 38, -24, 94, 7, 72, -6};
		//System.out.println("Value :" + findTriplets(arr, arr.length));
		System.out.println("Value :" + findTriplets2(arr, arr.length));
	}
	public static boolean findTriplets(int arr[] , int n)
    {
		Arrays.sort(arr);
		if (arr[0]>=0) return false;
		HashSet<Integer> hash = new HashSet<Integer>();
		for (int a : arr) {
		    hash.add(a);
		}
		//for (int i = 0; i<n; i++) {
			//int a = arr[i];
			int j = 0;
			int k = n-1;
			int sum;
			while (j<k) {
				sum = arr[j]+arr[k];
				if (hash.contains(-sum)) {
					return true;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		//}
		return false;
    }
	//a+b+c = 0 => b+c = -a => c = -a-b
	public static boolean findTriplets2(int arr[] , int n)
    {
		for (int i = 0; i<n; i++) {
			int a = arr[i];
			if(isTripletExist(arr, i+1, n-1, a)) {
				return true;
			}
		}
		return false;
    }
	public static boolean isTripletExist(int[] arr, int start, int end, int target) {
		HashSet<Integer> hash = new HashSet<Integer>();
		for (int i = start; i<=end; i++) {
			if (hash.contains(target-arr[i])) {
				return true;
			} else {
				hash.add(arr[i]);
			}
		}
		return false;
	}
	
	//
	public static boolean findTriplets3(int arr[] , int n)
    {
		Arrays.sort(arr);
		
		for (int i = 0; i<n; i++) {
			int a = arr[i];
			int j = i+1;
			int k = n-1;
			int sum;
			while (j<k) {
				sum = a+arr[j]+arr[k];
				if (sum == 0) {
					return true;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return false;
    }
	
	//Editorial solution.
	public boolean findTriplets4(int arr[],int n){
	    // sort the elements
		Arrays.sort(arr);
		
		// traversing the array elements
		for(int i=0;i<n-2;i++){
			int l=i+1;
			int r=n-1;
			int x=arr[i];
			
			// find the two elements which sum upto zero
			// with element at ith index
			while(l<r){
				
				// check if the sum is equal to 0
				if(x+arr[l]+arr[r]==0)
					return true;
				// else, if the sum is less than zero
				// then you need to take greater element
				else if(x + arr[l] + arr[r] < 0)
					l++;
				// If the sum is greater than 0
				// then you need to include some smaller elelment
				// instead of something greater
				else
					r--;
			}
		}
		return false;
	}
}
