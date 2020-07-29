package com.alysoft.algo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LearningGraph
{

	public static void main(String[] args) throws IOException
	{
		String[] strArr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();    
        strArr = line.split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);
        int K = Integer.parseInt(strArr[2]);
        
        int[] weights = new int[N];
        line = br.readLine();    
        strArr = line.split(" ");
        for (int i = 0; i<N; i++) {
        	weights[i] = Integer.parseInt(strArr[i]);
        }
        Graph graph = new Graph(N, weights);
        for (int i = 0; i<M; i++) {
            line = br.readLine();
            strArr = line.split(" ");
            int x = Integer.parseInt(strArr[0]);
            int y = Integer.parseInt(strArr[1]);
            graph.addEdge(x, y);
        }
        for (int i = 0; i<N; i++) {
        	System.out.println(graph.getKthPositionNode(i, K));
        }
	}

	
	static class Graph {
		int vertices;
		int[] weights;
		ArrayList<PriorityQueue<Integer>> list;
		
		public Graph(int V, int[] weights) {
			this.vertices = V;
			this.weights = weights;
			this.list = new ArrayList<PriorityQueue<Integer>>();
			for (int i = 0; i<V; i++) {
				this.list.add(new PriorityQueue<Integer>(new WeightComparator()));
			}
		}
		class WeightComparator implements Comparator<Integer> {

			@Override
			public int compare(Integer o1, Integer o2)
			{
				int i = weights[o1];
				int j = weights[o2];
				if (i == j) {
					return o2-o1;
				}
				return j-i;
			}
		}
		public void addEdge(int x, int y) {
			this.list.get(x-1).add(y-1);
			this.list.get(y-1).add(x-1);
		}
		public int getKthPositionNode(int x, int k) {
			PriorityQueue<Integer> priorityQueue = this.list.get(x);
			int returnVal = -1;
			for (int i = 0; i<k; i++) {
				if (priorityQueue.isEmpty()) {
					return -1;
				}
				returnVal = priorityQueue.poll();
			}
			return returnVal+1;
		}
	}
}
