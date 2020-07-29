package com.alysoft.algo.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Given an array of N positive integers, print k largest elements from the array.  The output elements should be printed in decreasing order.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N and k, N is the size of array and K is the largest elements to be returned. The second line of each test case contains N input C[i].

Output:
Print the k largest element in descending order.

Your Task:
You are required to complete the method kthLargest() which takes 3 arguments and prints required output.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100
K ≤ N
1 ≤ C[i] ≤ 1000

Example:
Input:
2
5 2
12 5 787 1 23
7 3
1 23 12 9 30 2 50

Output:
787 23
50 30 23

Explanation:
Testcase 1: 1st largest element in the array is 787 and second largest is 23.
Testcase 2: 3 Largest element in the array are 50, 30 and 23.
 * @author ymohammad
 *
 */
public class KLargestElements
{
	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            
            kthLargest(arr, n, k);
            
        }
    }
	public static void kthLargest(int arr[], int n, int k){
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
		for (int i = 0; i<k; i++) {
			minHeap.add(arr[i]);
		}
		for (int i = k; i<n; i++) {
			minHeap.poll();
			minHeap.add(arr[i]);
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		for (int i = 0; i<k; i++) {
			maxHeap.add(minHeap.poll());
		}
		
		for (int i = 0; i<k; i++) {
			System.out.print(maxHeap.poll() + " ");
		}
    }
}
