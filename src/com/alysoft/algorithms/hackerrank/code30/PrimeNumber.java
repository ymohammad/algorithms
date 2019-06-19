package com.alysoft.algorithms.hackerrank.code30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        /* Enter your code here. */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int a[] = new int[t];
        for(int x = 0; x<t; x++) {
            int n = scan.nextInt();
            a[x] = n;
        }
        for (int n: a) 
        	System.out.println(checkIsPrime(n));
        
        ArrayList<String> list = new ArrayList<String>();
        Collections.sort(list);
    }
    
    public static String checkIsPrime(int n) {
        if (n == 1) return "Not prime";
        
        if (n == 2) return "Prime";
        
        for (int x = 2; x<=n/2; x++) {
            if (n%x == 0) {
                return "Not prime";
            }
        }
        return "Prime";
    }
}