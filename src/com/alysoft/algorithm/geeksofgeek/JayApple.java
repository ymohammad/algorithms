package com.alysoft.algorithm.geeksofgeek;
import java.util.*;
import java.lang.*;
import java.io.*;

public class JayApple {
	

		public static void main (String[] args)
		 {
		    int[] arr = null;
		    // Input the number of test cases you want to run
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	            // Input the size of the array
	            int n = sc.nextInt();
	 
	            arr = new int[n];
	            for(int x = 0; x<arr.length; x++)
	                arr[x] = 0;
	                
	            // Input the array
	            for (int i = 0; i < n; i++) {
	                int queueMem = sc.nextInt();
	                System.out.println(">>> Next queMem :" + queueMem + ".. Value at " + arr[queueMem]);
	                arr[queueMem] = arr[queueMem] + 1;
	            }
	            int minApples = 0;
	            for(int y: arr) {
	                if (y >= 1) 
	                    minApples++;
	                    
	            }
	            
	            // Compute and print result
	            System.out.println(minApples);
	 
	            t--;
	        }
		 }
	
}
