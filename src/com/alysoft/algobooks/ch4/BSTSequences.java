package com.alysoft.algobooks.ch4;

import java.util.ArrayList;
import java.util.LinkedList;

import com.alysoft.algorithms.tree.BinaryNode;

/**
 * BST Sequences: A binary search tree was created by traversing through an array from left to right
and inserting each element. Given a binary search tree with distinct elements, print all possible
arrays that could have led to this tree.
 * @author ymohammad
 *
 */
public class BSTSequences
{
	public static void getAllPossibleArrays(BinaryNode<Integer> bst, ArrayList<Integer[]> listOfPossibleArrays) {
		if (bst == null) return;
		
		
	}
	
	public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, 
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
			System.out.println("Preparing final first :" + first);
			System.out.println("Preparing final second :" + second);
			result.addAll(first);
			result.addAll(second);
			System.out.println("Preparing final result :" + result);
			results.add(result);
			System.out.println("Arrays of LinkedList :" + results);
			System.out.println("**************************************\n\n\n");
			return;
		}
		
		/**
		 * Recurse with head of first added to the prefix. Removing the head will damage
		 * first, so we'll need to put it back where we found it afterwards. 
		 */
		int headFirst = first.removeFirst();
		System.out.println("First head :" + headFirst);
		System.out.println("prefix :" + prefix);
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		System.out.println("First Prefix :" + prefix);
		
		/* Do the same thing with second, damaging and then restoring the list.*/
		int headSecond = second.removeFirst();
		System.out.println("Second head :" + headSecond);
		prefix.addLast(headSecond);
		System.out.println("second Prefix :" + prefix);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}
	public static void main(String[] args)
	{
		LinkedList<Integer> first = new LinkedList<Integer>();
		LinkedList<Integer> second = new LinkedList<Integer>();
		first.add(1);
		first.add(2);
		second.add(3);
		second.add(4);
		System.out.println("Before First :" + first);
		System.out.println("Before Second :" + second);
		
		ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		weaveLists(first, second, results, prefix);
		
		System.out.println("After First :" + first);
		System.out.println("After Second :" + second);
		
		System.out.println("results :" + results);
		System.out.println("prefix :" + prefix);
	}

}
