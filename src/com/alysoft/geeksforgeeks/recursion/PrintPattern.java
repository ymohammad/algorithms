package com.alysoft.geeksforgeeks.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintPattern
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            StringBuffer buff = new StringBuffer();
            int target = n;
            buff.append(n + " ");
            n = (n>0) ? n-5 : n+5;
            printSequence(n, target, false, buff);
            System.out.println(buff.toString());
            t--;
        }
	}
	public static void printSequence(int n, int target, boolean isUp, StringBuffer buff) {
		buff.append(n + " ");
		if (n == target) {
	        return;
	    } 
		if (n <= 0 && !isUp) {
	    	isUp = true;
	    } 
		
		if (n>0 && !isUp) {
	    	printSequence(n-5, target, isUp, buff);
	    } else {
	    	printSequence(n+5, target, isUp, buff);
	    }
	}
}
