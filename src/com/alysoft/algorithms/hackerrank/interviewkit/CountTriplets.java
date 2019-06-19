package com.alysoft.algorithms.hackerrank.interviewkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given an array and you need to find number of tripets of indices (i, j, k) such that the 
 * elements at those indices are in geometric progression for a given common ratio r and i<j<k.

https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * @author ymohammad
 *
 */
public class CountTriplets
{
	
	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	long count = 0L;
    	
    	if (r == 1) return count;
    	
    	HashMap<Long, Long> firstTwoVariableMap = new HashMap<>();
    	HashMap<Long, Long> secondTwoVariableMap = new HashMap<>();
    	int n = arr.size();
    	for (int i=0; i<n; i++) {
    		long a = arr.get(i);
    		long b = arr.get(i) *r;
    		if (firstTwoVariableMap.containsKey(b)) {
    		} else {
    			firstTwoVariableMap.put(b, a);
    		}
    		/*
    		if (i+2 < n) {
        		long a = arr.get(i);
    			long b = arr.get(i+1);
    			long c = arr.get(i+2);
    			//b^{2}=ac
    			if (b == a*r && c == a*r*r) {
    				//System.out.println("Found it for " + a + ", " + b + ", " + c + " => (" + i + ", " + j + ", " + k + ")" );
    				count++;
    			}
    		}*/
    	}
    	return count;
    }
	
    static long countTripletsBruteForce(List<Long> arr, long r) {
    	long count = 0L;
    	int n = arr.size();
    	for (int i=0; i<n; i++) {
    		for (int j=i+1; j<n; j++) {
    			for (int k = j+1; k<n; k++) {
    				long a = arr.get(i);
    				long b = arr.get(j);
    				long c = arr.get(k);
    				//b^{2}=ac
    				if (b == a*r && c == a*r*r) {
    					System.out.println("Found it for " + a + ", " + b + ", " + c + " => (" + i + ", " + j + ", " + k + ")" );
    					count++;
    				}
    			}
    		}
    	}
    	return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTripletsBruteForce(arr, r);
        System.out.println(ans);
        bufferedReader.close();
    }
}
