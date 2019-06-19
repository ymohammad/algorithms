package com.alysoft.algo.codechef.may19contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You have become good friends with Chef. Right now, Chef is busy in the kitchen, so he asked you to solve a problem for him.

Consider a list of integers L. Initially, L contains the integers 1 through N, each of them exactly once (but it may contain multiple
 copies of some integers later). 
The order of elements in L is not important. You should perform the following operation N−1 times:

Choose two elements of the list, let's denote them by X and Y. These two elements may be equal.
Erase the chosen elements from L.
Append the number X+Y+X⋅Y to L.
At the end, L contains exactly one integer. Find the maximum possible value of this integer. Since the answer may be large, compute 
it modulo 1,000,000,007 (109+7).
 * @author ymohammad
 *
 */
public class ReduceToOne
{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tLine = null;
		while ((tLine = br.readLine()) == null) {
		}
		int t = Integer.parseInt(tLine.trim());
		 
        while (t > 0)
        {
        	int n = Integer.parseInt(br.readLine().trim());
            
            //int reducedValue = reduceToOne(n);
			//System.out.println(reducedValue);
        	int reducedValue = reduceToOne2(n);
			System.out.println(reducedValue);
			 reducedValue = reduceToOne3(n);
			System.out.println(reducedValue);
			reducedValue = reduceToOne4(n);
			System.out.println(reducedValue);
            t--;
        }
	}

	private static int reduceToOne(int n)
	{
		int modulo = 1000000007;
		Queue<Integer> queue = new LinkedList<Integer>();
		int j = 1;
		while (j <= n) {
			queue.add(j);
			j++;
		}
		j = 1;
		while (j < n && queue.size()>1) {
			int x = queue.poll()%modulo;
			int y = queue.poll()%modulo;
			long product = (x*y)%modulo;
			int z = (x + y + (int)product)%modulo;
			queue.add(z);
			j++;
		}
		System.out.println("Total :" + queue.peek());
		return queue.peek()%modulo;
	}
	private static int reduceToOne2(int n)
	{
		int modulo = 1000000007;
		Queue<Integer> queue = new LinkedList<Integer>();
		int j = 1;
		while (j <= n) {
			queue.add(j);
			j++;
		}
		j = 1;
		long bigValue = queue.poll();
		while (j < n && queue.size()>0) {
			int y = queue.poll();
			long product = (bigValue*y);
			bigValue = (bigValue + y + product);
			bigValue = bigValue%modulo;
			j++;
		}
		System.out.println("Result :" + bigValue + ">>> queue:" + queue);
		int result = (int)bigValue%modulo;
		return result;
	}
	private static int reduceToOne3(int n)
	{
		int modulo = 1000000007;
		int j = 1;
		int eachValue = 1;
		long bigValue = eachValue;
		while (j < n) {
			int y = eachValue+1;
			long product = (bigValue*y)%modulo;
			bigValue = (bigValue + y + product);
			bigValue = bigValue%modulo;
			j++;
			eachValue++;
		}
		System.out.println("Result :" + bigValue + ">>> queue:" + eachValue + " >>> j-" + j);
		int result = (int)bigValue%modulo;
		return result;
	}
	private static int reduceToOne4(int n)
	{
		int modulo = 1000000007;
		int eachValue = n;
		long sumOfElements = ((eachValue * (eachValue + 1))/2)%modulo;
		long productValue = getFactorial(eachValue, modulo);
		int result = (int)(sumOfElements + productValue)%modulo;
		return result;
	}

	private static long getFactorial(int n, int p)
	{
        long result = 1; 
        for (int i = 1; i <= n; i++) 
            result = (result * i) % p; 
      
        return result;
	}
}
