package com.alysoft.geeksofgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Given three increasingly sorted arrays A, B, C of sizes N1, N2, and N3 respectively, you need to print all common elements in these arrays.

Note: Please avoid printing the same common element more than once.

Input:
First line contains a single integer T denoting the total number of test cases. T testcases follow. 
Each testcase contains four lines of input. First line consists of 3 integers N1, N2 and N3, denoting the sizes of arrays A, B, C respectively. 
The second line contains N1 elements of A array. The third lines contains N2 elements of B array. The fourth lines contains N3 elements of C array.

Output:
For each testcase, print the common elements of array. If not possible then print -1.
 * 
 * Example:
Input:
1
6 5 8
1 5 10 20 40 80
6 7 20 80 100
3 4 15 20 30 70 80 120
Output:
20 80
 * @author ymohammad
 *
 */
public class CommonElements
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int n1 = Integer.parseInt(arrayValues[0].trim());
            int n2 = Integer.parseInt(arrayValues[1].trim());
            int n3 = Integer.parseInt(arrayValues[2].trim());
            
            long[] a = getInputArray(br, n1);
            long[] b = getInputArray(br, n2);
            long[] c = getInputArray(br, n3);
				
			printCommonElements(a, b, c);
			System.out.println();
            t--;
        }
	}

	private static void printCommonElements(long[] a, long[] b, long[] c)
	{
		boolean isFound = false;
		int bStartInd = 0;
		int cStartInd = 0;
		HashSet<Long> hash = new HashSet<Long>();
		for (long x: a) {
			int l = binarySearch(b, x, bStartInd, b.length-1);
			if (l == -1) continue;
			
			int m = binarySearch(c, x, cStartInd, c.length-1);
			if (m == -1) continue;
			
			bStartInd = l;
			cStartInd = m;
			isFound = true;
			if (!hash.contains(x)) {
				hash.add(x);
				System.out.print(x + " ");
			}
		}
		
		if (!isFound) {
			System.out.print(-1);
		}
	}
	public static int binarySearch(long[] arr, long k, int start, int end) {
		if (start > end) return -1;
		if (k<arr[0]) return -1;
		
		int mid = (start+end)/2;
		if (arr[mid] == k) return mid;
		
		if (k < arr[mid]) {
			return binarySearch(arr, k, start, mid-1);
		} else {
			return binarySearch(arr, k, mid+1, end);
		}
	}

	private static long[] getInputArray(BufferedReader br, int size) throws IOException
	{
		String line = br.readLine();
		String[] arrayValues = line.trim().split(" ");
        long[] a = new long[size];
        int i = 0;
		for (String s: arrayValues) {
		    if (s != null && s.trim().length() > 0) {
		        a[i]= Long.parseLong(s.trim());
		        i++;
		    }
		}
		return a;
	}
}
