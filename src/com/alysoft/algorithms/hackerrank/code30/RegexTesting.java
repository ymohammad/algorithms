package com.alysoft.algorithms.hackerrank.code30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTesting {

	public static void main(String[] args) {
        String myRegExString = ".[@gmail.com]$";
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(myRegExString);
        for(int a0 = 0; a0 < N; a0++){
            String firstName = in.next();
            String emailID = in.next();
            Matcher m = p.matcher(emailID);
            if (m.find()) {
            	System.out.println("Found :" + m.group());
                list.add(firstName);
            }
        }
        Collections.sort(list);
        for(String s: list) {
            System.out.println(s);
        }
    }
}
