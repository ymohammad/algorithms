package com.alysoft.algo.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array arr[] of N numbers. The task is to print only those numbers whose digits are from set {1,2,3}.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
Each test case consists of two lines. First line of each test case contains an integer N and the second line contains N space separated array elements.

Output:
For each test case, In new line print the required elements in increasing order. if there is no such element present in the array print "-1".

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= A[i] <= 106

Example:
Input:
3
3
4 6 7
4
1 2 3 4
5
12 111 34 13 55

Output:
-1
1 2 3
12 13 111

Explanation:
Testcase 1: No elements are there in the array which contains digits 1, 2 or 3.

Testcase 2: 1, 2 and 3 are the only elements in the array which conatins digits as 1, 2 or 3.
 * @author ymohammad
 *
 */
public class NumbersContaining123
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		HashSet<Integer> hash = getNumbersHash();
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
			
			printSetNumbers(a, n, hash);
            t--;
        }
	}
	public static void printSetNumbers(int[] arr, int n, HashSet<Integer> hash)
	{
		StringBuffer buff = new StringBuffer();
		Arrays.sort(arr);
		for (int x : arr) {
			if (isValidNumber(hash, x)) {
				buff.append(x + " ");
			}
		}
		if (buff.length() == 0) {
		    buff.append(-1);
		}
		System.out.println(buff);
	}
	public static boolean isValidNumber(HashSet<Integer> hash, int x) {
	    boolean returnVal = false;
	    if (x<1000) {
	    	returnVal = hash.contains(x);
	    } else {
	    	while (x>0) {
	    		returnVal = hash.contains(x%1000);
	    		if (!returnVal) return returnVal;
	    		
				x = x/1000;
			}
	    }
	    return returnVal;
	}
	public static HashSet<Integer> getNumbersHash()
	{
		int[] nums = {1, 2, 3};
		HashSet<Integer> hash = new HashSet<Integer>();
		
		for (int i=0; i<3; i++) {
		    hash.add(nums[i]);
			for (int j = 0; j<3; j++) {
			    hash.add(nums[i] * 10 + nums[j]);
				for (int k = 0; k<3; k++) {
					hash.add(nums[i]*100+ nums[j]*10 + nums[k]);
				}
			}
		}
		return hash;
	}
}
