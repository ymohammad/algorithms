package com.alysoft.algobooks.ch2;

import com.alysoft.datastructure.linklist.SingleNode;

/**
 * Implement an algorithm to delete a node in the middle (i.e., any node but
	the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
	that node.
	EXAMPLE
	lnput:the node c from the linked list a->b->c->d->e->f
	Result: nothing is returned, but the new linked list looks like a ->b->d- >e- >f
 * @author ymohammad
 *
 */
public class DeleteMiddleNode
{
	/*
	 * Note that this problem cannot be solved if the node to be deleted is the last node in the linked list. That's
		okay-your interviewer wants you to point that out, and to discuss how to handle this case. You could, for
		example, consider marking the node as dummy.
	 */
	public static void deleteNode(SingleNode<Integer> node) {
		SingleNode<Integer> nextNode = node.getNext();
		node.setData(nextNode.getData());
		node.setNext(nextNode.getNext());
		nextNode.setNext(null);
	}
	public static void main(String[] args)
	{
		SingleNode<Integer> head = new SingleNode<Integer>(1, new SingleNode<Integer>(2, 
				new SingleNode<Integer>(3, new SingleNode<Integer>(4, new SingleNode<Integer>(5, null)))));
		deleteNode(head.getNext().getNext());
		while (head != null) {
			System.out.print(head.toString() + "-->");
			head = head.getNext();
		}
		
	}

}
