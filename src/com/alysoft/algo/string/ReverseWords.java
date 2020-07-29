package com.alysoft.algo.string;

/**
 * Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.

Output:
For each test case, in a new line, output a single line containing the reversed String.

User Task:
The task is to complete the function reverseWords() which reverse words from the given string and prints the answer. The newline is automatically appended by the driver code.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr

Explanation:
Testcase 1: After reversing the whole string(not individual words), the input string becomes much.very.program.this.like.i.
 * @author ymohammad
 *
 */
public class ReverseWords
{

	public static void main(String[] args)
	{
		String s = "i.like.this.program.very.much";
		reverseWords(s);
	}
	public static void reverseWords(String s) {
        // Your code here
        String[] sd = s.split("\\.");
        int i = 0; 
        int j = sd.length-1;
        while (i<j) {
            String temp = sd[i];
            sd[i] = sd[j];
            sd[j] = temp;
            i++;
            j--;
        }
        StringBuffer buff = new StringBuffer();
        for (int k = 0; k<sd.length; k++) {
            String x = sd[k];
            buff.append(x);
            if (k != sd.length-1) {
                buff.append(".");
            }
        }
        System.out.print(buff.toString());
    }
}
