package com.alysoft.completedsa.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a MxN matrix, count the number of squares in the matrix.squaresinREct

Input:

The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. 
Each test case contains two space seperated integers M and N, denoting the size of the Matrix.
Output:

For each test output a single integer denoting the total number of squares.
Constraints:

1<=T<=102
1<=M,N<=10^4

Example:

Input:

2
2 2
4 3

Output:

5
20
 * @author ymohammad
 *
 */
public class SquaresInMatrix
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
            int m = Integer.parseInt(arrayValues[0]);
            int n = Integer.parseInt(arrayValues[1]);	
            long result = getNumberOfSquares(n, m);
			System.out.println(result);
            t--;
        }
	}
	public static long getNumberOfSquaresLoop(long n, long m)
	{
		long result = 0L;
		int i = 0;
		while (i <n && i<m) {
			long noOfHorizontals = n-i;
			long noOfVerticals = m-i;
			result = result + (noOfHorizontals * noOfVerticals);
			i++;
		}
		return result;
	}
	public static long getNumberOfSquares(long n, long m)
	{
		long result = 0L;
		if (n > m) {
			result = ((m * (m + 1) *(2*m + 1))/6) + (n-m)*((m*(m+1))/2);
		} else if (n < m) {
			result = (n * (n + 1) *(2*n + 1))/6 + (m-n)*((n*(n+1))/2);
		} else {
			result = (n * (n + 1) *(2*n + 1))/6;
		}
		return result;
	}
}
