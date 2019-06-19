package com.alysoft.algorithms.linkedlist;

import java.util.HashSet;

public class LinkedList {
	private Node head = null;
	
	static int findMergingofTwoLists(Node headA, Node headB) {
		//This solution is amazing..
		/*
		 * ListA = 1--2--3
			ListB = 1--3
			
			so the merge point is 3
			
			lets say they merge at 3 like in your example, you would get the 
			following order of nodes: A1,B1,ne -> A2,B3,ne -> A3,B1,ne -> A1,B2,ne -> A3,B3 hooray,we found it.
		 */
		/*
		 Node currentA = headA;
	     Node currentB = headB;
	
	    //Do till the two nodes are the same
	    while(currentA != currentB){
	        //If you reached the end of one list start at the beginning of the other one
	        //currentA
	        if(currentA.next == null){
	            currentA = headB;
	        }else{
	            currentA = currentA.next;
	        }
	        //currentB
	        if(currentB.next == null){
	            currentB = headA;
	        }else{
	            currentB = currentB.next;
	        }
	    }
	    return currentB.data;
		 */
		
		//Other solution would be looping each list and adding to hasset and checking and getting the merging list.
		
		return 0;
	}
	static Node deleteDuplicates(Node sortedList) {
		/**
		 * Delete duplicate-value nodes from a sorted linked list
		 */
		Node head = sortedList;
		Node prevNode = null;
		Node currentNode = sortedList;
		
		while (currentNode != null) {
			if (prevNode != null && prevNode.data == currentNode.data) {
				prevNode.next = currentNode.next;
			} else {
				prevNode = currentNode;
			}
			currentNode = currentNode.next;
		}
		return head;
	}
	Node mergeLists(Node headA, Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method
	     Node tail = headA;
	     Node tempHead = headA;
	     while (headA != null) {
	         if (headA.data >= headB.data) {
	        	 moveNode(headB, headA);
	         }
	     }
	     return null;
	}
	public static Node moveNode(Node destRef, Node sourceRef) {
		if (destRef == null || sourceRef == null) return null;
		
		Node newNode = sourceRef;
		/* Advance the source pointer */
		sourceRef = newNode.next;
	 
	    /* Link the old dest off the new node */
	    newNode.next = destRef;
	 
	    /* Move dest to point to the new node */
	    destRef = newNode;
	    return destRef;
	}
	int getNodeLength(Node head) {
	    int len = 0;
	    Node temp = head;
	    while (temp != null) {
	        temp = temp.next;
	        len++;
	    }
	    return len;
	}
	public boolean isLoopExist() {
		if (head == null) return false;
		/**
		 * Method 1. Make a change in Node datastructre and maintain a isVisited flag. 
		 * Now traverse the LL, if you found isVisited then loop exist. Otherwise no.
		 */
		
		/**
		 * Method 2: Use a Map or set collection and store the object. While traversing,
		 * check if it is exist in the collection, if exist then already visited.
		 * Otherwise, add it to the Hash collection and move for the next element.
		 */
		
		/**
		 * Method 3: Use Floyd’s Cycle-Finding Algorithm.
		 * Use two pointers, slow and faster.
		 * Checks if slow and faster meets then it is having loop.
		 */
		Node slowPtr = head;
		Node fastPtr = head;
		
		while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			//NOTE: Compare objects not the data value..
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		
		HashSet<Node> set = new HashSet<Node>();
		
		return false;
	}
	
	//Recursive soln is not working..
	public Node reverseRecursive(Node prev, Node current) {
		if (current.next == null) return current;
		
		Node rest = current.next;
		Node head = reverseRecursive(current, rest);
		head.next = prev;
		return head;
	}
	
	/**
	 * Reverse a linked list.
	 * Given pointer to the head node of a linked list, the task is to reverse the linked list. 
	 * We need to reverse the list by changing links between nodes.
	 */
	public void reverseLinkedList() {
		/**
		 * Method 1: Traverse the complete Linked List and put the elements to new Linked List. Since Linked List is a Stack.
		 * It follows LIFO approach.
		 * Read the new Linked list as the reverse one.
		 * This approach takes more memory... O(n) memory.
		 */
		
		
		/**
		 * Method 2: Use 3 pointers and reverse the Linked List.
		 */
		Node prev = null;
		Node current = head;
		Node next = null;
		
		while (current != null) {
			//Store the next pointer which current.next.
			//Now, change the current.next to point the previous node. This way, it is changing its linking.
			//Make the prev node which is current now.
			//Move the current node to next.
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	/**
	 * Program for n’th node from the end of a Linked List
	 * Given a Linked List and a number n, write a function that returns the value at the n’th node from end of the Linked List.
	 * 
	 * @param n
	 * @return
	 */
	public Node findNthNodeFromEnd(int n) {
		if (head == null) return null;
		/**
		 * Method 1:
		 * Easy way is to find the size of the Linked List.
		 * While traversing the LL, at each iteration, check n-i = j-1
		 * where i is the current index and j is the position from end.
		 */
		
		Node returnNode = null;
		int size = head.getSize();
		int i = 0;
		Node temp = head;
		while (temp != null) {
			i++;
			if (size-i == n-1) {
				returnNode = temp;
				break;
			}
			temp = temp.next;
		}
		//return returnNode;
		
		/**
		 * Method 2:(Use length of linked list) 
		 * 1) Calculate the length of Linked List. Let the length be len.
		 * 2) Print the (len – n + 1)th node from the begining of the Linked List.
		 */
		
		/**
		 * Method 3: This one is amazing. Thing of two pointers, one is faster and one is slower. Slower starts once faster is reached to the 
		 * required position.
		 * Think about two cars: C(current) and R(result). They have the same speed and C is in fromt of R. 
		 * The distance between them is the value of positionFromTail. So when C arrive at the ending point, 
		 * where is R? Note that their distance is "positionFromTail", the position of R is the position from tail.
		 */
		Node current = head;
	    Node result = head;
	    int count = 0;
	    while(current != null) {
	        if (count > n) {
	            result = result.next;
	        }
	        count++;
	        current = current.next;
	    }
	    int data = result.data;
	    return result;
	}
	/**
	 * Find the middle of a given linked list.
	 * Given a singly linked list, find middle of the linked list. 
	 * For example, if given linked list is 1->2->3->4->5 then output should be 3.
	 * 
	 * If there are even nodes, then there would be two middle nodes, 
	 * we need to print second middle element. 
	 * For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
	 */
	public Node findMiddle() {
		if (head == null) return null;
		
		/**
		 * Method 1: Straight Forward, find the size, and find the middle position, traverse and get the node.
		 */
		
		/**
		 * Method 2: Use 2 pointers. Slow and Fast. Slow pointer moves 1 position at a time, while faster moves 2 position.
		 * This way, once faster pointer reaches end, slow pointer will be at the middle of the list.
		 */
		
		Node slowPointer = head;
		Node fastPointer = head;
		
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}
	/**
	 * Swap nodes in a linked list without swapping data
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean swapNodes(int x, int y) {
		/**
		 * Here, we need to handle the following cases, it is a tricky one.
		 * 	1) x and y may or may not be adjacent.
			2) Either x or y may be a head node.
			3) Either x or y may be last node.
			4) x and/or y may not be present in linked list.
		 */
		if (head == null) return false;
		
		if (x == y) return false;
		
		Node xPrevNode = null;
		Node xCurrentNode = head;
		
		Node yPrevNode = null;
		Node yCurrentNode = head;
		
		while (xCurrentNode != null && xCurrentNode.data != x) {
			xPrevNode = xCurrentNode;
			xCurrentNode = xCurrentNode.next;
		}
		
		while (yCurrentNode != null && yCurrentNode.data != y) {
			yPrevNode = yCurrentNode;
			yCurrentNode = yCurrentNode.next;
		}
		
		if (xCurrentNode == null || yCurrentNode == null) return false;

		//Check if any node is equal to head..then change head position.
		if (xPrevNode != null) {
			xPrevNode.next = yCurrentNode;
		} else {
			head = yCurrentNode;
		}
		
		if (yPrevNode != null ) {
			yPrevNode.next = xCurrentNode;
		} else {
			head = xCurrentNode;
		}
		Node tempXNext = xCurrentNode.next;
		Node tempYNext = yCurrentNode.next;
		yCurrentNode.next = tempXNext;
		xCurrentNode.next = tempYNext;
		
		return true;
	}
	/**
	 * Search an element in a Linked List (Iterative and Recursive)
	 * @param data
	 * @return
	 */
	public Node findIterative(int data) {
		Node returnNode = head;
		
		if (returnNode == null || returnNode.data == data) return returnNode;
		
		while(returnNode != null && returnNode.data != data) {
			returnNode = returnNode.next;
		}
		return returnNode;
	}
	public Node findRecursive(int data) {
		return searchNodeRecursive(head, data);
	}
	public Node searchNodeRecursive(Node node, int data) {
		if (node == null || node.data == data) return node;
		return searchNodeRecursive(node.next, data);
	}
	public int size() {
		/*
		 * Method 1: Straight forward way, just iterate over the list and find the length.
		 */
		int size = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			size++;
		}
		
		//Method 2: Recursive way. This is implemented directly in the node. But same logic, we can implement here as well.
		size = head.getSize();
		
		return size;
	}
	
	  public void printList()
	    {
	        Node tNode = head;
	        System.out.println("Head is " + head.data);
	        //while (tNode != null)
	        {
	            System.out.print(tNode.data+" ");
	            tNode = tNode.next;
	            System.out.print(tNode.data+" ");
	            System.out.print(tNode.next.data+" ");
	            System.out.print(tNode.next.next.data+" ");
	        }
	    }
	/**
	 * Delete node at index based position.
	 * @param index
	 */
	public void deleteNodeAtPosition(int index) {
		if (head == null) return;
		
		if (index == 0) {
			head = head.next;
			return;
		}
		
		Node prevNode = head;
		Node currentNode = head;
		
		int currIndex = 0;
		while(currentNode != null && index != currIndex) {
			prevNode = currentNode;
			currentNode = currentNode.next;
			currIndex++;
		}
		
		if (currentNode == null) return;
		
		prevNode.next = currentNode.next;
	}
	
	/**
	 * Delete the node for the given data.
	 * @param data
	 * @return
	 */
	public Node deleteDataNode(int data) {
		Node currentNode = head;
		if (currentNode == null) return head;
		
		if (currentNode != null && currentNode.data == data) {
			head = currentNode.next;
			return currentNode;
		}
		
		Node prevNode = null;
		
		while (currentNode != null && currentNode.data != data) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
				
		if (currentNode == null) return null;
		
		prevNode.next = currentNode.next;
		return currentNode;
	}
	
	//Push the data to linked list. It pushes to the first position.
	public Node push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		return head;
	}
	public String toString() {
		return head.toString();
	}
	public static void main(String[] args) {
		performTests();
	}
	public static void performTests() {
		testDeleteDataNode();
		System.out.println("\n\n");
		testDeleteNodeAtPosition();
		System.out.println("\n\n");
		testFindIterative();
		System.out.println("\n\n");
		testFindRecursive();
		System.out.println("\n\n");
		testSwapNodes();
		System.out.println("\n\n");
		testFindMiddle();
		System.out.println("\n\n");
		testFindLastNthNode();
		System.out.println("\n\n");
		testReverseLinkedList();
		System.out.println("\n\n");
		testMoveNode();
	}
	public static void testMoveNode() {
		LinkedList listObj1 = new LinkedList();
		listObj1.push(1);
		listObj1.push(2);
		listObj1.push(3);
		
		LinkedList listObj2 = new LinkedList();
		listObj2.push(1);
		listObj2.push(2);
		listObj2.push(3);
		
		System.out.println("Insertion	     :" + listObj1 + " :: Size :" + listObj1.size());
		Node destNode = listObj1.head;
		destNode = moveNode(destNode, listObj2.head);
		System.out.println("Reverse Linked List :" + destNode);
	}
	public static void testReverseLinkedList() {
		LinkedList listObj = new LinkedList();
		listObj.push(75);
		listObj.push(20);
		listObj.push(3);
		listObj.push(41);
		listObj.push(17);
		listObj.push(8);
		listObj.push(11);
		
		System.out.println("Insertion	     :" + listObj + " :: Size :" + listObj.size());
		listObj.reverseLinkedList();
		System.out.println("Reverse Linked List :" + listObj);
		listObj.reverseLinkedList();
		System.out.println("Reverse Linked List :" + listObj);
		listObj.reverseLinkedList();
		System.out.println("Reverse Linked List :" + listObj);
		
		System.out.println("\n\n Using recursive method..");
		listObj.head = listObj.reverseRecursive(null, listObj.head);
		System.out.println("Reverse Linked List :" + listObj);
		listObj.head = listObj.reverseRecursive(null, listObj.head);
		System.out.println("Reverse Linked List :" + listObj);

	}
	
	public static void testFindLastNthNode() {
		LinkedList listObj = new LinkedList();
		listObj.push(75);
		listObj.push(20);
		listObj.push(3);
		listObj.push(41);
		listObj.push(17);
		listObj.push(8);
		listObj.push(11);
		
		System.out.println("Insertion	     :" + listObj + " :: Size :" + listObj.size());
		System.out.println("3rd Node from End :" + listObj.findNthNodeFromEnd(3));
		System.out.println("2rd Node from End :" + listObj.findNthNodeFromEnd(2));
		System.out.println("1rd Node from End :" + listObj.findNthNodeFromEnd(1));
		System.out.println("4rd Node from End :" + listObj.findNthNodeFromEnd(4));
		System.out.println("5rd Node from End :" + listObj.findNthNodeFromEnd(5));
		System.out.println("6rd Node from End :" + listObj.findNthNodeFromEnd(6));
		System.out.println("7rd Node from End :" + listObj.findNthNodeFromEnd(7));
		System.out.println("8rd Node from End :" + listObj.findNthNodeFromEnd(8));
	}
	
	public static void testFindMiddle() {
		LinkedList listObj = new LinkedList();
		listObj.push(75);
		listObj.push(20);
		listObj.push(3);
		listObj.push(41);
		listObj.push(17);
		listObj.push(8);
		listObj.push(11);
		
		System.out.println("Insertion	     :" + listObj + " :: Size :" + listObj.size());
		System.out.println("Middle Node :" + listObj.findMiddle());
		
		listObj = new LinkedList();
		listObj.push(15);
		listObj.push(2);
		listObj.push(3);
		listObj.push(1);
		listObj.push(17);
		listObj.push(18);
		
		System.out.println("Insertion	     :" + listObj + " :: Size :" + listObj.size());
		System.out.println("Middle Node :" + listObj.findMiddle());
		
		listObj = new LinkedList();
		listObj.push(2);
		listObj.push(3);
		
		System.out.println("Insertion	     :" + listObj + " :: Size :" + listObj.size());
		System.out.println("Middle Node :" + listObj.findMiddle());
	}
	public static void testSwapNodes() {
		LinkedList listObj = new LinkedList();
		listObj.push(75);
		listObj.push(20);
		listObj.push(3);
		listObj.push(41);
		listObj.push(17);
		listObj.push(8);
		listObj.push(11);
		
		System.out.println("Insertion	     :" + listObj + " :: Size :" + listObj.size());
		listObj.swapNodes(20, 41);
		System.out.println("Swap Nodes 20 and 41 :" + listObj);
		listObj.swapNodes(75, 20);
		System.out.println("Swap Nodes 75 and 20 :" + listObj);
		listObj.swapNodes(8, 11);
		//listObj.printList();
		System.out.println("Swap Nodes 8 and 11  :" + listObj);
		listObj.swapNodes(41, 17);
		System.out.println("Swap Nodes 41 and 17 :" + listObj);
		listObj.swapNodes(8, 20);
		System.out.println("Swap Nodes 8 and 20  :" + listObj);
		listObj.swapNodes(17, 8);
		System.out.println("Swap Nodes 17 and 8  :" + listObj);
	}
	public static void testFindRecursive() {
		LinkedList listObj = new LinkedList();
		listObj.push(75);
		listObj.push(20);
		listObj.push(3);
		listObj.push(41);
		listObj.push(17);
		listObj.push(8);
		listObj.push(11);
		
		System.out.println("Insertion	 :" + listObj + " :: Size :" + listObj.size());
		System.out.println("Find 3  :" + listObj.findRecursive(3));
		System.out.println("Find 20 :" + listObj.findRecursive(20));
		System.out.println("Find 17 :" + listObj.findRecursive(17));
		System.out.println("Find 41 :" + listObj.findRecursive(41));
		System.out.println("Find 31 :" + listObj.findRecursive(31));
	}
	public static void testFindIterative() {
		LinkedList listObj = new LinkedList();
		listObj.push(75);
		listObj.push(20);
		listObj.push(3);
		listObj.push(41);
		listObj.push(17);
		listObj.push(8);
		listObj.push(11);
		
		System.out.println("Insertion	 :" + listObj + " :: Size :" + listObj.size());
		System.out.println("Find 3 :" + listObj.findIterative(3));
		System.out.println("Find 20 :" + listObj.findIterative(20));
		System.out.println("Find 17 :" + listObj.findIterative(17));
		System.out.println("Find 41 :" + listObj.findIterative(41));
	}
	public static void testDeleteNodeAtPosition() {
		LinkedList listObj = new LinkedList();
		listObj.push(75);
		listObj.push(20);
		listObj.push(3);
		listObj.push(41);
		listObj.push(17);
		listObj.push(8);
		listObj.push(11);
		
		System.out.println("Insertion	 :" + listObj + " :: Size :" + listObj.size());
		listObj.deleteNodeAtPosition(3);
		System.out.println("After deleting 3 :" + listObj);
		listObj.deleteNodeAtPosition(0);
		System.out.println("After deleting 0 :" + listObj);
		listObj.deleteNodeAtPosition(7);
		System.out.println("After deleting 7:" + listObj);
		listObj.deleteNodeAtPosition(4);
		System.out.println("After deleting 4:" + listObj);
	}
	public static void testDeleteDataNode() {
		LinkedList listObj = new LinkedList();
		listObj.push(35);
		listObj.push(2);
		listObj.push(3);
		listObj.push(4);
		listObj.push(7);
		listObj.push(8);
		listObj.push(1);
		
		System.out.println("Insertion	 :" + listObj + " :: Size :" + listObj.size());
		listObj.deleteDataNode(3);
		System.out.println("After deleting 3 :" + listObj);
		listObj.deleteDataNode(1);
		System.out.println("After deleting 1 :" + listObj);
		Node output = listObj.deleteDataNode(70);
		System.out.println("After deleting 70:" + listObj);
	}
}
