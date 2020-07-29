package com.alysoft.algo.context2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given a matrix Mat of m rows and n columns. The matrix is boolean so the elements of the matrix can only be either 0 or 1.
Now, if any row of the matrix contains a 1, then you need to fill that whole row with 1. After doing the mentioned operation, 
you need to print the modified matrix.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow.
The first line of each testcase contains m and n denoting number of rows and number of columns.
Then next m lines contain n elements denoting the elements of the matrix.

Output:
For each testcase, in a new line, print the modified matrix.

Constraints:
1 <= T <= 100
1 <= m, n <= 900
Matij ∈ {0,1}

Examples:
Input:
2
5 4
1 0 0 0
0 0 0 0
0 1 0 0
0 0 0 0
0 0 0 1
1 2
0 0
Output:
1 1 1 1
0 0 0 0
1 1 1 1
0 0 0 0
1 1 1 1
0 0

Explanation:
Testcase1: rows = 5 and columns = 4
The given matrix is
1 0 0 0
0 0 0 0
0 1 0 0
0 0 0 0
0 0 0 1
Evidently, the first row contains a 1 so fill the whole row with 1. The third row also contains a 1 so that row will be filled too. 
Finally, the last row contains a 1 and therefore it needs to be filled with 1 too.
The final matrix is
1 1 1 1
0 0 0 0
1 1 1 1
0 0 0 0
1 1 1 1


 * @author ymohammad
 *
 */
public class BooleanMatrix
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            String line = br.readLine();
            String[] arrayValues = line.trim().split(" ");
            int m = Integer.parseInt(arrayValues[0].trim());
            int n = Integer.parseInt(arrayValues[1].trim());
           
            int[][] arr = new int[m][n];
            for (int i = 0; i<m; i++) {
            	 line = br.readLine();
                 arrayValues = line.trim().split(" ");
                 int j = 0;
     			for (String s: arrayValues) {
     			    if (s != null && s.trim().length() > 0) {
     			        arr[i][j]= Integer.parseInt(s.trim());
     			        j++;
     			    }
     			}
            }
            
            printBooleanArray(m, n, arr);
            t--;
        }
	}

	private static void printBooleanArray(int m, int n, int[][] arr)
	{
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i<m; i++) {
			int[] rowArr = arr[i];
			changeIfOneExist(rowArr, buff);
		}
		System.out.println(buff);
		
		
		/*for (int i = 0; i<n; i++) {
			for (int j=0; j<m; j++) {
				
			}
		}*/
	}

	private static void changeIfOneExist(int[] rowArr, StringBuffer buff)
	{
		boolean isOneExist = false;
		StringBuffer localBuff = new StringBuffer();
		int n = rowArr.length;
		for (int i = 0; i<n; i++) {
			if (rowArr[i] == 1) {
				isOneExist = true;
				break;
			}
			localBuff.append(rowArr[i] + " ");
		}
		if (isOneExist) {
			for (int i = 0; i<n; i++) {
				buff.append(1 + " ");
			}
		} else {
			buff.append(localBuff);
		}
		buff.append("\n");
	}
}
