package com.alysoft.algorithms.stacks;

import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		int h1Sum = 0;
		int h2Sum = 0; 
		int h3Sum = 0;
		
		int tempValueHolder = -1;
		
		int h1[] = new int[n1];
		for (int h1_i = n1-1; h1_i >= 0; h1_i--) {
			tempValueHolder = in.nextInt();
			h1[h1_i] = tempValueHolder;
			h1Sum = h1Sum + tempValueHolder;
		}
		int h2[] = new int[n2];
		for (int h2_i = n2-1; h2_i >= 0; h2_i--) {
			tempValueHolder = in.nextInt();
			h2[h2_i] = tempValueHolder;
			h2Sum = h2Sum + tempValueHolder;
		}
		int h3[] = new int[n3];
		for (int h3_i = n3-1; h3_i >= 0; h3_i--) {
			tempValueHolder = in.nextInt();
			h3[h3_i] = tempValueHolder;
			h3Sum = h3Sum + tempValueHolder;
		}
		Stack<Integer> stacksCy1 = getStackFromArray(h1);
		Stack<Integer> stacksCy2 = getStackFromArray(h2);
		Stack<Integer> stacksCy3 = getStackFromArray(h3);
		
		//System.out.println("h1Sum :" + h1Sum + " >h2Sum:" + h2Sum + " >h3Sum:" + h3Sum + " >stacksCy1:" + stacksCy1 + " >stacksCy2:" + stacksCy2
		//		+ " >stacksCy3:" + stacksCy3);
		int equalSize = getEqualHeightCylender(h1Sum, h2Sum, h3Sum, stacksCy1, stacksCy2, stacksCy3);
		System.out.println(equalSize);
	}

	/*
	 * Take the bigger height Stack,
	 * -> remove one stack and check all three are equal.
	 * -> If not equal, compare heights of all the stacks and repeat step 2.
	 */
	private static int getEqualHeightCylender(int h1Sum, int h2Sum, int h3Sum,
			Stack<Integer> stacksCy1, Stack<Integer> stacksCy2,
			Stack<Integer> stacksCy3) {
		int result = Math.min(Math.min(h1Sum, h2Sum), h3Sum);
		
		while(h1Sum != h2Sum || h2Sum != h3Sum) {
			if (h1Sum == 0 || h2Sum == 0 || h3Sum == 0) {
				result = 0;
				break;
			}
			
			int topped;
			if (h1Sum > result) {
				topped = stacksCy1.pop();
				h1Sum = h1Sum - topped;
				result = Math.min(result, h1Sum);
			} 
			if (h2Sum > result) {
				topped = stacksCy2.pop();
				h2Sum = h2Sum - topped;
				result = Math.min(result, h2Sum);
			} 
			
			if (h3Sum > result) {
				topped = stacksCy3.pop();
				h3Sum = h3Sum - topped;
				result = Math.min(result, h3Sum);
			}
		}
		
		return result;
	}

	private static Stack<Integer> getStackFromArray(int[] h1) {
		Stack<Integer> resultStack = new Stack<Integer>();
		for(int i=0; i < h1.length; i++){
			resultStack.push(h1[i]);
        }
		return resultStack;
	}
}
