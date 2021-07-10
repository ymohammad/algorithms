package com.alysoft.geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array A of N integers. The task is to count the pairs which are adjacent and equal.

Input:
First line of input contains number of testcases T. For each testcase, there will be two lines of input, first of
 which contains N(size of array) and next line contains N elements.

Output:
For each testcase, print the count of such pairs which are adjacent and equal.

Example:
Input:
1
5
5 2 2 1 3

Output:
1

Explanation:
Testcase 1: 2 and 2 forms a pair which are adjacent and equal.
 * @author ymohammad
 *
 */
public class AdjacentEqual
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
				
			int x = 0;
			int j = 0;
			while (j<n-1) {
			    if (a[j] == a[j+1]) {
			        x++;
			        
			    } 
			    j++;
			}
			
			System.out.println(x);
            t--;
        }
	}
}
