package com.alysoft.algo.codechef.mock2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * As every other little boy, Mike has a favorite toy to play with. Mike's favorite toy is a set of N disks. The boy likes to compose his disks in stacks, but there's one very important rule: the disks in a single stack must be ordered by their radiuses in a strictly increasing order such that the top-most disk will have the smallest radius.

For example, a stack of disks with radii (5, 2, 1) is valid, while a stack of disks with radii (3, 4, 1) is not.

Little Mike has recently come up with the following algorithm after the order of disks are given:

First, Mike initiates an empty set of disk stacks.
Then, Mike processes the disks in the chosen order using the following pattern:
If there is at least one stack such that Mike can put the current disk on the top of the stack without making it invalid, then he chooses the stack with the smallest top disk radius strictly greater than the radius of the current disk, and puts the current disk on top of that stack.
Otherwise, Mike makes a new stack containing only the current disk.
For example, let's assume that the order of the disk radii is (3, 4, 5, 1, 1, 2). Here's how the set of the top stack disks will appear during the algorithm's run:

In the beginning of the algorithm, the set of disk stacks is empty. After processing the first disk, the set of top stack disks is {3}.
We cannot put the second disk on the only stack that we have after processing the first disk, so we make a new stack. After processing the second disk, the set of top stack disks is {3, 4}.
We cannot put the third disk on any of the available stacks, so we make a new stack. After processing the third disk, the set of top stack disks is {3, 4, 5}.
The fourth disk has radius 1, so it can be easily put on any of the available stacks. According to the algorithm, we choose the stack with the top disk radius equal to 3. After processing the fourth disk, the set of top stack disks is {1, 4, 5}.
The fifth disk has radius 1, so there are two stacks we can put it on. According to the algorithm, we choose the stack with the top disk radius equal to 4. After processing the fifth disk, the set of top stack disks is {1, 1, 5}.
The sixth disk has radius 2, so there is only one stack we can put it on. The final set of top stack disks is {1, 1, 2}.
Mike is really excited about his new algorithm, but he has so many disks that it seems impossible to simulate the algorithm manually.

You are given an array A of N integers denoting the radii of Mike's disks. The disks are already ordered by Mike. Your task is to find the set of the stack top disk radii after the algorithm is done.

Input
The first line of the input contains an integer T denoting the number of test cases. The description of T test cases follows.

The first line of a test description contains a single integer N.

The second line of the description contains N integers denoting A1, ... , AN.

Output
For each test case, output a single line. The line should start with a positive integer S denoting the number of stacks after the algorithm is done. This should be followed by S integers on the same line denoting the stacks' top disk radii in non-decreasing order.

If there are multiple correct answers, you are allowed to output any of them.

Constraints
1 ≤ T ≤ 10
1 ≤ N ≤ 105
1 ≤ Ai ≤ 109
Example
Input:
3
6
3 4 5 1 1 2
10
3 2 9 5 2 9 4 14 7 10
8
14 5 13 19 17 10 18 12

Output:
3 1 1 2
5 2 2 4 7 10 
4 5 10 12 18 
Explanation
Example 1 is already explained in the problem statement.
 * @author ymohammad
 *
 */
public class Stacks
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
	            int n = Integer.parseInt(br.readLine().trim());
	            int[] diskRaddiArr = new int[n];
	            
	            String line = br.readLine();
	            String[] split = line.split(" ");
	            int i = 0;
	            while (i < n) {
	            	diskRaddiArr[i] = Integer.parseInt(split[i]);
	            	i++;
	            }
	            String frequencyStr = getTopStackDiskRadii(diskRaddiArr, n);
	            System.out.println(frequencyStr);
	            t--;
	        }
		} 
		catch (Exception e)
		{
		}
	}

	private static String getTopStackDiskRadii(int[] diskRaddiArr, int n)
	{
		ArrayList<Integer> listOfStacks = new ArrayList<Integer>();
		
		for (int r : diskRaddiArr) {
			if (listOfStacks.size() == 0) {
				listOfStacks.add(r);
			} else {
				boolean isStackFound = false;
				for (int i=0; i<listOfStacks.size(); i++) {
					Integer stackHead = listOfStacks.get(i);
				}
			}
		}
		return null;
	}
}
