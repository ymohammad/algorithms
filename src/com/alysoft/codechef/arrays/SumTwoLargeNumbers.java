package com.alysoft.codechef.arrays;

public class SumTwoLargeNumbers
{

	public static void main(String[] args) {
		String str1 = "3333311111111111";
		String str2 =   "44422222221111";
		System.out.println(addNumbers(str1, str2));
		
		str1 = "7777555511111111";
		str2 =    "3332222221111";
		System.out.println(addNumbers(str1, str2));
	}
	public static String addNumbers(String s1, String s2) {
		int carry = 0;
		StringBuffer result = new StringBuffer();
		int i = s1.length()-1;
		int j = s2.length()-1;
		
		while (i>=0 || j>=0) {
			int a = (i>=0)? Integer.parseInt(String.valueOf(s1.charAt(i))) : 0;
			int b = (j>=0)? Integer.parseInt(String.valueOf(s2.charAt(j))) : 0;
			int total = a+b+carry;
			result.append(total%10);
			carry = total/10;
			i--;
			j--;
		}
		result.reverse();
		return result.toString();
	}
}
