package com.alysoft.geeksforgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * Given an array of integers, and an integer  �K� , find the count of pairs of elements in the array whose sum is equal to 'K'.

	Input:
	First line of the input contains an integer T, denoting the number of test cases. Then T test cases follow. 
	Each test case consists of two lines. First line of each test case contains 2 space separated integers N and K denoting the 
	size of array and the sum respectively. Second line of each test case contains N space separated integers denoting the elements of the array.
	
	Output:
	Print the count of pairs of elements in the array whose sum is equal to the K..
 * @author ymohammad
 *
 */
public class CountPairWithSum
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
				
			int x = isPariExistEasy(arr, n, k);
			System.out.println("\n\nWith HashMap");
			System.out.println();
			x = isPariExist(arr, n, k);
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
	private static int isPariExistEasy(int[] arr, int n, int k) {
	    int count = 0;
	    for(int i=0; i<n; i++) {
	        for (int j=i+1; j<n; j++) {
	            if ((arr[i]+arr[j]) == k) {
	            	System.out.println(arr[i] + ", " + arr[j] + "=>" + k);
	                count++;
	            }
	        }
	    }
	    return count;
	}
	private static int isPariExist(int[] arr, int n, int k)
	{
		HashSet<Integer> a = null;
		LinkedHashMap<Integer, Integer> hash = new LinkedHashMap<Integer, Integer>();
		
		for (int i = 0; i<n; i++) {
			if (hash.containsKey(arr[i])) {
				hash.put(arr[i], hash.get(arr[i]) + 1);
			} else {
				hash.put(arr[i], 1);
			}
		}
		int count = 0;
		for (int i = 0; i<n; i++) {
			int a1 = arr[i];
			int val = hash.get(a1);
			if (val == 1)
				hash.remove(a1);
			int b = k-a1;
			if (hash.containsKey(b) && hash.get(b)>0) {
				
				count++;
				int temp = val-1;
			//	System.out.println(a + ", " + (k-a) + "=>" + k);
				while (temp > 0) {
					temp--;
					count++;
					//System.out.println(a + ", " + (k-a) + "=>" + k);
				}
				hash.put(a1, temp);

				temp = hash.get(b)-1;
				while (temp > 0) {
					temp--;
					count++;
					//System.out.println(a + ", " + (k-a) + "=>" + k);
				}
				hash.put(b, temp);
			} else {
				hash.put(a1, val);
			}
		}
		return count;
	}
}
