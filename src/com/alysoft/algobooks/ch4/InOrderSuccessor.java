package com.alysoft.algobooks.ch4;

import com.alysoft.algorithms.tree.BinaryNode;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent.
 * @author ymohammad
 *
 */
public class InOrderSuccessor
{
	public static BinaryNode<Integer> getNextNode(BinaryNode<Integer> node) {
		if (node == null) return node;
		
		//Is it a Root
		 if (node.getRight() != null) { 
			BinaryNode<Integer> right = node.getRight();
			while (right.getLeft() != null) {
				right = right.getLeft();
			} 
			return right;
		} else {
			//leaf nodes.
			if (node.getParent().getLeft() == node) {
				return node.getParent();
			} else {
				BinaryNode<Integer> n = node.getParent();
				while (n != null && n.getParent() != null && n.getParent().getRight() == n) {
					n = n.getParent();
				}
				return n.getParent() == null ? null : n;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7, 8, 9, 10};
		BinaryNode<Integer> bst = getBST(arr);
		BinaryNode<Integer> testNode = getDataNode(bst, 5);
		System.out.println(testNode.getData());
		System.out.println(">>>> isValidBSTByInOrder :" + getNextNode(testNode));
	}

	
	private static BinaryNode<Integer> getDataNode(BinaryNode<Integer> bst, int data)
	{
		if (bst == null) return null;
		
		if (bst.getData() == data) return bst;
		
		BinaryNode<Integer> node = getDataNode(bst.getLeft(), data);
		if (node != null) return node;
		
		
		return getDataNode(bst.getRight(), data);
	}
	//Supporting methods..
	public static BinaryNode<Integer> getBST(int[] sortedArr) {
		if (sortedArr == null) return null;
		return createMinimalBST(sortedArr,0, sortedArr.length-1);
	}
	public static BinaryNode<Integer> createMinimalBST(int arr[], int start, int end) {
		if (end < start) return null;
		int mid = (start + end)/2;
		BinaryNode<Integer> n = new BinaryNode<Integer>(arr[mid]);
		n.setLeft(createMinimalBST(arr, start, mid-1));
		n.setRight(createMinimalBST(arr, mid+1, end));
		
		if (n.getLeft() != null) n.getLeft().setParent(n);
		if (n.getRight() != null) n.getRight().setParent(n);
		return n;
	}
}
