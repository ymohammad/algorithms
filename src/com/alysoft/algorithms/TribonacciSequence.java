package com.alysoft.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TribonacciSequence
{

	  public static double[] tribonacci(double[] s, int n) {
	      // hackonacci me
	      double[] returnArr = new double[n];
	      int index = 0;
	      for (double a: s) {
	    	  if (index < n) {
	    		returnArr[index] = a;
	  	        index++;
	    	  }
	      }
	      while (index < n) {
	        returnArr[index] = returnArr[index-1] + returnArr[index-2] + returnArr[index-3];
	        index++;
	      }
	      return returnArr;
	  }
	  public static int solution(int number) {
		    int returnResult = 0;
		    for (int x=1; x<=number; x++) {
		      if (x%3 == 0 || x%5 == 0) {
		    	  System.out.println(x);
		        returnResult += x;
		      }
		    }
		    return returnResult;
	}
	  //best
	  public static String orderWeight(String string) {
		    String[] split = string.split(" ");
		    Arrays.sort(split, new Comparator<String>() {
		      public int compare(String a, String b) {
		        int aWeight = a.chars().map(c -> Character.getNumericValue(c)).sum();
		        int bWeight = b.chars().map(c -> Character.getNumericValue(c)).sum();
		        return aWeight - bWeight != 0 ? aWeight - bWeight : a.compareTo(b);
		      }
		    });
		    return String.join(" ", split);
		  }
	public static String orderWeight1(String strng)
	{
		// your code
		StringBuilder sb = new StringBuilder();
		strng = strng.trim();
		String[] allNumsStr = strng.split(" ");
		Hashtable<Integer, List<String>> valuesMap = new Hashtable<>();
		for (String str : allNumsStr)
		{
			int total = 0;
			for (char ch : str.toCharArray())
			{
				if (Character.isDigit(ch))
				{
					total += Integer.parseInt(String.valueOf(ch));
				}
			}
			if (valuesMap.containsKey(total))
			{
				valuesMap.get(total).add(str);
			} else
			{
				List<String> data = new LinkedList<>();
				data.add(str);
				valuesMap.put(total, data);
			}
		}

		Set<Integer> allKeys = valuesMap.keySet();
		List<Integer> list = new ArrayList<>();
		for (int a : allKeys)
		{
			list.add(a);
		}
		Collections.sort(list);
		for (int j = 0; j < list.size(); j++)
		{
			int a = list.get(j);
			List<String> allNums = valuesMap.get(a);
			Collections.sort(allNums);
			for (int i = 0; i < allNums.size(); i++)
			{
				String eachNum = allNums.get(i);
				sb.append(eachNum);
				if (i != (allNums.size() - 1))
				{
					//System.out.println(">> i" + i + " >> " + (allNums.size() - 1));
					sb.append(" ");
				}
			}
			if (j != (list.size() - 1)) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	  public static void main(String[] args) {
		  /*System.out.println(tribonacci(new double[] {8.0, 13.0, 13.0}, 20));
		  System.out.println(tribonacci(new double[] {20.0, 11.0, 2.0}, 20));
		  System.out.println(tribonacci(new double[] {9.0, 15.0, 13.0}, 21));
		  System.out.println(tribonacci(new double[] {16.0, 12.0, 0.0}, 19));
		  System.out.println(tribonacci(new double[] {12.0, 11.0, 15.0}, 0));*/
		  //11 11 2000 10003 22 123 1234000 44444444 9999
		  System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
	  }
}
