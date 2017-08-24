package com.alysoft.algorithms.stacks;

import java.util.Scanner;

/**
 * Pick a value from 'a' stack or 'b' stack.. the sum of what you have picked from 'a' and 'b' should not be exceed 'x'. 
 * you will be failed if exceed. At last find the number of maximum possible stacks.
 * 
 * @author ymohammad
 *
 */
public class TwoStacksGame {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            // your code goes here
        }
    }
}
