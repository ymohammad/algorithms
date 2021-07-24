package com.alysoft.completedsa.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an integer array and a non-negative integer k, count all distinct pairs with difference equal to k, i.e., A[ i ] - A[ j ] = k.


Input:

The first line of input consists number of the test cases. The description of T test cases is as follows:

The first line of each test case contains the size of the array, the second line has the elements of the array and the third line consists of the difference k.

Output:

In each separate line print the number of times difference k exists between the elements of the array.
 * @author ymohammad
 *
 */
public class CountDistinctPairs
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
				
			int k = Integer.parseInt(br.readLine().trim());
			
			int x = getPairCount(a, n, k);
			System.out.println(x);
            t--;
        }
	}

	private static int getPairCount(int[] arr, int n, int k)
	{
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int x: arr) {
			if (hash.containsKey(x)) {
				hash.put(x, hash.get(x)+1);
			} else {
				hash.put(x, 1);
			}
		}
		int count = 0;
		for (int i = 0; i<n; i++) {
			int a = arr[i];
			
			if (k == 0) {
				if (hash.containsKey(a) && hash.get(a)>1) {
					count++;
					hash.put(a, hash.get(a)-2);
				}
			} else if (hash.containsKey(a-k) && hash.get(a)>0) {
				count++;
				hash.put(a, hash.get(a)-1);
			}
		}
		return count;
	}
}
