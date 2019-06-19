package com.alysoft.algo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Actually, the two sticks in a pair of chopsticks need not be of the same length. 
 * A pair of sticks can be used to eat as long as the difference in their length is at most D. 
 * The Chef has N sticks in which the ith stick is L[i] units long. A stick can't be part of more than one pair of chopsticks. 
 * Help the Chef in pairing up the sticks to form the maximum number of usable pairs of chopsticks.

Input
The first line contains two space-separated integers N and D. The next N lines contain one integer each, the ith line giving the value of L[i].

Output
Output a single line containing the maximum number of pairs of chopsticks the Chef can form.

Constraints
1 ≤ N ≤ 100,000 (10 5 )
0 ≤ D ≤ 1,000,000,000 (10 9 )
1 ≤ L[i] ≤ 1,000,000,000 (10 9 ) for all integers i from 1 to N
Example
Input:

5 2
1
3
3
9
4

Output:
2
Explanation
The 5 sticks have lengths 1, 3, 3, 9 and 4 respectively. 
The maximum allowed difference in the lengths of two sticks forming a pair is at most 2. 
It is clear that the 4th stick (length 9) cannot be used with any other stick. 
The remaining 4 sticks can can be paired as (1st and 3rd) and (2nd and 5th) to form 2 pairs of usable chopsticks.
 * 
 * @author ymohammad
 *
 */
public class Chopsticks
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Scanner sc = new Scanner(System.in);
		//String line = br.readLine();
        //String[] arrayValues = line.trim().split(" ");
        int n = sc.nextInt();
        int d = sc.nextInt();	 
        
        int[] stickArr = new int[n];
        int i = 0;
        while (i < n) {
        	//line = br.readLine();
        	stickArr[i] = sc.nextInt();
        	i++;
        }
        int result = getChopstickCount(stickArr, n, d);
		System.out.println(result);
	}

	private static int getChopstickCount(int[] stickArr, int n, int d)
	{
		Arrays.sort(stickArr);
		int result = 0;
		int i = 0;
		while ( i<n-1) {
			if ((stickArr[i+1]-stickArr[i]) <= d) {
				result++;
				i = i+2;
			} else {
				i++;
			}
		}
		return result;
	}
}
