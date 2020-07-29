package com.alysoft.algo.stack.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * There are N persons standing in a line from left to right. This line is represented with an array of size N and the elements of 
 * the array are the height of the persons. For each person the closest friend is the closest person to his left whose height is strictly 
 * smaller than him. If for any person there is no person to his left whose height is smaller than him print -1 else print the index of 
 * smaller friend (0-based indexing).

Input: 
First line contains an integer T which denotes number of test cases. Next line contains an integer N which which is the size of the array. 
Next line of each test case contain N space seperated integers denoting the array  .

Output: 
For each print -1 or index of the closet friend, if found.

Constraints:
1 <= T <= 10000
1 <= N <= 105
0 <= A[i] <= 105

Example :
Input :
1
6
1 3 4 1 3 8
Output :
-1 0 1 -1 3 4
 * @author ymohammad
 *
 */
public class ClosestFriends
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
				
			findNPrintClosestFriends(a, n);
			printArray(a);
            t--;
        }
	}

	private static void printArray(int[] arr)
	{
		StringBuffer buff = new StringBuffer();
		for (int x : arr) {
			buff.append(x + " ");
		}
		System.out.println(buff.toString());
	}

	private static void findNPrintClosestFriends(int[] arr, int n)
	{
		Stack<Pair> stack = new Stack<Pair>();
		for (int i = 0; i<n; i++) {
			stack.push(new Pair(i, arr[i]));
		}
		Stack<Pair> stack2 = new Stack<Pair>();
		while (!stack.isEmpty()) {
			Pair eachObj = stack.pop();
			if (stack.isEmpty()) {
				arr[eachObj.getInd()] = -1;
			} else if (eachObj.getHeight() > stack.peek().getHeight()) {
				arr[eachObj.getInd()] = stack.peek().getInd();
			} else {
				while (!stack.isEmpty() && eachObj.getHeight() <= stack.peek().getHeight()) {
					stack2.push(stack.pop());
				}
				if (stack.isEmpty()) {
					arr[eachObj.getInd()] = -1;
				} else {
					arr[eachObj.getInd()] = stack.peek().getInd();
				}
				while (!stack2.isEmpty()) {
					stack.push(stack2.pop());
				}
			}
		}
	}
	private static class Pair 
	{
		private int height;
		private int ind;
		public Pair(int ind, int ch) {
			this.ind = ind;
			this.height = ch;
		}
		public int getHeight()
		{
			return this.height;
		}

		public int getInd()
		{
			return this.ind;
		}
	}
}
