package com.alysoft.algobooks.ch2;

import com.alysoft.datastructure.linklist.*;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than x come
	before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
	to be after the elements less than x (see below). The partition element x can appear anywhere in the
	"right partition"; it does not need to appear between the left and right partitions.
	EXAMPLE
	Input:
	Output:
	3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
	3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

 * @author ymohammad
 *
 */
public class Partition
{
	/*
	//Method 1 : we start a"new" list (using the existing nodes). Elements bigger than the pivot element are
	put at the tail and elements smaller are put at the head. Each time we insert an element, we update either
	the head or tail.
	
	*/
	public static void partitionList(SinglyLinkedList<Integer> sl, int p) {
		SingleNode<Integer> head = sl.getHead();
		while (head != null) {
			if (head.getData() < p) {
				//System.out.println("Found :" + head.getData());
				int data = head.getData();
				SingleNode<Integer> nextNode = head.getNext();
				sl.delete(head);
				sl.insertAtBegining(data);
				head = nextNode;
			} else {
				head = head.getNext();
			}
		}
	}
	public static void main(String[] args)
	{
		SinglyLinkedList<Integer> sLL = new SinglyLinkedList<Integer>(1);
		sLL.insertAtEnd(7);
		sLL.insertAtEnd(3);
		
		
		sLL.insertAtEnd(8);
		sLL.insertAtEnd(5);
			sLL.insertAtEnd(6);
		sLL.insertAtEnd(2);
		sLL.insertAtEnd(4);
		sLL.insertAtEnd(9);
		sLL.insertAtEnd(10);
		/**/
		
		System.out.println("Complete List:" + sLL);
		
		partitionList(sLL, 5);
		System.out.println("Complete List:" + sLL);
	}

}
