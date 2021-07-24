package com.alysoft.completedsa.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AddBinaryStrings
{
	public static void main(String[] args) {
		System.out.println(">>> :" + ('1'-'0'));
		System.out.println(">>> :" + ('0'-'0'));
		System.out.println(">>> :" + ('1'-'1'));
	}
	public static void main1(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            String line = br.readLine();
            String[] splitArr = line.split(" ");
            String s1 = splitArr[0];
            String s2 = splitArr[1];
            
            String ch = addNGetBinaryStrings(s1, s2);
            System.out.println(ch);
            t--;
        }
	}

	private static String addNGetBinaryStrings(String s1, String s2)
	{
		int i = s1.length()-1;
		int j = s2.length()-1;
		
		Stack<Character> binStack = new Stack<Character>();
		char carry = '0';
		while (i>= 0 || j>=0) {
			if (i>= 0 && j>=0) {
				carry = storeValueNGetCarry(binStack, s1.charAt(i), s2.charAt(j), carry);
			} else if (i>= 0) {
				carry = storeValueNGetCarry(binStack, s1.charAt(i), carry, '0');
			} else if (j>=0) {
				carry = storeValueNGetCarry(binStack, s2.charAt(j), carry, '0');
			}
			i--;
			j--;
		}
		if (carry == '1')
			binStack.push(carry);
		
		StringBuffer buff = new StringBuffer();
		while (!binStack.isEmpty()) {
			buff.append(binStack.pop());
		}
		return buff.toString();
	}
	
	private static char storeValueNGetCarry(Stack<Character> binStack, char i, char j, char carry)
	{
		if (j == '0' && carry == '0') {
			binStack.push(i);
			return carry;
		}
		String binVal = addBinaryVal(i, j, carry);
		binStack.push(binVal.charAt(1));
		carry = binVal.charAt(0);
		return carry;
	}

	private static String addBinaryVal(char i, char j, char carry)
	{
		if (i == '1' && j == '1' && carry == '1') {
			return "11";
		} else if (i == '1' && j == '1' && carry == '0') {
			return "10";
		} else if (i == '1' && j == '0' && carry == '1') {
			return "10";
		} else if (i == '0' && j == '1' && carry == '1') {
			return "10";
		} else if (i == '0' && j == '0' && carry == '1') {
			return "01";
		} else if (i == '0' && j == '1' && carry == '0') {
			return "01";
		} else if (i == '1' && j == '0' && carry == '0') {
			return "01";
		} else {
			return "00";
		}
	}

	private static String addNGetBinaryStrings2(String s1, String s2)
	{
		int s1Val = convertToInt(s1);
		int s2Val = convertToInt(s2);
		int finalVal = s1Val+s2Val;
		return convertToBinaryString(finalVal);
	}
	private static String convertToBinaryString(int finalVal)
	{
		StringBuffer buff = new StringBuffer();
		while (finalVal > 0) {
			int x = finalVal%2;
			buff.append(x);
			finalVal = finalVal/2;
		}
		buff.reverse();
		return buff.toString();
	}

	public static int convertToInt(String binaryStr) {
		int n = binaryStr.length();
		int powerIndex = 0;
		int totalVal = 0;
		for (int i = n-1; i>=0; i--) {
			char charAt = binaryStr.charAt(i);
			if (charAt == '1') {
				totalVal += (Integer.parseInt(String.valueOf(charAt))*Math.pow(2, powerIndex));
			}
			
			powerIndex++;
		}
		return totalVal;
	}
}
