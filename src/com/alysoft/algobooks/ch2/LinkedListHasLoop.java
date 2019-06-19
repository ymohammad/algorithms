package com.alysoft.algobooks.ch2;

import java.util.HashSet;
import java.util.Hashtable;

import com.alysoft.datastructure.linklist.SingleNode;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
	beginning of the loop.
	DEFINITION
	Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
	as to make a loop in the linked list.
	EXAMPLE
	Input: A - > B - > C - > D - > E - > C [the same C as earlier]
	Output:
	C
 * @author ymohammad
 *
 */
public class LinkedListHasLoop
{
	/**
	 * Method 2: This can also be solved by using two pointers. Slower and faster.
	 * 
	 *  1. Create two pointers, FastPointer and SlowPointer.
		2. Move FastPointer at a rate of 2 steps and SlowPointer at a rate of 1 step.
		3. When they collide, move SlowPointer to LinkedListHead. Keep FastPointer where it is.
		4. Move SlowPointer and FastPointer at a rate of one step. Return the new collision point.

	 * @param head
	 * @return
	 */
	public static SingleNode<Integer> getLoopNodeMethod2(SingleNode<Integer> head) {
		
	}
	/**
	 * Method 1: We can achieve this just be having a hastable and storing the node reference.
	 * If reference found then just return the node reference..
	 * @param head
	 * @return
	 */
	public static SingleNode<Integer> getLoopNode(SingleNode<Integer> head) {
		HashSet<SingleNode<Integer>> nodeRefereceHt = new HashSet<SingleNode<Integer>>();
		SingleNode<Integer> loopNode = null;
		while (head != null) {
			if (nodeRefereceHt.contains(head)) {
				loopNode = head;
				break;
			}
			nodeRefereceHt.add(head);
			head = head.getNext();
		}
		return loopNode;
	}
	
	public static void main(String[] args) {
		
		SingleNode<Integer> nineNode = new SingleNode<Integer>(9, null);
		nineNode.setNext(new SingleNode<Integer>(2, new SingleNode<Integer>(1, nineNode)));
		
		SingleNode<Integer> list1 = new SingleNode<Integer>(3, new SingleNode<Integer>(1, new SingleNode<Integer>(5, nineNode)));
		System.out.println("Sending list to find loopNode");
		SingleNode<Integer> loopNode = getLoopNode(list1);
		System.out.println(loopNode.getData());
		
		list1 = new SingleNode<Integer>(1, new SingleNode<Integer>(2, 
				new SingleNode<Integer>(3, new SingleNode<Integer>(4, new SingleNode<Integer>(5, null)))));
		loopNode = getLoopNode(list1);
		System.out.println(loopNode);
	}
}
