package com.alysoft.algo.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov)
    {
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(s);
       vis[s] = true;
       
       while (!queue.isEmpty()) {
           int val = queue.poll();
           ArrayList<Integer> adjList = list.get(val);
           System.out.print(val + " ");
           for (int x : adjList) {
               if (vis[x] == false) {
                   queue.add(x);
                   vis[x] = true;
               }
           }
       }
    }
}
