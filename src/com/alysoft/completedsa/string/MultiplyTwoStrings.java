package com.alysoft.completedsa.string;

import java.util.Scanner;

/**
 * Given two numbers as stings s1 and s2 your task is to multiply them. You are required to complete the function 
 * multiplyStrings which takes two strings s1 and s2 as its only argument and returns their product as strings.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow . 
Each test case contains two strings s1 and s2 .

Output:
For each test case in a new line the output will be a string denoting the product of the two strings s1 and s2.
 * @author ymohammad
 *
 */
public class MultiplyTwoStrings
{
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            System.out.println(multiply(a,b));
        }
    }
	public static String multiply(String a,String b){
        //return new java.math.BigInteger(a).multiply(new java.math.BigInteger(b)).toString();
		if (a.length() == 0 || b.length() == 0) return "0";
		
		a = (a.charAt(0) == '-') ? a.substring(1) : a;
		b = (b.charAt(0) == '-') ? b.substring(1) : b;
		
		a = new StringBuffer(a).reverse().toString();
		b = new StringBuffer(b).reverse().toString();
		
		System.out.println(a);
		System.out.println(b);
		int n = a.length();
		int m = b.length();
		
		int[] res = new int[n+m];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				res[i+j] = res[i+j] + ((a.charAt(i)-'0')*(b.charAt(j)-'0'));
				printtArray(res);
			}
		}
		printtArray(res);
		
		String product = new String(); 
        // Multiply with current digit of first number 
        // and add result to previously stored product 
        // at current position.  
        for (int i = 0; i < res.length; i++) 
        { 
            int digit = res[i]%10; 
            int carry = res[i]/10; 
            if(i+1<res.length) 
            { 
            	res[i+1] = res[i+1] + carry; 
            } 
            product = digit+product; 
        } 
        
		return product;
    }
	
	private static void printtArray(int[] res)
	{
		for (int a: res) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	public static String multiply1(String a,String b){
        //return new java.math.BigInteger(a).multiply(new java.math.BigInteger(b)).toString();
		
		String shortStr = a.length() > b.length() ? b : a;
		String longStr = a.length() > b.length() ? a : b;
		
		int sN = shortStr.length();
		for (int i = 0; i< sN; i++) {
			longStr = addStrItself(longStr);
		}
		return longStr;
    }
	private static String addStrItself(String strVal)
	{
		StringBuffer finalStr = new StringBuffer();
		int i = strVal.length()-1;
		int carry = 0;
		while (i>=0) {
			int x = (Integer.parseInt(String.valueOf(strVal.charAt(i)))*2) + carry;
			carry = x/10;
			finalStr.append(x%10);
			i--;
		}
		finalStr.reverse();
		return finalStr.toString();
	}
}
