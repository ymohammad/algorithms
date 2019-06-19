package com.alysoft.algorithms.hackerrank.interviewkit;

import java.util.Hashtable;
import java.util.Scanner;

public class RansomNote5
{
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> magazineHt = new Hashtable<String, Integer>();
        for (String eachWord: magazine) {
        	if (magazineHt.containsKey(eachWord)) {
        		magazineHt.put(eachWord, magazineHt.get(eachWord) + 1);
        	} else {
        		magazineHt.put(eachWord, 1);
        	}
        }
        
        for (String n : note) {
            if (!magazineHt.containsKey(n) || magazineHt.get(n) <=0) {
                System.out.println("No");
                return;
            } else {
            	//Contains.. then removed it as it is already used.
            	magazineHt.put(n, magazineHt.get(n) - 1);
            }
        }
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
