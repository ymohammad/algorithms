package com.alysoft.codechef.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * There are 100 houses located on a straight line. The first house is numbered 1 and the last one is numbered 100. 
 * Some M houses out of these 100 are occupied by cops.

	Thief Devu has just stolen PeePee's bag and is looking for a house to hide in.
	
	PeePee uses fast 4G Internet and sends the message to all the cops that a thief named Devu has just 
	stolen her bag and ran into some house.
	
	Devu knows that the cops run at a maximum speed of x houses per minute in a straight line and they will search 
	for a maximum of y minutes. Devu wants to know how many houses are safe for him to escape from the cops. 
	Help him in getting this information.
	
	Input
	First line contains T, the number of test cases to follow.
	
	First line of each test case contains 3 space separated integers: M, x and y.
	
	For each test case, the second line contains M space separated integers which represent the house numbers where the cops are residing.
	
	Output
	For each test case, output a single line containing the number of houses which are safe to hide from cops.


 * Example
	Input:
	3
	4 7 8
	12 52 56 8
	2 10 2
	21 75
	2 5 8
	10 51
	
	Output:
	0
	18
	9
 * 
 * Explanation
	Example 1 : Cops in house 12 can cover houses 1 to 68, and cops in house 52 can cover the rest of the houses. 
	So, there is no safe house.

	Example 2 : Cops in house 21 can cover houses 1 to 41, and cops in house 75 can cover houses 55 to 95, 
	leaving houses numbered 42 to 54, and 96 to 100 safe. So, in total 18 houses are safe.
 * @author ymohammad
 *
 */
public class CopsThiefDevu
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eachLine;
		while ((eachLine = br.readLine()) != null) {
			int t = Integer.parseInt(eachLine.trim());
			 
	        // One by one run for all input test cases
	        while (t > 0)
	        {
	        	
	        	String str = br.readLine();
	        	String[] lineSplit = str.split(" ");
	        	int noOfCops = Integer.parseInt(lineSplit[0].trim());
	        	int ratOfSearch = Integer.parseInt(lineSplit[1].trim());
	        	int searchTime = Integer.parseInt(lineSplit[2].trim());
	        	
	        	
	        	int[] copsHousesArr = new int[noOfCops];
	        	str = br.readLine();
	        	lineSplit = str.split(" ");
	        	int i = 0;
	        	for (String s : lineSplit) {
	        		if (s != null && s.trim().length()>0) {
	        			copsHousesArr[i] = Integer.parseInt(s.trim());
	        			i++;
	        		}
	        	}
	        	int safeHousesCount = getSafeHouseCountToHide(copsHousesArr, ratOfSearch, searchTime);
	        	System.out.println(safeHousesCount);
	            t--;
	        }
	        break;
		}
	}

	private static int getSafeHouseCountToHide(int[] copsHousesArr, int rateOfSearch, int searchTime)
	{
		int noOfHouseSearch = rateOfSearch*searchTime;
		if (noOfHouseSearch >= 100) return 0;
		
		Arrays.sort(copsHousesArr);
		
		int[] limitsArray = new int[copsHousesArr.length*2];
		int i=0;
		for (int x: copsHousesArr) {
			limitsArray[i] = (x-noOfHouseSearch);
			i++;
			limitsArray[i] = (x+noOfHouseSearch);
			i++;
		}
		int safeHouseCount = 0;
		
		int n = limitsArray.length;
		if (limitsArray[0] > 1) {
			safeHouseCount += (limitsArray[0]-1);
		}
		int j = 1;
		while (j<n-1) {
			if (limitsArray[j] <  limitsArray[j+1]) {
				safeHouseCount += (limitsArray[j+1]-limitsArray[j]-1);
			}
			j = j+2;
		}
		
		if (limitsArray[n-1] < 100) {
			safeHouseCount += (100-limitsArray[n-1]);
		}
		return safeHouseCount;
	}
}
