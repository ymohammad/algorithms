package com.alysoft.algo.trees;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.

Input Format:
The first line of input contains T denoting number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains the number of edges. The second line contains the relation between nodes.

Output Format:
The function should print nodes in bottom view of Binary Tree. Your code should not print a newline, it is added by the caller code that runs your function.

User Task:
This is a funcitonal problem, you don't need to care about input, just complete the function bottomView() which should print the bottom view of the given tree.

Constraints:
1 <= T<= 30
0 <= Number of nodes <= 100
0 <= Data of a node <= 1000

Example:
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
3 1 2
40 20 60 30

Explanation:
Testcase 1:  First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.


Thus nodes of binary tree will be printed as such 3 1 2.
 * @author ymohammad
 *
 */
public class BottomViewOfBinaryTree
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	public void bottomView(Node root)
    {	
		if (root == null) return;
		
		Map<Integer, Node> mapHolder = new TreeMap<Integer, Node>();
		Queue<NodeWrapper> q = new LinkedList<NodeWrapper>();
		q.add(new NodeWrapper(root, 0));
		NodeWrapper temp;
		while (!q.isEmpty())
		{
			temp = q.poll();
			if (temp != null) {
				mapHolder.put(temp.level, temp.nd);
				
				if (temp.nd.left != null)
				{
					q.add(new NodeWrapper(temp.nd.left, temp.level-1));
				}
				
				if (temp.nd.right != null)
				{
					q.add(new NodeWrapper(temp.nd.right, temp.level+1));
				}
			}
		}
		
		Collection<Node> allNodes = mapHolder.values();
		for (Node eachNode : allNodes) {
			System.out.print(eachNode.data + " ");
		}
    }

	
	class NodeWrapper
	{
		Node nd;
		int level;

		public NodeWrapper(Node nd, int level)
		{
			this.nd = nd;
			this.level = level;
		}
	}
}
