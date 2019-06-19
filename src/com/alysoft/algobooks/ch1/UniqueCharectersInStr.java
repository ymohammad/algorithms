package com.alysoft.algobooks.ch1;
/**
 * Need to identify, if we have unique characters in the given string.
 * 
 * Method 1: BruteForce way, we can do it in n^2 time complexity but using two for loops.
 * Method 2: Check if the string of ASCII (128 chars) or if Unicode then we need bigger storage. This can done in O(n) or O(1)
 * as the size is fixed.
 * @author ymohammad
 *
 */
public class UniqueCharectersInStr
{

	public static boolean isUnique(String charString) {
		byte[] allChar = new byte[128];
		char[] charArray = charString.toCharArray();
		for (char eachCh: charArray) {
			if (allChar[(byte)eachCh] == 1) {
				return false;
			} else {
				allChar[(byte)eachCh] = 1;
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		String str = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("isUnique() " + isUnique(str));
		
		System.out.println("Unicode of U+0041 :" + '\u00F1');
		System.out.println(">>> " + newMethod());
	}

	public static int newMethod() {
		try
		{
			System.out.println("IN the try block..");
			return 0;
		} catch (Exception e)
		{
			// TODO: handle exception
		} finally {
			System.out.println("In the finally block...");
			return 1;
		}
	}
}
