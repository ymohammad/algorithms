package com.alysoft.geeksforgeeks.math;

import java.util.Scanner;

public class FractionAddition
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			GfG g = new GfG();
			g.addFraction(a,b,c,d);
		T--;
		}
	}

	static class GfG
	{ 	
	    void addFraction(int num1, int den1, int num2, int den2)
	    {
	        int newNum = (den1 == den2) ? (num1+num2) : (num1*den2)+(num2*den1);
	        int newDen = (den1 == den2) ? (den1) : (den1*den2);
	        
	        int gcd = getGCD(newNum, newDen);
	        if (gcd != 0) {
	            newNum = newNum/gcd;
	            newDen = newDen/gcd;
	        }
	        System.out.println(newNum+"/" + newDen);
	    }
	    
	    int getGCD(int a, int b) {
	        if (a==b) return a;
	        if (a==0) return b;
	        if (b==0) return a;
	        
	        int maxVal = a>b ? a : b;
	        int minVal = a>b ? b : a;
	        
	        return getGCD(maxVal-minVal, minVal);
	    }
	}

}
