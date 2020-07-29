package com.alysoft.algo.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Given a binary tree, check if the tree can be folded or not. A tree can be folded if left and right subtrees of the tree are structure 
 * wise same. An empty tree is considered as foldable.

Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.

(a)
       10
     /    \
    7      15
     \    /
      9  11
(b)
        10
       /  \
      7    15
     /      \
    9       11
(c)
        10
       /  \
      7   15
     /    /
    5   11
(d)
         10
       /   \
      7     15
    /  \    /
   9   10  12
Input:
First line of input contains number of testcases T. For each testcase, there will be two lines, first of which containing the 
number of edges (between two nodes) in the tree. Next line contains N pairs (considering a and b) with a 'L' (means node b on left of a) 
or 'R' (means node b on right of a) after a and b.

Output Format:
Print "Yes" (without quotes) if the tree is foldable and "No" ( without quotes) if it is unfoldable.

Your Task:
The task is to complete the function isFoldable() that takes root of the tree as input and returns true or false.

Constraints:
1 <= T <= 100
1 <= n <= 103
1 <= data of node <= 104

Example:
Input:
2
4
10 7 L 7 9 R 10 15 R 15 11 L
4
10 7 L 7 5 L 10 15 R 15 11 L

Output:
Yes
No
 * @author ymohammad
 *
 */
public class FoldableBinaryTree
{

	public static void insert(Node root,int a,int a1,char lr)
    {
        if(root==null)
        {
            return;
        }
        if(root.data==a)
        {
            switch(lr)
            {
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    
     public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t=sc.nextInt();
          
           while(t-->0){
            int n=sc.nextInt();
            if(n==0)
            {
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0)
                {
                    root=new Node(a);
                    switch(lr)
                    {
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else
                {
                    insert(root,a,a1,lr);
                }
            }
            
            boolean val = isFoldable(root);
            if(val == true)
              System.out.println("Yes");
            else
              System.out.println("No");
           }
    }
	public static boolean isFoldable(Node root)
    {
        if (root == null) return true;
        
        Node mirrorLeft = mirror(root.left);
        boolean isStructureSame = isStructureSame(mirrorLeft, root.right);
        root.left = mirror(mirrorLeft);
        return isStructureSame;
    }
    private static boolean isStructureSame(Node n1, Node n2)
	{
    	if (n1 == null && n2 == null) return true;
    	
    	if (n1 == null || n2 == null) return false;
    	
    	if ((n1.left != null && n2.left == null) || (n1.left == null && n2.left != null))return false;
    	if ((n1.right != null && n2.right == null) || (n1.right == null && n2.right != null))return false;
		return isStructureSame(n1.left, n2.left) && isStructureSame(n1.right, n2.right);
	}
	private static Node mirror(Node root)
	{
    	Node temp = root;
    	Queue<Node> q = new LinkedList<Node>();
    	q.add(root);
    	while (!q.isEmpty()) {
    		temp = q.poll();
    		
    		Node t = temp.left;
    		temp.left = temp.right;
    		temp.right = t;
    		
    		if (temp.left != null) {
    			q.add(temp.left);
    		}
    		if (temp.right != null) {
    			q.add(temp.right);
    		}
    	}
    	
		return root;
	}

}
