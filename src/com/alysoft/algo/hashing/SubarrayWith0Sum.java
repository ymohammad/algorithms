package com.alysoft.algo.hashing;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Given an array a[] of N positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.

Input Format:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains N space separated integers forming the array.

Output Format:
Print "Yes" ( without quotes) if there exist a subarray of size at least one with sum equal to 0 or else print "No" ( without quotes).

Your Task:
This is a function problem. You only need to complete the function subArrayExists() that takes array and n as parameters and returns true or false.

Constraints:
1 <= T <= 100
1 <= N <= 104
-105 <= a[i] <= 105

Example:
Input:
2
5
4 2 -3 1 6
5
4 2 0 1 6

Output:
Yes
Yes

Explanation:
Testcase 1: 2, -3, 1 is the subarray with sum 0.
 * @author ymohammad
 *
 */
public class SubarrayWith0Sum
{
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t>0)
		{
		    int n = scan.nextInt() ;
		    int arr[] = new int[n];
		    for(int i = 0; i<n;i++)
		    {
		        arr[i] = scan.nextInt();
		    }
		    
		    t--;
		     System.out.println(findsum(arr,n)==true?"Yes":"No");
		}
	}
	static boolean findsum(int arr[],int n)
	{
	    //Your code here
	    HashSet<Integer> hash = new HashSet<Integer>();
	    hash.add(0);
	    int sum = 0;
	    for (int x : arr) {
	        sum += x;
	        if (hash.contains(sum)) {
	            return true;
	        }
	        hash.add(sum);
	    }
	    return false;
	}
}
