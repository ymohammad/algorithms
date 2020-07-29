package com.alysoft.algo.graph;

import java.util.ArrayList;

public class FindCycleDirected
{
	private static boolean isCycleExist(ArrayList<ArrayList<Integer>> adjList, int v)
	{
		boolean[] visited = new boolean[v];
		boolean[] ancestor = new boolean[v];
		for (int i = 0; i<v; i++) {
			if (isCycleUtil(adjList, i, visited, ancestor)) {
				return true;
			}
		}
		return false;
	}
	private static boolean isCycleUtil(ArrayList<ArrayList<Integer>> adjList, int i, boolean[] visited, boolean[] ancestor)
	{
		visited[i] = true;
		ArrayList<Integer> arrayList = adjList.get(i);
		for (int x : arrayList) {
			if (ancestor[x]) return true;
			
			ancestor[x] = true;
			if (!visited[x]) {
				if (isCycleUtil(adjList, x, visited, ancestor)) {
					return true;
				}
			}
			ancestor[x] = false;
		}
		return false;
	}
	public static void main(String[] args)
	{
		int v = 4;
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i<v; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		//0 to 1
		adjList.get(0).add(1);
		
		//1 to 2
		adjList.get(1).add(2);
		
		//2 to 3
		adjList.get(2).add(3);
		
		//3 to 1
		adjList.get(1).add(3);
		
		System.out.println("Is cycle exist :" + isCycleExist(adjList, v));
		
		adjList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i<v; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		//0 to 1
		adjList.get(0).add(1);
		
		//1 to 2
		adjList.get(1).add(2);
		
		//2 to 3
		adjList.get(2).add(3);
		
		//3 to 1
		adjList.get(3).add(1);
		System.out.println("Is cycle exist :" + isCycleExist(adjList, v));
	}

	
}
