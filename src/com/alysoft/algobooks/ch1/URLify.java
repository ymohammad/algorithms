package com.alysoft.algobooks.ch1;

/**
 *  Write a method to replace all spaces in a string with '%20'. You may assume that the string
	has sufficient space at the end to hold the additional characters, and that you are given the "true"
	length of the string. (Note: If implementing in Java, please use a character array so that you can
	perform this operation in place.)
	
	EXAMPLE
	Input: "Mr John Smith     ", 13
	Output: "Mr%20John%20Smith"
 * 
 * 
 * Method 1: Have a new array of characters of same size. Loop on the first array, once you get space
 * then just add %, 2 and 0 in the new array and continue. We might face issues as the required spaces
 * provided at the end. So, substring with spaces might help. 
 * 
 * Method 2: As we know, the spaces are at the end. How will it be if we start iterating from end.
 * Loop on the array, once you get the first character then move it to the end of the array and maintain end index as well.
 *
 */
public class URLify
{
	
	//Method 2 -- Given in book.
	public static String urlify(String str, int trueLength) {
		char[] charArray = str.toCharArray();
		int spaceCount = 0;
		for (int i=0; i<trueLength; i++) {
			if (charArray[i] == ' ') {
				spaceCount++;
			}
		}
		
		int index = trueLength + spaceCount*2;
		
		if (trueLength < charArray.length) charArray[trueLength] = '\0';
		
		for (int i = trueLength-1; i>=0; i--) {
			if (charArray[i] == ' ') {
				charArray[index-1] = '0';
				charArray[index-2] = '2';
				charArray[index-3] = '%';
				index = index - 3;
			} else {
				charArray[index-1] = charArray[i];
				index--;
			}
		}
		return new String(charArray);
	}

	//Method 2
	public static String urlify(String str) {
		char[] charArray = str.toCharArray();
		int emptyIndex = charArray.length -1;
		boolean isCharFound = false;
		for (int i = charArray.length -1; i >=0; i--) {
			char ch = charArray[i];
			//System.out.println("Ch :" + ch);
			if (ch != ' ') {
				isCharFound = true;
			}
			
			if (isCharFound) {
				if (ch == ' ') {
					charArray[emptyIndex] = '0';
					charArray[emptyIndex-1] = '2';
					charArray[emptyIndex-2] = '%';
					emptyIndex = emptyIndex-3;
				} else {
					charArray[emptyIndex] = charArray[i];
					emptyIndex--;
				}
			}
		}
		return new String(charArray);
	}

	public static void main(String[] args)
	{
		System.out.println(urlify("Mr John Smith    ", 13));
	}

}
