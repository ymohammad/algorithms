package com.alysoft.algo.trees;

import java.util.Scanner;

/**
 * Given a binary tree of N edges, where every node contains distinct data. The task is to find the maximum path sum. 
 * The path may start and end at any node in the tree.

Input:
First line of input contains number of testcases T. For each testcase, there will be two lines, first of which containing the 
number of edges (between two nodes) in the tree. Next line contains N pairs (considering a and b) with a 'L' (means node b on left of a) or 'R' 
(means node b on right of a) after a and b.

Output:
Print the maximum path sum in the binary tree.

User Task:
The task is to complete the findMaxSum that takes root as input and returns max sum.

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
2
6
10 2 L 2 20 L 2 1 R 10 -25 R -25 3 L -25 4 R
3
10 2 L 10 5 R 5 -2 R

Output:
32
17

Explanation:
Testcase 2: Path in the given tree goes like 2, 10, 5, which gives the max sum as 17.
 * @author ymohammad
 *
 */
public class MaximumPathSumFromAnyNode
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
            
            MaximumPathSumFromAnyNode g=new MaximumPathSumFromAnyNode();
            System.out.println(g.findMaxSum(root));
            
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
	int findMaxSum(Node node) {
        if (node == null) return 0;
        
        int[] totalMaxArr = new int[1];
        totalMaxArr[0] = Integer.MIN_VALUE;
        int maxVal = findMaxSumChild(node, totalMaxArr);
        return Math.max(maxVal, totalMaxArr[0]);
    }
    int findMaxSumChild(Node node, int[] totalMaxArr) {
        if (node == null) return 0;
        
        int leftSum = findMaxSumChild(node.left, totalMaxArr);
        int rightSum = findMaxSumChild(node.right, totalMaxArr);
        int maxVal = Math.max(node.data + leftSum, node.data + rightSum);
        maxVal = Math.max(node.data, maxVal);
        totalMaxArr[0] = Math.max(totalMaxArr[0], node.data + leftSum + rightSum);
        return maxVal;
    }
    int findMaxSum2(Node node)
    {
        int maxSum = 0;
        java.util.Queue<Node> q = new java.util.LinkedList<Node>();
        q.add(node);
        Node temp;
        int localSum = 0;
        while (!q.isEmpty()) {
            temp = q.poll();
            localSum += temp.data;
            maxSum = Math.max(maxSum, localSum);
            if (localSum <=0) {
                localSum = 0;
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        return maxSum;
    }
}
