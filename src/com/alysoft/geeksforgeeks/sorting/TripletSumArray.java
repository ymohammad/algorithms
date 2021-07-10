package com.alysoft.geeksforgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TripletSumArray
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
            int x = Integer.parseInt(arrayValues[1].trim());
            
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
				
			int res = getTripletCount(a, n, x);
			
			System.out.println(res);
            t--;
        }
	}
	public static int getTripletCount(int[] arr, int n, int x) {
	    if (n<3) return 0;
	    
	    HashSet<Integer> hash = new HashSet<Integer>();
	    //a+b = x-c
	    for (int i = 0; i<n-1; i++) {
	        hash.add(x-arr[i]);
	    }
	    
	    for (int i = 0; i<n; i++) {
	        for (int j=i+1; j<n; j++) {
	        	int c = (x-(arr[i]+arr[j]));
	            if ((c != arr[i]) && (c != arr[j] ) && hash.contains(arr[i]+arr[j])) {
	                return 1;
	            }
	        }
	    }
	    return 0;
	}
}
