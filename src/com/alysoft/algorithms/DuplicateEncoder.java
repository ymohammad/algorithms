package com.alysoft.algorithms;

import java.util.HashMap;
/*
 * The goal of this exercise is to convert a string to a new string where each character in the 
 * new string is '(' if that character appears only once in the original string, or ')' if that 
 * character appears more than once in the original string. Ignore capitalization when determining 
 * if a character is a duplicate.
 * 
 * Examples:

	"din" => "((("
	
	"recede" => "()()()"
	
	"Success" => ")())())"
	
	"(( @" => "))(("
 */
public class DuplicateEncoder {
	//two loops solution with data structure.
	public static String encode(String word) {
		StringBuffer strBuff = new StringBuffer();
		if (word != null && word.length() > 0) {
			word = word.toUpperCase();
			HashMap<Character, Integer> charatCountMap = new HashMap<Character, Integer>();
			
			for (int eachCharInd = 0; eachCharInd < word.length(); eachCharInd++) {
				Character eachChar = word.charAt(eachCharInd);
				int charCount = charatCountMap.containsKey(eachChar) ? (charatCountMap.get(eachChar) + 1) : 1;
				charatCountMap.put(eachChar, charCount);
			}
			for (int charInd = 0; charInd < word.length(); charInd++) {
				if (charatCountMap.get(word.charAt(charInd)) > 1) {
					strBuff.append(")");
				} else {
					strBuff.append("(");
				}
			}
		}
		return strBuff.toString();
	}
	
	//Single loop solution
	//As this solution is using the indexOf and lastIndexOf, which gives the time complexity as O(n2).
	public static String encodeSingleLoop(String word) {
		StringBuffer resultBuff = new StringBuffer();
		if (word != null && word.length() > 0) {
			word = word.toUpperCase();
			
			for (int eachCharInd = 0; eachCharInd < word.length(); eachCharInd++) {
				char eachChar = word.charAt(eachCharInd);
				resultBuff.append((word.lastIndexOf(eachChar) == word.indexOf(eachChar)) ? "(" : ")");
			}
		}
		return resultBuff.toString();
	}
	
	//Solution with O(n)
	public static String encodingBest(String word) {
		StringBuffer resultBuff = new StringBuffer();
		if (word != null && word.length() > 0) {
			word = word.toUpperCase();
			
			int asciCharSize = 256;
			char[] charArray = new char[asciCharSize];
			char[] wordCharArray = word.toCharArray();
			
			for (int eachInd = 0; eachInd < wordCharArray.length; eachInd++) {
				charArray[wordCharArray[eachInd]]++;
			}
			
			for (int eachInd = 0; eachInd < wordCharArray.length; eachInd++) {
				if (charArray[wordCharArray[eachInd]] > 1) {
					resultBuff.append(")");
				} else  {
					resultBuff.append("(");
				}
			}
			
		}
		return resultBuff.toString();
	}
	public static void main(String[] args) {
		System.out.println("))))()))):" + encodingBest("abcbdb"));
	}
}
