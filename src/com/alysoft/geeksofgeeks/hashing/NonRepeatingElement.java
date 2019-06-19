package com.alysoft.geeksofgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

/**
 * Find the first non-repeating element in a given array A of N integers.
Note: Array consists of only positive and negative integers and not zero.

Input:
The first line of input is an integer T, denoting the number of test cases. Each test case has subsequent two lines of input. 
First line is an integer N, denoting size of integer array A. Second line consists of N space separated integers of the array A.

Output:
For each testcase, print the required answer. If no such element exists, then print 0
 * @author ymohammad
 *
 */
public class NonRepeatingElement
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
            long[] a = new long[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Long.parseLong(s.trim());
			        i++;
			    }
			}
				
			long x = getNonRepeatingElement(a, n);
			
			System.out.println(x);
            t--;
        }
	}

	private static long getNonRepeatingElement(long[] a, int n)
	{
		HashMap<Long, Integer> hash = new HashMap<Long, Integer>();
		for (int i=0; i<n; i++) {
			long x = a[i];
			if (hash.containsKey(x)) {
				hash.put(x, -1);
			} else {
				hash.put(x, i);
			}
		}
		int firstIndex = n;
		Set<Long> keySet = hash.keySet();
		for (long ln: keySet) {
			int index = hash.get(ln);
			
			if (index != -1 && firstIndex>index) {
				firstIndex = index;
			}
		}
		return firstIndex == n ? 0 : a[firstIndex];
	}
}
