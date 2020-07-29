package com.alysoft.algo.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstTriversal
{

	public static void main(String[] args)
	{
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(16);
		root.left.right = new Node(21);
		root.right.left = new Node(22);
		root.right.right = new Node(1);
		root.left.left.left = new Node(0);
		
		//bfTraversal(root);
		printLevelByLevel(root);
	}
	public static void printLevelByLevel(Node root) {
		if (root == null) return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		Node temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp != null) {
				System.out.print(temp.data + " ");
				if (temp.left != null)
					queue.add(temp.left);
				
				if (temp.right != null)
					queue.add(temp.right);
			} else {
				if (!queue.isEmpty()) {
					System.out.println();
					queue.add(null);
				}
			}
		}
	}
	public static void bfTraversal(Node root)
	{
		if (root == null) return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp != null)
			{
				System.out.print(temp.data + " ");
				if (temp.left != null)
					queue.add(temp.left);
				
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
	}
}
