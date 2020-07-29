package com.alysoft.algo.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleUndirectedGraph
{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            if(isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
	}
	
	
	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
       boolean[] visited = new boolean[V];
       int parent = -1;
       for (int i = 0; i<V; i++) 
       {
    	   if (!visited[i]) {
    		   if (isCyclicUtil(0, list, visited, parent)) return true;
    	   }
       }
       return false;
    }
    static boolean isCyclicUtil(int node, ArrayList<ArrayList<Integer>> list,  
        boolean[] visited, int parent) {
        
    	visited[node] = true;
        ArrayList<Integer> adjList = list.get(node);
        for (int x : adjList) {
        	if (!visited[x]) {
        		if (isCyclicUtil(x, list, visited, node)) return true;
        	} else if (x != parent) {
        		return true;
        	}
        }
        return false;
    }
}
