package com.alysoft.algorithms.hackerrank.arrays;


import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 * 
 * Sample Input

	5 4
	1 2 3 4 5
  
  Sample Output
	5 1 2 3 4
 * 
 * @author ymohammad
 *
 */
public class LeftRotation {
	private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scan.nextLine().split(" ");

        int n = Integer.parseInt(nd[0].trim());

        int d = Integer.parseInt(nd[1].trim());

        int[] a = new int[n];
        int[] b = new int[n];
        
        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }
        
        //normalApproach(a, d, n);
        leftShiftApproach(a, d, n);
    }
    
    public static void normalApproach(int[] a, int d, int n) {
    	int[] b = new int[n];
    	int startInd = a.length == d ? 0 : d;
        int bCurrentInd = 0;
        int aIndex = startInd;
        do {
            b[bCurrentInd] = a[aIndex];
            System.out.print(a[aIndex] + " ");
            aIndex = (aIndex == a.length-1) ? 0 : aIndex+1;
            bCurrentInd++;
        } while (aIndex != startInd);
    }
    
    public static void leftShiftApproach(int[] sourceArray, int d, int n) {
    	int[] shiftedArray = new int[n];
    	for(int i=0; i<n; i++) {
    		shiftedArray[(i + n-d)%n] = sourceArray[i];
    	}
    	
    	//Print the array.
    	for(int val: shiftedArray)
    		System.out.print(val + " ");
    }
}
