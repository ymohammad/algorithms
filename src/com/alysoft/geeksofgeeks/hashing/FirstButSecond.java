package com.alysoft.geeksofgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FirstButSecond
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            
            int n = Integer.parseInt(arrayValues[0].trim());
            int m = Integer.parseInt(arrayValues[1].trim());
            
            line = br.readLine();
            arrayValues = line.trim().split(" ");
            long[] a = new long[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
			
			line = br.readLine();
            arrayValues = line.trim().split(" ");
            long[] b = new long[m];
            int j = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        b[j]= Integer.parseInt(s.trim());
			        j++;
			    }
			}
			
			printNotPresent(a, b, n, m);
            t--;
        }
	}

	private static void printNotPresent(long[] a, long[] b, int n, int m)
	{
		Map<Long, Integer> hash = new HashMap<Long, Integer>();
		
		for (long x: b) {
			if (hash.containsKey(x)) {
				hash.put(x, hash.get(x)+1);
			} else {
				hash.put(x, 1);
			}
		}
		StringBuffer buff = new StringBuffer();
		for (long x: a) {
			if (hash.containsKey(x)) {
				hash.put(x, hash.get(x)-1);
			} else {
				buff.append(x + " ");
			}
		}
		System.out.println(buff.toString().trim());
	}
}
