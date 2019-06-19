package com.alysoft.codemonk.module2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PalindromStr
{
    public static void main(String args[] ) throws Exception {
    	/*
    	 * 
    	 3
		abc
		abba
		aba
    	 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());              

        for (int i = 0; i<t; i++) {
        	String str = br.readLine();
        	isPalindromBetter(str.trim());
        }
    }
    public static void isPalindromBetter(String str) {
    	char[] charArray = str.toCharArray();
    	if (charArray.length == 0) return;
    	int i = 0; 
    	int j = charArray.length-1;
    	
    	while (i<j) {
    		if (charArray[i] != charArray[j]) {
    			System.out.println("NO");
    			return;
    		}
    		i++;
    		j--;
    	}
    	System.out.println("YES " + ((charArray.length)%2 == 0 ? "EVEN" : "ODD"));
    }
    public static void isPalindrom(String str) {
    	int noOfChars = str.length();
    	
    	int[] asciiArr = new int[200];
    	
    	for (char c : str.toCharArray()) {
    		asciiArr[c] = asciiArr[c] + 1;
    	}
    	
    	boolean isFirstOddFound = false;
    	for (int x : asciiArr) {
    		
    		if (x != 0 && x%2 != 0 && isFirstOddFound) {
    			System.out.println("NO");
    			return;
    		}
    		if (x%2 != 0) isFirstOddFound = true;
    	}
    	
    	System.out.println("YES " + (noOfChars%2 == 0 ? "EVEN" : "ODD"));
    }
    
    
    public static void main1(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int noOfTests = Integer.parseInt(s.nextLine());
        for (int i=0; i<noOfTests; i++) {
            
            int n = Integer.parseInt(s.nextLine());
            int noOfInversion = 0;
            
            for (int rowIndex = 0; rowIndex < n; rowIndex++) {
                
                String[] str = (s.nextLine()).split(" ");
                for (int x = 0; x<str.length; x++) {

                    if (x+1 < str.length) {
                        if (Integer.parseInt(str[x]) > Integer.parseInt(str[x+1])) {
                            noOfInversion++;
                        }
                    }
                }
            }
            System.out.println(noOfInversion);
        }
    }
}
