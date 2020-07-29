package com.alysoft.algo.context2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given a number N. You need to toggle the middle bit of N in binary form and print the result in decimal form.

If number of bits in binary form of N are odd then toggle the middle bit (Like 111 to 101).
If number of bits in binary form of N are even then toggle both the middle bits (Like 1111 to 1001)
Note: Toggling a bit means converting a 0 to 1 and vice versa.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains a single number N.

Output:
For each testcase, in a new line, print the decimal form after toggling the middle bit of N.

Constraints:
1 <= T <= 100
1 <= N <= 106

Examples:
Input:
5
1
2
3
4
5
Output:
0
1
0
6
7

Examples:
Testcase3: N=3. Binary is 11. Toggle the middle bits: 00. 00 in decimal is 0
Testcase5: N=5. Binary is 101. Toggle the middle bit: 111. 111 in decimal is 7
 * @author ymohammad
 *
 */
public class ToggleTheMiddle
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
            
				
			int x = getFilpCount(n);
			System.out.println(x);
            t--;
        }
	}
	
	public static int getFilpCount(int n) {
		int res = 0;
	    int bitCount = logValue(n, 2) + 1;
	    int[] arr = new int[bitCount];
	    for (int i = bitCount-1; i>=0; i--) {
	    	arr[i] = (n%2);
	    	n = n/2;
	    }
	    if (bitCount%2 == 0) {
	    	int ind = bitCount/2;
	    	toggleBit(arr, ind);
	    	toggleBit(arr, ind-1);
	    } else {
	    	int ind = bitCount/2;
	    	toggleBit(arr, ind);
	    }
	    int count = 0;
	    for (int i = bitCount-1; i>=0; i--) {
	    	res += (arr[i]*Math.pow(2, count));
	    	count++;
	    }
	    return res;
	}

	private static void toggleBit(int[] arr, int ind)
	{
		if (arr[ind] == 0) {
			arr[ind] = 1;
		} else {
			arr[ind] = 0;
		}
	}

	private static int logValue(int n, int base)
	{
		return (int)(Math.log(n)/Math.log(base));
	}
	
}
