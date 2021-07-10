package com.alysoft.geeksforgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Given an array of positive integers which can contain integers from 1 to N where elements can be repeated or can 
 * be absent from the array. Your task is to count frequency of all elements from 1 to N.

Note: Expected time complexity is O(n) with O(1) extra space.

Input: 
First line of input contains an integer T denoting the number of test cases. 
For each test case, first line contains an integer N denoting the size of array. 
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each test case, output N space-separated integers denoting the frequency of each element from 1 to N.
 * 
 * Example: 
Input:
2
5
2 3 2 3 5
4
3 3 3 3

Output:
0 2 2 0 1
0 0 4 0
 * 
 * @author ymohammad
 *
 */
public class FrequencyOfArrayElements
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
				
			String x = getArrayFrequencyCount(a, n);
			
			System.out.println(x);
            t--;
        }
	}

	private static String getArrayFrequencyCount(int[] arr, int n)
	{
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i<n; i++) {
			int x = arr[i];
			if (hash.containsKey(x)) {
				hash.put(x, hash.get(x)+1);
			} else {
				hash.put(x, 1);
			}
		}
		StringBuffer buff = new StringBuffer();
		for (int i=1; i<=n; i++) {
			if (hash.containsKey(i)) {
				buff.append(hash.get(i) + " ");
			} else {
				buff.append(0 + " ");
			}
		}
		return buff.toString();
	}
}
