package com.alysoft.algobooks.ch8;

/**
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
 * @author ymohammad
 *
 */
public class TripleStep
{

	public static void main(String[] args)
	{
		System.out.println("No. of ways :" + getNoOfChoicesDP(100));
	}

	public static int getNoOfChoices(int i) {
		if (i < 0) {
			return 0;
		}
		if (i == 0) {
			return 1;
		}
		
		return getNoOfChoices(i-1) + getNoOfChoices(i-2) + getNoOfChoices(i-3);
	}
	public static int getNoOfChoicesDP(int i) {
		
		int[] mom = new int[i+1];
		mom[0] = 1;
		mom[1] = 1;
		mom[2] = 2;
		for (int x=3; x<=i; x++) {
			mom[x] = mom[x-1] + mom[x-2] + mom[x-3];
		}
		return mom[i];
	}
}
