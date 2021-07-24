package com.alysoft.completedsa.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element K. 
 * The task is to find the index of the given element K in the array A.

Input:
The first line of the input contains an integer T, denoting the total number of test cases. Then T test cases follow. 
Each test case consists of three lines. First line of each test case contains an integer N denoting the size of the given array. 
Second line of each test case contains N space separated integers denoting the elements of the array A. Third line of each test 
case contains an integer K denoting the element to be searched in the array.

Output:
Corresponding to each test case, output the index of the element found in the array.  If element is not present, then output -1.

Example:
Input:
3
9
5 6 7 8 9 10 1 2 3
10
3
3 1 2
1
4
3 5 1 2
6

Output:
5
1
-1

 * @author ymohammad
 *
 */
public class SearchRotatedArray
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
            int rotateIndex = -1;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        if (i>0 && rotateIndex == -1 && a[i-1]>a[i]) {
			        	rotateIndex = i;
			        }
			        i++;
			    }
			}
			int k = Integer.parseInt(br.readLine().trim());
			int x = getFoundElementIndex(a, n, k, rotateIndex);
			System.out.println(x);
            t--;
        }
	}

	public static int getFoundElementIndex(int[] a, int n, int k, int rotateIndex)
	{
		rotateIndex = rotateIndex == -1 ? (n-1) : rotateIndex;
		int res = doBinarySearch(0, rotateIndex, k, a);
		if (res != -1) return res;
		return doBinarySearch(rotateIndex, n-1, k, a);
	}
	
	public static int doBinarySearch(int start, int end, int k, int[] a) {
		while (start < end) {
			int mid = (start+end)/2;
			if (a[mid] == k) return mid;
			
			if (k < a[mid]) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		if (a[end] == k) return end;
		return -1;
	}
}
