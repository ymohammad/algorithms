package com.alysoft.algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array A[] and a range [a, b]. The task is to partition the array around the range such that array is divided in three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified arranged array.

Input Format:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. First line of 
each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array (A[]).

Output Format:
For each test case the output will be 1 if the array is properly arranged else it would be 0.

User Task: 
The task is to complete the function threeWayPartition() which should segregate the elements as required. The function returns an array.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
5
1 2 3 3 4
1 2
3
1 2 3
1 3

Output:
1
1

Explanation:
Testcase 2: First, array has elements less than or equal to 1. Then, elements between 1 and 3. And, finally elements greater than 3. So, output is 1.
 
 * @author ymohammad
 *
 */
public class ThreeWayPartitioning
{

	public static void main(String[] args)
	{
		int a = 36;
		int b = 72;
		List<Integer> asList = Arrays.asList(87, 78, 16, 94);
		ArrayList<Integer> list = new ArrayList<Integer>(asList);
		System.out.println("OUtput :" + threeWayPartition(list, a, b));
		
		System.out.println("Numeric value of A :" + getCharIndex('a'));
		System.out.println("Numeric value of D :" + getCharIndex('d'));
		System.out.println("Numeric value of Z :" + getCharIndex('z'));
		
		System.out.println("Char value of A :" + getCharForIndex(getCharIndex('a')));
		System.out.println("Char value of D :" + getCharForIndex(getCharIndex('d')));
		System.out.println("Char value of Z :" + getCharForIndex(getCharIndex('z')));
	}
	public static ArrayList<Integer> threeWayPartition(ArrayList<Integer> A, int a, int b)
	{
        //add code here.
        int n = A.size();
        int i = 0;
        int j = n-1;
        int k = 0;
        while (k<=j) {
            if (A.get(k)<a) {
                swap(A, i, k);
                i++;
                k++;
            } else if (A.get(k)>b) {
                swap(A, j, k);
                j--;
            } else {
                k++;
            }
        }
        return A;
    }
    public static void swap(ArrayList<Integer> A, int from, int to) {
        int temp = A.get(from);
        A.set(from, A.get(to));
        A.set(to, temp);
    }
    
    public static int getCharIndex(char ch) {
    	int a = (int)'a';
    	int chVal = (int) ch;
        
        return chVal-a;
    }
    public static char getCharForIndex(int ind) {
    	int aNumericValue = (int)'a';
        int chNumericValue = aNumericValue + ind;
        return (char)chNumericValue;
    }
}
