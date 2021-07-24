package com.alysoft.completedsa.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

/**
 * Given an array of names of candidates in an election. 
 * A candidate name in array represents a vote casted to the candidate. Print the name of candidate that received Max votes. 
 * If there is tie, print lexicographically smaller name.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. 
Then T test case follows. Each testcase contains two lines:-
The number of votes cast N
The name of the candidates separated by a space. Each name represents one vote casted to that candidate.

Output:
For each testcase, print the name of the candidate with the maximum votes, and also print the votes casted for the candidate. 
The name and votes are separated by a space.
 * 
 * Example:
Input:
2
13
john johnny jackie johnny john jackie jamie jamie john johnny jamie johnny john
3
andy blake clark

Output:
john 4
andy 1
 * 
 * @author ymohammad
 *
 */
public class ElectionWinner
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int i = 0;
            HashMap<String, Integer> hash = new HashMap<String, Integer>();
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			    	if (hash.containsKey(s) ) {
			    		hash.put(s, hash.get(s)+1);
			    	} else {
			    		hash.put(s, 1);
			    	}
			    }
			}
			printWinner(hash, n);	
            t--;
        }
	}

	private static void printWinner(HashMap<String, Integer> hash, int n)
	{
		int maxVotes = 0;
		String maxName = "";
		Set<String> keySet = hash.keySet();
		for (String s: keySet) {
			int temp = hash.get(s);
			if (temp>maxVotes) {
				maxVotes = temp;
				maxName = s;
			} else if (temp == maxVotes) {
				if (s.compareTo(maxName)<0) {
					maxName = s;
				}
			}
		}
		System.out.println(maxName + " " + maxVotes);
	}	
}
