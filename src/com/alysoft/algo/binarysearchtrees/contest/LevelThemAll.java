package com.alysoft.algo.binarysearchtrees.contest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * You are given a binary tree and an integer L. Count the number of nodes on that level.
Note: L may be greater than maximum possible level. In such case answer is 0 nodes.

Input Format:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. 
The first line contains number of edges and level L. The second line contains the relation between nodes.

Output Format:
For each testcase, in a new line, print the number of nodes on given level.

Your Task:
You need to complete the function Count which takes Root and level and return Number of nodes at that level.

Constraints:
1 <= T <= 30
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000
 

Example:
Input:
2
2 1
1 2 L 1 3 R
4 3
10 20 L 10 30 R 20 40 L 20 60 R
Output:
1
2

Explanation:
Testcase1: The tree is
        1
     /      \
   2        3
On first level there is only one node.
Testcase2: The tree is
                           10
                        /        \
                     20         30
                  /       \
               40       60
On third level there are 2 nodes.
 * @author ymohammad
 *
 */
public class LevelThemAll
{
	static class Node {
		int data;
		Node left,right;
		Node(int d) {
			data = d;
			left = right = null;		
		}
	}
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            int lvl = sc.nextInt();
            Node root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr= sc.next().charAt(0);
                Node parent = m.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')parent.left = child;
                else parent.right = child;
                m.put(n2, child);
                n--;
            }
            
            LevelThemAll g = new LevelThemAll();
			System.out.println(g.Count(root, lvl));
        }
    }
	
	int Count(Node root, int lvl) {
        // Code here
		int count = 0;
		Queue<WrapperNode> q = new LinkedList<WrapperNode>();
		q.add(new WrapperNode(root, 1));
		q.add(null);
		
		while (!q.isEmpty()) {
			WrapperNode wrapNode = q.poll();
			if (wrapNode != null) {
				if (wrapNode.level == lvl) {
					count++;
				}
				if (wrapNode.node.left != null) {
					q.add(new WrapperNode(wrapNode.node.left, wrapNode.level+1));
				}
				if (wrapNode.node.right != null) {
					q.add(new WrapperNode(wrapNode.node.right, wrapNode.level+1));
				}
			} else {
				if (!q.isEmpty()) {
					q.add(null);
				}
			}
		}
		return count;
    }
	
	static class WrapperNode {
		Node node;
		int level;
		
		public WrapperNode(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}
}
