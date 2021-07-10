package com.alysoft.geeksforgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given two arrays A and B of size N and M. The task is to print the array elements of A and B alternatively, i.e, A[i], B[i], A[i+1], B[i+1] ... .

Input: First line of input contains number of testcases T. For each testcase, there will be three lines, first of which contains N and M and next two line contains N and M integers respectively.

Output: For each testcase, print the array elements as required.

Constraints:
1 <= T <= 100
1 <= N, M <= 104
1 <= A[i], B[i] <= 106

Example:
Input:
1
2 3
1 3
2 4 5

Output:
1 2 3 4 5

Explanation:
Testcase 1: Elements are printed as A[0], B[0], A[1], B[1], B[2].
 * @author ymohammad
 *
 */
public class AlternatingElements
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
        	String nmStr = br.readLine().trim();
        	String[] nmArr = nmStr.split(" ");
            int n = Integer.parseInt(nmArr[0].trim());
            int m = Integer.parseInt(nmArr[1].trim());
            
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			while(i<n) {
			    if (arrayValues[i].trim().length() > 0) {
			        a[i]= Integer.parseInt(arrayValues[i].trim());
			        i++;
			    }
			}
				
			line = br.readLine();
            arrayValues = line.trim().split(" ");
            int[] b = new int[m];
            int j = 0;
			while(j<m) {
			    if (arrayValues[j].trim().length() > 0) {
			        b[j]= Integer.parseInt(arrayValues[j].trim());
			        j++;
			    }
			}

			printAlternateArray(a, b, n, m);
			
            t--;
        }
	}

	private static void printAlternateArray(int[] a, int[] b, int n, int m)
	{
		int i = 0;
		int j = 0;
		StringBuffer buffer = new StringBuffer();
		while (i<n || j<m) {
			if (i<n) {
				buffer.append(a[i] + " ");
				i++;
			}
			if (j<m) {
				buffer.append(b[j] + " ");
				j++;
			}
			
			
		}
		System.out.println(buffer.toString().trim());
	}
}
