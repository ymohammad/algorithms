package com.alysoft.geeksofgeeks.math;

public class TriangularNumber
{

	public static void main(String[] args)
	{
		System.out.println("Triangle 4:" + isTriangle(4));
		System.out.println("Triangle 1:" + isTriangle(1));
		System.out.println("Triangle 3:" + isTriangle(3));
		System.out.println("Triangle 6:" + isTriangle(6));
		System.out.println("Triangle 6:" + isTriangle(3));
		System.out.println("Triangle 4:" + isTriangle(4));
		System.out.println("Triangle 6:" + isTriangle(6));
		System.out.println("Triangle 55:" + isTriangle(55));
		System.out.println("Triangle 345:" + isTriangle(345));
	}
	public static int isTriangle(int n) {
	     int rowNum = 1;
	     int returnVal = 1;
	     int temp = 1;
	     while (temp < n) {
	         int currentRowTotal = 0;
	         for (int x=1; x<=rowNum; x++) {
	             currentRowTotal = currentRowTotal + x;
	         }
	         if (currentRowTotal>n) {
	             returnVal = 0;
	             break;
	         }
	         rowNum++;
	         temp = currentRowTotal;
	     }
	     
	     return returnVal;
	 }
}
