package com.alysoft.geeksforgeeks.string;

import java.util.Scanner;

public class Anagrams
{
	public static void main(String[] args) {
		printArray();
	}
	public static void main1(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			String s1=sc.next();
			System.out.println(remAnagrams(s,s1));
		}
	}

	private static boolean isAnagram(String s1, String s2) {
		return remAnagrams(s1, s2) == 0;
	}
	private static int remAnagrams(String s, String s1)
	{
		int[] valueArray = new int[256];
		
		char[] charArray = s.toCharArray();
		for (char ch : charArray) {
			valueArray[(int)ch]++;
		}
		
		charArray = s1.toCharArray();
		for (char ch : charArray) {
			valueArray[(int)ch]--;
		}
		
		int counter = 0;
		for (int i: valueArray) {
			if (i != 0)
				counter += Math.abs(i);
		}
		return counter;
	}

	private static void printArray()
	{
		for (int i = 97; i < (97+26); i++)
		{
				System.out.println((char)i + " = " + i);
		}
	}
}
