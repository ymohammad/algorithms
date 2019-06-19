package com.alysoft.geeksofgeeks.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LargestPrimeFactor
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		// Input the number of test cases you want to run
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            long n = Long.parseLong(br.readLine());
 
            // Compute and print result
            System.out.println(getLargestPrimeFactor(n));
 
            t--;
        }
	}

	public static int getLargestPrimeFactor(long n) {
		int prime = 0;
		while (n%2 == 0) {
			prime = 2;
			n = n/2;
		}
		for (int x =3; x*x<=n; x = x+2) {
			//System.out.println("X :" + x + " N:" + n + " >> " + (n%x));
			while (n%x == 0) {
				prime = x;
				n = n/x;
			}
		}
		if (n > 2) {
			prime = (int)n;
		}
		return prime;
	}

	private static boolean isPrime(int x)
	{
		int startDivisor = (int)Math.ceil(Math.sqrt(x));
		for (int i = startDivisor; i>1; i--) {
			if (x%i == 0) {
				return false;
			}
		}
		return true;
	}
}
