package com.alysoft.algo.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an array A[] of N numbers and another number x. The task is to determine whether or not there exist three 
 * elements in A[] whose sum is exactly x.

Input Format:
First line of input contains number of testcases T. For each testcase, first line of input contains n and x. Next line contains array elements.

Output Format:
Print "1" (without quotes) if there exist three elements in A whose sum is exactly x, else "0" (without quotes).

Your Task:
This is a function problem. You only need to complete the function find3Numbers() that takes A, arr_size, and sum as parameters 
and returns true or false.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 103
1 ≤ A[i] ≤ 105

Example:
Input:
2
6 13
1 4 45 6 10 8
5 10
1 2 4 3 6

Output:
1
1

Explanation:
Testcase 1: There is one triplet with sum 13 in the array. Triplet elements are 1, 4, 8, whose sum is 13.
 * @author ymohammad
 *
 */
public class TripletSumInArray
{

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int x = Integer.parseInt(inputLine[1]);
		    int arr[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    System.out.println(find3Numbers(arr, n, x));
		}
	}
	public static int find3Numbers(int A[], int n, int x) { 
	    
	       //add your code here 
	        Arrays.sort(A);

	        if (A[0]>x) return 0;
	        System.out.println("X :" + x);
	        int target = 0;
	        for (int i=0; i<n-2; i++) {
	            target = Math.abs(x-A[i]);
	            if (isTwoNumberTargetExist(A, n, i+1, n-1, target)) {
	            	System.out.println(A[i]);
	                return 1;
	            }
	        }
	        return 0;
	        
	    }
	    static boolean isTwoNumberTargetExist(int A[], int n, int start, int end, int target) {
	        if (A[start]>target) return false;
	        
	        int sum = 0;
	        while (start<end) {
	            sum = A[start] + A[end];
	            if (sum == target) {
	            	System.out.println(target + " Numbers Are :" + A[start] + ", " + A[end]);
	                return true;
	            } else if (sum < target) {
	                start++;
	            } else {
	                end--;
	            }
	        }
	        return false;
	    }
}
