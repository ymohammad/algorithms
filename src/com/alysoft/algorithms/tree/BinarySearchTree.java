package com.alysoft.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class BinarySearchTree {
	
	 class Node {
		    int data;
		    Node left;
		    Node right;
		    
		    Node() {
		    	
		    }
		    Node(int value) {
		    	this.data = value;
		    }
		 }
	 
	public BinaryNode getMinNode(BinaryNode rootNode) {
		BinaryNode resultNode = rootNode;
		BinaryNode tempNode = rootNode;
		while (tempNode != null) {
			resultNode = tempNode;
			tempNode = tempNode.getLeft();
		}
		return resultNode;
	}
	
	public BinaryNode getMaxNode(BinaryNode rootNode) {
		if (rootNode == null)
			return null;
		
		while (rootNode.getRight() != null) {
			rootNode = rootNode.getRight();
		}
		return rootNode;
	}
	
	public void appendNode(Node root, int value) {
		if (root == null) return;
		Node tempNode = root;
		while (true) {
			if (value > tempNode.data) {
				if (tempNode.right == null) {
					Node newNode = new Node();
					newNode.data = value;
					tempNode.right = newNode;
					break;
				} else {
					tempNode = tempNode.right;
				}
			} else {
				if (tempNode.left == null) {
					Node newNode = new Node();
					newNode.data = value;
					tempNode.left = newNode;
					break;
				} else {
					tempNode = tempNode.left;
				}
			}
		}
		
		
	}
	public Node insert(Node root, int value) {
		if (root == null) {
			root = new Node();
			root.data = value;
		} else {
			Node tempNode = root;
			while (true) {
				if (value > tempNode.data) {
					if (tempNode.right == null) {
						Node newNode = new Node();
						newNode.data = value;
						tempNode.right = newNode;
						break;
					} else {
						tempNode = tempNode.right;
					}
				} else {
					if (tempNode.left == null) {
						Node newNode = new Node();
						newNode.data = value;
						tempNode.left = newNode;
						break;
					} else {
						tempNode = tempNode.left;
					}
				}
			}
		}
		return root;
	}
	

	 
	 public static void main(String[] args) {
		 /*
		  	4
	       / \
	      2   7
	     / \
	    1   3
		  
		  p = (L+1)*2
		  s = (L + IP) 
		  */
		 BinarySearchTree bst = new BinarySearchTree();
		 Node root = bst.new Node(4);
		 root.left = bst.new Node(2);
		 root.right = bst.new Node(7);
		 root.left.left = bst.new Node(1);
		 root.left.right = bst.new Node(3);
		 
		 Node afterInsertion = bst.insert(root, 6);
		 
		 bst.printBinaryTree(afterInsertion);
		 
		 //4 2 3 1 7
		 root = null;
		 root = bst.insert(root, 4);
		 root = bst.insert(root, 2);
		 root = bst.insert(root, 3);
		 root = bst.insert(root, 1);
		 root = bst.insert(root, 7);
		 root = bst.insert(root, 6);
		 System.out.println("\n\nCompleted the prepration of new Tree..");
		 bst.printBinaryTree(afterInsertion);
	 }
	 private void printBinaryTree(Node rootNode) {
		if (rootNode == null) return;
		
		System.out.print(rootNode.data + " ");
		printBinaryTree(rootNode.left);
		printBinaryTree(rootNode.right);
	 }
	 private void printBinaryTree2(Node rootNode) {
		LinkedHashMap<Integer, ArrayList<Node>> mapObj = new LinkedHashMap<Integer, ArrayList<Node>>();
		loopEachLevel(mapObj, rootNode, 0);
		
		int dimensionY = mapObj.size();
		
		for (int eachInd = 0; eachInd < dimensionY; eachInd++) {
			
			ArrayList<Node> listObj = mapObj.get(eachInd);
			int dimensionX = listObj.size();
			
			for (Node nodeObj : listObj) {
				//System.out.print(nodeObj.getData() + " ");
			}
		}
	}
	
	public void loopEachLevel(Map<Integer, ArrayList<Node>> nodesListMap, 
			Node rootNode, int levelNo) {
		
		if (rootNode == null)
			return;
		
		ArrayList<Node> listOfNodes = null;
		if (nodesListMap.get(levelNo) == null) {
			listOfNodes = new ArrayList<Node>();
		} else {
			listOfNodes = nodesListMap.get(levelNo);
		}
		listOfNodes.add(rootNode);
		nodesListMap.put(levelNo, listOfNodes);
		
		levelNo = levelNo+1;
		loopEachLevel(nodesListMap, rootNode.left, levelNo);
		loopEachLevel(nodesListMap, rootNode.right, levelNo);
	}
}
