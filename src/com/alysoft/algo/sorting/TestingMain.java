package com.alysoft.algo.sorting;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestingMain
{

	public static void main(String[] args)
	{
		int[] arr = {1, 5, 7, 8, 10};
		System.out.println("Search 5:" + Arrays.binarySearch(arr, 5));
		System.out.println("Search 2:" + Arrays.binarySearch(arr, 2));
		System.out.println("Search 7:" + Arrays.binarySearch(arr, 7));
		System.out.println("Search 9:" + Arrays.binarySearch(arr, 9));
		System.out.println("Search 55:" + Arrays.binarySearch(arr, 55));
		
		System.out.println("Test :" + 5687%1000);
		int x = 5687912;
		while (x>0) {
			System.out.println("Test1 :" + x%1000);
			x = x/1000;
		}
		splitCsv();
		char[] ch = {'K', 'R', 'P', 'C', 'S', 'N', 'Y', 'T', 'J', 'M'};
		orderHash(ch);
	}
	public static void orderHash(char[] charArray)
	{
		for (char ch : charArray)
		{
			int x = ((ch-'A') + 1)%10;
			System.out.println(ch + " -> " + x);
		}
	}
	public static void splitCsv()
	{
		String s = "a1,a2,a3,\"a4,a5\",a6";
		Pattern pattern = Pattern.compile("\\s*(\"[^\"]*\"|[^,]*)\\s*");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			if (matcher.group().trim().length() > 0)
				System.out.println(matcher.group(0));
		}
	}
}
