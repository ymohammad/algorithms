package com.alysoft.completedsa.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array A of N elements. Find the majority element in the array. A majority element in an array A 
 * of size N is an element that appears more than N/2 times in the array.

Input:  
The first line of the input contains T denoting the number of testcases. The first line of the test 
case will be the size of array and second line will be the elements of the array.

Output: 
For each test case the output will be the majority element of the array. Output "-1" if no majority 
element is there in the array.
 * @author ymohammad
 *
 */
public class MajorityElements
{
	public static void main1(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] arrayValues = line.split(" ");
            int[] a = new int[n];
			for(int i = 0; i < n; i++)
				a[i]= Integer.parseInt(arrayValues[i]);
			
			int x = getMajorityElement(a, n);
			
			System.out.println(x);
            t--;
        }
	}

	private static int getMajorityElement(int[] a, int n)
	{
		if (n == 0) return -1;
		
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		
		for (int x: a) {
			if (hs.containsKey(x)) {
				hs.put(x, hs.get(x)+1);
			} else {
				hs.put(x, 1);
			}
		}
		
		int maxValue = (int) Math.floor(n/2);
		for (int x: a) {
			if (hs.get(x)>maxValue) {
				return x;
			};
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int a[] = {3, 3, 3, 5, 5, 5, 5, 4, 2};
		System.out.println("Major Element :" + findMajorityUsingMoorAlgo(a, a.length));
	}
	public static int findMajorityUsingMoorAlgo(int[] a, int n) {
		int counter = 1;
		int majorIndex = 0;
		int majorElement = a[majorIndex];
		for (int i = 1; i<n; i++) {
			if (a[i] == majorElement) {
				counter++;
			} else {
				counter--;
			}
			
			if (counter == 0) {
				majorIndex = i;
				majorElement = a[i];
				counter = 1;
			}
		}
		
		//Here majorElement could be non-major also as the array might not contain any major element.
		//In that case, we need to verify if it is really a major or not. Two times looping is needed here.
		counter = 0;
		for (int x: a) {
			if (x == majorElement) {
				counter++;
			}
		}
		return (counter>n/2)? majorElement: -1;
	}
}
