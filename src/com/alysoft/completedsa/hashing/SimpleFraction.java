package com.alysoft.completedsa.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a fraction. Convert it into a decimal. So simple :P

eg.
10/2 = 5
3/5 = 0.6

(The Question Begins Now)  :D
If the decimals are repeating recursively, then enclose them inside  ().

eg.
8/3 = 2.(6)

as 8/3 = 2.66666666.......  infinitly.   
 * @author ymohammad
 *
 */
public class SimpleFraction
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = Integer.parseInt(br.readLine().trim());
            int d = Integer.parseInt(br.readLine().trim());
            printFraction(n, d);
            t--;
        }
	}

	public static void printFraction(int num, int dem) {
		int r = num%dem;
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		StringBuffer buff = new StringBuffer();
		if (r == 0) {
			System.out.println(num/dem);
		} else {
			int prevRem = -1;
			int currentQ = -1;
			boolean isDotAdded = false;
			String nonRepeating = "";
			int index = 0;
			while (r != 0) {
				r = num%dem;
				currentQ = num/dem;
				if (r == 0) {
					buff.append(currentQ);
					break;
				} else if (prevRem == r){
					buff.append("("+(currentQ)+")");
					break;
				} else {
					buff.append(currentQ);
				}
				
				if (!isDotAdded) {
					buff.append(".");
					nonRepeating = buff.toString();
					buff = new StringBuffer(); 
					isDotAdded = true;
				}
				prevRem = r;
				num = r*10;

				if (hash.containsKey(r)) {
					int i = hash.get(r);
					StringBuffer nonRepeatBuff = new StringBuffer(nonRepeating);
					for (int x = 0; x<i; x++) {
						nonRepeatBuff.append(buff.charAt(x));
					}
					nonRepeatBuff.append("(" + buff.substring(i) + ")");
					System.out.println(nonRepeatBuff);
					return;
				} else {
					hash.put(r, index);
				}
				index++;
			}
			System.out.println(nonRepeating + buff.toString());
		}
	}
}
