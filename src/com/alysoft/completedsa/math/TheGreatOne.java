package com.alysoft.completedsa.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array A of size N which consists of positive integers. 
 * The task is to make the largest number K from array elements such that every chosen array element has exactly 3 divisiors. 
 * If no such number can be formed then print -1.

Input:
The first line of input contains T denoting the number of testcases. Each testcase contains two lines. The first line contains N(size of the array) and second line contains N space separated elements of an array

Output:
Print the required answer in new line

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= A[i] <= 1018
 

Example:
Input:
1
10
1 2 3 4 5 6 7 8 9 10

Output:
94

Explanation:
Testcase 1: In the given array 1, 2, 3, 4, 5, 6, 7, 8, 9, 10. 4 and 9 are the only elements which are having exactly 3 divisors i.e 
divisors of 4 are 1, 2, 4 and divisors of 9 are 1, 3, 9. Thus 94 is the largest number formed from these two numbers having exactly 3 divisors.
 * @author ymohammad
 *
 */
public class TheGreatOne
{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] arrayValues = line.split(" ");
            ArrayList<Long> primeSquareList = new ArrayList<Long>();
            for (String s : arrayValues) {
            	long eachNumber = Long.parseLong(s);
				if (isSquareOfPrime(eachNumber)) {
            		primeSquareList.add(eachNumber);
            	}
            }
            
            if (primeSquareList.size() == 0) {
            	System.out.println("-1");
            } else {
            	Collections.sort(primeSquareList);
                StringBuffer sb = new StringBuffer();
                int listSize = (primeSquareList.size()-1);
                for(int x=listSize; x>=0; x--) {
                	sb.append(primeSquareList.get(x));
                }
                System.out.println(sb.toString());
            }
            t--;
        }
	}
	private static boolean isSquareOfPrime(long n) {
		if (!isPerfectSquare(n)) return false;
		
		double sqrt = Math.sqrt(n);
		return isPrime(sqrt);
	}
	private static boolean isPrime(double number)
	{
		if (number == 1) return false;
		if (number == 2) return true;
		double numberSqrt = Math.sqrt(number);
		for (int x=2; x<=numberSqrt; x++) {
			if (number%x == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean isPerfectSquare(long n) {
		double sqrt = Math.sqrt(n);
		return ((sqrt - Math.floor(sqrt)) == 0);
	}
	private static Queue<Integer> getAllUniquePrimeFactors(long n)
	{
		if (n < 4) return null;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		
		//Unique multipliers of 2... ex: 2, 4, 8..
		int maxFactor = 1;
		int multiplier = 2;
		while (n%2 == 0) {
			if (maxFactor == multiplier) {
				queue.add(maxFactor);
				maxFactor = 1;
				multiplier = multiplier + 2;
			} else {
				maxFactor = maxFactor*2;
			}
			n = n/2;
		}
		if (maxFactor != 1) queue.add(maxFactor);
		
		for (int p = 3; p*p < n; p = p+2) {
			while (n%p == 0) {
				queue.add(p);
				n = n/p;
			}
		}
		
		if (n>2) {
			queue.add((int)n);
		}
		return queue;
	}
}
