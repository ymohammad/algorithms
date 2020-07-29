package com.alysoft.algo.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given two arrays X and Y of positive integers, find number of pairs such that xy > yx (raised to power of) where x is an element 
 * from X and y is an element from Y.

Input Format:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test consists of 
three lines. The first line of each test case consists of two space separated M and N denoting size of arrays X and Y respectively. 
The second line of each test case contains M space separated integers denoting the elements of array X. The third line of each test case 
contains N space separated integers denoting elements of array Y.

Output Format:
Corresponding to each test case, print in a new line, the number of pairs such that xy > yx.

Your Task:
This is a function problem. You only need to complete the function countPairs() that takes X, Y, M, N as parameters and returns the total 
number of pairs.

Constraints:
1 ≤ T ≤ 100
1 ≤ M, N ≤ 105
1 ≤ X[i], Y[i] ≤ 103

Example:
Input
1
3 2
2 1 6
1 5

Output
3

Explanation:
Testcase 1: The pairs which follow xy > yx are as such: 21 > 12,  25 > 52 and 61 > 16 
 * @author ymohammad
 *
 */
public class NumberOfPairs
{

	public static void main (String[] args) throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int g = 0;g < t;g++)
        {
            String[] str = (br.readLine()).trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            
            int[] x = new int[n];
            str = (br.readLine()).trim().split(" ");
            for(int i = 0;i< n;i++)
                x[i] = Integer.parseInt(str[i]);
                
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[m];
            for(int i = 0;i< m;i++)
            {
                y[i] = Integer.parseInt(str[i]);
                
            }
            System.out.println(countPairs(x, y, n, m));
           
        }
	}
	static long countPairs1(int arrX[], int arrY[], int n, int m)
    {
        int count = 0;
        for (int i = 0; i<n; i++)
        {
            int x = arrX[i];
            for (int j = 0; j<m; j++)
            {
                int y = arrY[j];
                System.out.println("Math.pow(" + x + ", " + y + ") - " + Math.pow(x, y));
                System.out.println("Math.pow(" + y + ", " + x + ") - " + Math.pow(y, x));
                if (Math.pow(x, y)>Math.pow(y, x)) {
                    count++;
                }
            }
        }
        return count;
    }
	
	/**
	 * The trick to this question is if y > x, then then x^y > y^x with some exceptions.

		Simply sort the array Y[], and for every element x in X[], find the index idx of smallest number just greater than x in Y[]. 
		All the elements after, this index idx satisfy the above relation. So add (n - idx) to the ans.
		
		But as we mentioned there are some exceptions. Try to think of these exceptions.
		
		Following are the exceptions :

		if x = 0, then count for this is 0.
		 if x = 1, then count is total no of 0s in Y[] only.
		if x = 2, for y = 3, y = 4, the above property does not hold, and the count should be decreased
		if x = 3, for y = 2, the count need to be inreased
		This is the complete solution.
		The overall time complexity is O(nlong + mlogn)
	 */
	static long countPairs2(int arrX[], int arrY[], int n, int m)
    {
        int count = 0;
        Arrays.sort(arrY);
        
        for (int i = 0; i<n; i++)
        {
            int x = arrX[i];
            if (x == 1) {
            	count += getZeroCount(arrY, m);
            } else {
            	for (int j = 0; j<m; j++)
                {
                    int y = arrY[j];
                    if (x == 2 && (y==3 || y==4)) {
                    	continue;
                    }
                    if (x == 3 && y == 2) {
                    	count++;
                    	continue;
                    }
                    if ((y==1 || y>x)) {
                    	if (y == 1) {
                    		count++;
                    	} else {
                    		count += (m-j);
                        	break;
                    	}
                    }
                }
            }
        }
        return count;
    }
	
	static long countPairs(int arrX[], int arrY[], int n, int m)
    {
        long count = 0L;
        Arrays.sort(arrY);
        int[] yExceptArray =  getExceptionalCountArray(arrY, m);
        int i = 0;
        while (i<n) {
        	int x = arrX[i];
        	count += getPossibleCount(x, arrY, m, yExceptArray);
        	i++;
        }
        
        return count;
    }
	
	private static long getPossibleCount(int x, int[] arrY, int m, int[] yExceptArray)
	{
		long count = 0L;
		int j = 0;
		if (x == 1) {
			return yExceptArray[0];
	    } 
		j = Arrays.binarySearch(arrY, x);
		if (j<0) {
			j = Math.abs(j+1);
		}
		else 
		{
			while (j<m && arrY[j] == x) {
				j++;
			}
		}
		count += (m-j);
		count += yExceptArray[0] + yExceptArray[1];

		if (x == 2 ) {
			count = count - yExceptArray[3]-yExceptArray[4];
        }
		if (x == 3) {
			count += yExceptArray[2];
        }
		return count;
	}
	private static int[] getExceptionalCountArray(int[] arrY, int m)
	{
		int[] yExceptArray = new int[5];
		for (int y : arrY) {
			if (y < 5) {
				yExceptArray[y]++;
			} 
		}
		return yExceptArray;
	}
	private static int getZeroCount(int[] arrY, int m)
	{
		int count = 0;
		for (int y : arrY) {
			if (y == 0) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
}
