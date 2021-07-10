package com.alysoft.geeksforgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array A of N positive integers and another number X. 
 * Determine whether or not there exist two elements in A whose sum is exactly X.

	Input:
	The first line of input contains an integer T denoting the number of test cases. 
	The first line of each test case is N and X, N is the size of array. 
	The second line of each test case contains N integers representing array elements A[i].
	
	Output:
	Print "Yes" if there exist two elements in A whose sum is exactly X, else "No" (without quotes).
 * @author ymohammad
 *
 */
public class KeyPairs
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            
            int n = Integer.parseInt(arrayValues[0].trim());
            int k = Integer.parseInt(arrayValues[1].trim());
            
            line = br.readLine();
            arrayValues = line.trim().split(" ");
            int[] arr = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        arr[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			String x = isPariExist(arr, n, k);
			
			System.out.println(x);
            t--;
        }
	}

	public static String isPairExistSort(int[] arr, int n, int k) {
		int l = 0; 
		int r = 0;
		Arrays.sort(arr);
		while (l<n && r<n) {
			if ((arr[l] + arr[r]) == k) {
				return "Yes";
			} else if((arr[l] + arr[r]) < k) {
				r++;
			} else {
				l++;
			}
		}
		return "No";
	}
	private static String isPariExist(int[] arr, int n, int k)
	{
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		for (int i = 0; i<n; i++) {
			if (hash.containsKey(arr[i])) {
				hash.put(arr[i], hash.get(arr[i]) + 1);
			} else {
				hash.put(arr[i], 1);
			}
		}
		for (int i = 0; i<n; i++) {
			int a = arr[i];
			int val = hash.get(a);
			hash.put(a, val-1);
			if (hash.containsKey(k-a) && hash.get(k-a)>0) {
				return "Yes";
			} else if(val>0) {
			    hash.put(a, val);
			}
		}
		return "No";
	}
}
