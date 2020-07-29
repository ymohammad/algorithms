package com.alysoft.algo.heap;

import java.util.Scanner;

/**
 * Given an array arr[] of N positive integers and a number K. The task is to find the kth largest element in the array.

Input:
First line of input contains number of testcases. For each testcase, there will be a single line of input containing number of elements in the array and K. Next line contains N elements.

Output:
For each testcase, there will be a single line of output containing the kth largest element in the array.

Your Task:
You are required to complete the method KthLargest() which takes 3 arguments and returns the Kth Largest element.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= arr[i] <= 106
1 <= K <= N

Example:
Input:
2
5 3
3 5 4 2 9
5 5
4 3 7 6 5

Output:
4
3

Explanation:
Testcase 1: Third largest element in the array is 4.
Testcase 2: Fifth largest element in the array is 3.
 * @author ymohammad
 *
 */
public class KthLargestImplement
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
                
            System.out.println(KthLargest(arr, n, k));
        }
    }
	public static int KthLargest(int arr[], int n, int k){
        // Your code here
        int[] heap = new int[k];
        for (int i = 0; i<k; i++) {
            heap[i] = arr[i];
        }
        buildHeap(heap, k);
        
        for (int i = k; i<n; i++) {
        	if (arr[i]>heap[0]) {
        		extractMin(heap, k);
                insert(heap, k, arr[i]);
        	}
        }
        return extractMin(heap, k);
    }
    public static void insert(int[] heap, int n, int x) {
        int j = n-1;
        heap[j] = x;
        int parent = -1;
        while (j > 0) {
            parent = (j-1)/2;
            if (heap[j]<heap[parent]) {
               int temp = heap[parent];
                heap[parent] = heap[j];
                heap[j] = temp;
                j = parent; 
            } else {
                break;
            }
        }
    }
    public static int extractMin(int[] arr, int n) {
        int min = arr[0];
        arr[0] = arr[n-1];
        heapify(arr, n-1, 0);
        return min;
    }
    public static void buildHeap(int[] arr, int n) {
        int index = (n-2)/2;
        for (int i = index; i>=0; i--) {
            heapify(arr, n, i);
        }
    }
    public static void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        
        if (left < n && arr[smallest] > arr[left]) {
            smallest = left;
        }
        if (right < n && arr[smallest] > arr[right]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, smallest);
        }
    }
}
