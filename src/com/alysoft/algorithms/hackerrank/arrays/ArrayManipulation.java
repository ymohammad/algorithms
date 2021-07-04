package com.alysoft.algorithms.hackerrank.arrays;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayManipulation {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok = null;
	
	public static void main(String[] args) {
		//bruteForceApproach();
		arrayDifferanceApproach();
    }
	public static void arrayDifferanceApproach() {
		int n = getInt();
        int m = getInt();
        long[] arr = new long[n];
        long globalMax = 0;
        for(int a0 = 0; a0 < m; a0++){
            int a = getInt();
            int b = getInt();
            int k = getInt();
            
            arr[a-1]+=k;
            if(b<n) {
            	arr[b]-=k; 
            }
        }
        
        long temp=0;

        for(int i=0;i<n;i++){
            temp += arr[i];
            if(temp> globalMax) globalMax=temp;
        }
	}
	public static void bruteForceApproach() {
		int n = getInt();
        int m = getInt();
        long[] arr = new long[n];
        long globalMax = 0;
        for(int a0 = 0; a0 < m; a0++){
            int a = getInt();
            int b = getInt();
            int k = getInt();
            
            for(int i = a; i<=b; i++) {
                long sum = arr[i-1] + k;
                globalMax = globalMax < sum ? sum : globalMax;
                arr[i-1] = sum;
            }
        }
        System.out.println(globalMax);
	}
	
	public static void printArray(long[] arr) {
		for(long x: arr) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}
	static String gets() throws IOException{
	    if(tok == null || !tok.hasMoreTokens())
	        tok = new StringTokenizer(br.readLine());
	    return tok.nextToken();
	}

	static int getInt() {
	    try {
	        return Integer.parseInt(gets());
	    } catch(IOException | NumberFormatException e) {
	        return -1;
	    }
	}
}
