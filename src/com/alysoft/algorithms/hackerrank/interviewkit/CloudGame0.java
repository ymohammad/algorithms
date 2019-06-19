package com.alysoft.algorithms.hackerrank.interviewkit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 * 
 * For each game, Emma will get an array of clouds numbered  if they are safe or  if they must be avoided. 
 * For example, [0, 1, 0, 0, 0, 1, 0] indexed from . The number on each cloud is its index in the 
 * list so she must avoid the clouds at indexes  and . She could follow the following two paths:  or . 
 * The first path takes 3 jumps while the second takes 4.
 * @author ymohammad
 */
public class CloudGame0
{
	private static final Scanner scanner = new Scanner(System.in);
	
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int minPaths = 0;
        int jumpIndex = 0;
        
        if (c[0] == 1) return 0;
        
        while (jumpIndex<c.length) {
            if ((jumpIndex+2) < c.length && c[jumpIndex+2] == 0) {
            	minPaths++;
            	jumpIndex = jumpIndex + 2;
            } else if ((jumpIndex+1) < c.length && c[jumpIndex+1] == 0) {
            	minPaths++;
            	jumpIndex++;
            } else {
            	//We are at the end of the cloud.
            	break;
            }
        }
        return minPaths;

    }
	public static void main(String[] args) throws IOException
	{
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }
        int result = jumpingOnClouds(c);
        System.out.println(result);
        scanner.close();
	}

}
