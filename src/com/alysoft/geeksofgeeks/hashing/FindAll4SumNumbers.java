package com.alysoft.geeksofgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array A of size N, find all combination of four elements in the array whose sum is equal to a given value K. 
 * For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and K = 23, one of the quadruple is “3 5 7 8” (3 + 5 + 7 + 8 = 23).

Input:
The first line of input contains an integer T denoting the no of test cases. 
Then T test cases follow. Each test case contains two lines. The first line of input contains two integers N and K. 
Then in the next line are N space separated values of the array.

Output:
For each test case in a new line print all the quadruples present in the array separated by space which sums up to value of K. Each quadruple is unique which are separated by a delimeter "$" and are in increasing order.

 * Example:
Input:
2
5 3
0 0 2 1 1 
7 23
10 2 3 4 5 7 8

Output:
0 0 1 2 $
2 3 8 10 $2 4 7 10 $3 5 7 8 $
 * 
 * @author ymohammad
 *
 */
public class FindAll4SumNumbers
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
            
            int n = Integer.parseInt(arrayValues[0]);
            int k = Integer.parseInt(arrayValues[1]);
            
            line = br.readLine();
            arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			printSequence(a, n, k);
            t--;
        }
	}
	public static void printSequence(int[] arr, int n, int k) {
		int l, r;
		StringBuffer buff = new StringBuffer();
		Arrays.sort(arr);
		for (int i=0; i<n-3; i++) {
			for (int j=i+1; j<n-2; j++) {
				l = j+1;
				r = n-1;
				while (l<r) {
					int sum = (arr[i] + arr[j] + arr[l] + arr[r]);
					String newStr = (arr[i] + " " + arr[j] + " " + arr[l] + " " + arr[r]);
					if ( sum == k) {
						if (buff.indexOf(newStr.trim())== -1) {
							buff.append(newStr +" $");
						}
						
						l++;
						r--;
					} else if (sum < k) {
						l++;
					} else {
						r--;
					}
				}
			}
		}
		if (buff.length() == 0) {
	    	System.out.println(-1);
	    } else {
	    	System.out.println(buff.toString().trim());
	    }
	}
	public static void printSequenceBF(int[] arr, int n, int k) {
		Arrays.sort(arr);
		StringBuffer buff = new StringBuffer();
	    for (int i=0; i<n-4; i++) {
	    	for (int j=i+1; j<n; j++) {
	    		for (int l = j+1; l<n; l++) {
	    			for (int m = l+1; m<n; m++) {
	    				if ((arr[i] + arr[j] + arr[l] + arr[m]) == k) {
	    					ArrayList<Integer> list = new ArrayList<Integer>();
	    					list.add(arr[i]);
	    					list.add(arr[j]);
	    					list.add(arr[l]);
	    					list.add(arr[m]);
	    					Collections.sort(list);
	    					StringBuffer temp = new StringBuffer();
	    					for (int x=0; x<list.size(); x++) {
	    						temp.append(" ");
	    						temp.append(list.get(x));
	    					}
	    					temp.toString().trim();
	    					if (buff.indexOf(temp.toString()) == -1) {
	    						buff.append(temp.toString()+"$");
	    					}
	    					
	    				}
	    			}
	    		}
	    	}
	    }
	    if (buff.length() == 0) {
	    	System.out.println(-1);
	    } else {
	    	System.out.println(buff.toString().trim());
	    }
	}
}
