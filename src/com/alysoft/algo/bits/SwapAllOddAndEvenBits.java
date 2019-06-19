package com.alysoft.algo.bits;

/**
 * Given an unsigned integer N. The task is to swap all odd bits with even bits. For example, if the given number is 23 (00010111), it should be converted to 43(00101011). Here, every even position bit is swapped with adjacent bit on right side(even position bits are highlighted in binary representation of 23), and every odd position bit is swapped with adjacent on left side.

Input:
The first line of input contains T, denoting the number of testcases. Each testcase contains single line.

Output:
For each testcase in new line, print the converted number.

User Task:
Your task is to complete the function swapBits() which takes and integer and returns integer with all the odd and even bits swapped.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100

Example:
Input:
2
23
2

Output:
43
1

Explanation:
Testcase 1: BInary representation of the given number; 00010111 after swapping 00101011.
 * @author ymohammad
 *
 */
public class SwapAllOddAndEvenBits
{

	public static void main(String[] args) {
		System.out.println(swapBits(23));
		System.out.println(0xAAAAAAAA);
		System.out.println(0x55555555);
	}
	
	/**
	 * If we take a closer look at the sample testcases, we can observe that we basically need to right shift (>>) 
	 * all even bits (In the above example, even bits of 23 are highlighted) by 1 so that they become odd bits (highlighted in 43), 
	 * and left shift (<<) all odd bits by 1 so that they become even bits. The following solution is based on this observation. 
	 * The solution assumes that input number is stored using 32 bits.

		Let the input number be x
		1) Get all even bits of x by doing bitwise and of x with 0xAAAAAAAA. The number 0xAAAAAAAA is a 32 bit number with all even bits 
		set as 1 and all odd bits as 0.
		2) Get all odd bits of x by doing bitwise and of x with 0x55555555. The number 0x55555555 is a 32 bit number with all odd bits 
		set as 1 and all even bits as 0.
		3) Right shift all even bits.
		4) Left shift all odd bits.
		5) Combine new even and odd bits and return.
	 * @param n
	 * @return
	 */
	public static int swapBits(int n) {
		   
	   int evenBits = n&0xAAAAAAAA;
	   int oddBits = n&0x55555555;
	   evenBits = evenBits>>1;
	   oddBits = oddBits<<1;
	   return (evenBits|oddBits);
	}
	public static int swapBits2(int n) {
		   
	   String binary = getBinary(n);
	   StringBuffer res = new StringBuffer();
	   int i = 1;
	   while ( i<binary.length()) {
	       res.append(binary.charAt(i));
	       res.append(binary.charAt(i-1));
	       i+=2;
	   }
	   return Integer.parseInt(res.toString(), 2);
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
}
