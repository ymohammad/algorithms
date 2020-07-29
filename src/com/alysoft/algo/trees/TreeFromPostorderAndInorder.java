package com.alysoft.algo.trees;

import java.util.Scanner;

public class TreeFromPostorderAndInorder
{
	public static void preOrder(Node root) 
	{
		if(root == null)
			return;
		
			System.out.print(root.data+" ");
			preOrder(root.left);
			
			preOrder(root.right);
		
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int inorder[] = new int[n];
			int postorder[] = new int[n];
			for(int i=0; i<n; i++)
				inorder[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				postorder[i] = sc.nextInt();
			TreeFromPostorderAndInorder g = new TreeFromPostorderAndInorder();
			Node root = g.buildTree(inorder,postorder,n);
			preOrder(root);
			System.out.println();
			
		T--;	
				
		}
	}
	int postIndex = -1;
    Node buildTree(int in[], int post[], int n)
	{
        if (n-1 < 0) return null;
        postIndex = n-1;
        
        return buildTree(in, 0, in.length-1, post);
	}
	Node buildTree(int in[], int inStart, int inEnd, int post[]) {
	    if (postIndex < 0) return null;
	    if (inStart < 0 || inEnd < 0) return null;
	    if (inStart>inEnd) return null;
	    
	    int data = post[postIndex];
	    postIndex--;
        Node root = new Node(data);
        if (inStart == inEnd) return root;
        
        int rootInd = getIndex(in, data, inStart, inEnd);
        root.right = buildTree(in, rootInd+1, inEnd, post);
        root.left = buildTree(in, inStart, rootInd-1, post);
        return root;
	}
	public int getIndex(int in[], int data, int inStart, int inEnd) {
	    for (int i = inStart; i<=inEnd; i++)
	    {
	        if (in[i] == data) {
	            return i;
	        }
	    }
	    return -1;
	}
}
