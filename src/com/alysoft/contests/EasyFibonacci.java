package com.alysoft.contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * The Fibonacci sequence F0,F1,… is a special infinite sequence of non-negative integers, where F0=0, F1=1 and 
 * for each integer n≥2, Fn=Fn−1+Fn−2.

Consider the sequence D of the last decimal digits of the first N Fibonacci numbers, i.e. D=(F0%10,F1%10,…,FN−1%10). 
Now, you should perform the following process:

Let D=(D1,D2,…,Dl).
If l=1, the process ends.
Create a new sequence E=(D2,D4,…,D2⌊l/2⌋). In other words, E is the sequence created by removing all odd-indexed elements from D.
Change D to E.
When this process terminates, the sequence D contains only one number. You have to find this number.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains a single integer N.
Output
For each test case, print a single line containing one integer ― the last remaining number.

Constraints
1≤T≤105
1≤N≤1018
Subtasks
Subtask #1 (20 points):

1≤T≤105
1≤N≤107
Subtask #2 (80 points): original constraints

Example Input
1
9
Example Output
3
Explanation
Example case 1: The first N Fibonacci numbers are (0,1,1,2,3,5,8,13,21). 
The sequence D is (0,1,1,2,3,5,8,3,1)→(1,2,5,3)→(2,3)→(3).
 * @author ymohammad
 *
 */
public class EasyFibonacci
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine = br.readLine();
		while (eachLine == null) {
			eachLine = br.readLine();
		}
		int t = Integer.parseInt(eachLine.trim());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
        	long n = Long.parseLong(br.readLine().trim());
        	
        	int finalValue = getFinalValue(n);
        	System.out.println(finalValue);
            t--;
        }
	}

	private static int getFinalValue(long n)
	{
		if (n == 1) return 0;
		if (n == 2) return 1;
		
		ArrayList<Integer> fibList = getFibonciiNumbers(60);
		long position = getPossibleNumberPos(n);
		System.out.println("Position :" + position);
		int x = getNumberRequired(fibList, position, n);
		//System.out.println("Middle number is found..");
		System.out.println("With division :" + x);
		
		/*fibList = getFibonciiNumbersComplete(n);
		x = getPossibleMiddleNum(fibList, 0, 0);
		System.out.println("WithOut division :" + x);*/
		return x;
	}

	private static int getNumberRequired(ArrayList<Integer> fibList, long position, long n)
	{
		int index = (int)position%60;
		//System.out.println("Index :" + index);
		//System.out.println("List : " + fibList);
		return fibList.get(index-1);
	}

	private static long getPossibleNumberPos(long n)
	{
		int powerVal = 0;
		for (int i = 63; i>0; i--) {
			if ((n>>i & 1) == 1) {
				powerVal = i;
				break;
			}
		}
		long position = (long)Math.pow(2, powerVal);
		return position;
	}

	private static int getPossibleMiddleNum(ArrayList<Integer> fibList)
	{
		if (fibList.size() == 1) return fibList.get(0);
		if (fibList.size() == 2 || fibList.size() == 3) return fibList.get(1);
		return -1;
	}

	/**
	 * if a number is at odd position.. it never be considered as it would have removed already from the list during first iteration.
		Our desired number is at even position only.
	 * @param fibList
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getPossibleMiddleNum(ArrayList<Integer> fibList, long start, long end)
	{
		/*int mid;
		boolean isEven = (fibList.size())%2 == 0;
		while (start < end) {
			mid = (int)(start+end)/2;
			mid = mid+1;
			
		}*/
		int size = fibList.size();
		for (int i = 1; i<=size; i++) {
			if (i%2 != 0) {
				fibList.set(i-1, -1);
			}
		}
		for (int i = 0; i<fibList.size(); i++) {
			if (fibList.get(i) == -1) {
				fibList.remove(i);
			}
		}
		if (fibList.size() == 1) {
			return fibList.get(0);
		} else {
			return getPossibleMiddleNum(fibList, start, end);
		}
	}
	/*static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	private static int getFibonciiNumbersMiddle(long n)
	{
		Node root = new Node(0);
		root.next = new Node(0);
		int prevNum1 = 1;
		int prevNum2 = 0;
		int currNum;
		long counter = 2L;
		while (counter < n) {
			currNum = prevNum1+prevNum2;
			currNum = currNum%10;
			returnList.add(currNum);
			prevNum2 = prevNum1;
			prevNum1 = currNum;
			counter++;
			if (returnList.size() == 3) {
				returnList.remove(0);
				returnList.remove(1);
			}
			
		}
		
		return returnList;
	}*/
	private static ArrayList<Integer> getFibonciiNumbers(long n)
	{
		/*while (n>60) {
			n = n/60;
		}*/
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		returnList.add(0);
		returnList.add(1);
		int prevNum1 = 1;
		int prevNum2 = 0;
		int currNum;
		long counter = 2L;
		//System.out.print(prevNum2 + ", " + prevNum1);
		while (counter < n) {
			currNum = prevNum1+prevNum2;
			currNum = currNum%10;
			//System.out.print(", " + currNum);
			returnList.add(currNum);
			prevNum2 = prevNum1;
			prevNum1 = currNum;
			counter++;
			/*if (returnList.size() == 3) {
				int data = returnList.get(1);
				returnList.clear();
				returnList.add(data);
			}*/
		}
		
		return returnList;
	}
	private static ArrayList<Integer> getFibonciiNumbersComplete(long n)
	{
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		returnList.add(0);
		returnList.add(1);
		int prevNum1 = 1;
		int prevNum2 = 0;
		int currNum;
		long counter = 2L;
		//System.out.print(prevNum2 + ", " + prevNum1);
		while (counter < n) {
			currNum = prevNum1+prevNum2;
			currNum = currNum%10;
			//System.out.print(", " + currNum);
			returnList.add(currNum);
			prevNum2 = prevNum1;
			prevNum1 = currNum;
			counter++;
			/*if (returnList.size() == 3) {
				int data = returnList.get(1);
				returnList.clear();
				returnList.add(data);
			}*/
		}
		
		return returnList;
	}
}
