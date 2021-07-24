package com.alysoft.completedsa.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LastTwoDigitsFibonacci
{
	//static List<Integer> fabinociList = new ArrayList<Integer>();
	public static void main (String[] args)
	 {
		try {
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		       int t = Integer.parseInt(sc.readLine());

		       // One by one run for all input test cases
		       while (t > 0)
		       {
		           // Input the size of the array
		           int n = Integer.parseInt(sc.readLine());
		           n = n > 300 ? n%300 : n;
		           int febinociNumber = getFebinociNumber(n);
		           System.out.println(febinociNumber);

		           t--;
		       }
		} catch (Exception ex) {
			
		}
		//fabinociList.add(0L);
		//fabinociList.add(1);
		//fabinociList.add(1);
	    // Input the number of test cases you want to run
       //Scanner sc = new Scanner(System.in);
       
	 }
	private static int addNGetLastTwoDigits(int a, int b) {
		int c = a + b;
		return getLastTwoDigits(c);
	}
	private static int getLastTwoDigits(int febinociNumber)
	{
		if (febinociNumber <= 99) {
			return (int)febinociNumber;
		}
		
		int digit0 = febinociNumber%10;
		febinociNumber = febinociNumber/10;
		int digit1 = febinociNumber%10;
		
		return Integer.parseInt(digit1 + "" + digit0);
	}

	public static int getFebinociNumber(int n) {
		if (n == 1) return 1;
		if (n == 2) return 1;
		int ta = 1;
		int tb = 1;
		int tc = 0;
		for (int i = 3; i<=n; i++) {
			tc = addNGetLastTwoDigits(ta, tb);
			ta = tb;
			tb = tc;
		}
		return tc;
		/*
		if (n > fabinociList.size()) {
			int startIndex = fabinociList.size();
			for (int i = startIndex; i<n; i++) {
				fabinociList.add(addNGetLastTwoDigits(fabinociList.get(i-1), fabinociList.get(i-2)));
			}
		}
		
		return fabinociList.get(n-1);
		*/
	}

}
