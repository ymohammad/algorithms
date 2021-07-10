package com.alysoft.geeksforgeeks.sorting;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SortingElementsArrayFrequency
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
				
			printFrequencySort(a, n);
            t--;
        }
	}
	public static void printFrequencySort(int[] a, int n) {
	    int[] b = new int[61];
	    for (int i=0; i<n; i++) {
	        b[a[i]]++;
	    }
	    HashMap<Integer, ArrayList<Integer>> hash = new HashMap<Integer, ArrayList<Integer>>();
	    for (int i = 0; i<b.length; i++) {
	        if (b[i] != 0) {
	            ArrayList<Integer> list = null;
	           if (!hash.containsKey(b[i])) {
	               list = new ArrayList<Integer>();
	               list.add(i);
	           } else {
	               list = hash.get(b[i]);
	               addToList(list, i);
	           }
	           hash.put(b[i], list);
	        }
	    }
	    List<Integer> keyList = new ArrayList<>(hash.keySet());
	    Collections.sort(keyList);
	    
	    StringBuffer buff = new StringBuffer();
	    int j = keyList.size()-1;
	    while (j>=0) {
	    	Integer eachKey = keyList.get(j);
	    	ArrayList<Integer> arrayList = hash.get(eachKey);
	    	for (int eachNum: arrayList) {
	    		int m = eachKey;
	    		while (m > 0) {
		    		buff.append(eachNum + " ");
		    		m--;
		    	}
	    	}
	    	j--;
	    }
	    System.out.println(buff.toString().trim());
	}
	private static void addToList(ArrayList<Integer> list, int i)
	{
		for (int j=0; j<list.size(); j++) {
			Integer val = list.get(j);
			if (i<val) {
				list.add(j, i);
				return;
			}
		}
		list.add(i);
	}
}
