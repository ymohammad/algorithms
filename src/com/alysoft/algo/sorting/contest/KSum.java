package com.alysoft.algo.sorting.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * You are given an array of integers. Find the sum of first K smallest numbers. 

Input : 
First line of input contains number of testcases T. The 1st line of each testcase contains a two integers N denoting the number 
of elements in the array A and K. The 2nd line of each testcase, contains N space separated integers denoting the elements of the array A.

Output : 
For each testcase you need to print the sum of K smallest numbers.

Constraints :
1 <= T <= 50
1 <= N <= 105
1 <= K <= N
0 <= A[i] <= 10

Example :
Input :
1
6 4
1 3 4 1 3 8

Output :
8

Explaination :
Testcase1: Sum of first 4 smallest numbers is 1+1+3+3 = 8
 * @author ymohammad
 *
 */
public class KSum
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int n = Integer.parseInt(arrayValues[0].trim());
            int k = Integer.parseInt(arrayValues[1].trim());
            line = br.readLine();
            arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			int x = getKSmallestSum(a, n, k);
			System.out.println(x);
            t--;
        }
	}

	private static int getKSmallestSum(int[] arr, int n, int k)
	{
		int[] countArray = new int[11];
		Arrays.fill(countArray, -1);
		for (int x : arr) {
			if (countArray[x] == -1) {
				countArray[x] = 0;
			}
			countArray[x]++;
		}
		int sum = 0;
		int currentCount = 0;
		for (int i = 0; i<11; i++) {
			if (countArray[i] != -1) {
				int x = countArray[i];
				while (x > 0) {
					sum += i;
					currentCount++;
					if (currentCount == k) {
						return sum;
					}
					x--;
				}
			}
			
		}
		return sum;
	}

}
