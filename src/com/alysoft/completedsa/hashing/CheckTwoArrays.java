package com.alysoft.completedsa.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.
 * @author ymohammad
 *
 */
public class CheckTwoArrays
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
				
			line = br.readLine();
            arrayValues = line.trim().split(" ");
            long[] b = new long[n];
            i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        b[i]= Long.parseLong(s.trim());
			        i++;
			    }
			}
			int x = isEqualArray(a, b);
			System.out.println(x);
            t--;
        }
	}

	private static int isEqualArray(long[] a, long[] b)
	{
		HashMap<Long, Long> hash = new HashMap<Long, Long>();
		for (long x: a) {
			if (hash.containsKey(x)) {
				hash.put(x, hash.get(x)+1L);
			} else {
				hash.put(x, 1L);
			}
		}
		for (long x: b) {
			if (hash.containsKey(x)) {
				hash.put(x, hash.get(x)-1L);
			} else {
				hash.put(x, 1L);
			}
		}
		
		Iterator<Long> iterator = hash.keySet().iterator();
		while (iterator.hasNext()) {
			if (hash.get(iterator.next()) != 0) return 0;
		}
		return 1;
	}
}
