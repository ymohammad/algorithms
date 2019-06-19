package com.alysoft.algorithms.hackerrank.interviewkit;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. 
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 * 
 * For example , the list of all anagrammatic pairs is  at positions  respectively.

Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .

sherlockAndAnagrams has the following parameter(s):

s: a string .
Input Format

The first line contains an integer , the number of queries. 
Each of the next  lines contains a string  to analyze.

 * @author ymohammad
 *
 */
public class SherlockAndAnagrams
{
	private static int[] primeNum = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	static int sherlockAndAnagrams(String s) throws Exception {
		//System.out.println("starting... for " + s);
		//Here the idea is, anagram string will have the same hash value.
		Hashtable<String, Integer> hashStore = new Hashtable<>();
		int numOfAnagrams = 0;
		for (int i = 0; i< s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				String hashCode = getHashCodeBIG(s.substring(i, j));
				//System.out.println("Hash code for " + s.substring(i, j) + " is " + hashCode);
				if (hashStore.containsKey(hashCode)) {
					hashStore.put(hashCode, hashStore.get(hashCode)+1);
					//numOfAnagrams++;
				} else {
					hashStore.put(hashCode, 1);
				}
			}
		}
		
		System.out.println("Hashstore :" + hashStore);
		
		for (String eachKey: hashStore.keySet()) {
			int count = hashStore.get(eachKey);
			if (count == 1) continue;
			
			int calVal = (count * (count-1))/2;
			numOfAnagrams = numOfAnagrams + calVal;
		}
		
		return numOfAnagrams;
	}
	
	static long getFactorial(int n) {
		if (n <= 1) {
			return 1L;
		}
		
		long factValue = (n * getFactorial(n-1));
		return factValue;
	}
	/**
	 * Using prime numbers ensures that there won’t be any collisions. 
	 * This is because prime factorizations are unique. If you don’t use primes, two strings that aren’t anagrams 
	 * could produce the same hash value. For example, using the A-Z to 1-26 map, ’BJ’ maps to [2, 10] 
	 * and ‘DE’ maps to [4,5], both of which multiply to 20. 
	 * @param subStr
	 * @return
	 */
	static long getHashCode(String subStr)
	{
		long returnValue = 1L;
		int aValue = Character.getNumericValue('a');
		//System.out.println("Numeric value of a :" + aValue);
		for (char ch : subStr.toCharArray()) {
			//System.out.println("Prime Value for " + ch + " - " + (getPrimeNumber(Math.abs(Character.getNumericValue(ch)-aValue))));
			 int primeMultiplier = getPrimeNumber(Math.abs(Character.getNumericValue(ch)-aValue));
			returnValue = returnValue * primeMultiplier;
			//System.out.println("Value  " + ch + " -> " + primeMultiplier + " -> " + returnValue);
		}
		return returnValue;
	}
	
	static String getHashCodeBIG(String subStr)
	{
	    BigInteger bd = BigInteger.ONE;
		int aValue = Character.getNumericValue('a');
		for (char ch : subStr.toCharArray()) {
			 int primeMultiplier = getPrimeNumber(Math.abs(Character.getNumericValue(ch)-aValue));
			 bd = bd.multiply(new BigInteger(Integer.toString(primeMultiplier)));
		}
		return bd.toString();
	}
	
	static int getPrimeNumber(int n) {

		return primeNum[n];
	}
	// Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams1(String s) {
        Hashtable<Character, ArrayList<Integer>> indexHash = new Hashtable<>();
        
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++)
		{
			char ch = charArray[i];
			if (indexHash.containsKey(ch)) {
				indexHash.get(ch).add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				indexHash.put(ch, list);
			}
		}
        
        System.out.println(indexHash);
        int returnCount = 0;
        
        for (int i = 0; i < charArray.length; i++) {
        	ArrayList<Integer> arrayList = indexHash.get(charArray[i]);
        	if (arrayList != null && arrayList.size() > 1) {
        		returnCount++; //for end chars.
        		for (int j = 0; j < arrayList.size(); j++)
				{
        			int x = arrayList.get(j);
        			if (j+1 < arrayList.size()) {
    					if ((arrayList.get(j+1) - arrayList.get(j)) > 1) {
    						returnCount = returnCount + 1;
    					}
        			}
        			System.out.println(" X:" + x + " >>> count:" + returnCount);
				}
        		indexHash.put(charArray[i], new ArrayList<Integer>());
        	}
        }
        
        return returnCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
    	
    	/*
    	System.out.println("primeNum length :" + primeNum.length);
    	String a = "abcdefghijklmnopqrstuvwxyz";
    	for (char ch : a.toCharArray()) {
    		long hashCode = getHashCode(String.valueOf(ch));
    		System.out.println("Hash code for " + ch + " is " + hashCode);
    	}
    	
    	
    	String hashCode = getHashCodeBIG("ffbigffcecahafcafhcdg");
		System.out.println("Hash code for ffbigffcecahafcafhcdg is " + hashCode);
		
    	int count = 55;
    	long factorial = getFactorial(count-2);
		long calVal = ((count * (count-1))/2);
    	System.out.println("Factorial 55 :" + calVal);
		System.exit(0);*/
    	/**/
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }


        scanner.close();
        
    	//subStringSet("abcd", 4);
    	//System.out.println(getFactorial(2));
    }

    public static void subStringSet(String str, int n) 
    { 
    	char[] charArray = str.toCharArray();
       for (int i = 0; i < n; i++)  {
           for (int j = i+1; j <= n; j++) {
        	   
           }
       }
        	   //System.out.println(str.substring(i, j)); 
    } 
}
