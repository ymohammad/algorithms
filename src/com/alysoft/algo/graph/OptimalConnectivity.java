package com.alysoft.algo.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.alysoft.algo.graph.LearningGraph.Graph;

/**
 * A company X has a network of  computers. There are  links in the network, each link connecting a pair of computers. Each link has a particular time lag in between the two computers. It is assured that all the computers are connected.
The engineers at X assume that the current status of the network is a bit slow and they want to improve it. So they experiment with  computer pairs.
For each of these  pairs, you are given new direct link's time lag between the pair of computers. If these two computers are directly connected using the new link and some old link is removed from the network, you need to check if the network become better.

A new network is better than older if the sum of all the time lags is strictly lesser in the new network than the old one and the network is still connected.
Note:  All queries are independent. That is, for each of the  pairs, old network is the initial given network.

Input Format
The first line contains an integer  denoting the total number of computers.
Each of the next  lines contains a triplet of integers  which states that the computer with the number  is connected to the computer with the number  and the time lag is of  units.
The next line contains an integer .
Each of the next  lines contains three integers  and  which states that the new direct link between computer with the number  and computer with the number  has the time lag of  units.

Output Format
For each query, you need to print YES  if you can improve the network by adding this link else print NO.
 * @author ymohammad
 *
 */
public class OptimalConnectivity
{
	public static void main(String[] args) throws Exception {
		String[] strArr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();    
        int N = Integer.parseInt(line.trim());
        Graph graph = new Graph(N+1);
        for (int i = 0; i<N-1; i++) {
        	line = br.readLine();    
            strArr = line.split(" ");
            int u = Integer.parseInt(strArr[0]);
            int v = Integer.parseInt(strArr[1]);
            int w = Integer.parseInt(strArr[2]);
            graph.addEdge(u, v, w);
        }

        int Q = Integer.parseInt(br.readLine().trim());
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i<Q; i++) {
        	line = br.readLine();    
            strArr = line.split(" ");
            int u = Integer.parseInt(strArr[0]);
            int v = Integer.parseInt(strArr[1]);
            int w = Integer.parseInt(strArr[2]);
        	isModificationValid(graph, u, v, w, buff);
        }
        System.out.println(buff);
	}
	private static void isModificationValid(Graph graph, int u, int v, int w, StringBuffer buff)
	{
		long x = graph.getWeight(u, v);
		if (w < x) {
			buff.append("YES" + "\n");
		} else {
			buff.append("NO" + "\n");
		}
	}
	//public void performModification ()
	static class Graph {
		int V;
		ArrayList<ArrayList<Edge>> list;
		
		public Graph(int initialSize) {
			this.V = initialSize;
			this.list = new ArrayList<ArrayList<Edge>>();
			for (int i = 0; i<this.V; i++) {
				this.list.add(new ArrayList<Edge>());
			}
		}
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
		/*public int getPathCost(int source, int destination, int tillCost, boolean[] visited) {
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
		public void addEdge(int u, int v, int w) {
			this.list.get(u).add(new Edge(v, w));
			this.list.get(v).add(new Edge(u, w));
		}
	}
	static class Edge {
		int vertex;
		long weight;
		public Edge(int v, long w) {
			this.vertex = v;
			this.weight = w;
		}
	}
}
