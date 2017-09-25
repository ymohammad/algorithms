package com.alysoft.algorithms.tree;

import java.util.Stack;

public class TreeUtils {

	/**
	 * A tree is a complete binary tree if it has either zero or two children.
	 * @param rootNode
	 * @return
	 */
	public static boolean isCompleteBinaryTree(BinaryNode rootNode) {
		if (rootNode == null)
			return true;

		if (rootNode.getLeft() == null && rootNode.getRight() == null)
			return true;

		if (rootNode.getLeft() != null && rootNode.getRight() != null) {
			return isCompleteBinaryTree(rootNode.getLeft())
					&& isCompleteBinaryTree(rootNode.getRight());
		} else {
			return false;
		}
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(getAreaOfCircle(9));
		divide(3, 4);
	}
	
	public static void divide(int a, int b) {
		if(a == 0) {
			System.out.println("Cannot divide by 0");
			return;
		}
		System.out.println((double)a/b);
	}
	
	public static float getAreaOfCircle(int radius) {
	    
		double area = (22/7d)*radius*radius;
		return (float)(area);
	}
	
	
	public static void printTopView(BinaryNode rootNode) {
		if (rootNode == null)
			return;
		printMostLeftNodes(rootNode.getLeft());
		System.out.println(rootNode.getData() + " ");
		printMostRightNodes(rootNode.getRight());
		
	}
	public static void printMostLeftNodes(BinaryNode rootNode) {
		BinaryNode tempNode = rootNode;
		while (tempNode != null) {
			System.out.println(tempNode.getData() + " ");
			tempNode = tempNode.getLeft();
		}
	}
	
	public static void printMostRightNodes(BinaryNode rootNode) {
		BinaryNode tempNode = rootNode;
		while (tempNode != null) {
			System.out.println(tempNode.getData() + " ");
			tempNode = tempNode.getRight();
		}
	}
	
	//Lowest Common Ancestor
	/*
	 *  
	 	 4
       /   \
      2     7
     / \   /
    1   3 6
     
	 */
	public Node getLowestCommonAncestor(Node root, int v1, int v2) {
		Stack<Node> v1Ancestors = new Stack<Node>();
		Stack<Node> v2Ancestors = new Stack<Node>();
		
		if (root.data == v1) {
			v1Ancestors.push(root);
		} else {
			if (v1 < root.data) {
				findNode(v1Ancestors, root.left, v1);
			} else {
				findNode(v1Ancestors, root.right, v1);
			}
		}
		
		if (root.data == v2) {
			v2Ancestors.push(root);
		} else {
			if (v2 < root.data) {
				findNode(v2Ancestors, root.left, v2);
			} else {
				findNode(v2Ancestors, root.right, v2);
			}
		}
		
		return null;
	}

	public void findNode(Stack<Node> v1Ancestors, Node left, int v1) {
		
	}
}
