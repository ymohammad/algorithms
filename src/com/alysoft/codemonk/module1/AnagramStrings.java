package com.alysoft.codemonk.module1;

import java.util.Scanner;

/**
 * Given two strings, a and b , that may or may not be of the same length, determine the minimum number 
 * of character deletions required to make a and b anagrams. Any characters can be deleted from either of the strings.
 * For e.g. -> For the word RAM - MAR,ARM,AMR,RMA etc. are few anagrams.
 * @author ymohammad
 *
 */
public class AnagramStrings
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
        int t = s.nextInt();                 // Reading input from STDIN
        s.nextLine();
        for(int x = 0; x < t; x++) {
        	int numOfDeletes = 0;
            String s1 = s.nextLine();
            String s2 = s.nextLine();
            int[] charArr1 = new int[257];
            int[] charArr2 = new int[257];
            
            for (char ch : s1.toCharArray()) {
            	charArr1[ch] = charArr1[ch] + 1;
            }
            for (char ch : s2.toCharArray()) {
            	charArr2[ch] = charArr2[ch] + 1;
            }
            
            for (int a = 0; a <charArr1.length; a++) {
            	if (charArr1[a] != 0 || charArr2[a] != 0) {
            		numOfDeletes = numOfDeletes + Math.abs(charArr1[a]-charArr2[a]);
            	}
            }
            System.out.println(numOfDeletes);
        }
	}

}
