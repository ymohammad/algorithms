package com.alysoft.algobooks.ch2;

import com.alysoft.datastructure.linklist.SingleNode;

/*
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 * It is easy if we know the size of the LL. n-k will give the kth node in the list.
 * But if size is not know then we can solve this problem by using two pointers.
 * Pointer1 move till kth from start then we have a new pointer from head.
 * Once the first pointer reaches end the second pointer will be at the kth position from last.
 */
public class ReturnKthToLast
{
	//Solution 1: Recursive method call..
	public static int kthFromLastRecursive(SingleNode<Integer> head, int k) {
		if (head == null) return 0;
		
		int curVal = kthFromLastRecursive(head.getNext(), k) + 1;
		
		if (curVal == k) {
			System.out.println("Kth value from last :" + head.getData());
		}
		return curVal;
	}
	//Solution 2
	public static void kthFromLast(SingleNode<Integer> head, int k) {
		SingleNode<Integer> firstPointer = head;
		SingleNode<Integer> secondPointer = head;
		
		for (int i=0; i<k; i++) {
			if (firstPointer == null) return;
			
			firstPointer = firstPointer.getNext();
		}
		
		while (firstPointer != null) {
			firstPointer = firstPointer.getNext();
			secondPointer = secondPointer.getNext();
		}
		System.out.println(k + "th position Node is " + secondPointer);
	}
	public static void main(String[] args)
	{
		SingleNode<Integer> head = new SingleNode<Integer>(1, new SingleNode<Integer>(2, new SingleNode<Integer>(3, new SingleNode<Integer>(4, new SingleNode<Integer>(5, null)))));
		//kthFromLast(head, 5);
		kthFromLastRecursive(head, 5);
	}

}
