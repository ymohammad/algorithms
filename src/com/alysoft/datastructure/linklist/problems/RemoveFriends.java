package com.alysoft.datastructure.linklist.problems;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class RemoveFriends
{
	//Logger
	 static Logger logger = Logger.getLogger("MyLog"); 
	public static void main(String args[] ) throws Exception {
        //Scanner
		createLogger();
		
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i<t; i++) {
        	int n = s.nextInt();
        	int k = s.nextInt();
        	CircularLinkedList<Integer> ls = new CircularLinkedList<Integer>();
        	for (int x=0; x<n; x++) {
        		ls.add(s.nextInt());
        	}
        	
        	boolean isFriendDeleted = false;
    		int noOfDeletes = 0;
    		while (noOfDeletes != k) {
    			if (ls.peek() == null || ls.peekNext() == null) break;
    			
    			if (ls.peek() < ls.peekNext()) {
    				ls.popPeekHead();
    				logger.info(ls.toString());
    				isFriendDeleted = true;
    				noOfDeletes++;
    			} else {
    				ls.rotateOneStep();
    			}
    		}
    		if (!isFriendDeleted) {
    			ls.pop();
    		}
        	System.out.println(ls);
        }
    }

	static class CircularLinkedList<T>
	{
		private SingleNode<T> tail = null;
		private SingleNode<T> prevPeekHead = null;
		private SingleNode<T> peekHead = null;
		
		private int length = 0;
		
		public CircularLinkedList() {
			this.tail = null;
			this.length = 0;
		}
		
		//Method 1: Insert at Start
		public void add(T data) {
			this.addToTail(data);
		}
		
		//Method 2: insert at the start.
		public void addToHead(T data) {
			if (tail == null) {
				tail = new SingleNode<T>(data, null);
				tail.setNext(tail);
			} else {
				SingleNode<T> head = tail.getNext();
				SingleNode<T> newNode = new SingleNode<T>(data, head);
				tail.setNext(newNode);
			}
			this.length++;
		}
		
		//Method 3: Add to tail
		public void addToTail(T data) {
			this.addToHead(data);
			this.tail = tail.getNext();
		}
		
		//Method 4: pop method implementation
		public T pop() {
			if (tail == null) return null;
			
			SingleNode<T> head = tail.getNext();
			this.tail.setNext(head.getNext());
			head.setNext(null);
			this.length--;
			return head.getData();
		}
		
		//Method 4: pop method implementation
		public T popPeekHead() {
			if (tail == null || this.peekHead == null) return null;
			
			SingleNode<T> local = peekHead;
			SingleNode<T> next = peekHead.getNext();
			this.peekHead = next;
			
			if (local == this.tail.getNext()) {
				this.tail.setNext(this.peekHead);
				this.prevPeekHead = this.tail;
			} else {
				this.prevPeekHead.setNext(next);
			}
			
			
			this.length--;
			local.setNext(null);
			return local.getData();
		}
		
		
		//Method 5: pop method implementation
		public T peek() {
			if (tail == null) return null;
			
			if (peekHead == null || peekHead.getNext() == null) {
				resetPointers();
			}
			
			return peekHead.getData();
		}
		
		private void resetPointers() {
			this.prevPeekHead = tail;
			this.peekHead = tail.getNext();
		}
		//Method 4: pop method implementation
		public T peekNext() {
			if (tail == null) return null;
			if (peekHead == null || peekHead.getNext() == null) {
				resetPointers();
			}
			return peekHead.getNext().getData();
		}
		//Method 5: Rotate the list to 1 step.
		public void rotateOneStep() {
			this.prevPeekHead = this.peekHead;
			this.peekHead = this.peekHead.getNext();
			if (this.peekHead == this.tail) {
				resetPointers();
			}
		}
		@Override
		public String toString()
		{
			if (tail == null) return "[]";
			
			if (tail.getNext() == null) return this.tail.toString();
			
			SingleNode<T> head = tail.getNext();
			StringBuffer buff = new StringBuffer();
			while (head != tail) {
				buff.append(head.toString());
				head = head.getNext();
			}
			buff.append(tail.toString());
			return buff.toString();
		}
	}
	
	static class SingleNode<T>
	{
		private T data;
		private SingleNode<T> next;
		
		public SingleNode() {
			super();
		}
		
		public SingleNode(T data, SingleNode<T> next)
		{
			super();
			this.data = data;
			this.next = next;
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
			return this.data + " ";
		}
	}
	
	
	
	
	public static void createLogger() {  

	     
	    FileHandler fh;  

	    try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("C:/temp/MyLogFile.log");  
	        logger.addHandler(fh);
	        //SimpleFormatter formatter = new SimpleFormatter();  
	        //fh.setFormatter(formatter);  

	        // the following statement is used to log any messages  
	        logger.info("My first log");  

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  

	    logger.info("Hi How r u?");  

	}
}
