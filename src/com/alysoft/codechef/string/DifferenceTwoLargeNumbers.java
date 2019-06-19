package com.alysoft.codechef.string;

public class DifferenceTwoLargeNumbers
{

	public static void main(String[] args)
	{
		String str1 = "11443333311111111100";
		String str2 =     "1144422222221111";
		System.out.println(differenceTwoNumbers(str1, str2));
	}

	public static String differenceTwoNumbers(String s1, String s2) {
		StringBuffer difference = new StringBuffer();
		
		int n = s1.length();
		int m = s2.length();
		int i = n-1;
		int j = m-1;
		
		while (i>=0 || j>=0) {
			int a = (i>=0) ? (s1.charAt(i)-'0'):0;
			int b = (j>=0) ? (s2.charAt(j)-'0'):0;
			
			difference.append(Math.abs(a-b));
			i--;
			j--;
		}
		difference.reverse();
		return difference.toString();
	}
}
