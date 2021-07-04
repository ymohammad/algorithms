package com.alysoft.algorithms.hackerrank.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DyanamicArray {

	/**
	 * https://www.hackerrank.com/challenges/dynamic-array/problem
	 * @param args
	 */
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        //System.out.println("N got " + n);
        //System.out.println("Q got " + q);
        int[][] seqList = new int[n][n];
        for(int x = 0; x< n; x++) {
        	int[] is = seqList[x];
            Arrays.fill(is, -1);
        }
        //System.arraycopy(src, srcPos, dest, destPos, length);()
        int lastAnswer = 0;
        in.nextLine();
        ArrayList<String> queriesList = new ArrayList<String>();
        for(int a0 = 0; a0 < q; a0++){
        	queriesList.add(in.nextLine());
        }
        for (String line : queriesList) {
            System.out.println("Each Line :" + line);
            String[] eachQrArr = line.split(" ");
            int x = Integer.valueOf(eachQrArr[1]);
            int y = Integer.valueOf(eachQrArr[2]);
            int seqInd = getSequenceIndex(x, lastAnswer, n);
            int[] seq = seqList[seqInd];
            if (eachQrArr[0].equals("1")) {
                 addToArray(seq, y);
            } else if (eachQrArr[0].equals("2")) {
            	System.out.println("seqInd ::" + seqInd + " seq ::" + seq + " >> getLogicalArrSize(seq)::" + getLogicalArrSize(seq));
                int ind = y%getLogicalArrSize(seq);
                lastAnswer = seq[ind];
                System.out.println(lastAnswer);
            }
            //printListItems(seqList);
        }
    }
    private static void printListItems(ArrayList<int[]> seqList) {
    	for (int i = 0; i < seqList.size(); i++) {
			int[] eachArr = seqList.get(i);
			System.out.print("For Index :" + i + " = ");
			for(int x: eachArr) {
				System.out.print(x + ", ");
			}
			System.out.println();
		}
    	System.out.println("\n\n");
	}
/*	public static int[] getSeqFromList(int[][] seqList, int seqInd, int s) {
    	System.out.println("seqInd " + seqInd + " >> seqList::");
        int[] seq = seqList[seqInd];
        if (seqList[seqInd] != 0) {
            seq = seqList[seqInd];
        }
        
        if (seq == null) {
        	System.out.println("Creating new array " + seqInd);
            seq = new int[s];
            Arrays.fill(seq, -1);
            seqList.add(seqInd, seq);
        }
        
        return seq;
    }*/
    public static int getLogicalArrSize(int[] arr) {
    	int returnSize = 0;
        for (int x =0; x< arr.length; x++) {
            if (arr[x] == -1) {
                break;
            }
            returnSize++;
        }
        return returnSize;
    }
    public static void addToArray(int[] arr, int value) {
        for (int x =0; x< arr.length; x++) {
            if (arr[x] == -1) {
                arr[x] = value;
                break;
            }
        }
    }
    public static int getSequenceIndex(int x, int lastAnswer, int n) {
        return ((x ^ lastAnswer) % n);
    }
    
    
    
    /// Implementation by other Member.. amazing code.
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok = null;

    public static void impl(String[] args) {
        int last = 0, x, y;
        int n = getInt(), q = getInt(), cmd, c, len;
        int[][] A = new int[n][];
        int[] tmp;
        for(int k = 0; k < q; ++k) {
            cmd = getInt();
            x = getInt();
            y = getInt();
            c = (x^last) % n;
            switch(cmd) {
                case 1:
                    if(A[c] == null)
                        len = 1;
                    else
                        len = A[c].length + 1;
                    tmp = new int[len];
                    if(A[c] != null)
                        System.arraycopy(A[c], 0, tmp, 0, A[c].length);
                    tmp[tmp.length-1] = y;
                    A[c] = tmp;
                    break;
                case 2:
                    System.out.println(last = A[c][y % A[c].length]);
            }
        }
    }

    static String gets() throws IOException{
        if(tok == null || !tok.hasMoreTokens())
            tok = new StringTokenizer(br.readLine());
        return tok.nextToken();
    }

    static int getInt() {
        try {
            return Integer.parseInt(gets());
        } catch(IOException | NumberFormatException e) {
            return -1;
        }
    }
}
