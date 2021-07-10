package com.alysoft.geeksforgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinDistanceBTWNumbers
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] arrayValues = line.split(" ");
            int[] a = new int[n];
			for(int i = 0; i < n; i++)
				a[i]= Integer.parseInt(arrayValues[i]);
			
			line = br.readLine();
			arrayValues = line.split(" ");
			int res = minDist(a, n, Integer.parseInt(arrayValues[0]), Integer.parseInt(arrayValues[1]));
			System.out.println(res);
            t--;
        }
	}
	
	public static int minDist(int arr[], int n, int x, int y) {
		
		int i = 0;
		int partX = 2*n;
		int partY = 2*n;
		int minDistance = 2*n;
		while (i < n) {
			if (arr[i] == x) {
				partX = i;
				minDistance = Math.min(minDistance, Math.abs(partX-partY));
			} else if (arr[i] == y) {
				partY = i;
				minDistance = Math.min(minDistance, Math.abs(partX-partY));
			}
			System.out.println("partX :" + partX + " >> partY:" + partY + " >> minDistance:" + minDistance);
			
			i++;
		}
		
		if (partX == 2*n || partY == 2*n) return -1;
		
		return Math.min(minDistance, Math.abs(partX-partY));
	}
}
