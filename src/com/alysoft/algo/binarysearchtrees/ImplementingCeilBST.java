package com.alysoft.algo.binarysearchtrees;

import com.alysoft.algo.trees.Node;

/**
 * Given an array arr[] of N positive integers to be inserted into BST and a number X. The task it to find Ceil of X.
Ceil(X) is a number that is either equal to X or is immediately greater than X.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements in the BST, i.e N. 
Next line contains N elements to be inserted into BST and last line contains X.

Output:
For each testcase, print the smallest element in BST which is larger than X.

Your task:
No need to worry about insert function in BST. Just complete the function findCeil() to implement ceil in BST.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 105

Example:
Input:
2
5
5 7 1 2 3
3
6
10 5 11 4 7 8
6

Output:
5
7

Explanation:
Testcase 1: We find 3 in BST, so ceil of 3 is 3.
 * @author ymohammad
 *
 */
public class ImplementingCeilBST
{
	/*
	 *  Ceil Value Node: Node with smallest data larger than or equal to key value.
		Imagine we are moving down the tree, and assume we are root node. The comparison yields three possibilities,
		A) Root data is equal to key. We are done, root data is ceil value.
		B) Root data < key value, certainly the ceil value can’t be in left subtree. Proceed to search on right subtree as reduced problem instance.
		C) Root data > key value, the ceil value may be in left subtree. We may find a node with is larger data than key value in 
			left subtree, if not the root itself will be ceil node.
	 */
	int findCeil(Node root, int key) { 
        if (root == null)
            return -1;
        // Code here
        
        if (root.data == key) return root.data;
        
        if (key > root.data) return findCeil(root.right, key);
        
        if (key < root.data) {
            int lower = findCeil(root.left, key);
            if (lower >= key) return lower;
        }
        return root.data;
    }
}
