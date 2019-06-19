package com.alysoft.algo.codechef.april19contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Shlok and Sachin are good friends. Shlok wanted to test Sachin, so he wrote down a string S with length N and one character X. He wants Sachin to find the number of different substrings of S which contain the character X at least once. Sachin is busy with his girlfriend, so he needs you to find the answer.

Two substrings of S are considered different if their positions in S are different.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N.
The second line contains a string S with length N, followed by a space and a character X.
Output
For each test case, print a single line containing one integer — the number of substrings of S that contain X.

Constraints
1≤T≤1,000
1≤N≤106
S contains only lowercase English letters
X is a lowercase English letter
the sum of N over all test cases does not exceed 106
Subtasks
Subtask #1 (30 points): the sum of N over all test cases does not exceed 103
Subtask #2 (70 points): original constraints

Example Input
2
3
abb b
6
abcabc c
Example Output
5
15
Explanation
Example case 1: The string "abb" has six substrings: "a", "b", "b", "ab", "bb", "abb". The substrings that contain 'b' are "b", "b", "ab", "bb", "abb".
 * @param args
 * @throws Exception
 */
public class FriendorGirlfriend
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
            
        	String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            
            String str = arrayValues[0];
            String x = arrayValues[1];
            int containsStrCount = getContainsString(str, x, n);
			System.out.println(containsStrCount);
            t--;
        }
	}
	private static int getContainsString(String str, String x, int n)
	{
		int count = 0;
		while (str.indexOf(x) != -1) {
			str = str.substring(str.indexOf(x)+1);
			int totalLen = str.length()+1;
			count += totalLen;
		}
		//System.out.println("FriendorGirlfriend.getContainsString() noOfSubsets :" + noOfSubsets);
		return count;
	}
	private static int getContainsString4(String str, String x, int n)
	{
		int count = 0;
		int cnt[] = new int[26]; 
		for (int i = 0; i<n; i++) {
			Arrays.fill(cnt, 0);
			for (int j = i; j<n; j++) {
				cnt[getCharIndex(str.charAt(j))]++;
				if (cnt[getCharIndex(x.charAt(0))] != 0) {
					count += (n-j);
					break;
				}
			}
		}
		//System.out.println("FriendorGirlfriend.getContainsString() noOfSubsets :" + noOfSubsets);
		return count;
	}
	public static int getCharIndex(char ch) {
		return ch-'a';
	}
	private static int getContainsString3(String str, String x, int n)
	{
		int count = 0;
		for (int i = 0; i<n; i++) {
			for (int j = i; j<n; j++) {
				if (str.substring(i, j+1).indexOf(x) != -1) {
					count++;
				}
			}
		}
		return count;
	}
	private static HashMap<String, Integer> dpMapHash = null;
	private static int getContainsString2(String str, String x, int n)
	{
		dpMapHash = new HashMap<String, Integer>();
		SolObject sol = new SolObject();
		return loopNFindSubStrings(str, sol, 0, n-1, x.charAt(0));
	}
	
	private static int loopNFindSubStrings(String prob, SolObject sol, int startIndex, int endIndex, char xExist)
	{
		//String is not contineous.
		if (!sol.isContineousStrFlag()) {
			return 0;
		}
		if (endIndex < startIndex) {
			
			if (sol.getSolStr().indexOf(xExist) != -1) {
				return 1;
			} else {
				return 0;
			}
		}
		int firstPart = 0;
		int secondPart = 0;
		int result = 0;
		if (dpMapHash.containsKey(sol.getSolStr() + prob.charAt(startIndex))) {
			result = dpMapHash.get(sol.getSolStr() + prob.charAt(startIndex));
		} else {
			SolObject newSol = new SolObject(sol.getSolStr() + prob.charAt(startIndex), sol.getLastCharIndex(), startIndex);
			firstPart = loopNFindSubStrings(prob, newSol, startIndex+1, endIndex, xExist);
			secondPart = loopNFindSubStrings(prob, new SolObject(sol), startIndex+1, endIndex, xExist);
			dpMapHash.put(sol.getSolStr() + prob.charAt(startIndex), firstPart + secondPart);
			result = dpMapHash.get(sol.getSolStr() + prob.charAt(startIndex));
		}
		return result;
	}
	static class SolObject {
		private StringBuffer localBuff = null;
		private int lastCharIndex = -1;
		private boolean contineousStrFlag = true;
		public SolObject()
		{
			localBuff = new StringBuffer();
		}
		public SolObject(String data, int lastCharIndex, int currentCharIndex) {
			this();
			localBuff.append(data);
			this.lastCharIndex = currentCharIndex;
			if (lastCharIndex != -1 && lastCharIndex+1 != currentCharIndex) {
				this.contineousStrFlag = false;
			}
		}
		public SolObject(SolObject obj)
		{
			this();
			if (obj != null) {
				this.localBuff.append(obj.getSolStr());
				this.lastCharIndex = obj.getLastCharIndex();
			}
		}
		public int getLastCharIndex() {
			return lastCharIndex;
		}
		public String getSolStr() {
			return this.localBuff.toString();
		}
		@Override
		public String toString()
		{
			return "SolObject [localBuff=" + this.localBuff + ", lastCharIndex=" + this.lastCharIndex + ", contineousStrFlag=" + this.isContineousStrFlag()+"]";
		}
		public boolean isContineousStrFlag()
		{
			return this.contineousStrFlag;
		}
	}
}