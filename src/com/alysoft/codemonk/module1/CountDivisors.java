package com.alysoft.codemonk.module1;

import java.util.Scanner;

/**
 * You have been given 3 integers - l, r and k. Find how many numbers between l and r (both inclusive) 
 * are divisible by k. You do not need to print these numbers, you just have to find their count.

	Input Format
	The first and only line of input contains 3 space separated integers l, r and k.
	
	Output Format
	Print the required answer on a single line.

 * @author ymohammad
 *
 */
public class CountDivisors
{

	/**
	 * There are multiple ways to solve this problem. The easiest one is to iterate over the entire range 
	 * and check each number. This gives us a time complexity of O(N) where N is the size of the range.
	 * However, this problem can also be solved in O(1) time which might be helpful for larger constraints. 
	 * 
	 * The number of numbers divisible by a certain number k in the range from 1 to r is (r/k).
	 * Thus we can first find the number of numbers divisible by k in the range from 1 to r and then subtract 
	 * from it the numbers divisible by k in the range from 1 to l-1 to obtain the answer.

		Answer : (r/k)-(l-1/k)

	 * @param l
	 * @param r
	 * @param k
	 */
	public static void bestSolution(short l, short r, short k) {
		short answer = (short) ((r/k) - (l-1/k));
		System.out.println(answer);
	}
	public static void main(String[] args)
	{
		//Scanner
        Scanner s = new Scanner(System.in);
        short l = s.nextShort();
        short r = s.nextShort();
        short k = s.nextShort();
        int count = 0;
        
        if (r < k) {
        	System.out.println(count);
        } else {
        	//It means, we want to know if l to r, numbers multiple of K.
        	for (short a = l; a<=r; a++) {
        		if (a%k == 0) {
        			count++;
        		}
        	}
        	System.out.println(count);
        }
	}

}
