package com.alysoft.algo.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * You have been given an undirected graph consisting of N nodes and M edges. This graph can consist of self-loops as well as multiple edges. In addition , you have also been given Q queries. For each query , you shall be given 2 integers A and B. You just need to find if there exists an edge between node A and node B. If yes, print "YES" (without quotes) else , print "NO"(without quotes).

Input Format:

The first line consist of 2 integers N and M denoting the number of nodes and edges respectively. Each of the next M lines consist of 2 integers A and B denoting an undirected edge between node A and B. The next line contains a single integer Q denoting the number of queries. The next Line contains 2 integers A and B denoting the details of the query.

Output Format

Print Q lines, the answer to each query on a new line.

Constraints:






 * @author ymohammad
 *
 */
public class EdgeExistence
{
	static class Graph {
        int V;
        ArrayList<ArrayList<Integer>> list = null;
        public Graph(int V) {
            this.V = V;
            this.list = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i<V; i++) {
                this.list.add(new ArrayList<Integer>());
            }
        }
        public void addEdge(int u, int v) {
            this.list.get(u).add(v);
            this.list.get(v).add(u);
        }
        public boolean isEdgeExist(int A, int B) {
            ArrayList<Integer> adjList = this.list.get(A);
            if (adjList.size() == 0) return false;
            
            for (int x : adjList) {
                if (x == B) return true;
            }
            return false;
        }
    }
    static class Query {
        int A;
        int B;
        public Query(int a, int b) {
            this.A = a;
            this.B = b;
        }
    }
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input*/

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();  
        while (line == null) {
            line = br.readLine(); 
        }
        String[] strArr = line.split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);
        
        Graph graph = new Graph(N);
        for (int i = 0; i<M; i++) {
            line = br.readLine(); 
            strArr = line.split(" ");
            graph.addEdge(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));
        }
        
        int Q = Integer.parseInt(br.readLine());
        Query[] queries = new Query[Q];
        for (int i = 0; i<Q; i++) {
            line = br.readLine(); 
            strArr = line.split(" ");
            queries[i] = new Query(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));
        }
        
        printQueryEdgeInfo(graph, queries, Q);
    }
    public static void printQueryEdgeInfo(Graph graph, Query[] queries, int Q)
    {
        for (int i = 0; i<Q; i++) {
            Query eachQuery = queries[i];
            if (graph.isEdgeExist(eachQuery.A, eachQuery.B)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
