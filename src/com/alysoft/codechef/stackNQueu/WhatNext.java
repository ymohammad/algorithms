package com.alysoft.codechef.stackNQueu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * Input:
2
5
1 5 4 8 3
10
1 4 7 4 5 8 4 1 2 6

Output:
15834
1474584162
 * @author ymohammad
 *
 */
public class WhatNext
{
	public static void main1(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine;
		while ((eachLine = br.readLine()) != null) {
			int t = Integer.parseInt(eachLine);
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	        	int n = Integer.parseInt(br.readLine());
	        	int[] arr = new int[n];
	        	String akString = br.readLine();
	        	String[] split = akString.split(" ");
	        	int i = 0;
	        	for (String s : split) {
	        		if (s != null) {
	        			arr[i] = Integer.parseInt(s.trim());
	        			i++;
	        		}
	        		
	        	}
	        	String nextNum = getNextNum(arr, n);
	        	System.out.println(nextNum);
	            t--;
	        }
	        break;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(findLCM(36, 60));
		int a = 10, b = 15, g; 
        //g = gcd(a, b); 
        //System.out.println("GCD(" + a +  " , " + b+ ") = " + g); 
          
        a = 35; b = 10; 
        g = gcd(a, b); 
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g);
	}
	
	public static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
          
        return gcd(b%a, a); 
    } 

	public static int findLCM(int a, int b) 
    { 
        int lar = Math.max(a, b); 
        int small = Math.min(a, b); 
        for (int i = lar; ; i += lar) { 
            if (i % small == 0) 
                return i; 
        } 
    } 

	private static String getNextNum(int[] arr, int n)
	{
		if (n == 1) {
			return Integer.toString(arr[0]+1);
		}
		int carry = 0;
		StringBuffer result = new StringBuffer();
		int lastDigit = arr[n-1] + 1;
		result.append(lastDigit%10); 
		carry = lastDigit/10;
		
		int i = n-2;
		while (carry > 0 || i>=0) {
			lastDigit = arr[i] + carry;
			result.append(lastDigit%10); 
			carry = lastDigit/10;
			i--;
		}
		if (carry > 0) {
			result.append(carry);
		}
		return result.reverse().toString();
	}
}
