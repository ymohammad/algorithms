package com.alysoft.algobooks.ch4;

import java.util.Stack;

import com.alysoft.algorithms.tree.BinaryNode;

public class ValidateBST
{
	/**
	 * Think about the validateBSTByRecursive function as a recursive function that ensures each node is
		within an allowable (min, max) range. At first, this range is infinite. When we traverse
		to the left, the min is negative infinity and the max is root. value . Can you implement
		this recursive function and properly adjust these ranges as you traverse the tree?
	 */
	public static boolean validateBSTByRecursive(BinaryNode<Integer> rootNode) {
		return validateBSTByRecursive(rootNode, null, null);
	}
	public static boolean validateBSTByRecursive(BinaryNode<Integer> rootNode, Integer min, Integer max) {
		if (rootNode == null) return true;
		
		if ((min != null && rootNode.getData() <= min) || (max != null && rootNode.getData() > max)) {
			return false;
		}
		
		if (!validateBSTByRecursive(rootNode.getLeft(), min, rootNode.getData()) || !validateBSTByRecursive(rootNode.getRight(), rootNode.getData(), max)) {
			return false;
		}
		return true;
		
	}
	/**
	 * Method 1: As we know it is a BST then if we traverse the tree in In-ORDER then it will give a sorted values.
	 * We can keep the values in an array (stack) and can verify if the value is in sorted for or not.
	 * @param rootNode
	 * @return
	 */
	public static boolean isValidBSTByInOrder(BinaryNode<Integer> rootNode) {
		Stack<Integer> sortedValueStack = new Stack<Integer>();
		boolean returnVal = traverseTreeInOrder(rootNode, sortedValueStack);
		System.out.println("Sorted Values :" + sortedValueStack);
		return returnVal;
	}
	public static boolean traverseTreeInOrder(BinaryNode<Integer> rootNode, Stack<Integer> sortedValueStack) {
		if (rootNode == null) return true;
		
		boolean leftTraversal = traverseTreeInOrder(rootNode.getLeft(), sortedValueStack);
		if (!leftTraversal) {
			return leftTraversal;
		}
		if (!sortedValueStack.isEmpty() && sortedValueStack.peek() > rootNode.getData()) {
			return false;
		}
		sortedValueStack.push(rootNode.getData());
		
		return traverseTreeInOrder(rootNode.getRight(), sortedValueStack);
	}
	
	/**
	 * This method checks the condition for each sub tree.
	 * But this might not work. Because.. root should be less the entire
	 * sub tree.
	 * @param rootNode
	 * @return
	 */
	public static boolean isValidBST(BinaryNode<Integer> rootNode) {
		if (rootNode == null) return true;
		BinaryNode<Integer> right = rootNode.getRight();
		BinaryNode<Integer> left = rootNode.getLeft();
		if (right != null && (right.getData() < rootNode.getData())) {
			return false;
		} else if (left != null && (left.getData() > rootNode.getData())) {
			return false;
		} else {
			return isValidBST(rootNode.getLeft()) && isValidBST(rootNode.getRight());
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,4,6,7, 8, 9, 10};
		BinaryNode<Integer> bst = getBST(arr);
		System.out.println(">>>> isValidBSTByInOrder :" + isValidBSTByInOrder(bst));
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
		return n;
	}
}
