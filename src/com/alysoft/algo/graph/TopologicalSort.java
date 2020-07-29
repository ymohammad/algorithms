package com.alysoft.algo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort
{
	public static void main (String[] args)throws IOException 
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
                
            String s[] = read.readLine().trim().split("\\s+");
            int p = 0;
            for(int i = 1; i <= edg; i++)
            {    int u = Integer.parseInt(s[p++]);
                 int v = Integer.parseInt(s[p++]);
                 list.get(u).add(v);
                
            }
            
            
            int res[] = new int[10001];
             res = topoSort(list, nov);
             printArray(res);
            boolean valid = true;
            
            for(int i = 0; i < nov; i++)
            {
                int n = list.get(res[i]).size();
                for(int j = 0; j < list.get(res[i]).size(); j++)
                {
                    for(int k = i+1; k < nov; k++)
                    {
                        if(res[k]==list.get(res[i]).get(j))
                            n--;
                    }
                }
                if(n!=0)
                {
                    valid = false;
                    break;
                }
            }
            if(valid == true)
                System.out.println("0");
            else
                System.out.println("1");
		}
    }
	private static void printArray(int[] res)
	{
		for (int x: res) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
    {
       int[] returnArr = new int[N];
       boolean[] visited = new boolean[N];
       Stack<Integer> stack = new Stack<Integer>();
       for (int node = 0; node<N; node++) {
           if (!visited[node]) {
               topoSortUtil(node, list, visited, stack);
           }
       }
       int i = returnArr.length-1;
       while (!stack.isEmpty()) {
    	  int x = stack.pop();
          //returnArr[i] = x;
          i--;
       }
       return returnArr;
    }
    static void topoSortUtil(int node, ArrayList<ArrayList<Integer>> list, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        ArrayList<Integer> adjList = list.get(node);
        for (int x : adjList) {
            if (!visited[x]) {
                topoSortUtil(x, list, visited, stack);
            }
        }
        stack.push(node);
    }
}
