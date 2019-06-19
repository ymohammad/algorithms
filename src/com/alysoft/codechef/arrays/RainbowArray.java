package com.alysoft.codechef.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Chef likes all arrays equally. But he likes some arrays more equally than others. In particular, he loves Rainbow Arrays.

	An array is Rainbow if it has the following structure:
	
	First a1 elements equal 1.
	Next a2 elements equal 2.
	Next a3 elements equal 3.
	Next a4 elements equal 4.
	Next a5 elements equal 5.
	Next a6 elements equal 6.
	Next a7 elements equal 7.
	Next a6 elements equal 6.
	Next a5 elements equal 5.
	Next a4 elements equal 4.
	Next a3 elements equal 3.
	Next a2 elements equal 2.
	Next a1 elements equal 1.
	ai can be any non-zero positive integer.
	There are no other elements in array.
	
	Help Chef in finding out if the given array is a Rainbow Array or not.
 * 
 * Input
	The first line of the input contains an integer T denoting the number of test cases.
	The first line of each test case contains an integer N, denoting the number of elements in the given array.
	The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of array.
	
	Output
	For each test case, output a line containing "yes" or "no" (without quotes) corresponding to the case if the array is rainbow array or not.
 * 
 * Example
	Input
	3
	19
	1 2 3 4 4 5 6 6 6 7 6 6 6 5 4 4 3 2 1
	14
	1 2 3 4 5 6 7 6 5 4 3 2 1 1
	13
	1 2 3 4 5 6 8 6 5 4 3 2 1
	
	Output
	yes
	no
	no
 * @author ymohammad
 *
 */
public class RainbowArray
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine;
		while ((eachLine = br.readLine()) != null) {
			int t = Integer.parseInt(eachLine.trim());
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	        	
	        	int n = Integer.parseInt(br.readLine().trim());
	        	
	        	String str = br.readLine();
	        	String[] lineSplit = str.split(" ");
	        	
	        	int[] arr = new int[n];
	        	int i = 0;
	        	for (String s : lineSplit) {
	        		if (s != null && s.trim().length()>0) {
	        			arr[i] = Integer.parseInt(s.trim());
	        			i++;
	        		}
	        	}
	        	findIsARainbowArray(arr, n);
	            t--;
	        }
	        break;
		}
	}

	public static void findIsARainbowArray(int[] arr, int n)
	{
		int i = 0;
		int j = n-1;
		
		int prevValue = arr[i];
		while (i < j) {
			if (arr[i] != arr[j] && (arr[i] == prevValue || arr[i] == (prevValue+1))) {
				System.out.println("no");
				return;
			}
			prevValue = arr[i];
			i++;
			j--;
		}
		if (n%2 != 0) {
			if ((arr[i] == prevValue || arr[i] == (prevValue+1))) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		} else {
			System.out.println("yes");
		}
	}
}
