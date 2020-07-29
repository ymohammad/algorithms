package com.alysoft.algo.binarysearchtrees;

import java.util.Stack;

import com.alysoft.algo.trees.Node;

public class InOrderTraversalNonRecursive
{
	
	
	public static void inOrder(Node root) {
		if (root == null) return;
		
		StringBuffer buff = new StringBuffer();
		Node curr = root;
		Stack<Node> stack = new Stack<Node>();
		
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			//curr is null at this point.
			curr = stack.pop();
			buff.append(curr.data);
			curr = curr.right;
		}
		System.out.println(buff);
	}
	//Morris Traversal - Iterative inorder without using extra space.
	public static void inOrderMorris(Node root) {
		if (root == null) return;
		
		StringBuffer buff = new StringBuffer();
		Node curr = root;
		while (curr != null) {
			if (curr.left == null) {
				buff.append(curr.data + " ");
				curr = curr.right;
			} else {
				Node inOrderPredecessor = getInOrderPredecessor(curr.left, curr.data);
				if (inOrderPredecessor.right == null) {
					inOrderPredecessor.right = curr;
					curr = curr.left;
				} else {
					inOrderPredecessor.right = null;
					buff.append(curr.data + " ");
					curr = curr.right;
				}
			}
		}
		System.out.print(buff);
	}
	
	private static Node getInOrderPredecessor(Node root, int rootData)
	{
		while (root.right != null && root.right.data != rootData) {
			root = root.right;
		}
		return root;
	}
	public static void preOrder(Node root) {
		if (root == null) return;
		
		StringBuffer buff = new StringBuffer();
		Node curr = root;
		Stack<Node> stack = new Stack<Node>();
		
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				buff.append(curr.data + " ");
				stack.push(curr);
				curr =curr.left;
			}
			curr = stack.pop();
			curr = curr.right;
		}
	}
}
