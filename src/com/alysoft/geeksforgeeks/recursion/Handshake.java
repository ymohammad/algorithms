package com.alysoft.geeksforgeeks.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * We have N persons sitting on a round table. Any person can do a handshake with any other person.

    1
2        3
    4
Handshake with 2-3 and 1-4 will cause cross.

In how many ways these N people can make handshakes so that no two handshakes crosses each other. N would be even. 

For example, in above diagram, there are two non-crossing ways to handshake {{1, 2}, {3, 4}} and {{1, 3}, {2, 4}}.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.

Output:

Print number of ways.

Constraints:

1 ≤ T ≤ 20
2 ≤ N ≤ 30

Example:

Input:
2
2
8

Output:
1
14
 * @author ymohammad
 *
 */
public class Handshake
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	String line = null;
        	while (line == null || line.trim().length()==0) {
        		line = br.readLine();
            }
        	int n = Integer.parseInt(line.trim());
        	int x = getPossibleHandshakes(n);
        	System.out.println(x);
            t--;
        }
	}

	private static int getPossibleHandshakes(int n)
	{
		if (n <= 1) return 0;
		
		int possibleHandShakes =  1 + getPossibleHandshakes(n-2);
		return possibleHandShakes;
	}

}
