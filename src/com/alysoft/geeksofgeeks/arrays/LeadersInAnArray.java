package com.alysoft.geeksofgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Given an array of positive integers. Your task is to find the leaders in the array.
Note: An element of array is leader if it is greater than or equal to all the elements to its right side. 
Also, the rightmost element is always a leader.

Input:
3
6
16 17 4 3 5 2
5
1 2 3 4 0
5
7 4 5 7 3
Output:
17 5 2
4 0
7 7 3
 * @author ymohammad
 *
 */
public class LeadersInAnArray
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] arrayValues = line.split(" ");
            int[] a = new int[n];
			for(int i = 0; i < n; i++)
				a[i]= Integer.parseInt(arrayValues[i]);
			
			checkNPrintLeaderBest(a, n);
            t--;
        }
	}
	private static void checkNPrintLeaderBest(int[] a, int n)
	{
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(a[n-1]);
		
		for (int i = n-2; i>=0; i--) {
			if (a[i]>= stack.peek()) {
				stack.push(a[i]);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.println(sb.toString().trim());
	}
	private static void checkNPrintLeader(int[] a, int n)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<n; i++) {
			boolean isLeader = true;
			for (int j = i+1; j<n; j++) {
				if (a[i]<a[j]) {
					isLeader = false;
					break;
				}
			}
			if (isLeader) {
				sb.append(a[i] + " ");
			}
		}
		System.out.println(sb.toString().trim());
	}
}
