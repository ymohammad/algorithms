package com.alysoft.completedsa.math;

import java.util.Scanner;

public class NthRoot
{
	public static void main (String[] args)
	 {
	    // Input the number of test cases you want to run
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();

       // One by one run for all input test cases
       while (t > 0)
       {
           // Input the size of the array
           int n = sc.nextInt();
           int m = sc.nextInt();
           int d = getPerfectRoot(n, m);

           // Compute and print result
           System.out.println(d);

           t--;
       }
	 }
	 public static int getPerfectRoot(int n, int m) {
	     if (m == 1) return 1;
	     int d = -1;
	     
	     if (m%n == 0 && isPerfectRoot(n, n, m)) {
               d = n;
       } else {
           int sq = (int)Math.sqrt(m);
           for (int i=2; i<=sq; i++) {
               if (m%i == 0) {
                   if(isPerfectRoot(i, n, m)) {
                       d = i;
                       break;
                   }
               }
           }
       }
       return d;
	 }
	 public static boolean isPerfectRoot(int i, int n, int m) {
	     int total = i;
	     for (int x = 2; x <= n; x++) {
	         total = total * i;
	     }
	     return total == m;
	 }
}
