package com.alysoft.algo.sorting.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Given an array of positive element having size N and an integer C. Check if there exists a pair (A,B) such that A xor B = C.

Input : 
First line of input contains number of testcases T. The 1st line of each testcase contains a two integers N and C. The 2nd line of each testcase, contains N space separated integers denoting the elements of the array A.

Output: 
Print "Yes" is the pair exists else print "No" without quotes.(Change line after every answer).

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= C <= 105
0 <= arr[i] <= 105

Example:
Input:
2
7 7
2 1 10 3 4 9 5 
5 1
9 9 10 10 3 

Output:
Yes
No

Explanation :
In first case, pair (2,5) give 7. Hence answer is "Yes". In second case no pair exist such that satisfies the condition hance the answer is "No".
 * @author ymohammad
 *
 */
public class XORPair
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int n = Integer.parseInt(arrayValues[0].trim());
            int k = Integer.parseInt(arrayValues[1].trim());
            line = br.readLine();
            arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			String x = getXOrPossible(a, n, k);
			System.out.println(x);
            t--;
        }
	}

	private static String getXOrPossible(int[] arr, int n, int c)
	{
		HashSet<Integer> hash = new HashSet<Integer>();
		for (int x : arr) {
			if (hash.contains(x^c)) {
				return "Yes";
			} else {
				hash.add(x);
			}
		}
		return "No";
	}

}
