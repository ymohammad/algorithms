package com.alysoft.geeksforgeeks.searching;

import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			System.out.println(floorSqrt(a));
			t--;
		}
	}
	public static long floorSqrt(long x) {
		int count = 0;
		long returnVal = 1L;
		while (returnVal*returnVal<=x) {
			returnVal++;
		}

		return --returnVal;
	}
}
