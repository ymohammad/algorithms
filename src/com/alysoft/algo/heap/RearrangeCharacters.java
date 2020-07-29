package com.alysoft.algo.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a string S with repeated characters (only lowercase). The task is to rearrange characters in a string such that no two 
 * adjacent characters are same.

Note : It may be assumed that the string has only lowercase English alphabets.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a 
single line containing a string of lowercase english alphabets.

Output:
For each test case in a new line print "1" (without quotes) if the generated string doesn't contains any same adjacent characters, 
else if no such string is possible to be made print "0" (without quotes).

Your Task:
You are required to complete the method rearrangeString() which takes 1 argument and returns the string without any same adjacent character.

Constraints:
1 <= T <= 100
1 <= length of string <= 104

Example:
Input:
3
geeksforgeeks
bbbabaaacd
bbbbb

Output:
1
1
0

Explanation:
Testcase 1: All the repeated characters of the given string can be rearranged so that no adjacent characters in the string is equal.
Testcase 3: Repeated characters in the string cannot be rearranged such that there should not be any adjacent repeated character.
 * @author ymohammad
 *
 */
public class RearrangeCharacters
{

	public static void main(String[] args)
	{
		String str = "kkk";
		rearrangeCharacters(str);
	}
	static boolean rearrangeCharacters(String str) {
		int[] charHash = new int[26];
		char[] charArr = str.toCharArray();
		for (char ch : charArr) {
		    charHash[getCharIndex(ch)]++;
		}
		
		PriorityQueue<CharBean> pq = new PriorityQueue<CharBean>(new ComparatorHandler());
		for (int i = 0; i<26; i++) {
		    if (charHash[i]>0) {
		        pq.add(new CharBean(getChar(i), charHash[i]));
		    }
		}
		CharBean prevBean = null;
		CharBean temp = null;
		while (!pq.isEmpty()) {
			temp = pq.poll();
			temp.freq--;
			if (prevBean != null && temp.ch == prevBean.ch) return false;
			
			if (prevBean != null && prevBean.freq > 0) {
				pq.add(prevBean);
			}
			if (pq.isEmpty() && temp.freq > 0) return false;
			
			if (!pq.isEmpty())
				prevBean = temp;
		}
		if (prevBean.ch == temp.ch) return false;
		
		return true;
	}
	static char getChar(int index) {
	    int x = 'a'+index;
	    return (char)x;
	}
	static int getCharIndex(char ch) {
	    return ch-'a';
	}
	static class ComparatorHandler implements Comparator<CharBean> {

		@Override
		public int compare(CharBean b1, CharBean b2)
		{
			if (b1.freq > b2.freq) return -1;
	        
	        if (b1.freq == b2.freq) return 0;
	        
	        return 1;
		}
	}
	static class CharBean {
	    char ch;
	    int freq;
	    public CharBean(char ch, int freq) {
	        this.ch = ch;
	        this.freq = freq;
	    }
	    @Override
	    public String toString() {
	    	return "Char=" + ch + "; Freq=" + freq;
	    }
	}
}
