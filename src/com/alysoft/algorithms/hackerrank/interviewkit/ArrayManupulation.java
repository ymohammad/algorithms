package com.alysoft.algorithms.hackerrank.interviewkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayManupulation
{
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok = null;
	
	public static void main(String[] args) {
        int n = getInt();
        int m = getInt();
        long[] arr = new long[n];
        long globalMax = 0;
        for(int a0 = 0; a0 < m; a0++){
            int a = getInt();
            int b = getInt();
            int k = getInt();
            
            arr[a-1]+=k;
            if(b<n) arr[b]-=k; 
        }
        
        long temp=0;

        for(int i=0;i<n;i++){
            temp += arr[i];
            if(temp> globalMax) globalMax=temp;
        }
        System.out.println(globalMax);
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
