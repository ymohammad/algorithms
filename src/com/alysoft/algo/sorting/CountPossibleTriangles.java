package com.alysoft.algo.sorting;

import java.util.Arrays;

/**
 * Given an unsorted array arr of positive integers. Find the number of triangles that can be formed with three different 
 * array elements as lengths of three sides of triangles. 

Input Format: 
The first line of the input contains T denoting the number of testcases. First line of test case is the length of array N and second 
line of test case are its elements.

Output Format:
Number of possible triangles are displayed to the user.

Your Task:
This is a function problem. You only need to complete the function findNumberOfTriangles() that takes N as parameter and returns the 
count of total possible triangles.

Constraints:
1 <= T <= 10
3 <= N <= 103
1 <= arr[i] <= 103

Example:
Input:
2
3
3 5 4
5
6 4 9 7 8

Output:
1
10

Explanation:
Testcase 1: A triangle is possible with all the elements 5, 3 and 4.
 * @author ymohammad
 *
 */
public class CountPossibleTriangles
{

	public static void main(String[] args)
	{
		int[] arr = {6, 4, 9, 7, 8};
		long count = findNumberOfTriangles(arr, arr.length);
		System.out.println("CountPossibleTriangles.main()" + count);
	}
	static long findNumberOfTriangles(int arr[], int n)
    {
        // add your code here
        long returnVal = 0L;
        Arrays.sort(arr);
        int i = 0; 
        int j = i+1;
        int k = j+1;
        while (i<n-2) {
        	if (k<n && isTriangleValid(arr[i], arr[j], arr[k])) {
        		returnVal++;
        		System.out.println("(" + arr[i] + ", " + arr[j] + ", " + arr[k] + ")");
        		k++;
        	} else if (j == (n-2)) {
        		i++;
        		j = i+1;
        		k = j+1;
        	} else {
        		j++;
        		k = j+1;
        	}
        }
        return returnVal;
    }
	static long findNumberOfTriangles2(int arr[], int n)
    {
        // add your code here
        long returnVal = 0L;
        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                for (int k = j+1; k<n; k++) {
                    if (isTriangleValid(arr[i], arr[j], arr[k])) {
                    	System.out.println("(" + arr[i] + ", " + arr[j] + ", " + arr[k] + ")");
                        returnVal++;
                    }
                }
            }
        }
        return returnVal;
    }
    static boolean isTriangleValid(int a, int b, int c) {
        if ((a+b)>c && (b+c)>a && (c+a)>b) {
            return true;
        }
        return false;
    }
}
