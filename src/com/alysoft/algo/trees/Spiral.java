package com.alysoft.algo.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Input Format:
The task is to complete the method which takes one argument, root of the Tree. The struct node has a data part which stores the data, pointer to left child and pointer to right child.
There are multiple test cases. For each test case, this method will be called individually.

Output Format:
The function should print level order traversal in spiral form .

User Task:
The task is to complete the function printSpiral() which prints the elements in spiral form of level order traversal. 
The newline is automatically appended by the driver code.

Constraints:
1 <= T <= 100
1 <= Number of nodes <= 3000
1 <= Data of a node <= 1000

Example:
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
1 3 2
10 20 30 60 40

Explanation:
Testcase1: The tree is
        1
     /      \
   3       2
So, the spiral level order would be 1 3 2
Testcase2: The tree is
                           10
                        /        \
                     20         30
                  /       \
               40       60
So, the spiral level order would be 10 20 30 60 40
 * @author ymohammad
 *
 */
public class Spiral
{

	public static void main(String args[])
    {
		
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		//Node root=null;
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
		
            Spiral g = new Spiral();
            g.printSpiral(root);
			System.out.println();
            t--;
			
        }
    }
	void printSpiral(Node node) 
    {
      if (node == null) return;
      
      Node temp;
      StringBuffer buff = new StringBuffer();
      Queue<Node> q = new LinkedList<Node>();
      Stack<Node> s = new Stack<Node>();
      s.push(node);
      //1 2 L 2 3 L 3 4 L 2 5 R 1 6 R 4 7 L 5 8 L 3 9 R 5 10 R 9 11 L
      int count = 0;
      while (!s.isEmpty() || !q.isEmpty()) {
    	  count = q.size();
    	  while (count > 0) {
    		  temp = q.poll();
    		  buff.append(temp.data + " ");
    		  if (temp.left != null)
    			  s.push(temp.left);
    		  if (temp.right != null)
    			  s.push(temp.right);
    		  count--;
    	  }
    	  
    	  count = s.size();
    	  Stack<Node> tempS = new Stack<Node>();
    	  while (count > 0) {
    		  temp = s.pop();
    		  buff.append(temp.data + " ");
    		  if (temp.right != null)
    			  tempS.push(temp.right);
    		  
    		  if (temp.left != null)
    			  tempS.push(temp.left);
    		  
    		  count--;
    	  }
    	  while (!tempS.isEmpty()) {
    		  q.add(tempS.pop());
    	  }
      }
      System.out.print(buff.toString().trim());
    }
}
