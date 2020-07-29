package com.alysoft.algo.graph;

import java.util.ArrayList;

public class FindCycleInGraph
{
	public static boolean isCycleExist(ArrayList<ArrayList<Integer>> adjList, int v) {
		boolean[] visited = new boolean[v];
		visited[0] = true;
		boolean result = isCycleExist(adjList, 0, -1, visited);
		return result;
	}
	private static boolean isCycleExist(ArrayList<ArrayList<Integer>> adjList, int x, int parent, boolean[] visited)
	{
		ArrayList<Integer> arrayList = adjList.get(x);
		for (int a : arrayList) {
			if (parent!=a && visited[a]) return true;
			
			if (!visited[a]) {
				visited[a] = true;
				return isCycleExist(adjList, a, x, visited);
			}
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
		adjList.get(1).add(0);
		
		//1 to 2
		adjList.get(1).add(2);
		adjList.get(2).add(1);
		
		//2 to 3
		adjList.get(2).add(3);
		adjList.get(3).add(2);
		
		//3 to 1
		adjList.get(3).add(1);
		adjList.get(1).add(3);
		
		System.out.println("Is cycle exist :" + isCycleExist(adjList, v));
	}

}
