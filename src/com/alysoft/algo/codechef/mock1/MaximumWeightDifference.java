package com.alysoft.algo.codechef.mock1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Chef has gone shopping with his 5-year old son. They have bought N items so far. The items are numbered from 1 to N, and the item i weighs Wi grams.

Chef's son insists on helping his father in carrying the items. He wants his dad to give him a few items. Chef does not want to burden his son. But he won't stop bothering him unless he is given a few items to carry. So Chef decides to give him some items. Obviously, Chef wants to give the kid less weight to carry.

However, his son is a smart kid. To avoid being given the bare minimum weight to carry, he suggests that the items are split into two groups, and one group contains exactly K items. Then Chef will carry the heavier group, and his son will carry the other group.

Help the Chef in deciding which items should the son take. Your task will be simple. Tell the Chef the maximum possible difference between the weight carried by him and the weight carried by the kid.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. The first line of each test contains two space-separated integers N and K. The next line contains N space-separated integers W1, W2, ..., WN.

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
	            int[] objectWeights = new int[n];
	            
	            line = br.readLine();
	            split = line.split(" ");
	            int i = 0;
	            while (i < n) {
	            	objectWeights[i] = Integer.parseInt(split[i]);
	            	i++;
	            }
	            int maxDifference = getMaxDifference(objectWeights, n, k);
	            System.out.println(maxDifference);
	            t--;
	        }
		} 
		catch (Exception e)
		{
		}
	}

	private static int getMaxDifference(int[] objectWeights, int n, int k)
	{
		Arrays.sort(objectWeights);
		int totalSum = 0;
		int frontKSum = 0;
		int rareKSum = 0;
		for (int w : objectWeights) {
			totalSum += w;
		}
		for (int i = 0; i<k; i++) {
			frontKSum += objectWeights[i];
		}
		int j = n-1;
		for (int i = 0; i<k; i++) {
			rareKSum += objectWeights[j];
			j--;
		}
		int maxDifference = Math.max(Math.abs(frontKSum - (totalSum-frontKSum)), Math.abs(rareKSum - (totalSum-rareKSum)));
		return maxDifference;
	}

}
