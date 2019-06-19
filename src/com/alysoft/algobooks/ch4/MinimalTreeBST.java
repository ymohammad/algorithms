package com.alysoft.algobooks.ch4;

import com.alysoft.algorithms.tree.BinaryNode;

public class MinimalTreeBST
{
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
		return n;
	}
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7};
		BinaryNode<Integer> bst = getBST(arr);
		System.out.println(">>>>");
		printInOrderTriversal(bst);
	}

	public static void printInOrderTriversal(BinaryNode<Integer> node) {
		if (node == null) return;
		
		printInOrderTriversal(node.getLeft());
		System.out.println(node.getData());
		printInOrderTriversal(node.getRight());
	}
}
