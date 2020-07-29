package com.alysoft.algo.string;

/**
 * You are given a string S of lowercase characters, find the rank of the string amongst its permutations when sorted lexicographically. Return 0 if the characters are repeated in the string.
Note: Return the rank%1000000007 as answer as rank might overflow.

Input Format:
The first line of input contains an integer T denoting the number of test cases. Each test case consist of a string S in 'lowercase' only in a separate line.

Output Format:
For each testcase, in a new line, print the rank of the string amongst its lexicographically-sorted-permutations.

Your Task:
This is a function problem. You only need to complete the function findRank that takes string S as parameter and returns the rank.

Constraints:
1 ≤ T ≤ 50
1 ≤ |S| ≤ 15

Example:
Input:
3
abc
acb
caa
Output:
1
2
0
 

Explanation:
Testcase2:
Input : 'acb'
Output : 2
The lexicographically-sorted permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
You can clearly see that acb occurs at position 2 in the permutations.
 * @author ymohammad
 *
 */
public class LexicographicRankOfAString
{

	public static void main(String[] args)
	{
		System.out.println("LexicographicRankOfAString.main() string :" + findRank("string"));
		System.out.println("LexicographicRankOfAString.main() abc :" + findRank("abc"));
		System.out.println("LexicographicRankOfAString.main() acb :" + findRank("acb"));
		System.out.println("LexicographicRankOfAString.main() caa :" + findRank("caa"));
	}
	/**
	 * APPROACH
	 * *********
	 * Let the given string be “STRING”. In the input string, ‘S’ is the first character. There are total 6 characters and 4 of 
	 * them are smaller than ‘S’. So there can be 4 * 5! smaller strings where first character is smaller than ‘S’, like following

		R X X X X X
		I X X X X X
		N X X X X X
		G X X X X X
		
		Now let us Fix S’ and find the smaller strings staring with ‘S’.
		
		Repeat the same process for T, rank is 4*5! + 4*4! +…
		
		Now fix T and repeat the same process for R, rank is 4*5! + 4*4! + 3*3! +…
		
		Now fix R and repeat the same process for I, rank is 4*5! + 4*4! + 3*3! + 1*2! +…
		
		Now fix I and repeat the same process for N, rank is 4*5! + 4*4! + 3*3! + 1*2! + 1*1! +…
		
		Now fix N and repeat the same process for G, rank is 4*5! + 4*4! + 3*3! + 1*2! + 1*1! + 0*0!
		
		Rank = 4*5! + 4*4! + 3*3! + 1*2! + 1*1! + 0*0! = 597

		Note that the above computations find count of smaller strings. Therefore rank of given string is count of smaller strings plus 1. 
		The final rank = 1 + 597 = 598
	 * @param S
	 * @return
	 */
	static int findRank(String str) 
    {
		int rank = 1;
        int n = str.length();
        int fact = factorial(n);
        int[] countArr = new int[26];
        for (int i = 0; i<n; i++) {
        	char ch = str.charAt(i);
        	int charIndx = ch-'a';
        	if (countArr[charIndx]>0) {
        		//character repeated.
        		return 0;
        	}
        	countArr[charIndx]++;
        }
        //Cumulative sum
        for (int i = 1; i<26; i++) {
        	countArr[i] = countArr[i-1] + countArr[i];
        }
        for (int i = 0; i<n; i++) {
        	char ch = str.charAt(i);
        	int x = ch-'a';
        	fact = fact/(n-i);
        	int lowerCharCount = 0;
        	if (x > 0) {
        		lowerCharCount = countArr[x-1];
        	}
        	rank = rank%1000000007 + (lowerCharCount*fact)%1000000007;
        	
        	for (int j = x; j<26; j++) {
        		countArr[j]--;
        	}
        }
        return rank;
    }
	public static int factorial(int n)
	{
		int fact = 1;
		while (n > 0) {
			fact = (fact*n)%1000000007;
			n = n-1;
		}
		return fact;
	}
}
