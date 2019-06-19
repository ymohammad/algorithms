package com.alysoft.codemonk.module1;

import java.util.Scanner;

public class Cipher
{
	public static void printCipher(String sampleStr, int n) {
		char[] charArray = sampleStr.toCharArray();
		StringBuffer encryptedStr = new StringBuffer();
		for (char ch : charArray) {
			if (Character.isDigit(ch)) {
				encryptedStr.append((Integer.parseInt(Character.toString(ch)) + n)%10);
			} else if (isAlphabet(ch)){
				encryptedStr.append(getNextChar(ch, n));
			} else {
				encryptedStr.append(ch);
			}
		}
		System.out.println(encryptedStr.toString());
	}
	
	private static char getNextChar(char ch, int n)	{
		char startingChar = 'a';
		if (Character.isUpperCase(ch)) {
			startingChar = 'A';
		} 
		int diff = (int)(ch) - (int)(startingChar);
		//System.out.println(ch + " - Difference is " + diff);
		diff = (diff + n)%26;
		//System.out.println(ch + " - Final value :" + diff);
		//System.out.println(ch + " - Calculated value " + ((int)(startingChar) + diff));
		return (char) ((int)(startingChar) + diff);
	}

	public static boolean isAlphabet(char c) {
		int capA = Character.getNumericValue('A');
		int capZ = Character.getNumericValue('Z');
		int smallA = Character.getNumericValue('a');
		int smallZ = Character.getNumericValue('z');
		
		int numericValue = Character.getNumericValue(c);
		return (numericValue >= capA && numericValue <= capZ) || (numericValue >= smallA && numericValue <= smallZ);
	}
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();                 // Reading input from STDIN
        int n = s.nextInt();
        printCipher(input, n);

    }
}
