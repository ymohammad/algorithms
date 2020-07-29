package com.alysoft.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a directed graph, the task is to complete the method isCyclic() to detect if there is a cycle in the graph or not. You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.

Input: The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. 
Each test case consists of two lines. Description of testcases is as follows: The First line of each test case contains two 
integers 'N' and 'M'  which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'M'  
space separated pairs u and v denoting that there is an uni-directed  edge from u to v .

Output:
The method should return 1 if there is a cycle else it should return 0.

User task:
Since this is a functional program you don't have to worry about input, you just have to complete the function

Constraints:
1 <= T <= 100
1<= N,M <= 100
0 <= u,v <= N-1

Example:
Input:
3
2 2
0 1 0 0
4 3
0 1 1 2 2 3
4 3
0 1 2 3 3 2
Output:
1
0
1

Explanation:
Testcase 1: In the above graph there are 2 vertices. The edges are as such among the vertices.


From graph it is clear that it contains cycle.
 * @author ymohammad
 *
 */
public class DetectCycleDirectedGraph
{

	public static void main(String[] args)
	{

	}
	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
		boolean[] visited = new boolean[V];
        boolean[] blackSet = new boolean[V];
        for (int i = 0; i<V; i++) {
        	if (isCyclicUtil(i, list, visited, blackSet)) {
        		return true;
        	}
        }
        return false;
        /*boolean[] visited = new boolean[V];
        boolean[] blackSet = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (blackSet[node] == true) return true;
            
            if (visited[node] == false) {
                visited[node] = true;
                blackSet[node] = true;
                ArrayList<Integer> adjList = list.get(node);
                for (int x : adjList) {
                    //if (blackSet[x] == false) 
                    {
                        queue.add(x);
                    }
                }
            } 
        }
        return false;*/
    }
	private static boolean isCyclicUtil(int node, ArrayList<ArrayList<Integer>> list, boolean[] visited, boolean[] blackSet)
	{
		if (blackSet[node]) return true;
		
		if (visited[node]) return false;
		
		visited[node] = true;
		blackSet[node] = true;
		 ArrayList<Integer> adjList = list.get(node);
		 for (int x : adjList) {
			 if (isCyclicUtil(x, list, visited, blackSet)) return true;
		 }
		 blackSet[node] = false;
		return false;
	}
}
