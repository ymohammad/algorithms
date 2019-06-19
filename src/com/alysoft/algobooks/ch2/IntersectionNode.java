package com.alysoft.algobooks.ch2;

import com.alysoft.datastructure.linklist.SingleNode;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
kth node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.
 * @author ymohammad
 *
 */
public class IntersectionNode
{
	public static SingleNode<Integer> getInsertionNode(SingleNode<Integer> list1Head, SingleNode<Integer> list2Head) {
		
		if (list1Head == null || list2Head == null) return null;
		
		int list1Length = getListLength(list1Head);
		int list2Length = getListLength(list2Head);
		
		SingleNode<Integer> longerList = list1Length >= list2Length ? list1Head : list2Head;
		SingleNode<Integer> smallerList = list1Length < list2Length ? list1Head : list2Head;
		
		int k = Math.abs(list1Length - list2Length);
		
		while (k != 0) {
			longerList = longerList.getNext();
			k--;
		}
		while (longerList != null && smallerList != null) {
			if (longerList == smallerList) return smallerList;
			
			longerList = longerList.getNext();
			smallerList = smallerList.getNext();
		}
		return null;
	}
	private static int getListLength(SingleNode<Integer> head)
	{
		int returnCount = 0;
		while (head != null) {
			returnCount++;
			head = head.getNext();
		}
		
		return returnCount;
	}
	public static void main(String[] args)
	{
		SingleNode<Integer> sevenNode = new SingleNode<Integer>(7, null);
		sevenNode.setNext(new SingleNode<Integer>(2, new SingleNode<Integer>(1, null)));
		
		SingleNode<Integer> list1 = new SingleNode<Integer>(3, new SingleNode<Integer>(1, 
				new SingleNode<Integer>(5, new SingleNode<Integer>(9, new SingleNode<Integer>(5, sevenNode)))));
		
		SingleNode<Integer> list2 = new SingleNode<Integer>(4, new SingleNode<Integer>(6, sevenNode));
		
		SingleNode<Integer> insertionNode = getInsertionNode(list1, list2);
		SingleNode.printLinkedList(insertionNode);
		
		insertionNode = getInsertionNode(list1, null);
		SingleNode.printLinkedList(insertionNode);
		
		insertionNode = getInsertionNode(list1, new SingleNode<Integer>(3, new SingleNode<Integer>(1, 
				new SingleNode<Integer>(5, new SingleNode<Integer>(9, new SingleNode<Integer>(5, null))))));
		SingleNode.printLinkedList(insertionNode);
	}

}
