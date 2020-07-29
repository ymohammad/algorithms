package com.alysoft.algo.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * You have been given a Tree consisting of N nodes. A tree is a fully-connected graph consisting of N nodes and  edges. 
 * The nodes in this tree are indexed from 1 to N. Consider node indexed 1 to be the root node of this tree. The root node lies at 
 * level one in the tree. You shall be given the tree and a single integer x . You need to find out the number of nodes lying on level x.

Input Format

The first line consists of a single integer N denoting the number of nodes in the tree. Each of the next  lines consists of 2 integers a and b 
denoting an undirected edge between node a and node b. The next line consists of a single integer x.

Output Format

You need to print a single integers denoting the number of nodes on level x.

Constraints



Note

It is guaranteed that atleast one node shall lie on level x
 * @author ymohammad
 *
 */
public class LevelNodes
{
	public static void main(String args[] ) throws Exception {
		String[] strArr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();    
        int N = Integer.parseInt(line.trim());
        GraphUndirected graph = new GraphUndirected(N+1);
        for (int i = 0; i<N-1; i++) {
        	line = br.readLine();    
            strArr = line.split(" ");
            int u = Integer.parseInt(strArr[0]);
            int v = Integer.parseInt(strArr[1]);
            graph.addEdge(u, v);
        }

        int x = Integer.parseInt(br.readLine().trim());
        int y = getNodeCountsOnLevel(graph, x);
        System.out.println(y);
    }

	private static int getNodeCountsOnLevel(GraphUndirected graph, int x)
	{
		boolean[] visited = new boolean[graph.V];
		int count = dfs(graph, 1, x, visited);
		return count;
	}

	private static int dfs(GraphUndirected graph, int node, int x, boolean[] visited)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		q.add(null);
		visited[node] = true;
		int level = 0;
		while (!q.isEmpty()) {
			Integer u = q.poll();
			if (u != null) {
				graph.addLevel(u, level);
				ArrayList<Integer> adjList = graph.list.get(u);
				for (int eachNode : adjList) {
					if (!visited[eachNode]) {
						visited[eachNode] = true;
						q.add(eachNode);
					}
				}
			} else {
				if (!q.isEmpty()) {
					q.add(null);
					level++;
				}
			}
		}
		int count = graph.getNodesCountAt(x-1);
		return count;
	}
}
