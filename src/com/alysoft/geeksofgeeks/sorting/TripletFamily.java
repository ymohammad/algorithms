package com.alysoft.geeksofgeeks.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class TripletFamily
{
	public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
           ArrayList<Integer> res = new ArrayList<Integer>();
           res = findTriplet(arr, n);
            if(res.size()!=3)System.out.println("-1");
		    else
		    {
		        Collections.sort(res);
		        if(res.get(0)+res.get(1) == res.get(2))
		            System.out.println("1");
		        else
		             System.out.println("0");
		    }
        }
    }
	public static ArrayList<Integer> findTriplet(int arr[], int n) {
		HashSet<Integer> hash = new HashSet<Integer>();
		
		for (int x: arr) {
			hash.add(x);
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			for (int j = i+1; j<n; j++) {
				if (hash.contains(arr[i]+arr[j])) {
					res.add(arr[i]);
					res.add(arr[j]);
					res.add(arr[i]+arr[j]);
					return res;
				}
			}
		}
		return res;
    }
}
