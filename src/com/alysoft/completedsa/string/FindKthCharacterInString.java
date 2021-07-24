package com.alysoft.completedsa.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a decimal number m. Convert it in binary string and apply n iterations, in each iteration 0 becomes 01 and 1 becomes 10. 
 * Find kth character in the string after nth iteration.
 * 
 * Input: The first line consists of an integer T i.e number of test cases. 
 * The first and only line of each test case consists of three integers m,k,n. 
 * 
 * Output: Print the required output.

	Constraints: 
	1 <= T <= 100
	1 <= m <= 50
	1 <= n <= 10
	0 <= k <|Length of final string|
	
 * @author ymohammad
 *
 */
public class FindKthCharacterInString
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
            String[] split = line.split(" ");
            int m = Integer.parseInt(split[0]);
            int k = Integer.parseInt(split[1]);
            int n = Integer.parseInt(split[2]);
            findKthCharacter(m, k, n);
            t--;
        }
	}

	public static void findKthCharacter(int m, int k, int n)
	{
		String binaryString = Integer.toBinaryString(m);
		StringBuffer buff = new StringBuffer(binaryString);
		for (int i = 0; i<n; i++) {
			char[] charArray = buff.toString().toCharArray();
			buff = new StringBuffer();
			for (char ch: charArray) {
				if (ch == '0') {
					buff.append("01");
				} else {
					buff.append("10");
				}
			}
		}
		char[] charArray = buff.toString().toCharArray();
		int i = 0;
		for (char ch: charArray) {
			if (i == k) {
				System.out.println(ch);
				break;
			}
			i++;
		}
	}
}
