package com.alysoft.geeksforgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoopInArray
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
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			while(i<n) {
			    if (arrayValues[i].trim().length() > 0) {
			        a[i]= Integer.parseInt(arrayValues[i].trim());
			        i++;
			    }
			}
				
			int x = getArrayLoop2(a, n);
			
			System.out.println(x);
            t--;
        }
	}
	private static int getArrayLoop3(int[] a, int n)
	{
		int i = 0;
		a[0] = a[0]+n;
		while (i<n) {
			if (a[i]<=i) {
				return 1;
			}
			
			i++;
		}
		return 0;
	}
	private static int getArrayLoop2(int[] a, int n)
	{
		int i = 0;
		a[0] = a[0]+n;
		while (i<n) {
			if (a[i]<n) {
				if (a[a[i]%n] != 0) {
					return 1;
				} else {
					a[a[i]%n] = n + a[a[i]%n];
				}
			}
			
			i++;
		}
		return 0;
	}
	private static int getArrayLoop(int[] a, int n)
	{
		int i = 0;
		a[0] = -1*a[0];
		while (i<n) {
			if (a[i]<n) {
				if (a[Math.abs(a[i])] < 0) {
					return 1;
				} else {
					a[Math.abs(a[i])] = -1 * a[Math.abs(a[i])];
				}
			}
			
			i++;
		}
		return 0;
	}
}
