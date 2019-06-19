package com.alysoft.algo.heap;

public class Heap
{
	private int capacity;
	private int count = 0;
	private int[] array;
	
	public Heap(int capacity) {
		this.capacity = capacity;
		this.array = new int[this.capacity];
	}
	public int getParent(int index) {
		if (index >= this.count) return -1;
		int parentIndex = (index-1)/2;
		if (parentIndex >= this.count) return -1;
		return parentIndex;
	}
	public int getLefChild(int index) {
		if (index >= this.count) return -1;
		
		int leftIndex = (2*index+1);
		if (leftIndex >= this.count) return -1;
		return leftIndex;
	}
	public int getRightChild(int index) {
		if (index >= this.count) return -1;
		
		int rightIndex = (2*index+2);
		if (rightIndex >= this.count) return -1;
		return rightIndex;
	}
	public void swapElement(int fromIndex, int toIndex) {
		int temp = this.array[fromIndex];
		this.array[fromIndex] = this.array[toIndex];
		this.array[toIndex] = temp;
	}
	public void heapify(int index) {
		int max;
		int leftIndex = getLefChild(index);
		if (leftIndex != -1 && this.array[leftIndex] > this.array[index]) {
			max = leftIndex;
		} else {
			max = index;
		}
		int rightIndex = getRightChild(index);
		if (rightIndex != -1 && this.array[rightIndex]>this.array[max]) {
			max = rightIndex;
		}
		if (max != index) {
			swapElement(index, max);
			heapify(max);
		}
	}
	public int deleteMax() {
		if (this.count == 0) return -1;
		int data = this.array[0];
		this.array[0] = this.array[this.count-1];
		this.array[this.count-1] = 0;
		this.count--;
		heapify(0);
		return data;
	}
	public boolean insert(int data) {
		if (this.count == this.capacity) {
			this.resizeHeap();
		}
		this.count++;
		int i = this.count-1;
		while (i>0 && data > this.array[i-1/2]) {
			this.array[i] = this.array[(i-1)/2];
			i = (i-1)/2;
		}
		this.array[i] = data;
		return true;
	}
	private void resizeHeap()
	{
		int[] oldArray = this.array;
		this.array = new int[this.capacity*2];
		for (int i = 0; i<this.count; i++) {
			this.array[i] = oldArray[i];
		}
		this.capacity = this.capacity*2;
	}
	public void insertArray(int[] array)
	{
		if (this.capacity == this.count) {
			this.resizeHeap();
		}
		for (int i = 0; i<array.length; i++) {
			int ind = (this.count-1)<0 ? 0 : this.count-1;
			this.array[i + ind] = array[i];
		}
		this.count += array.length;
		for (int i=((this.count-1)/2); i>=0; i--) {
			this.heapify(i);
		}
	}
	public void heapSort() {
		int oldCount = this.count;
		while (this.count > 0) {
			this.swapElement(0, this.count-1);
			this.count--;
			this.heapify(0);
		}
		this.count = oldCount;
	}
	public String toString() {
		StringBuffer buff = new StringBuffer();
		for (int x = 0; x< this.count; x++) {
			buff.append(this.array[x] + " ");
		}
		return buff.toString().trim();
	}
	public void heapifySorted()
	{
		this.heapify(this.count-1);
	}
}
