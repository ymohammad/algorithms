package com.alysoft.geeksofgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of words, print the count of all anagrams together in sorted order (increasing order of counts).
	For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, then grouped anagrams are “(dog, god) (cat, tac, act)”. 
	So the output will be 2 3.

	Input:
	First line consists of T test case. First line of every test case consists of N, denoting the number of words in array. 
	Second line of every test case consists of words of array.

	Output:
	Single line output, print the counts of anagrams in increasing order.
 * 
 * Example:
	Input:
	2
	5
	act cat tac god dog
	3
	act cat tac
	Output:
	2 3
	3
 * @author ymohammad
 *
 */
public class GroupAnagramsTogether
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
            HashMap<String, Integer> anaMap = new HashMap<String, Integer>();
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        String sortStr = sortNGet(s);
			        if (anaMap.containsKey(sortStr)) {
			        	anaMap.put(sortStr, anaMap.get(sortStr)+1);
			        } else {
			        	anaMap.put(sortStr, 1);
			        }
			    }
			}
				
			String x = getSortedAnagramCount(anaMap, n);
			
			System.out.println(x);
            t--;
        }
	}
	
	private static String getSortedAnagramCount(HashMap<String, Integer> anaMap, int n)
	{
		int[] resultArr = new int[anaMap.size()];
		Collection<Integer> values = anaMap.values();
		int i = 0;
		for (int x: values) {
			resultArr[i] = x;
			i++;
		}
		Arrays.sort(resultArr);
		StringBuffer buff = new StringBuffer();
		for (int a: resultArr) {
			buff.append(a + " ");
		}
		return buff.toString().trim();
	}

	public static String sortNGet(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);
	}
}
