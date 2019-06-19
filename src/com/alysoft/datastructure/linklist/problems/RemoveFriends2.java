package com.alysoft.datastructure.linklist.problems;

import java.util.Scanner;

public class RemoveFriends2
{
	public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i<t; i++) {
        	int n = s.nextInt();
        	int k = s.nextInt();
        	SingleNode<Integer> sNode = new SingleNode<Integer>(s.nextInt());
        	SingleNode<Integer> temp = sNode;
        	for (int x=1; x<n; x++) {
        		temp.next = new SingleNode<Integer>(s.nextInt());
        		temp = temp.next;
        	}
        	
        	int deletedFriendCount = 0;
        	int noOfLoops = 0;
        	while (deletedFriendCount != k) {
        		noOfLoops++;
        		deletedFriendCount = loopNRemoveFriends(sNode, k, deletedFriendCount);
        		//System.out.println("\nLoop :" + noOfLoops + ", Deleted Friends :" + deletedFriendCount + ", Head pointing :" + sNode.getData());
        		//printNode(sNode);
        	}
        	
        	printNode(sNode);
        }
    }
	
	static void printNode(SingleNode<Integer> sl) {
		System.out.println();
		while (sl != null) {
			System.out.print(sl.getData() + " ");
			sl = sl.getNext();
		}
	}
	static int loopNRemoveFriends(SingleNode<Integer> sl, int k, int currentCount) {
		if (k == currentCount || sl == null) return currentCount;
		boolean isFriendDeleted = false;
		while (sl.getNext() != null) {
			if (k == currentCount) break;
			
			if (sl.getData() < sl.getNext().getData()) {
				SingleNode<Integer> nextNode = sl.getNext();
				sl.setData(nextNode.getData());
				sl.setNext(nextNode.getNext());
				nextNode.setNext(null);
				isFriendDeleted = true;
				currentCount++;
				
				//breaking loop
				if (currentCount > Math.abs(k-50)) {
					break;
				}
			} else {
				sl = sl.getNext();
			}
		}
		//Nothing can be deleted.
		if (!isFriendDeleted && currentCount == 0) {
			//Here sl is at the end node.
			sl.setData(null);
			//Set the breaking condition.
			currentCount = k;
		}
		return currentCount;
	}
	
	static class SingleNode<T>
	{
		private T data;
		private SingleNode<T> next;
		
		public SingleNode() {
			super();
		}
		
		public SingleNode(T data)
		{
			super();
			this.data = data;
		}
		
		public T getData()
		{
			return this.data;
		}
		public void setData(T data)
		{
			this.data = data;
		}
		public SingleNode<T> getNext()
		{
			return this.next;
		}
		public void setNext(SingleNode<T> next)
		{
			this.next = next;
		}

		@Override
		public String toString()
		{
			if (this.data == null) return "";
			
			if (this.next == null) return this.data+"";
			
			return this.data + " " + this.next.toString();
		}
	}
}
