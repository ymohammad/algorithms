package com.alysoft.algo.bits;

/**
 * You are given a decimal number N. You need to find the gray code of the number n and conver it into decimal.
To see how it's done, refer here.

Input:
The first line contains an integer T, the number of test cases. For each test case, there is an integer n denoting the number

Output:
For each test case, the output is gray code equivalent of n.

User Task:
The task is to complete the function greyConverter() which converts given decimal to gray code.

Constraints:
1 <= T <= 100
0 <= N <= 108

Example:
Input:
2
7
10

Output:
4
15

Explanation:
Testcase1: 7 is represented as 111 in binary form. The gray code of 111 is 100, in the binary form whose decimal equivalent is 4.

Testcase2: 10 is represented as 1010 in binary form. The gray code of 1010 is 1111, in the binary form whose decimal equivalent is 15.
 * @author ymohammad
 *
 */
public class GrayCode
{
	public static void main(String[] args) {
		System.out.println("Convert to grey 7:" + greyConverter(7));
		System.out.println("Convert to grey 10:" + greyConverter(10));
		System.out.println("Convert to binary 4:" + grayToBinary(4));
		System.out.println("Convert to binary 15:" + grayToBinary(15));
	}
	
	public static int greyConverter(int n) {
        
		 StringBuffer grey = new StringBuffer();
		 String binary = getBinary(n);
		 if (binary == null || binary.length() < 2) {
		     if (binary == null || binary.trim().length() == 0) return 0;
		     
		     return Integer.parseInt(binary, 2);
		 }
		 grey.append(binary.charAt(0));
		 int k = 1;
		 while (k < binary.length()) {
			 grey.append(xOr(binary.charAt(k-1), binary.charAt(k)));
			 k++;
		 }
		 return Integer.parseInt(grey.toString(), 2);
	 }

	private static String xOr(char x1, char x2)
	{
		return (x1 == x2) ? "0" : "1";
	}

	private static String getBinary(int n)
	{
		String binary = new String();
		while (n>0) {
			binary = (n%2)+binary;
			n = n/2;
		}
		return binary.toString();
	}
	
	public static int greyConverter2(int n) {
        int q=n>>1;
        return n^q;
    }
	
	public static int grayToBinary(int n) {
        
		String binary = getBinary(n);
		 if (binary == null || binary.length() < 2) {
		     if (binary == null || binary.trim().length() == 0) return 0;
		     
		     return Integer.parseInt(binary, 2);
		 }
		 StringBuffer grey = new StringBuffer();
		 grey.append(binary.charAt(0));
		 for (int i = 1; i<binary.length(); i++) {
			 if (binary.charAt(i) == '0') {
				 grey.append(grey.charAt(i-1));
			 } else {
				 grey.append(getInvert(grey.charAt(i-1)));
			 }
		 }
		 return Integer.parseInt(grey.toString(), 2);
    }

	private static String getInvert(char charAt)
	{
		return (charAt == '1' ? "0" : "1");
	}
	
	public static int grayToBinary2(int n) {
        int b=0;
        for(n=n;n>0;n=n>>1)
            b^=n;
        
        return b;
    }
      
}
