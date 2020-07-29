package com.alysoft.algo.graph;

import java.util.ArrayList;

import com.alysoft.algo.graph.OptimalConnectivity.Edge;

public class GraphUndirected
{
	int V;
	ArrayList<ArrayList<Integer>> list;
	int[] levels;
	public GraphUndirected(int initialSize) {
		this.V = initialSize;
		this.list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i<this.V; i++) {
			this.list.add(new ArrayList<Integer>());
		}
		this.levels = new int[this.V];
	}
	public void addEdge(int u, int v) {
		this.list.get(u).add(v);
		this.list.get(v).add(u);
	}
	public void addLevel(int u, int level) {
		this.levels[u] = level;
	}
	public int getNodesCountAt(int x)
	{
		int count = 0;
		for (int lev : this.levels) {
			if (lev == x) {
				count++;
			}
		}
		return count;
	}
	/*
	public long getWeight(int u, int v)
	{
		boolean[] visited = new boolean[this.V];
		ArrayList<Long> pathCost = new ArrayList<Long>();
		if (isTargetReachable(u, v, visited, pathCost)) {
			int x = 0;
			for (long cost : pathCost) {
				x += cost;
			}
			return x;
		} else {
			return Long.MAX_VALUE;
		}
	}
	
	public boolean isTargetReachable(int source, int destination, boolean[] visited, ArrayList<Long> pathCost) {
		if (source == destination) return true;
		if (visited[source]) return false;
		
		visited[source] = true;
		ArrayList<Edge> adjList = this.list.get(source);
		for (Edge edge : adjList) {
			if (isTargetReachable(edge.vertex, destination, visited, pathCost)) {
				pathCost.add((long)edge.weight);
				return true;
			}
		}
		return false;
	}
	public int getPathCost(int source, int destination, int tillCost, boolean[] visited) {
		if (source == destination) return tillCost;
		if (visited[source]) return Integer.MAX_VALUE;
		
		visited[source] = true;
		ArrayList<Edge> adjList = this.list.get(source);
		int minDistance = Integer.MAX_VALUE;
		for (Edge edge : adjList) {
			int x = getPathCost(edge.vertex, destination, tillCost+edge.weight, visited);
			minDistance = Math.min(minDistance, x);
		}
		return minDistance;
	}*/
	
	
}
