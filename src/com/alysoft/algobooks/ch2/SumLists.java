package com.alysoft.algobooks.ch2;

import com.alysoft.datastructure.linklist.SingleNode;
import com.alysoft.datastructure.linklist.SinglyLinkedList;

/*
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.

FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 - > 1 -> 2. That is, 912.
 */
public class SumLists
{
	//Follow up one...
	public static SingleNode<Integer> performSum(SingleNode<Integer> s1, SingleNode<Integer> s2) {
		
		if (s1.getNext() == null && s2.getNext() == null) {
			int value = s1.getData() + s2.getData();
			int carry = value > 10 ? 1 : 0;
			SingleNode<Integer> valNode = new SingleNode<Integer>(value%10, null);
			valNode.setExtraValue(carry);
			return valNode;
		}
		
		SingleNode<Integer> result = null;
		int value = 0;
		if (s1.getNext() != null && s2.getNext() != null) {
			result = performSum(s1.getNext(), s2.getNext());
			value = s1.getData() + s2.getData() + result.getExtraValue();
		} else if (s1.getNext() == null) {
			result = performSum(s1, s2.getNext());
			value = s2.getData() + result.getExtraValue();
		} else if (s2.getNext() == null) {
			result = performSum(s1.getNext(), s2);
			value = s1.getData() + result.getExtraValue();
		}
		value = s1.getData() + s2.getData() + result.getExtraValue();
		//we are at the last
		SingleNode<Integer> newNode = new SingleNode<Integer>(value%10, result);
		newNode.setExtraValue(value > 10 ? 1 : 0);
		return newNode;
	}
	
	//Method 3: Recursion but not passing the result as parameter
	public static SingleNode<Integer> performSum(SingleNode<Integer> s1, SingleNode<Integer> s2, int carry) {
		if (s1 == null && s2 == null && carry == 0) {
			return null;
		}
		int value = carry;
		value += (s1 != null ? s1.getData() : 0);
		value += (s2 != null ? s2.getData() : 0);
		
		SingleNode<Integer> result = new SingleNode<Integer>(value%10, null);
		
		if (s1 != null || s2 != null) {
			SingleNode<Integer> next = performSum(s1 != null ? s1.getNext() : null, s2 != null ? s2.getNext(): null, (value > 10 ? 1 : 0));
			result.setNext(next);
		}
		return result;
	}
	//Method 2: To perform the sum using recursion.
	public static void performSum(SingleNode<Integer> s1, SingleNode<Integer> s2, int carry, SingleNode<Integer> resultNodeList) {
		
		if (s1 == null && s2 == null) {
			return;
		}
		
		int val1 = s1 != null ? s1.getData() : 0;
		int val2 = s2 != null ? s2.getData() : 0;
		
		int sumValue = val1 + val2 + carry;
		
		carry = sumValue >=10 ? sumValue/10 : 0;
		int nextNodeVal = sumValue >=10 ? sumValue%10 : sumValue;
		
		resultNodeList.setNext(new SingleNode<Integer>((nextNodeVal), null));
		resultNodeList = resultNodeList.getNext();
		performSum(s1.getNext(), s2.getNext(), carry, resultNodeList);
		
	}

	/*
	 * Method 1: Just loop individual SingleNode and append each data element and then return the final string.
	 */
	public static SingleNode<Integer> addTwoLL(SingleNode<Integer> s1, SingleNode<Integer> s2) {
		
		int sumNum = getNumber(s1) + getNumber(s2);
		String value = Integer.toString(sumNum);
		SingleNode<Integer> returnNode = new SingleNode<Integer>(Integer.parseInt(value.charAt(value.length()-1)+""), null);
		SingleNode<Integer> tempNode = returnNode;
		for (int i = value.length()-2; i>=0; i--) {
			tempNode.setNext(new SingleNode<Integer>(Integer.parseInt(value.charAt(i)+""), null)); 
			tempNode = tempNode.getNext();
		}
		return returnNode;
	}
	public static int getNumber(SingleNode<Integer> sLL) {
		int s1Number = 0;
		int tensVal = 0;
		while (sLL != null) {
			if (tensVal == 0) {
				s1Number = sLL.getData();
			} else {
				int tensMultiplyer = 1;
				for (int x = 0; x<tensVal; x++) {
					tensMultiplyer = tensMultiplyer * 10;
				}
				s1Number = s1Number + sLL.getData() * tensMultiplyer;
			}
			sLL = sLL.getNext();
			tensVal++;
		}
		//System.out.println("Return Value :" + s1Number + " >>> For");
		return s1Number;
	}
	public static void main(String[] args) {
		SingleNode<Integer> s1 = new SingleNode<Integer>(7, new SingleNode<Integer>(1, new SingleNode<Integer>(6, null)));
		SingleNode<Integer> s2 = new SingleNode<Integer>(5, new SingleNode<Integer>(9, new SingleNode<Integer>(2, null)));
		
		System.out.println("Sum of numbers Iterative:");
		SingleNode.printLinkedList(addTwoLL(s1, s2));
		
		SingleNode<Integer> resultNodeList = new SingleNode<Integer>(-1, null);
		performSum(s1, s2, 0, resultNodeList);
		resultNodeList = resultNodeList.getNext();
		System.out.println("\nSum of numbers Recursive:");
		SingleNode.printLinkedList(resultNodeList);
		
		System.out.println("\nSum of numbers Recursive (efficient):" );
		SingleNode.printLinkedList(performSum(s1, s2, 0));
		
		System.out.println("\nSum of numbers Recursive (Follow up):" );
		s1 = new SingleNode<Integer>(6, new SingleNode<Integer>(1, new SingleNode<Integer>(7, null)));
		s2 = new SingleNode<Integer>(2, new SingleNode<Integer>(9, new SingleNode<Integer>(5, null)));
		SingleNode.printLinkedList(performSum(s1, s2));
		
		System.out.println("\nSum of numbers Recursive (Follow up):" );
		s1 = new SingleNode<Integer>(6, new SingleNode<Integer>(1, new SingleNode<Integer>(7, new SingleNode<Integer>(7, null))));
		s2 = new SingleNode<Integer>(2, new SingleNode<Integer>(9, new SingleNode<Integer>(5, null)));
		SingleNode.printLinkedList(performSum(s1, s2));
	}
}
