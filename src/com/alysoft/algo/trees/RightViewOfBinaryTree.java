package com.alysoft.algo.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Tree, print Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

          1
       /     \
     2        3
   /   \      /    \
  4     5   6    7
    \
     8

Input Format:
The first line of the input contains a single integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The first line contains number of edges. The second line contains relation between nodes.

Output Format:
For each test case, in a new line, print right view of the binary tree.

Your Task:
This is a function problem. You don't have to take input. Just complete the function rightView() that takes node as parameter and prints the right view. The newline is automatically appended by the driver code.

Constraints:
1 <=T<= 100
1 <= Number of nodes<= 100
1 <= Data of a node<= 1000

Example:
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
1 2
10 30 60

Explanation:
Test case 1:

           1

        /     \

      3        2

For the above test case the right view is: 1 2

Test case 2:

            10

         /        \

     20          30

   /      \      

40      60

Right View is: 10 30 60.
 * @author ymohammad
 *
 */
public class RightViewOfBinaryTree
{
	void rightView1(Node node) {
		if (node == null) return;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		
		Node temp = null;
		Node prev = null;
		StringBuffer buff = new StringBuffer();
		
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp != null) {
				if (temp.left != null)
					q.add(temp.left);
				
				if (temp.right != null)
					q.add(temp.right);
			} else {
				buff.append(prev.data + " ");
				if (!q.isEmpty()) {
					q.add(null);
				}
			}
			prev = temp;
		}
		System.out.print(buff);
    }
	
	//Editorial - recursive solution
	 Max_level max = new Max_level();
	    void rightViewUtil(Node node, int level, Max_level max_level) {
	        
        // base case
        if (node == null) 
            return;
            
        // If this is the last Node of its level
        if (max_level.max_level < level) {
            System.out.print(node.data + " ");
            max_level.max_level = level;
        }
        
        // recurse for left and right subtree
        rightViewUtil(node.right, level + 1, max_level);
        rightViewUtil(node.left, level + 1, max_level);
    }
    
	void rightView(Node node) {
        rightViewUtil(node, 1, max);
    }
	

	class Max_level {
	    int max_level;
	}
}
