package com.alysoft.algo.stack.contest;

import java.util.Scanner;
import java.util.Stack;

/**
 * Now, we'll try to solve a famous stack problem.

You are given an array A of size N. You need to push the elements of the array into a stack and then print minimum in the stack at each pop

Input Format:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. 
The first line of input contains size of array N. The second line of array contains the elements of array separated by spaces.

Output Format:
For each testcase, in a new line, print the required output.

Your Task:
Since this is a function problem, you don't need to take any input. Just complete the provided functions _push() and _getMinAtPop().

Constraints:
1 <= T <= 100
1 <= Ai <= 107

Examples:
Input:
2
5
1 2 3 4 5
7
1 6 43 1 2 0 5
Output:
1 1 1 1 1
0 0 1 1 1 1 1

 
 * @author ymohammad
 *
 */
public class MinimumAtPop
{

	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
            Stack<Integer>mys = _push(arr,n);
            _getMinAtPop(mys);
            System.out.println();
        }
    }
	private static Stack<Integer> minStack = null;
    public static Stack<Integer> _push(int arr[],int n)
    {
        minStack = new Stack<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int x: arr) {
            stack.push(x);
            if (minStack.isEmpty() || minStack.peek()>=x) {
                minStack.push(x);
            }
        }
        return stack;
    }
    
    /* print minimum element of the stack each time
       after popping*/
    static void _getMinAtPop(Stack<Integer>s)
    {
        StringBuffer buff = new StringBuffer();
        while (!s.isEmpty()) {
            int x = s.pop();
            buff.append(minStack.peek() + " ");
            if (x == minStack.peek()) {
                minStack.pop();
            }
        }
        System.out.print(buff.toString());
    }
}
