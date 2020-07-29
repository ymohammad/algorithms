package com.alysoft.algo.binarysearchtrees.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * You are given a binary search tree. You task is to find the median of sub tree of Kth smallest node of the tree.

Input Format:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input.
 The first line contains number of nodes and a value K separated by space. The second line contains value of nodes.

Output Format:
For each testcase, in a new line, print the median of sub tree of Kth smallest node of the tree.

Your Task:
This is a function problem. You don't have to take any input. You just need to complete the function median that takes node and K as parameters.

Constraints:
1 <= T <= 30
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000
1 <= K <= Number of nodes 

Example:
Input:
1
12 9
50 25 75 15 45 90 11 20 30 49 80 100
Output:
85

Explanation:
Testcase1: The tree is like this:
                                  50
                                 /     \
                             25        75
                           /      \              \
                          15       45             90
                         /    \       /  \        /     \
                      11     20   30    49  80      100
K=9. So the 9th smallest number is 75. The values of this subtree are 75 80 90 100. Now, the median of this is (80+90)/2 = 85
 * 
 * @author ymohammad
 *
 */
public class StrangeMedian
{
	static class Node {
	    int data;
	    Node left, right;
	    Node(int key){
	        this.data = key;
	        this.left = this.right = null;
	    }
	}
	static Node insertInBST(Node root, int key) { 
        if (root == null) return new Node(key); 
	    if (key < root.data) root.left = insertInBST(root.left, key); 
	    else root.right = insertInBST(root.right, key); 
	    return root; 
    }
    
    public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    Node root = null;
		    inputLine = br.readLine().trim().split(" ");
		    root = insertInBST(root, Integer.parseInt(inputLine[0]));
		    for(int i=1; i<n; i++){
		        insertInBST(root, Integer.parseInt(inputLine[i]));
		    }
		    StrangeMedian g = new StrangeMedian();
		    System.out.println(g.median(root, k));
		}
	}
	int median(Node root, int k) {
        if(root==null)return -1;
        // Code here
        
        int count = 1;
        ArrayList<Node> list = new ArrayList<Node>();
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
        	while (curr != null) {
        		stack.push(curr);
        		curr = curr.left;
        	}
        	curr = stack.pop();
        	if (count >= k) {
        		list.add(curr);
        	}
        	count++;
        	curr = curr.right;
        }
        int n = list.size();
        if (n == 0) return -1;
        
        if (n%2 == 0) {
        	int ind = n/2;
        	return (list.get(ind-1).data + list.get(ind).data)/2;
        } else {
        	int ind = n/2;
        	return list.get(ind).data;
        }
    }
}
