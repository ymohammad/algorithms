package com.alysoft.algo.codechef.may19contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Ari and Rich are playing a pretty confusing game. Here are the rules of the game:

The game is played with two piles of matches. Initially, the first pile contains N matches and the second one contains M matches.
The players alternate turns; Ari plays first.
On each turn, the current player must choose one pile and remove a positive number of 
matches (not exceeding the current number of matches on that pile) from it.
It is only allowed to remove X matches from a pile if the number of matches in the other pile divides X.
The player that takes the last match from any pile wins.
It can be proved that as long as both piles are non-empty, there is always at least one valid move, so the game must end by emptying some pile. 
Both Ari and Rich play optimally. Determine the winner of the game.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains two space-separated integers N and M.

Output
For each test case, print a single line containing the string "Ari" (without quotes) if Ari wins or "Rich" (without quotes) if Rich wins.

Constraints
1≤T≤10^5
1≤N,M≤10^18
Subtasks
Subtask #1 (30 points): 1≤N,M≤1,000
Subtask #2 (70 points): original constraints

Example Input
5
1 1
2 2
1 3
155 47
6 4
Example Output
Ari
Ari
Ari
Ari
Rich


Explanation:
155 47 -> Ari 141
14 47 -> Rich 42
14 5 -> Ari 10
4 5 -> Rich 4
4 1 -> Ari 1


6 4 -> Ari 4
2 4 -> Rich 4
2 0
 * @author ymohammad
 *
 */
public class Matches
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tLine = null;
		while ((tLine = br.readLine()) == null) {
		}
		int t = Integer.parseInt(tLine.trim());
		 
        while (t > 0)
        {
        	tLine = br.readLine();
        	String[] split = tLine.split(" ");
        	long n = Long.parseLong(split[0].trim());
        	long m = Long.parseLong(split[1].trim());
            
            String maxRemaining = getWinner(n, m, "Ari", "Rich");
			System.out.println(maxRemaining);
			maxRemaining = getWinner2(n, m, "Ari", "Rich");
			System.out.println(maxRemaining);
            t--;
        }
	}
	public static String getWinner(long n, long m, String currentPlayer, String previousPlayer) {
		if (n == 0 || m == 0) return previousPlayer;
		
		long max = Math.max(n, m);
		long min = Math.min(n, m);
		return getWinner(max%min, min, previousPlayer, currentPlayer);
	}
	public static String getWinner2(long n, long m, String currentPlayer, String previousPlayer) {
		if (n == 0 || m == 0) return previousPlayer;
		
		if (m == n) return currentPlayer;
		
		if (m%2 == 0 && n %2 == 0) return previousPlayer;
		
		long max = Math.max(n, m);
		long min = Math.min(n, m);
		if (willIWin(max%min, min, previousPlayer, currentPlayer, currentPlayer))
		return getWinner(max%min, min, previousPlayer, currentPlayer);
	}
	private static boolean willIWin(long n, long m, String currentPlayer, String previousPlayer, String originalPlayer)
	{
		if (n == 0 || m == 0) {
			if (previousPlayer.equals(originalPlayer)) return true;
			return false;
		}
		if (n == m) {
			if (currentPlayer.equals(originalPlayer)) return true;
			return false;
		}
		return false;
	}
}
