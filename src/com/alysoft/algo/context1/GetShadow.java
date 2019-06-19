package com.alysoft.algo.context1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an unsorted array A[] of size N of positive integers. One number 'a' from set {1, 2, …N} is missing and one number 'b' occurs twice in array. The task is to find the repeating and the missing.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each testcase, in a new line, print b, which is the repeating number, followed by a, which is the missing number, in a single line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 ≤ A[i] ≤ N

Example:
Input:
2
2
2 2
3 
1 3 3

Output:
2 1
3 2

Explanation:
Testcase 1: Repeating number is 2 and smallest positive missing number is 1.
Testcase 2: Repeating number is 3 and smallest positive missing number is 2.
 * @author ymohammad
 *
 */
public class GetShadow
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			printMissingAndSmallestElement(a, n);
            t--;
        }
	}

	private static void printMissingAndSmallestElement(int[] arr, int n)
	{
		int[] hash = new int[1000001];
		for (int i=0; i<n; i++)
		{
			hash[arr[i]]++;
		}
		int missing =-1;
		int duplicate = -1;
		for (int i=1; i<hash.length; i++)
		{
			if (hash[i] == 0) {
				missing = i;
			}
			if (hash[i]>1)
			{
				duplicate = i;
			}
			if (missing != -1 && duplicate != -1)
			{
				break;
			}
		}
		System.out.println(duplicate + " " + missing);
	}
}
