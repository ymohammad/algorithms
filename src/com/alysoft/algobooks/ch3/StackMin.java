package com.alysoft.algobooks.ch3;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 * @author ymohammad
 *
 */
public class StackMin
{
	/**
	 * This can be achieved with having a variable to hold minimum value. If during popout. It is possible that current min
	 * value might be popped out. If it happens then we need to find the new minimum which defeat the pop operation in O(1).
	 * 
	 * Mthod 2: We can store extra information in the stack node which tells what is the minimum unber under the stack. However,
	 * if the stack is big then we are holding something which rarely change and all the nodes have this information. This is not space efficient.
	 * 
	 * Method 3: We can use another stack to hold the minimum values. If it is pop out from main stack then we remove it from the
	 * min stack also otherwise not required. This is space efficient and also very fast.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
