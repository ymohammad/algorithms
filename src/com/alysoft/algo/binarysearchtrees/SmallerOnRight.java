package com.alysoft.algo.binarysearchtrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array arr[] of N elements. The task is to count maximum number of distinct smaller elements on right side of any array element. 
 * For example, in {10, 6, 9, 7, 20, 19, 21, 18, 17, 16}, the result is 4.  Note that 20 has maximum 4 smaller elements on right side.
 * Other elements have less count, for example 10 has 3 smaller elements on right side.

Input:
First line of input contains number of testcases T. 
For each testcase, first line of input contains number of elements in the array and next line contains array elements.

Output:
For each testcase, print the maximum count of smaller elements on right side.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 106

Example:
Input:
4
10
10 6 9 7 20 19 21 18 17 16
5
5 4 3 2 1
5
1 2 3 4 5
5
1 2 3 2 1

Output:
4
4
0
2

Explanation:

Testcase 1: Number of smaller elements on right side of every element (from left to right) in 
the array are 3 0 1 0 4 3 3 2 1 and 0 respecitvely. Maximum of all these counts is 4.
Testcase 2: Number of smaller elements on right side of every element (from left to right) in the array 
are 4 3 2 1 and 0 respecitvely. Maximum of all these counts is 4.
 * @author ymohammad
 *
 */
public class SmallerOnRight
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
				
			int x = getSmallerCountOnRight(a, n);
			
			System.out.println(x);
            t--;
        }
	}

	private static int getSmallerCountOnRight(int[] arr, int n)
	{
		int returnCount = 0;
		TreeSet<Integer> tree = new TreeSet<Integer>();

		for (int i=n-1; i>=0; i--) {
			tree.add(arr[i]);
			print(tree.headSet(arr[i]), arr[i]);
			returnCount = Math.max(returnCount, tree.headSet(arr[i]).size());
		}
		return returnCount;
	}

	private static void print(SortedSet<Integer> headSet, int fored)
	{
		System.out.println(fored + " Called Print :" + headSet);
		for (Integer eachInt : headSet) {
			System.out.println(eachInt);
		}
	}

}
