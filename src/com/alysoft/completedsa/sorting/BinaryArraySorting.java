package com.alysoft.completedsa.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a binary array, sort it in non-decreasing order

Input: First line contains an integer denoting the test cases 'T'.  Every test case contains two lines, first line is size and second line is space separated elements of array

Output:  Space separated elements of sorted arrays.  There should be a new line between output of every test case.
 * @author ymohammad
 *
 */
public class BinaryArraySorting
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
				
			String x = getSortedString(a, n);
			
			System.out.println(x);
            t--;
        }
	}

	private static String getSortedString(int[] a, int n)
	{
		int start = 0;
		int end = n-1;
		while (start<end) {
			if (a[start] == 1) {
				int temp = a[end];
				a[end] = 1;
				a[start] = temp;
				end--;
			} else {
				start++;
			}
		}
		StringBuffer buff = new StringBuffer();
		for (int x: a) {
			buff.append(x + " ");
		}
		return buff.toString();
	}
}
