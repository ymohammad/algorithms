package com.alysoft.geeksofgeeks.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ImmediateSmallarElement
{
	public static void main (String[] args) throws Exception
	 {
	    // Input the number of test cases you want to run
       BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(sc.readLine());

       // One by one run for all input test cases
       while (t > 0)
       {
           // Input the size of the array
           int n = Integer.parseInt(sc.readLine());

           int arr[] = new int[n];
           // Input the array
           String[] sArray = sc.readLine().split(" ");
           for (int i = 0; i < n; i++)
               arr[i] = Integer.parseInt(sArray[i]);

           for (int i = 1; i < n; i++) {
               if (arr[i-1]>arr[i]) {
                   System.out.print(arr[i] + " ");
               } else {
                   System.out.print(-1 + " ");
               }
           }
           System.out.println(-1);

           t--;
       }
	 }
}
