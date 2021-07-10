package com.alysoft.geeksforgeeks.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Given an array A of size N, construct a Product Array P (of same size) such that P is equal to the product of all the elements of A except A[i].
 * 
 * Example:
	Input
	2
	5
	10 3 5 6 2
	2
	12 20
	Output
	180 600 360 300 900
	20 12
	
	Explanation:
	Testcase1: For the product array P, at i=0 we have 3*5*6*2. At i=1 10*5*6*2. At i=2 we have 10*3*6*2. 
	At i=3 we have 10*3*5*2. At i=4 we have 10*3*5*6
	So P is 180 600 360 300 900
 * @author ymohammad
 *
 */
public class ProductArrayPuzzle
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
            BigInteger totalProduct = new BigInteger("1");
			for(int i = 0; i < n; i++) {
				a[i]= Integer.parseInt(arrayValues[i]);
				totalProduct = totalProduct.multiply(new BigInteger(Integer.toString(a[i])));
			}
			
			productPuzzlePrecise(a, n);
            t--;
        }
	}
	private static void printProductArrayBest(int[] a, int n)
	{
		long[] leftArr = new long[n];
		long[] rightArr = new long[n];
		
		leftArr[0] = 1L;
		rightArr[n-1] = 1L;
		
		for (int i = 1; i<n; i++)
			leftArr[i] = leftArr[i-1] * a[i-1];
		
		//System.out.println("Print left array ");
		//printArray(leftArr);
		
		for (int j = n-2; j>=0; j--) 
			rightArr[j] = rightArr[j+1]*a[j+1];
		
		//System.out.println("\nPrint right array ");
		//printArray(rightArr);
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<n; i++) {
			sb.append(leftArr[i]*rightArr[i] + " ");
		}
		System.out.println(sb);
	}
	public static void productPuzzlePrecise(int[] arr, int n) {
		BigDecimal logSum = new BigDecimal(0.0d);
		double EPS = 1e-9;
		for (int x: arr) {
			logSum = logSum.add(new BigDecimal(Math.log10(x)));
			System.out.println("Adding value for :" + x + " >> logSum:" + logSum);
		}
		System.out.println("logSum value :" + logSum);
		for (int i = 0; i< n; i++) {
			BigDecimal temp = logSum.subtract(new BigDecimal(Math.log10(arr[i])));
			BigDecimal bigDecimal = new BigDecimal(10.0);
			//System.out.println(" Temp value which is used for power :" + temp.doubleValue());
			double pow = Math.pow(10.0, temp.doubleValue());
			//bigDecimal = bigDecimal.pow(temp.doubleValue());
			//bigDecimal = bigDecimal.add(new BigDecimal(EPS));
			System.out.print( (int)pow + " ");
		}
		System.out.println();
	}
	public static void productPuzzle(int[] arr, int n) {
		double logSum = 0.0d;
		double EPS = 1e-9;
		for (int x: arr) {
			
			logSum += Math.log10(x);
			System.out.println("Adding value for :" + x + " >> logSum:" + logSum);
		}
		System.out.println("logSum value :" + logSum);
		for (int i = 0; i< n; i++) {
			System.out.print((int)(Math.pow(10.0d, (logSum-Math.log10(arr[i])))) + " ");
		}
		System.out.println();
	}
	private static void printArray(long[] arr)
	{
		for (long x : arr)
			System.out.print(x + " ");
	}
	private static void printProductArray(int[] a, int n, BigInteger totalProduct)
	{
		StringBuffer sb = new StringBuffer();
		for (int x : a) {
			sb.append(totalProduct.divide(new BigInteger(Integer.toString(x))) + " ");
		}
		System.out.println(sb.toString());
	}

	private static void printProductArray(int[] a, int n, long totalProduct)
	{
		for (int x : a) {
			System.out.print(totalProduct/x + " ");
		}
		System.out.println();
	}

}
