package com.alysoft.algorithms.hackerrank.tree;

import java.util.Scanner;

import com.alysoft.algorithms.tree.BinaryNode;

/**
 * Problem Source: https://www.hackerrank.com/challenges/swap-nodes-algo/problem
 * 
 * Swapping: Swapping subtrees of a node means that if initially node has left subtree L and right subtree R, 
 * then after swapping left subtree will be R and right subtree L.

Eg. In the following tree, we swap children of node 1.

                                Depth
    1               1            [1]
   / \             / \
  2   3     ->    3   2          [2]
   \   \           \   \
    4   5           5   4        [3]
Inorder traversal of left tree is 2 4 1 3 5 and of right tree is 3 5 1 2 4.

Swap operation: Given a tree and a integer, K, we have to swap the subtrees of all the nodes
 who are at depth h, where h = [K, 2K, 3K,...].

You are given a tree of N nodes where nodes are indexed from [1..N] and it is rooted at 1. 
You have to perform T swap operations on it, and after each swap operation print the inorder traversal of the current state of the tree.


Input Format 
First line of input contains N, number of nodes in tree. Then N lines follow. Here each of ith line (1 <= i <= N) contains two integers, a b, 
where a is the index of left child, and b is the index of right child of ith node. -1 is used to represent null node. 
Next line contain an integer, T. Then again T lines follows. Each of these line contains an integer K.

Output Format 
For each K, perform swap operation as mentioned above and print the inorder traversal of the current state of tree.

Constraints 
1 <= N <= 1024 
1 <= T <= 100 
1 <= K <= N 
Either a = -1 or 2 <= a <= N 
Either b = -1 or 2 <= b <= N 
Index of (non-null) child will always be greater than that of parent.

* Sample Input #02

	11
	2 3
	4 -1
	5 -1
	6 -1
	7 8
	-1 9
	-1 -1
	10 11
	-1 -1
	-1 -1
	-1 -1
	2
	2
	4
	Sample Output #02
	
	2 9 6 4 1 3 7 5 11 8 10
	2 6 9 4 1 3 7 5 10 8 11
 * @author ymohammad
 *
 */
public class SwapNodes {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int elementsArr[] = new int[n+1];
        elementsArr[0] = 1;
        int arrCurrInd = 1;
        for(int a0 = 0; a0 < n; a0++){
            String line = in.nextLine();
            String[] lefRightVal = line.split(" ");
            elementsArr[arrCurrInd] = Integer.parseInt(lefRightVal[0]);
            elementsArr[arrCurrInd+1] = Integer.parseInt(lefRightVal[1]);
            
            arrCurrInd = arrCurrInd + 2;
        }
        int noOfSwaps = in.nextInt();
        int[] depthArr = new int[noOfSwaps];
        
        for(int x = 0; x<noOfSwaps; x++) {
        	depthArr[x] = in.nextInt();
        }
        in.close();
        
        BinaryNode treeRootNode = createTree(elementsArr);
        
        performSwapOperation(noOfSwaps, treeRootNode, depthArr);
	}
	private static void performSwapOperation(int noOfSwaps, BinaryNode treeRootNode, int[] depthArr) {
		BinaryNode tempRootNode = treeRootNode;
		for(int x = 0; x< noOfSwaps; x++) {
			int depth = depthArr[x];
			performSwapAtDepth(depth, treeRootNode);
		}
	}
	private static void performSwapAtDepth(int depth, BinaryNode treeRootNode) {
		while(true) {
			
			if (treeRootNode == null || treeRootNode.depth == depth) {
				break;
			}
			
			if (treeRootNode.getLeft() != null) {
				treeRootNode = treeRootNode.getLeft();
			}
			
			if (treeRootNode.getRight() != null) {
				treeRootNode = treeRootNode.getRight();
			}
		}
	}
	public static BinaryNode createTree(int a[]) {
		BinaryNode rootNode = new BinaryNode();
		rootNode.setData(a[0]);
		rootNode.setDepth(1);
		
		BinaryNode tempNode = rootNode;
		int x = 1;
		while (x<a.length) {
			if (a[2*x+1] != -1) {
				tempNode.setLeft(new BinaryNode(a[2*x+1], x+1));
			}
			
			if (a[2*x+2] != -1) {
				tempNode.setRight(new BinaryNode(a[2*x+2], x+1));
			}
			
			x++;
			if (x%2 != 0) {
				tempNode = tempNode.getLeft();
			} else {
				tempNode = tempNode.getRight();
			}
		}
		return rootNode;
	}
	
	static class BinaryNode {
		private int data;
		private BinaryNode left;
		private BinaryNode right;
		private int depth;
		
		public BinaryNode() {
			this.left = this.right = null;
		}
		public BinaryNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
		public BinaryNode(int data, int depth) {
			this.data = data;
			this.depth = depth;
			this.left = this.right = null;
		}
		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public BinaryNode getLeft() {
			return left;
		}

		public void setLeft(BinaryNode left) {
			this.left = left;
		}

		public BinaryNode getRight() {
			return right;
		}

		public void setRight(BinaryNode right) {
			this.right = right;
		}
		
		public int getDepth() {
			return depth;
		}
		public void setDepth(int depth) {
			this.depth = depth;
		}
	}
}

