package com.alysoft.algo.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Chef has gone shopping with his 5-year old son. They have bought N items so far. 
 * The items are numbered from 1 to N, and the item i weighs Wi grams.

Chef's son insists on helping his father in carrying the items. He wants his dad to give him a few items. 
Chef does not want to burden his son. But he won't stop bothering him unless he is given a few items to carry. 
So Chef decides to give him some items. Obviously, Chef wants to give the kid less weight to carry.

However, his son is a smart kid. To avoid being given the bare minimum weight to carry, he suggests that the items are split into two groups, 
and one group contains exactly K items. Then Chef will carry the heavier group, and his son will carry the other group.

Help the Chef in deciding which items should the son take. Your task will be simple. Tell the Chef the maximum possible difference 
between the weight carried by him and the weight carried by the kid.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. The first line of 
each test contains two space-separated integers N and K. The next line contains N space-separated integers W1, W2, ..., WN.

Output:
For each test case, output the maximum possible difference between the weights carried by both in grams.

Constraints:
1 ≤ T ≤ 100
1 ≤ K < N ≤ 100
1 ≤ Wi ≤ 100000 (105)
Example:
Input:
2
5 2
8 4 5 2 10
8 3
1 1 1 1 1 1 1 1

Output:
17
2
Explanation:
Case #1: The optimal way is that Chef gives his son K=2 items with weights 2 and 4. Chef carries the rest of the items himself. Thus the difference is: (8+5+10) − (4+2) = 23 − 6 = 17.

Case #2: Chef gives his son 3 items and he carries 5 items himself.
 * @author ymohammad
 *
 */
public class MaximumWeightDifference
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while (t > 0)
			{
				int n = sc.nextInt();
				int k = sc.nextInt();
				int[] weightArray = new int[n];
				for (int i=0; i<n; i++) {
					weightArray[i] = sc.nextInt();
				}
				int result = getMaxDifference(weightArray, n, k);
				System.out.println(result);
				t--;
			}
		} 
		catch (Exception e)
		{
		}
	}

	private static int getMaxDifference(int[] weightArray, int n, int k)
	{
		Arrays.sort(weightArray);
		int s1 = 0;
		int s2 = 0;
		int s = 0;
		for (int i = 0; i<k; i++) {
			s1 += weightArray[i];
		}
		int p = n-1;
		for (int j=0; j<k; j++) {
			s2 += weightArray[p];
			p--;
		}
		
		for (int i=0; i<n; i++) {
			s += weightArray[i];
		}
		/**
		 * Here, it is possible that K group could be greater than N-K group and heavier than N-K. So, in that case we should consider it.
		 * 8 4 5 2 10 => 2 4 5 8 10
		 * => S1 = 2+4 = 6
		 * => S2 = 10+8 = 18
		 * => S = 29
		 * => 6-(29-6) = 6-23 = 17
		 * => 18-(29-18) = 18-11 = 7
		 */
		int maxDiff = Math.max(Math.abs(s1-(s-s1)), Math.abs(s2-(s-s2)));
		return maxDiff;
	}
}
