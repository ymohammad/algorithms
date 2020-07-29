package com.alysoft.algo.stack.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * We are given bracket sequence(may not be balanced). Every character of the sequence is either '(' or ')'.  For each closing bracket, we need to find an opening bracket which is farthest from it (and on left of it) and pair those two brackets.
Once an opening bracket is paired with closing bracket, it can not be used again for any other closing bracket.
Traverse from left of the sequence and for each ')' you need to find the left-most '('. Do this for all the ')'.

Input: 
First line contains an integer T which deoted number of test cases. Next line of each test case contains string which consist of  '(' or ')' .

Output: 
For each testcase, in a newline, print:

The count of total number of pairs in the first line.
The indices of opening and closing brackets (pairs) in subsequent lines. The indices are 0 based.
If the count is zero, just print the count as no pairs exist.

Constraints:
1 <= T <= 10
1 <= |S| <= 105
Example :
Input :
3
))((()
()()()
((()

Output :
1
2 5
3
0 1
2 3
4 5
1
0 3

Explanation:
Testcase1: The given sequence is ))((()
Only the last ')' has a '(' . Also the leftmost '(' for it is at the index 2. So the count is 1 and the indices are 2(open) and 5(close).
Testcase2: The sequence is ()()(). The first ')' has leftmost '(' at 0 index. The second ')' has leftmost '(' at 2 index. The third ')' has leftmost '(' at 4 index. So total count is 3 and the indices are 0 1, 2 3, 4 5.
Testcase3: The sequence is (((). The first ')' is at 3 index. The leftmost '(' is at 0 index. So total count is 1 and indices are 0 3


 * @author ymohammad
 *
 */
public class PairingTheBrackets
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            String line = br.readLine();
            findBalancedBrackets(line);
            t--;
        }
	}

	public static void findBalancedBrackets(String line)
	{
		Queue<Pair> queue = new LinkedList<Pair>();
		
		char[] charArray = line.toCharArray();
		int n = charArray.length;
		int pairCount = 0;
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i<n; i++) {
			char ch = charArray[i];
			if (ch == '(') {
				queue.add(new Pair(i, ch));
			} else {
				if (!queue.isEmpty()) {
					Pair retPair = queue.poll();
					buff.append(retPair.getInd() + " " + i + "\n");
					pairCount++;
				}
			}
		}
		if (pairCount == 0 ) {
			System.out.println("no pairs exist");
		} else {
			System.out.println(pairCount);
			System.out.print(buff.toString());
		}
	}

	private static class Pair 
	{
		private char ch;
		private int ind;
		public Pair(int ind, char ch) {
			this.ind = ind;
			this.ch = ch;
		}
		public char getCh()
		{
			return this.ch;
		}

		public int getInd()
		{
			return this.ind;
		}
	}
}
