package com.alysoft.algobooks.ch4;

import java.util.Hashtable;
import java.util.LinkedList;

import com.alysoft.algorithms.tree.BinaryNode;

public class ListOfDepths
{
	public static void getDepthsList(Hashtable<Integer, LinkedList<BinaryNode<Integer>>> hashtb, int level, BinaryNode<Integer> root) {
		if (root == null) return;
		
		LinkedList<BinaryNode<Integer>> ls = null;
		if (hashtb.containsKey(level)) {
			ls = hashtb.get(level);
			ls.add(root);
		} else {
			ls = new LinkedList<BinaryNode<Integer>>();
			ls.add(root);
			hashtb.put(level, ls);
		}
		getDepthsList(hashtb, level+1, root.getLeft());
		getDepthsList(hashtb, level+1, root.getRight());
	}
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7};
		BinaryNode<Integer> bst = getBST(arr);
		Hashtable<Integer, LinkedList<BinaryNode<Integer>>> hashtb = new Hashtable<Integer, LinkedList<BinaryNode<Integer>>>();
		getDepthsList(hashtb, 1, bst);
		System.out.println(hashtb.size());

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
