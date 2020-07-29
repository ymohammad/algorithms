package com.alysoft.algo.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an input stream of n integers, find the kth largest element for each element in the stream.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two lines. 
The first line of each test case contains two space separated integers k and n . Then in the next line are n space separated values of the array.

Output:
For each test case, in a new line, print the space separated values denoting the kth largest element at each insertion, if the kth largest 
element at a particular insertion in the stream doesn't exist print -1.

Your Task:
You are required to complete the method kthLargest() which takes 3 arguments and prints kth largest element or -1.

Constraints:
1 <= T <= 100
1 <= K <= n
1 <= n <= 106
1 <= stream[] <= 105

Example:
Input:
2
4 6
1 2 3 4 5 6
1 2
3 4

Output:
-1 -1 -1 1 2 3
3 4 

Explanation:
Testcase1:
k = 4
For 1, the 4th largest element doesn't exist so we print -1.
For 2, the 4th largest element doesn't exist so we print -1.
For 3, the 4th largest element doesn't exist so we print -1.
For 4, the 4th largest element is 1 {1, 2, 3, 4}
For 5, the 4th largest element is 2 {2, 3, 4 ,5}
for 6, the 4th largest element is 3 {3, 4, 5}
 * @author ymohammad
 *
 */
public class KthLargestElementStream
{

	public static void main(String[] args)
	{

	}
	public void kthLargest(int arr[], int n, int k){
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i<k-1; i++) {
            pq.add(arr[i]);
            buff.append(-1 + " ");
        }
        
        pq.add(arr[k-1]);
        buff.append(pq.peek() + " ");
        int j = k;
        while (j < n) {
            if (arr[j]>pq.peek()) 
            {
                pq.poll();
                pq.add(arr[j]);
                
            } 
            //else {
            //    buff.append(pq.peek() + " ");
           // }
            buff.append(pq.peek() + " ");
            
            j++;
        }
        /*
        while (!pq.isEmpty()) {
            buff.append(pq.poll() + " ");
        }*/
        System.out.print(buff);
    }
	
	
	//Editorial..
	public void kthLargestE(int arr[], int n, int k){
        Queue<Integer> pq = new PriorityQueue<>(); // making Minheap
	        for(int i=0;i<k-1;i++){
	            pq.add(arr[i]);
	            System.out.print("-1 ");
	        }
	        pq.add(arr[k-1]);
	        System.out.print(pq.peek()+" ");
	        for(int i=k;i<n;i++){// the size of heap will remain k now
	            if(pq.peek()<arr[i]){ // if top element is smaller than arr[i]
	                pq.poll();
	                pq.add(arr[i]);
	            }
	            System.out.print(pq.peek()+" ");
	        }
	        
    }
}
