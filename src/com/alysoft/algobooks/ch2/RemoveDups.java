package com.alysoft.algobooks.ch2;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Remove Duplicates! Write code to remove duplicates from an unsorted linked list.
	FOLLOW UP
	How would you solve this problem if a temporary buffer is not allowed?
 * @author ymohammad
 *
 */
public class RemoveDups
{
	//How would you solve this problem if a temporary buffer is not allowed?
	public static void methodNoBuffer(LinkedList<Integer> dataList) {
		ListIterator<Integer> iterator1 = dataList.listIterator();
		ListIterator<Integer> iterator2 = dataList.listIterator();
		
		while (iterator1.hasNext() ) {
			int i = iterator1.next();
			while (iterator2.hasNext()) {
				int j = iterator2.next();
				if (i == j) iterator2.remove();
			}
		}
	}
	public static void methodUsingCache(LinkedList<Integer> dataList) {
		
		Hashtable<Integer, Integer> hash = new Hashtable<>();
		ListIterator<Integer> iterator = dataList.listIterator();
		while (iterator.hasNext()) {
			int data = iterator.next();
			if (hash.containsKey(data)) {
				iterator.remove();
			} else {
				hash.put(data, data);
			}
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> dataList = new LinkedList<Integer>();
		dataList.add(1);
		dataList.add(2);
		dataList.add(3);
		dataList.add(1);
		dataList.add(4);
		dataList.add(2);
		dataList.add(4);
		dataList.add(5);
		dataList.add(5);
		
		methodNoBuffer(dataList);
		System.out.println("Final List :" + dataList);
	}
}
