package com.alysoft.algo.heap;

public class BinaryMinHeapTesting
{
	public static void main(String[] args) {
		int[] arr = {85, 15, 12, 78, 10, 74};
		BinaryMinHeap buildHeap = BinaryMinHeap.buildHeap(arr);
		System.out.println(buildHeap);
		buildHeap.delete(2);
		System.out.println("BuildHeap After delete :");
		System.out.println(buildHeap);
	}
}
