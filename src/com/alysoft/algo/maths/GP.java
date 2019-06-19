package com.alysoft.algo.maths;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GP
{
	public static void main(String[] args) throws Exception {
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
	        while (t > 0)
	        {
	            String line = br.readLine();
	            String[] split = line.split(" ");
	            int a = Integer.parseInt(split[0].trim());
	            int b = Integer.parseInt(split[1].trim());
	            int n = Integer.parseInt(br.readLine().trim());
	            
	            int nthTerm = termOfGP(a, b, n);
	            System.out.println(nthTerm);
	            t--;
	        }
		} 
		catch (Exception e)
		{
		}
	}
	public static int termOfGP(int A,int B,int N)
    {
        //Your code here
		double a = (double)A;
		double b = (double)B;
        double r = b/a;
        double newVal = Math.pow(r, N-1);
        newVal = A * newVal;
        return (int)Math.floor(newVal);
    }
}
