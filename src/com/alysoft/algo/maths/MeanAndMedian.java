package com.alysoft.algo.maths;

import java.util.Arrays;

/**
 * Given an array a[ ] of size N. The task is to find the median and mean of the array elements.

Input Format: 
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. 
Each test case consist of two line input, 1st line is the size of array and the 2nd line is the array elements.

Output Format: 
For each testcase, in a new line, print the space separated mean and median of the array elements.

Your Task:
This is a function problem. You just need to complete the following two function:

mean(): It takes the array and its size N as parameters and returns the mean as an integer.
median(): It takes the array and its size N as parameters and returns the median as an integer.
Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= a[i] <= 106

Example:
Input:
2
5
1 2 19 28 5
4
2 8 3 4

Output:
11 5
4 3

Explanation:
Testcase 1: For array of 5 elements , mean and median are 11 and 5 respectively.
 * @author ymohammad
 *
 */
public class MeanAndMedian
{
	public int median(int A[],int N)
    {
		Arrays.sort(A);
       //Your code here
       //If median is fraction then conver it to integer and return
		if (N%2 == 0) {
			int mid = (N/2);
			int finalVal = (A[mid-1] + A[mid])/2;
			return finalVal;
		} else {
			return A[N/2];
		}
    }
    
    public int mean(int A[],int N)
    {
       int total = 0;
       for (int x : A) {
    	   total += x;
       }
       int finalVal = (total/A.length);
       return finalVal;
    }
}
