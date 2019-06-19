package com.alysoft.algobooks.ch4;

import com.alysoft.algorithms.tree.BinaryNode;

/**
 * Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
algorithm to determine if T2 is a subtree of Tl.
A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
That is, if you cut off the tree at node n, the two trees would be identical.
 * @author ymohammad
 *
 */
public class CheckSubTree
{
	/**
	 * Method 1: It is possible to compare to strings. If we traverse the T1 and T2.
	 * And prepare a string. If T2 is the substring of T1 then it is a Subtree.
	 * However, here In-Order triversal will not work. Because it will give the values which
	 * are not having the same structure.
	 * PREORDER Traversal will give the values in correct order and we can compare two strings.
	 * Unfortunately, trees with different structures could still have the same pre-order traversal.
	 * With small tweak we can avoid this issue. When we reach the end state then we put the string 'X'.
	 * This gives proper tree.
	 * The left tree would have the traversal { 3, 4, X} and the right tree will have the traversal { 3, X, 4}.
	 * Otherwise, both trees have the same preorder traversal value.
	 * 
	 * This approach takes O(n + m) time and O(n + m) space, where n and mare the number of nodes in Tl 
	 * and T2, respectively. Given millions of nodes, we might want to reduce the space complexity.
	 * @param t1
	 * @param t2
	 */
	public static boolean verifySubTree1(BinaryNode<Integer> t1, BinaryNode<Integer> t2) {
		StringBuilder t1PreOrderString = new StringBuilder();
		StringBuilder t2PreOrderString = new StringBuilder();
		
		prepareTreePreOrderAsString(t1, t1PreOrderString);
		prepareTreePreOrderAsString(t2, t2PreOrderString);
		if (t1PreOrderString.indexOf(t2PreOrderString.toString()) != -1) {
			return true;
		}
		return false;
	}

	private static void prepareTreePreOrderAsString(BinaryNode<Integer> treeHead, StringBuilder preOrderStr) {
		if (treeHead == null) {
			preOrderStr.append("X");
			return;
		}
		preOrderStr.append(treeHead.getData().toString());
		prepareTreePreOrderAsString(treeHead.getLeft(), preOrderStr);
		prepareTreePreOrderAsString(treeHead.getRight(), preOrderStr);
	}
	
	/**
	 * Method 2: Alternative approach is to find find the head value of T2 in T1.
	 * Once find then start comparing left of T1 with left of T2, right of T1 with right of T2.
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean verifySubTree2(BinaryNode<Integer> t1, BinaryNode<Integer> t2) {
		if (t2 == null) return true;
		
		return isSubTree(t1, t2);
	}
	
	public static boolean isSubTree(BinaryNode<Integer> t1, BinaryNode<Integer> t2) {
		if (t1 == null) return false;
		
		if (t1.getData() == t2.getData() && matchTree(t1, t2)) {
			return true;
		} else {
			return isSubTree(t1.getLeft(), t2) ||  isSubTree(t1.getRight(), t2);
		}
	}

	private static boolean matchTree(BinaryNode<Integer> t1, BinaryNode<Integer> t2)
	{
		if (t1 == null && t2 == null) return true;
		
		if (t1== null || t2 == null) return false;
		
		if (t1.getData() != t2.getData()) return false;
		
		return matchTree(t1.getLeft(), t2.getLeft()) && matchTree(t1.getRight(), t2.getRight());
	}
}
