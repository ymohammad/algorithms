package com.leetcode.algorithms;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example
	
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.

 * @author ymohammad
 *
 */
public class LinkedListAddingTwoNumbers {
	
	public static void main(String[] args) {
		/*ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);*/
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		
		ListNode addTwoNumbers = addTwoNumbers(l1, l2);
		ListNode temp = addTwoNumbers;
		while(temp.next != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.print(temp.val);
	}
	
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode returnNode = new ListNode(0);
        getTwoNumbers(l1, l2, 0, returnNode);
        return returnNode;
    }
    
    public static void getTwoNumbers(ListNode l1, ListNode l2, int carry, ListNode resultListNode) {
    	System.out.println(">>> l1:" + l1 + " >>> l2::" + l2 + " >>>> carry::" + carry);
        if (l1 == null && l2 == null && carry == 0) {
            return;
        }
        int newCarry = 0;
        int tempSum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
        if (tempSum / 10 > 0) 
        {
            newCarry = tempSum / 10;
            tempSum = tempSum % 10; 
        }
        System.out.println(">>> newCarry::" + newCarry + " >>> tempSum::" + tempSum);
        resultListNode.val = tempSum;
        
        l1 = (l1 != null && l1.next != null) ? l1.next : null;
        l2 = (l2 != null && l2.next != null) ? l2.next : null;
        
        if (l1 != null || l2 != null || newCarry != 0) {
        	resultListNode.next = new ListNode(0);
        	getTwoNumbers(l1, l2, newCarry, resultListNode.next);
        }
    }
}
class ListNode {
    int val;
     ListNode next;
    ListNode(int x) { val = x; }
    public String toString() {
    	return val + "";
    }
}
