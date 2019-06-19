package com.alysoft.geeksofgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpsAndDowns
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
			printUpsAndDownsCount(a, n);
            t--;
        }
	}

	private static void printUpsAndDownsCount(int[] a, int n)
	{
		int upsCount = 0;
		int downsCount = 0;
		int i = 1;
		while ((i+1) < n) {
			if (a[i]<a[i+1] && a[i]<a[i-1]) {
				downsCount++;
			} else if (a[i]>a[i+1] && a[i]>a[i-1]) {
				upsCount++;
			}
			i++;
		}
		System.out.println(upsCount + " " + downsCount);
	}
	
	
}
