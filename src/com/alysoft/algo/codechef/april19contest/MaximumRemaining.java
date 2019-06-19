package com.alysoft.algo.codechef.april19contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Chef and Dhyey have become friends recently. Chef wants to test Dhyey's intelligence by giving him a puzzle to solve.

The puzzle contains an integer sequence A1,A2,…,AN. The answer to the puzzle is the maximum of Ai%Aj, taken over all valid i, j.

Help Dhyey solve this puzzle.

Input
The first line of each test case contains a single integer N.
The second line contains N space-separated integers A1,A2,…,AN.
Output
For each test case, print a single line containing one integer — the answer to the puzzle.

Constraints
2≤N≤105
1≤Ai≤109 for each valid i
Subtasks
Subtask #1 (30 points): 2≤N≤1,000
Subtask #2 (70 points): 2≤N≤105
Example Input 1
5  
1 2 3 4 5  
Example Output 1
4  
Example Input 2
6  
5 5 5 2 3 8
Example Output 2
5
 * @author ymohammad
 *
 */
public class MaximumRemaining
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
        	int[] allNumbersArr = new int[n];
            
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            
            for (int i = 0; i<n; i++) {
            	allNumbersArr[i] = Integer.parseInt(arrayValues[i].trim());
            }
            
            int maxRemaining = getMaximumRemaining(allNumbersArr, n);
			System.out.println(maxRemaining);
            t--;
        }
	}

	private static int getMaximumRemaining(int[] allNumbersArr, int n)
	{
		int maxNumber = allNumbersArr[0];
		int secondMaxNumber = maxNumber;
		
		for (int x : allNumbersArr) {
			if (x > maxNumber) {
				secondMaxNumber = maxNumber;
				maxNumber = x;
			}
		}
		if (maxNumber == secondMaxNumber) {
			secondMaxNumber = (maxNumber%secondMaxNumber);
		}
		return secondMaxNumber;
	}
}
