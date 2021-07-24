package com.alysoft.completedsa.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimeSum
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
            
			int x = getPrimeSum(n);
			
			System.out.println(x);
            t--;
        }
	}
	public static int getPrimeSum(int n) {
	    int sum = 0;
	    boolean[] primeNum = new boolean[n+1];
	    //Arrays.fill(primeNum, true);
	    for (int i=2; i<=n; i++) {
	    	if (!primeNum[i]) {
	    		sum += i;
	    		for (int p = i*2; p<=n; p+=i) {
	    			primeNum[p] = true;
	    		}
	    	}
	    }
	    return sum;
	}
}
