package com.alysoft.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnweighted
{

	public int getShortestPath(Graph gh, int source, int target, int v) {
		boolean routeFound = false;
		boolean[] visited = new boolean[v];
		int[] distances = new int[v];
		int[] previous = new int[v];
		Arrays.fill(distances, -1);
		Arrays.fill(previous, -1);
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(source, 0));
		visited[source] = true;
		while (!queue.isEmpty()) {
			Node eachNode = queue.poll();
			ArrayList<Node> adjList = gh.getAdjList(eachNode.x);
			for (Node n : adjList) {
				if (!visited[n.x]) {
					n.distance = eachNode.distance + 1;
					visited[n.x] = true;
					previous[n.x] = eachNode.x;
					queue.add(n);
					if (n.x == target) {
						routeFound = true;
						break;
					}
				}
			}
		}
		
		if(routeFound) {
            System.out.print("Path is: ");
            int i = target;
            //previous[i] will be 0 for source node
            while (previous[i] != -1) {
                System.out.print(i + " ");
                i = previous[i];
            }
            System.out.print(i + " ");

            System.out.println();
            System.out.println("Path length is:" + distances[target]);
            return i;
        }
		return -1;
	}
	
	public static void main(String[] args)
	{
		ShortestPathUnweighted sp = new ShortestPathUnweighted();
		int v = 8;
		Graph gh = new Graph(v);
		gh.addEdge(0, 1);
		gh.addEdge(0, 3);
		gh.addEdge(1, 2);
		gh.addEdge(3, 4);
		gh.addEdge(3, 7);
		gh.addEdge(4, 5);
		gh.addEdge(4, 6);
		gh.addEdge(4, 7);
		gh.addEdge(5, 6);
		gh.addEdge(6, 7);

        int source = 0, dest = 7;
        int x = sp.getShortestPath(gh, source, dest, v);
        System.out.println(x);
	}

	static class Graph {
		ArrayList<ArrayList<Node>> adjList = null;
		int v = 0;
		public Graph(int v) {
			this.v = v;
			this.adjList = new ArrayList<ArrayList<Node>>();
			for (int i =0; i<v; i++) {
				this.adjList.add(new ArrayList<Node>());
			}
		}
		public void addEdge(int u, int v) {
			this.adjList.get(u).add(new Node(v, -1));
			this.adjList.get(v).add(new Node(u, -1));
		}
		public ArrayList<Node> getAdjList(int x) {
			return this.adjList.get(x);
		}
	}
	
	static class Node {
		int x;
		int distance;
		public Node(int x, int distance) {
			this.x = x;
			this.distance = distance;
		}
	}
}
