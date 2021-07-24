package com.alysoft.completedsa.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a N x N matrix. Write a program to find count of all the distinct elements common to all rows of the matrix. Print count of such elements.

Input:
First line of input contains a single integer T which denotes the number of test cases. 
T test cases follows. First line of each test case contains a single integer N which denotes the 
dimension of matrix. 
Second line of each test case contains N*N space separated integers which denotes elements of the matrix.
 * @author ymohammad
 *
 */
public class FindDistinctElements
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
            int[][] arr = new int[n][n];
            int i = 0;
            int j = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			    	if (j>n-1) {
			        	j = 0;
			        	i++;
			        }
			        arr[i][j]= Integer.parseInt(s.trim());
			        j++;
			    }
			}
				
			int x = getDistinctCount(arr, n);
			
			System.out.println(x);
            t--;
        }
	}
	private static int getDistinctCount2(int[][] arr, int n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for (int i=0; i<n; i++) {
			HashSet<Integer> temp = new HashSet<Integer>();
			for (int j=0; j<n; j++) {
				if (i == 0) {
					hs.add(arr[i][j]);
				} else {
					temp.add(arr[i][j]);
				}
			}
			if (i!= 0) {
				if (hs.size() == 0) return 0;
				
				Iterator<Integer> iterator = hs.iterator();
				while (iterator.hasNext()) {
					if (!temp.contains(iterator.next())) {
						iterator.remove();
					}
				}
			}
		}
		return hs.size();
	}
	private static int getDistinctCount(int[][] arr, int n)
	{
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (i == 0 || (hash.containsKey(arr[i][j]) && hash.get(arr[i][j]) == i)) {
					hash.put(arr[i][j], i+1);
				}
			}
			System.out.println("Hash for row :" + i + " - " + hash);
		}
		
		int count = 0;
		for (int i=0; i<n; i++) {
			int val = arr[0][i];
			if (hash.containsKey(val) && hash.get(val) == n) {
				count++;
				hash.remove(val);
			}
		}
		return count;
	}
}
