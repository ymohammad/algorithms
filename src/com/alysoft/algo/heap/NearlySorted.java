package com.alysoft.algo.heap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Given an array of n elements, where each element is at most k away from its target position, you need to sort the array optimally.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. 
The first line contains two elements n and k separated by a space. The second line contains n elements of array.

Output:
For each testcase, in a new line, print the sorted array.

Note: DO NOT use STL sort() function for this question.

Your Task:
You are required to complete the method nearlySorted() which takes 3 arguments and prints the sorted array.

Constraints:
1 <= T <= 50
1 <= n <= 106
1 <= k <= n
1 <= arri <= 107

Examples:
Input:
2
7 3
6 5 3 2 8 10 9
5 2
4 3 1 2 5
Output:
2 3 5 6 8 9 10
1 2 3 4 5
 * @author ymohammad
 *
 */
public class NearlySorted
{

	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int num = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[num];
            for(int i = 0; i < num; i++)
                arr[i] = sc.nextInt();
            
            nearlySorted(arr, num, k);
            System.out.println();
        }
    }
	static void nearlySorted(int arr[], int num, int k){
        // your code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k+1);
        for (int i = 0; i<=k; i++) {
            pq.add(arr[i]);
        }
        StringBuffer buff = new StringBuffer();
        for (int i = k+1; i<num; i++) {
            buff.append(pq.poll() + " ");
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            buff.append(pq.poll() + " ");
        }
        System.out.print(buff);
    }
	
	//Editorial
	void nearlySortedE(int arr[], int num, int k){
        Queue<Integer> pq = new PriorityQueue<>();
        // Making Minheap for first K element
        for(int i = 0; i<k; ++i)
            pq.add(arr[i]);
               
        for(int i = k; i < num; i++){
            // popping topmost and inserting one more
            System.out.print(pq.peek() + " ");
            pq.poll();
            pq.add(arr[i]);
        }
               
        while(!pq.isEmpty()){
            // popping till heap becomes empty
            System.out.print(pq.peek() + " ");
            pq.poll();
        }
        
    }
}
