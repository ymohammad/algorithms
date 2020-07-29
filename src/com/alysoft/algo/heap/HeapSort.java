package com.alysoft.algo.heap;

import java.util.Scanner;

/**
 * Given an array of size N. The task is to sort the array elements by completing functions heapify() and buildHeap() which are used to implement 
 * Heap Sort.

Input:
First line of the input denotes number of test cases T. First line of the test case is the size of array and second line consists of array elements.

Output:
Sorted array in ascending order.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= arr[i] <= 106

Example:
Input:
2
5
4 1 3 9 7
10
10 9 8 7 6 5 4 3 2 1

Output:
1 3 4 7 9
1 2 3 4 5 6 7 8 9 10

Explanation:
Testcase 1: After sorting elements using heap sort, elements will be in order as 1, 3, 4, 7 and 9.
 
 * @author ymohammad
 *
 */
public class HeapSort
{

	void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        HeapSort hs = new HeapSort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            hs.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    public void heapSort(int arr[], int n)
    {
    	HeapSort g = new HeapSort();
        g.buildHeap(arr, n);
        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            g.heapify(arr, i, 0);
        }
    }

	void buildHeap(int arr[], int n)
    {
       // int leafNodeIndex = n-1;
        int nonLeafIndex = (n-2)/2;
        for (int i = nonLeafIndex; i>=0; i--) {
        	heapify(arr, n, i);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
    	if (i>n) return;
    	
    	int largestIndex = i;
    	int leftChild = 2*i+1;//leftChild(i, n);
    	int rightChild = 2*i+2; //rightChild(i, n);
    	
    	if (leftChild < n && arr[largestIndex]< arr[leftChild]) {
    		largestIndex = leftChild;
    	}
    	
    	if (rightChild < n && arr[largestIndex]< arr[rightChild]) {
    		largestIndex = rightChild;
    	}
    	if (largestIndex != i) {
    		int temp = arr[largestIndex];
    		arr[largestIndex] = arr[i];
    		arr[i] = temp;
    		heapify(arr, n, largestIndex);
    	}
    }

	private int rightChild(int i, int n)
	{
		int j = 2*i+2;
		return j;
	}

	private int leftChild(int i, int n)
	{
		return 2*i+1;
	}
}
