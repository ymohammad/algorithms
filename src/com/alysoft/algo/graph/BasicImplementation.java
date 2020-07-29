package com.alysoft.algo.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BasicImplementation
{
	public static void main(String[] args) throws Exception {
		String[] strArr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();    
        int noOfRoads = Integer.parseInt(line.trim());
        
        Graph graph = new Graph();
        for (int i = 0; i<noOfRoads; i++) {
            line = br.readLine();
            strArr = line.split(",");
            int A = Integer.parseInt(strArr[0]);
            int B = Integer.parseInt(strArr[1]);
            graph.addEdge(A, B);
        }
        System.out.println(graph.size());
	}
	
	static class Graph {
		HashMap<Integer, ArrayList<Integer>> listOfEdges = null;
		public Graph() {
			listOfEdges = new HashMap<Integer, ArrayList<Integer>>();
		}
		public void addEdge(int A, int B) {
			if (listOfEdges.containsKey(A)) {
				listOfEdges.get(A).add(B);
			} else {
				ArrayList list = new ArrayList<Integer>();
				list.add(B);
				listOfEdges.put(A, list);
			}
			if (listOfEdges.containsKey(B)) {
				listOfEdges.get(B).add(A);
			} else {
				ArrayList list = new ArrayList<Integer>();
				list.add(A);
				listOfEdges.put(B, list);
			}
		}
		public int size() {
			return this.listOfEdges.size();
		}
	}
}
