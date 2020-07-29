package com.alysoft.algo.trees;

import java.util.HashMap;

/**
 * Given an array of size N that represents a Tree in such a way that array indexes are values in tree nodes and array values give 
 * the parent node of that particular index (or node). The value of the root node index would always be -1 as there is no parent for root. 
 * Construct the standard linked representation of Binary Tree from this array representation.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of 
two lines. First line of each test case contains an integer N denoting the size of the tree array . Second line of each test case consists 
of 'N' space separated integers denoting the elements of the array .

Output:
The Output will be the sorted level order traversal of the tree.

User Task:
The task is complete the function 

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
2
7
-1 0 0 1 1 3 5
5
-1 0 0 2 2   

Output:
0 1 2 3 4 5 6
0 1 2 3 4

Explanation:
Testcase 1: For the array parent[] = {-1, 0, 0, 1, 1, 3, 5}; the tree generated will have a sturcture like

         0
       /   \
      1     2
     / \
    3   4
   /
  5
/
6
 * @author ymohammad
 *
 */
public class ConstructBinaryTreeFromParentArray
{

	public static void main(String[] args)
	{
		
	}

	//1 13 31 7 17 33 27 1 5 15 19 3 33 17 19 21 23 25 31 11 29 13 27 7 25 -1 23 15 3 11 21 5 9 9 
    public static Node createTree(int arr[], int n)
    {
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        Node root = null;
        for (int ind = 0; ind<arr.length; ind++) {
        	int data = ind;
        	int parentIndex = arr[ind];
        	
        	Node temp = new Node(data);
        	map.put(ind, temp);
        	if (parentIndex == -1) {
        		root = temp;
        	} else {
        		Node parent = map.containsKey(parentIndex) ? map.get(parentIndex) : null;
        		if (parent == null) {
        			parent = new Node(parentIndex);
        			map.put(parentIndex, parent);
        		}
        		if (parent.left == null) {
    				parent.left = temp;
    			} else {
    				parent.right = temp;
    			}
        	}
        	
        }
        return root;
    }
}
