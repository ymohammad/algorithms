/*******************************************************************************************************************************
MultiProblemsOnGraphPaths.java


1. You are given a graph, a src vertex and a destination vertex.
2. You are give a number named "criteria" and a number "k".
3. You are required to find and print the values of 
3.1 Smallest path and it's weight separated by an "@"
3.2 Largest path and it's weight separated by an "@"
3.3 Just Larger path (than criteria in terms of weight) and it's weight separated by an "@"
3.4 Just smaller path (than criteria in terms of weight) and it's weight separated by an "@"
3.5 Kth largest path and it's weight separated by an "@"

7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2

Smallest Path = 01256@28
Largest Path = 032546@66
Just Larger Path than 30 = 012546@36
Just Smaller Path than 30 = 01256@28
4th largest path = 03456@48


Author : ymohammad
Date   : Jul 25, 2021

Last modified by : ymohammad
Last modified on : Jul 25, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph.problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.alysoft.completedsa.graph.Edge;
import com.alysoft.completedsa.graph.GraphUtils;

/**
* Class MultiProblemsOnGraphPaths
*/
public class MultiProblemsOnGraphPaths {
    
    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    
    
    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
       
       if (src == dest) {
           if (wsf < spathwt) {
               spath = psf;
               spathwt = wsf;
           }
           
           if (wsf > lpathwt) {
               lpathwt = wsf;
               lpath = psf;
           }
           
           if (wsf > criteria && wsf < cpathwt) {
               cpath = psf;
               cpathwt = wsf;
           }
           
           if (wsf < criteria && wsf > fpathwt) {
               fpath = psf;
               fpathwt = wsf;
           }
            if (pq.size() < k) {
               pq.add(new Pair(wsf, psf));
           } else {
               Pair pa = pq.peek();
               if (wsf > pa.wsf) {
                   pq.poll();
                   pq.add(new Pair(wsf, psf));
               }
           }
           return;
       }
       
       visited[src] = true;
      
       for (Edge e: graph[src]) {
           if (visited[e.getnNode()] == false) {
               multisolver(graph, e.getnNode(), dest, visited, criteria, k, psf + e.getnNode(), wsf + e.getWeight());
           }
       }
       visited[src] = false;
    }
    public static void findMultiPaths(ArrayList<Edge>[] graph, int src, int dest, int criteria, int k) {
	boolean[] visited = new boolean[graph.length];
	multisolver(graph, src, dest, visited, criteria, k, ""+src, 0);
    }
    public static void main(String[] args) {
	/*
	 * 7
            9
            0 1 10
            1 2 10
            2 3 10
            0 3 40
            3 4 2
            4 5 3
            5 6 3
            4 6 8
            2 5 5
            0
            6
            30
            4
	 */
	ArrayList<Edge>[] graph = GraphUtils.createWtGraphArr(7);
	GraphUtils.addUDWtEdge(graph, 0, 1, 10);
	GraphUtils.addUDWtEdge(graph, 1, 2, 10);
	GraphUtils.addUDWtEdge(graph, 2, 3, 10);
	GraphUtils.addUDWtEdge(graph, 0, 3, 40);
	GraphUtils.addUDWtEdge(graph, 3, 4, 2);
	GraphUtils.addUDWtEdge(graph, 4, 5, 3);
	GraphUtils.addUDWtEdge(graph, 5, 6, 3);
	GraphUtils.addUDWtEdge(graph, 4, 6, 8);
	GraphUtils.addUDWtEdge(graph, 2, 5, 5);
	
    }
    static class Pair implements Comparable<Pair> {
	      int wsf;
	      String psf;

	      Pair(int wsf, String psf){
	         this.wsf = wsf;
	         this.psf = psf;
	      }

	      public int compareTo(Pair o){
	         return this.wsf - o.wsf;
	      }
	   }
}
