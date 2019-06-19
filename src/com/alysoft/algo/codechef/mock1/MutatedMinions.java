package com.alysoft.algo.codechef.mock1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Gru has not been in the limelight for a long time and is, therefore, planning something particularly nefarious. Frustrated by his minions' incapability which has kept him away from the limelight, he has built a transmogrifier — a machine which mutates minions.

Each minion has an intrinsic characteristic value (similar to our DNA), which is an integer. The transmogrifier adds an integer K to each of the minions' characteristic value.

Gru knows that if the new characteristic value of a minion is divisible by 7, then it will have Wolverine-like mutations.

Given the initial characteristic integers of N minions, all of which are then transmogrified, find out how many of them become Wolverine-like.

Input Format:
The first line contains one integer, T, which is the number of test cases. Each test case is then described in two lines.

The first line contains two integers N and K, as described in the statement.

The next line contains N integers, which denote the initial characteristic values for the minions.

Output Format:
For each testcase, output one integer in a new line, which is the number of Wolverine-like minions after the transmogrification.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ K ≤ 100
All initial characteristic values lie between 1 and 105, both inclusive.
Example
Input:
1
5 10
2 4 1 35 1

Output:
1
Explanation:
After transmogrification, the characteristic values become {12,14,11,45,11}, out of which only 14 is divisible by 7. So only the second minion becomes Wolverine-like.
 * @author ymohammad
 *
 */
public class MutatedMinions
{
	public static void main(String[] args) throws Exception {
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	            // Input the size of the array
	            String line = br.readLine();
	            String[] split = line.split(" ");
	            int n = Integer.parseInt(split[0]);
	            int k = Integer.parseInt(split[1]);
	            int[] minionsDna = new int[n];
	            
	            line = br.readLine();
	            split = line.split(" ");
	            int i = 0;
	            while (i < n) {
	            	minionsDna[i] = Integer.parseInt(split[i]);
	            	i++;
	            }
	            int noOfMinonsWovelworienCount = findMinonsWolvwarine(minionsDna, n, k);
	            //int tablesCleaned = getMinimumClearning(customers, n, m);
	            System.out.println(noOfMinonsWovelworienCount);
	            t--;
	        }
		} 
		catch (Exception e)
		{
		}
	}

	private static int findMinonsWolvwarine(int[] minionsDna, int n, int k)
	{
		int noOfMinons = 0;
		for (int i = 0; i<n; i++) {
			minionsDna[i] = minionsDna[i] + k;
			if (minionsDna[i]%7 == 0) {
				noOfMinons++;
			}
		}
		return noOfMinons;
	}
}
