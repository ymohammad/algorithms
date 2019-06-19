package com.alysoft.algo.interviewbit;

import java.util.*;

/**
 * 
 * Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 NOTE: You only need to implement the given function. Do not read input, instead use the arguments to the function. 
 Do not print the output, instead return values as specified. Still have a doubt? Checkout Sample Codes for more details. 
 * @author ymohammad
 *
 */
public class AddOneToNumber
{
	public static void main(String[] args) {
		AddOneToNumber obj = new AddOneToNumber();
		int[] A = {9, 9, 9};
		int[] plusOne = obj.plusOne(A);
		printArray(plusOne);
	}
	private static void printArray(int[] plusOne)
	{
		for (int x : plusOne) {
			System.out.print(x + " ");
		}
	}
	public int[] plusOne(int[] A) {
		if (A == null) return null;
		
		int size = A.length;
		int startIdx = 0;
		while (startIdx<size) {
			if (A[startIdx] != 0) {
				break;
			}
			startIdx++;
		}
		if (startIdx == A.length) return new int[] {1};
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int j = size-1;
		int val = A[j] + 1;
		A[j] = val%10;
		int carry = val/10;
		j--;
		while (j>=startIdx) {
			val = A[j] + carry;
			A[j] = val%10;
			carry = val/10;
			j--;
		}
		if (carry != 0) {
			list.add(carry);
		}
		int i = startIdx;
		while (i<size) {
			list.add(A[i]);
			i++;
		}
		int[] newArr = new int[list.size()];
		i = 0;
		for (int x: list) {
			newArr[i] = x;
			i++;
		}
		return newArr;
    }
}
