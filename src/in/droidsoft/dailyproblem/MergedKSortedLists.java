/*******************************************************************************************************************************
MergedKSortedLists.java

Author : ymohammad
Date   : Aug 3, 2020

Last modified by : ymohammad
Last modified on : Aug 3, 2020

*******************************************************************************************************************************/

package in.droidsoft.dailyproblem;

import java.util.Arrays;

/**
* Class MergedKSortedLists
*/
public class MergedKSortedLists
{
	/**
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public static int[] mergedList(int[] src, int[] dest) {
		
		int[] finalArr = new int[src.length + dest.length];
		int fIndex = 0;
		int sIndex = 0;
		int dIndex = 0;
		
		while (sIndex < src.length && dIndex < dest.length) {
			if (src[sIndex] < dest[dIndex]) {
				finalArr[fIndex] = src[sIndex];
				sIndex++;
				fIndex++;
			} else if (src[sIndex] > dest[dIndex]) {
				finalArr[fIndex] = dest[dIndex];
				fIndex++;
				dIndex++;
			} else {
				finalArr[fIndex] = src[sIndex];
				sIndex++;
				fIndex++;
				finalArr[fIndex] = dest[dIndex];
				dIndex++;
				fIndex++;
			}
		}
		while (sIndex < src.length) {
			finalArr[fIndex] = src[sIndex];
			sIndex++;
			fIndex++;
		}
		while (dIndex < dest.length) {
			finalArr[fIndex] = dest[dIndex];
			fIndex++;
			dIndex++;
		}
		return finalArr;
	}
	public static void main(String[] args) {
		int[][] kSortedArr = {{10, 15, 30}, {12, 15, 20}, {17, 20, 32}};
		int k = kSortedArr.length;
		int[] finalArr = kSortedArr[0];
		for (int i = 1; i < k; i++)
		{
			int[] eachArr = kSortedArr[i];
			finalArr = mergedList(finalArr, eachArr);
		}
		
		System.out.println(Arrays.toString(finalArr));
	}
}
