package com.alysoft.geeksforgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FirstElementToOccurKTimes
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
            int k = Integer.parseInt(arrayValues[1].trim());
            
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
				
			int x = getKCount(a, n, k);
			
			System.out.println(x);
            t--;
        }
	}

	public static int getKCount(int[] arr, int n, int k)
	{
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int x: arr) {
			if (hash.containsKey(x)) {
				hash.put(x, hash.get(x)+1);
			} else {
				hash.put(x, 1);
			}
		}
		
		for (int x: arr) {
			if (hash.get(x) == k) {
				return x;
			}
		}
		return -1;
	}
}
