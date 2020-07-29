package com.alysoft.algo.trees;

import java.util.Scanner;

/**
 * Given a Binary Tree you need to find maximum value which you can get by subtracting value of node B from value of node A, 
 * where A and B are two nodes of the binary tree and A is an ancestor of B. You are required to complete the function maxDiff. 
 * You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.

Input:
The task is to complete the function maxDiff which takes 1 argument, root of the Tree. The struct node has a data part which stores the data, 
pointer to left child and pointer to right child.
There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should return an integer denoting the maximum difference.

User Task:
The task is to complete the function maxDiff() which finds the maximum difference between the node and its ancestor.

Constraints:
1 <= T <= 100
2 <= Number of nodes <= 100
0 <= Data of a node <= 1000

Example:
Input:
1
2
5 2 L 5 1 R

Output:
4

Explanation:
Testcase 1:

             5
           /    \
         2      1
The maximum difference we can get is 4, which is bewteen 5 and 1.
 * @author ymohammad
 *
 */
public class MaximumDifferenceBetweenNodeAncestor
{

	public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t=sc.nextInt();
          
           while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            
            MaximumDifferenceBetweenNodeAncestor g=new MaximumDifferenceBetweenNodeAncestor();
            System.out.println(g.maxDiff(root));
            
        }
    }
    public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
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
	int maxDiffValue = Integer.MIN_VALUE;
    int maxDiff(Node root)
    {
        if (root == null) return 0;

        minValue(root);
        return maxDiffValue;
    }
    int minValue(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return root.data;
        
        int leftMin = minValue(root.left);
        int rightMin = minValue(root.right);
        
        int minVal = Math.min(leftMin, rightMin);
        
        maxDiffValue = Math.max(root.data-minVal, maxDiffValue);
        
        return Math.min(root.data, minVal);
    }
}
