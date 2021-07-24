package com.alysoft.completedsa.math;
import java.util.*;
import java.lang.*;
import java.io.*;
public class FindAllPrimeFactors
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
           System.out.println("The number :" + n);
           printAllFactors(n);

           t--;
       }
	 }
	 public static void printAllFactors(int n) {
	     boolean arr[] = new boolean[n+1];
	     for (int x = 2; x<arr.length; x++) {
	         arr[x] = true;
	     }
	     System.out.println("Starting the new row..");
	     for (int p = 2; p*p<n; p++) {
	         if (arr[p]) {
	             for (int i = p*p; i <= n; i=i+p) {
	                 arr[i] = false;
	             }
	         }
	     }
	     
	     for (int a=0; a<arr.length; a++) {
	         if (arr[a]) {
	             System.out.print(a + " ");
	         }
	     }
	     System.out.println();
	 }
}
