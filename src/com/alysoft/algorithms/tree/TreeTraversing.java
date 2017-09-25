package com.alysoft.algorithms.tree;

import java.util.Stack;

public class TreeTraversing {
	public static void main(String args[]) {
		TreeTraversing traversingObj = new TreeTraversing();
		
        /* creating a binary tree and entering 
         the nodes */
        
		//Case 1 -- BAC - INORDER
		System.out.println("\n\n********* Case 1 **************");
		BinaryTree tree = new BinaryTree();
		tree.setRoot(new BinaryNode('A'));
        tree.getRoot().setLeft(new BinaryNode('B'));
        tree.getRoot().setRight(new BinaryNode('C'));
        
        System.out.println("******** ITERATIVE - INORDER **********");
        traversingObj.inOrderIterative(tree.getRoot());
        
        System.out.println("\n******** RECURSIVE - INORDER **********");
        traversingObj.inOrderTraverser(tree.getRoot());
        
        
        //Case 2 --  - INORDER
        System.out.println("\n\n********* Case 2 **************");
      	BinaryTree tree2 = new BinaryTree();
      	tree2.setRoot(new BinaryNode('A'));
      	tree2.getRoot().setLeft(new BinaryNode('B'));
      	tree2.getRoot().setRight(new BinaryNode('C'));
      	tree2.getRoot().getLeft().setLeft(new BinaryNode('D'));
      	tree2.getRoot().getLeft().setRight(new BinaryNode('E'));
        
      	 System.out.println("******** ITERATIVE - INORDER **********");
         traversingObj.inOrderIterative(tree2.getRoot());
         
         System.out.println("\n******** RECURSIVE - INORDER **********");
         traversingObj.inOrderTraverser(tree2.getRoot());
    }
	
	
	public int getHeight(BinaryNode rootNode) {
		return height(rootNode)-1;
	}
	
	public int height(BinaryNode rootNode) {
		if (rootNode == null || isLeaveNode(rootNode))
			return 0;
		
		int leftSubHeight = height(rootNode.getLeft());
		int rightSubHeight = height(rootNode.getRight());
		if (leftSubHeight < rightSubHeight) {
			return rightSubHeight + 1;
		} else {
			return leftSubHeight + 1;
		}
	}
	
	public boolean isLeaveNode(BinaryNode node) {
		return node.getLeft() == null && node.getRight() == null;
	}
	public void inOrderIterative(BinaryNode rootNode) {
		if (rootNode == null) 
			return;
		
		BinaryNode tempNode = rootNode;
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		
		
		while (tempNode != null) {
			stack.push(tempNode);
			tempNode = tempNode.getLeft();
		}
		
		while (stack.size() > 0) {
			tempNode = stack.pop();
			System.out.print(tempNode.getData() + " ");
			
			if (tempNode.getRight() != null) {
				
				tempNode = tempNode.getRight();
				while (tempNode != null) {
					stack.push(tempNode);
					tempNode = tempNode.getLeft();
				}
			}
		}
	}
	/*
	 * Full Node: Node which has both Left and Right child.
	 */
	public int numberOfFullNodes(BinaryNode node) {
		if (node == null)
			return 0;

		if (node.getLeft() == null && node.getRight() == null)
			return 0;

		return numberOfFullNodes(node.getLeft())
				+ numberOfFullNodes(node.getRight())
				+ ((node.getLeft() != null && node.getRight() != null) ? 1 : 0);
	}
	public int numberOfNodes(BinaryNode node) {
		if (node != null) {
			return (1 + numberOfNodes(node.getLeft()) + numberOfNodes(node.getRight()));
		} else {
			return 0;
		}
	}
	
	//Leave node is a node for which left pointer and right pointer both are null.
	public int numberOfLeaveNodes(BinaryNode node) {
		if (node != null) {
			if (node.getLeft() == null && node.getRight() == null) {
				return 1;
			} else {
				return numberOfLeaveNodes(node.getLeft()) + numberOfLeaveNodes(node.getRight());
			}
		} else {
			return 0;
		}
	}
	
	public int numberOfNonLeaveNodes(BinaryNode node) {
		if (node != null) {
			if (node.getLeft() == null && node.getRight() == null) {
				return 0;
			} else {
				return 1 + numberOfLeaveNodes(node.getLeft()) + numberOfLeaveNodes(node.getRight());
			}
		} else {
			return 0;
		}
	}
	
	//InOrder traverser is BAC. We visit left first then center then right.
	public void inOrderTraverser(BinaryNode node) {
		if (node != null) {
			inOrderTraverser(node.getLeft());
			System.out.print(node.getData() + " ");
			inOrderTraverser(node.getRight());
		}
	}
	
	//PreOrder traverser is ABC. We visit center first, then left then right.
	public void preOrderTraverser(BinaryNode node) {
		if (node != null) {
			System.out.println(node.getData());
			inOrderTraverser(node.getLeft());
			inOrderTraverser(node.getRight());
		}
	}
	
	//PostOrder traverser is BCA. We visit left first, then right then root.
	public void postOrderTraverser(BinaryNode node) {
		if (node != null) {
			inOrderTraverser(node.getLeft());
			inOrderTraverser(node.getRight());
			System.out.println(node.getData());
		}
	}
}
