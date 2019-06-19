package com.alysoft.geeksofgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. 
The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left 
if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:
Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5

Explanation : 
Testcase1: sum of elements from 2nd position to 4th position is 12
Testcase2: sum of elements from 1st position to 5th position is 15
 * @author ymohammad
 *
 */
public class SubarrayWithGivenSum
{
	/**
	 * 
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = br.readLine();
            String[] arrayValues = line.split(" ");
            int n = Integer.parseInt(arrayValues[0]);
            int s = Integer.parseInt(arrayValues[1]);
            line = br.readLine();
            arrayValues = line.split(" ");
            long[] arr = new long[n];
			for(int i = 0; i < n; i++)
				arr[i]= Integer.parseInt(arrayValues[i]);
			
			findNPrintSubArray(arr, n, s);
            t--;
        }
	}

	private static void findNPrintSubArray(long[] arr, int n, int targetSum)
	{
		/*long[] sumArray = new long[n];
		sumArray[0] = arr[0];
		for (int i=1; i<n; i++) {
			sumArray[i] = sumArray[i-1] + arr[i];
		}*/
		int startInd = 0;
		int endInd = 0;
		long currentSum = arr[endInd];
		while (startInd < n && endInd < n) {
			if (currentSum < targetSum) {
				endInd++;
				if (endInd < n)
					currentSum += arr[endInd];
			} else if (currentSum > targetSum) {
				currentSum = currentSum - arr[startInd];
				startInd++;
			} else {
				System.out.println((startInd+1) + " " + (endInd+1));
				return;
			}
		}
		System.out.println("-1");
	}
}
