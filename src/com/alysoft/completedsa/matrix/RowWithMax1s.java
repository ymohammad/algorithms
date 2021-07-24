package com.alysoft.completedsa.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RowWithMax1s
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        while (t > 0)
        {
        	String line=null;
        	while (line == null || line.trim().length()==0) {
        		line = br.readLine();
            }
        	String[] arrayValues = line.trim().split(" ");
        	int n = Integer.parseInt(arrayValues[0].trim());
            int m = Integer.parseInt(arrayValues[1].trim());
            
            int[][] booleanArr = new int[n][m];
            for (int a = 0; a<n; a++) {
            	line = br.readLine();;
            	arrayValues = line.trim().split(" ");
            	if (arrayValues.length == (m*n)) {
            		prepareSingleLineArray(arrayValues, booleanArr, n, m);
            		break;
            	}
            	int k=0;
            	for (int j = 0; j<m; j++) {
            		booleanArr[a][j] = Integer.parseInt(arrayValues[k]);
            		k++;
            	}
            }
            
            printMax1sRow(booleanArr, n, m);
            t--;
        }
	}
	public static void prepareSingleLineArray (String[] line, int[][] arr, int n, int m) {
		int k=0;
		for (int a = 0; a<n; a++) {
        	for (int j = 0; j<m; j++) {
        		arr[a][j] = Integer.parseInt(line[k]);
        		k++;
        	}
        }
	}
	private static void printMax1sRow(int[][] booleanArr, int n, int m)
	{
		int rowIndex = 0;
		int maxNumOf1s = 0;
		int maxRowIndex = -1;
		while (rowIndex < n) {
			int noOf1s = get1sCount(booleanArr[rowIndex], 0, m-1);
			if (noOf1s != -1 && noOf1s > maxNumOf1s) {
				maxNumOf1s = noOf1s;
				maxRowIndex = rowIndex;
			}
			rowIndex++;
		}
		System.out.println(maxRowIndex);
	}
	private static int get1sCount(int[] arr, int low, int high)
	{
		if (low > high) return -1;
		
		if (low == 0 && arr[low] == 1) return arr.length;
		
		if (low == 0 && arr[low] == 1) {
			return arr.length;
		}
		int mid = (low+high)/2;
		if (arr[mid] == 0) {
			return get1sCount(arr, mid+1, high);
		} else if(arr[mid] == 1 && arr[mid-1] == 1)  {
			return get1sCount(arr, low, mid-1);
		} else if (arr[mid] == 1 && arr[mid-1] == 0) {
			return (arr.length-1-mid)+1;
		}
		
		return -1;
	}
}
