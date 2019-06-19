package com.alysoft.algobooks.ch4;

import com.alysoft.algorithms.graphs.Node;
import com.alysoft.algorithms.tree.BinaryNode;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.
 * @author ymohammad
 *
 */
public class CheckBalanced
{
	public static boolean isBalancedTree(BinaryNode<Integer> rootNode) {
		int leftHeight = getTreeHeight(rootNode.getLeft());
		int rightHeight = getTreeHeight(rootNode.getRight());
		
		if (leftHeight == rightHeight) return true;
		
		return (leftHeight == rightHeight) || (leftHeight == (rightHeight + 1)) || (rightHeight == leftHeight+1);
	}
	private static int getTreeHeight(BinaryNode<Integer> node)
	{
		if (node == null) return 0;
		
		int leftTreeH = 1 + getTreeHeight(node.getLeft());
		int rightTreeH = 1 + getTreeHeight(node.getRight());
		
		return (leftTreeH > rightTreeH ? leftTreeH : rightTreeH);
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		BinaryNode<Integer> bst = getBST(arr);
		System.out.println("Is Balanced :" + isBalancedTree(bst));
	}
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
}
