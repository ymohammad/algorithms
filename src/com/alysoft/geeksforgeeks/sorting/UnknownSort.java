package com.alysoft.geeksforgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * You are given an array A of size N. You are also given an integer K. You need to sort the 
 * elements such that element that has the greater remainder when divided by K comes first. 
 * If two numbers give the same remainder on division by K then the number that is greater comes first.

	Input:
	The first line of input contains T denoting the number of testcases. T testcases follow. 
	Each testcase contains two lines of input. The first line contains N denoting the size of the array. 
	The second line contains the elements of the array Ai. The third line contains K.
	
	Output:
	For each testcase, in a new line, print the sorted array.
 * 
 * Example:
	Input:
	1
	5
	5 1 2 3 4
	1
	Output:
	5 4 3 2 1
 * 
 * @author ymohammad
 *
 */
public class UnknownSort
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
			sortUnknown(a, n, k);
            t--;
        }
	}

	private static void sortUnknown(int[] a, int n, int k)
	{
		pigeonSort(a, n, k);
		printArray(a);
	}
	

	private static void pigeonSort(int[] arr, int n, int k)
	{
		HashMap<Integer, ArrayList<Integer>> hash = new HashMap<Integer, ArrayList<Integer>>();
		
		for (int x: arr) {
			int rem = x%k;
			ArrayList<Integer> list = null;
			if (hash.containsKey(rem)) {
				list = hash.get(rem);
			} else {
				list = new ArrayList<Integer>();
			}
			list.add(x);
			hash.put(rem, list);
		}
		
		Set<Integer> keySet = hash.keySet();
		ArrayList<Integer> list = new ArrayList<Integer>(keySet);
		Collections.sort(list);
		int x = list.size();
		int j = 0;
		for (int i = x-1; i>=0; i--) {
			int rem = list.get(i);
			ArrayList<Integer> arrayList = hash.get(rem);
			if (arrayList.size() == 1) {
				arr[j] = arrayList.get(0);
				j++;
			} else {
				Collections.sort(arrayList);
				int y = arrayList.size();
				for (int index = y-1; index>=0; index--) {
					arr[j] = arrayList.get(index);
					j++;
				}
			}
		}
	}


	private static void printArray(int[] a)
	{
		StringBuffer buff = new StringBuffer();
		for (int x: a) {
			buff.append(x + " ");
		}
		System.out.println(buff.toString().trim());
	}
	
	private static int getMaxReminder(int[] arr, int k)
	{
		int maxVal = Integer.MIN_VALUE;
		for (int x: arr) {
			int rem = x%k;
			if (rem >maxVal) maxVal = rem;
		}
		return maxVal;
	}
	
	private static int getMinReminder(int[] arr, int k)
	{
		int minVal = Integer.MAX_VALUE;
		for (int x: arr) {
			int rem = x%k;
			if (rem<minVal) minVal = rem;
		}
		return minVal;
	}
}
