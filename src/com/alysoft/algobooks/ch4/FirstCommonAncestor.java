package com.alysoft.algobooks.ch4;

import java.util.HashMap;

import com.alysoft.algorithms.tree.BinaryNode;

/**
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.
 * @author ymohammad
 *
 */
public class FirstCommonAncestor
{

	/**
	 * Method 1: SUppose if there is a link to the parent for each node.
	 * Then we can easily find the common ancestor. It is same like the intersecting nodes.
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static BinaryNode<Integer> findCommonAncestor(BinaryNode<Integer> root, BinaryNode<Integer> p, BinaryNode<Integer> q) {
		if (root == null) return root;
		
		int delta = getDepth(p) - getDepth(q);
		BinaryNode<Integer> first = delta > 0 ? p : q; //deep node..
		BinaryNode<Integer> second = delta > 0 ? q : p; // not deep compare to first.
		
		first = upToTree(first, delta);
		
		while (first != null && second != null && first != second ) {
			first = first.getParent();
			second = second.getParent();
		}
		
		return first == null || second == null ? null : first;
	}

	private static BinaryNode<Integer> upToTree(BinaryNode<Integer> node, int delta)
	{
		while (delta > 0) {
			node = node.getParent();
			delta--;
		}
		return node;
	}

	private static int getDepth(BinaryNode<Integer> node)
	{
		int depth = 0;
		while (node != null) {
			depth++;
			node = node.getParent();
		}
		return depth;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(">>> starting..");
		BinaryNode<Integer> rootNode = prepareNGetTree(numbers, 0, null);
		BinaryNode<Integer> commonAncestor = findCommonAncestor(rootNode, localMap.get(8), localMap.get(5));
		System.out.println(">> commonAncestor :" + commonAncestor.getData());
	}
	private static HashMap<Integer, BinaryNode<Integer>> localMap = new HashMap<>();
	public static BinaryNode<Integer> prepareNGetTree(int[] numbers, int i, BinaryNode<Integer> rootNode) {
		
		if (i < numbers.length)
		{
			BinaryNode<Integer> tempPointer = new BinaryNode<Integer>(numbers[i]);
			rootNode = tempPointer;
			localMap.put(rootNode.getData(), rootNode);
			
			rootNode.setLeft(prepareNGetTree(numbers, (2*i+1), rootNode.getLeft()));
			if (rootNode.getLeft() != null)
				rootNode.getLeft().setParent(rootNode);
			
			rootNode.setRight(prepareNGetTree(numbers, (2*i+2), rootNode.getRight()));
			if (rootNode.getRight() != null)
				rootNode.getRight().setParent(rootNode);
		}
		return rootNode;
	}
}
