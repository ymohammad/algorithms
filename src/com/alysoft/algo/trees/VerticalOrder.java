package com.alysoft.algo.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * You are given a binary tree for which you have to print its vertical order traversal. your task is to complete the function verticalOrder which takes one argument the root of the binary tree and prints the node of the binary tree in vertical order as shown below.
If there are multiple nodes passing through a vertical line, then they should printed as they appear in level order traversal.

Input Format:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains 2 lines of input. The first line contains number of operations to insert the nodes. The second line contains the nodes and their position during the insertion.

Output Format:
For each testcase, the vertical order traversal of the tree is to be printed. The nodes' data are to be separated by spaces.

Your Task:
This is a function problem. Your task is to just complete the verticalOrder() function and you don't have to take any input or output. The newline is automatically appended by the driver code.

Constraints:
1 <= T <= 100
1 <= Number of nodes <= 5000

Example:
Input:
4
3
1 2 L 1 3 R 3 5 L
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R
4
1 2 L 1 3 R 2 4 R 4 5 R

Output:
2 1 5 3
3 1 2
40 20 10 60 30
2 1 4 3 5

Explanation:
Testcase1:
         1
       /     \
    2         3
              /
         5
As it is evident from the above diagram that during vertical traversal 2 will come first, then 1 and  5, and then 3. So output is 2 1 5 3
Testcase2:
         1
       /     \
     3       2
As it is evident from the above diagram that during vertical traversal 3 will come first, then 1 and then 2. So output is 3 1 2
 * @author ymohammad
 *
 */
public class VerticalOrder
{

	public static void main (String[] args)throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = Integer.parseInt(read.readLine());
            Node root = null;
            String str[] = read.readLine().replace("  ", " ").trim().split(" ");
            int k = 0;
            while(n-- > 0)
            {
                int n1 = Integer.parseInt(str[k++]);
                int n2 = Integer.parseInt(str[k++]);
	        	char lr= str[k++].charAt(0);
				
                
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
            }
            
            verticalOrder(root);
            System.out.println();
        }
    }
	//Level ordering
	static void verticalOrder(Node root)
	{
		if (root == null) return;
		Map<Integer, ArrayList<Node>> map = new TreeMap<Integer, ArrayList<Node>>();
		Queue<NodeWrapper> q = new LinkedList<NodeWrapper>();
		q.add(new NodeWrapper(root, 0));
		NodeWrapper temp = null;
		while (!q.isEmpty()) {
			temp = q.poll();
			ArrayList<Node> list = null;
	        if (!map.containsKey(temp.level)) {
	            list = new ArrayList<Node>();
	        } else {
	            list = map.get(temp.level);
	        }
	        list.add(temp.nd);
	        map.put(temp.level, list);
	        if (temp.nd.left != null) {
	        	q.add(new NodeWrapper(temp.nd.left, temp.level-1));
	        }
	        if (temp.nd.right != null) {
	        	q.add(new NodeWrapper(temp.nd.right, temp.level+1));
	        }
		}
		Collection<ArrayList<Node>> coll = map.values();
        StringBuffer buff = new StringBuffer();
        for (ArrayList<Node> eachList : coll) {
            for (Node eachNode : eachList) {
                buff.append(eachNode.data + " ");
            }
        }
        System.out.print(buff.toString());
	}
	static class NodeWrapper {
		Node nd;
		int level;

		public NodeWrapper(Node nd, int level) {
			this.nd = nd;
			this.level = level;
		}
	}
	static void verticalOrder1(Node root)
    {
        Map<Integer, ArrayList<Node>> map = new TreeMap<Integer, ArrayList<Node>>();
        verticalOrder(root, 0, map);
        Collection<ArrayList<Node>> coll = map.values();
        StringBuffer buff = new StringBuffer();
        for (ArrayList<Node> eachList : coll) {
            for (Node eachNode : eachList) {
                buff.append(eachNode.data + " ");
            }
        }
        System.out.print(buff.toString());
    }
    static void verticalOrder(Node root, int level, Map<Integer, ArrayList<Node>> map)
    {
        if (root == null) return;
        ArrayList<Node> list = null;
        if (!map.containsKey(level)) {
            list = new ArrayList<Node>();
        } else {
            list = map.get(level);
        }
        list.add(root);
        map.put(level, list);
        
        verticalOrder(root.left, level-1, map);
        verticalOrder(root.right, level+1, map);
    }
}
