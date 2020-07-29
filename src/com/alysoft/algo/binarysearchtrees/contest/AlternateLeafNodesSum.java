package com.alysoft.algo.binarysearchtrees.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * You need to build a BST from the given array A of size N. The array contains distinct elements. You need to build the tree using the Array elements in the order of their arrival (A[0] becomes root and so on). Now, you need to sum the alternate leaf nodes of this BST and print the result.
Note: Start from the left side of the tree when searching for leaf nodes. So sum leaftnode1+leaftnode3+leafnode5 ...

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. 
The first line contains N. The second line contains array elements.

Output:
For each testcase, in a new line, print the sum of alternate leaf nodes.

Constraints:
1 <= T <= 200
1 <= N <= 107
1 <= Ai <= 108

Examples:
Input:
1
6
5 1 2 3 4 6
Output:
4

Explanation:
Testcase1:
The BST will look like :
            5
          /     \
        1        6
         \         
            2                
               \          
                3  
                    \
                        4
As it is evident from the above BST, the leaf nodes are 4 and 6. So sum of alternate leaf nodes would be 4.
 * @author ymohammad
 *
 */
public class AlternateLeafNodesSum
{
	static class Node {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int[] a = new int[n];
            int i = 0;
			for (String s: arrayValues) {
			    if (s != null && s.trim().length() > 0) {
			        a[i]= Integer.parseInt(s.trim());
			        i++;
			    }
			}
				
			int x = getLeafNodesSum(a, n);
			
			System.out.println(x);
            t--;
        }
	}
	private static int getLeafNodesSum(int[] arr, int n)
	{
		if (n == 0) return -1;
		
		Node root = insertBST(null, arr[0]);
		for (int i = 1; i<n; i++) {
			insertBST(root, arr[i]);
		}
		
		int sum = getAlternateLeafNodesSum(root, n);
		return sum;
	}
	private static int getAlternateLeafNodesSum(Node root, int n)
	{
		if (root == null) return -1;
		
		int sum = 0;
		boolean isAdd = true;
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			if (current.left == null && current.right == null) {
				if (isAdd) {
					sum += current.data;
					isAdd = false;
				} else {
					isAdd = true;
				}
			}
			current = current.right;
		}
		
		return sum;
	}
	public static Node insertBST(Node root, int data) {
		if (root == null) return new Node(data);
		
		if (data < root.data) {
			root.left = insertBST(root.left, data);
		} else {
			root.right = insertBST(root.right, data);
		}
		return root;
	}
}
