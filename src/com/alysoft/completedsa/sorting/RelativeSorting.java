package com.alysoft.completedsa.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a way that the relative 
 * order among the elements will be same as those in A2. For the elements not present in A2, append them at last in sorted order. 
 * It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] 
 * has all distinct elements.

Note: Expected time complexity is O(N log(N)).
 * 
 * Example:
	Input:
	1
	11 4
	2 1 2 5 7 1 9 3 6 8 8
	2 1 8 3
	
	Output:
	2 2 1 1 8 8 3 5 6 7 9
 * @author ymohammad
 *
 */
public class RelativeSorting
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
            int n1 = Integer.parseInt(arrayValues[0].trim());
            int n2 = Integer.parseInt(arrayValues[1].trim());

            int[] a = new int[n1];
            int[] b = new int[n2];
            
            line = br.readLine();
            arrayValues = line.trim().split(" ");
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
			
			line = br.readLine();
            arrayValues = line.trim().split(" ");
            i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			       b[i]= Integer.parseInt(s.trim());
			       i++;
			    }
			}
			makeRelativeSort(a, b, n1, n2);
			printArray(a);
            t--;
        }
	}
	
	public static void makeRelativeSort(int[] a, int[] b, int n1, int n2)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int x: a) {
			if (map.containsKey(x)) {
				map.put(x, 1+map.get(x));
			} else {
				map.put(x, 1);
			}
		}
		
		int k = 0;
		for (int i = 0; i<n2; i++) {
			int s = b[i];
			if (map.containsKey(s)) {
				int n = map.get(s);
				while (n>0) {
					a[k] = s;
					k++;
					n--;
				}
				map.remove(s);
			}
		}
		
		Set<Integer> keySet = map.keySet();
		List<Integer> list = new ArrayList<Integer>(keySet);
		
		Collections.sort(list);
		int remSize = list.size();
		for (int i = 0; i<remSize; i++) {
			int s = list.get(i);
			int n = map.get(s);
			while (n>0) {
				a[k] = s;
				k++;
				n--;
			}
		}
	}

	private static void printArray(int[] arr)
	{
	    StringBuffer buff = new StringBuffer();
		for (int x: arr) {
			buff.append(x + " ");
		}
		System.out.println(buff.toString().trim());
	}
}
