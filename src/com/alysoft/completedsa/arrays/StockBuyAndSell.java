package com.alysoft.completedsa.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StockBuyAndSell
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
			
			printStockBuy(a, n);
            t--;
        }
	}
	
	public static void printStockBuy(int a[], int n) {
		StringBuffer buff = new StringBuffer();
		int buyIndex = 0;
		int i = 0;
		
		while (i < n) {
			if ((i+1) < n && a[i+1] < a[i]) {
				if (i != buyIndex) {
					buff.append("(" + buyIndex + " " + i + ") ");
				}
				buyIndex = i+1;
			}
			i++;
		}
		if ((i-1) != buyIndex) {
			buff.append("(" + buyIndex + " " + (i-1) + ") ");
		}
		
		if (buff.length() > 0) {
			System.out.println(buff.toString().trim());
		} else {
			System.out.println("No Profit");
		}
	}
}
