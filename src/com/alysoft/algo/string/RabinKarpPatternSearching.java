package com.alysoft.algo.string;

import java.util.Scanner;

/**
 * Given a string S and a pattern P of lowercase characters. The task is to check if pattern is present in string or not.

Input Format:
First line of input contains number of testcases T. For each testcase, first line of input contains string S and next line contains pattern P.

Output Format:
For each testcase, print "Yes" if pattern is found in the string else print "No".

Your Task:
This is a function problem. You need to complete the function search that returns true if pattern is found else returns false.

Constraints:
1 <= T <= 100
1 <= |S|, |P| <= 103

Example:
Input:
2
aabaacaadaabaaba
aaba
aabaacaadaabaaba
asdfa

Output:
Yes
No

Explanation:
Testcase 1: You can find the patter at starting at index 12.
Testcase 2: Pattern doesn't exists in the given string S.
 
 * @author ymohammad
 *
 */
public class RabinKarpPatternSearching
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- >0)
        {
            String s = "", p = "";
            s = sc.next();
            p = sc.next();
            
            int q = 101;
            
            if(search(p, s, q) == true)
             System.out.println("Yes");
            else
              System.out.println("No");
        }
	}
	static int d= 256;
    
    static boolean search(String pat, String txt, int q)
    {
        int[] patCount = new int[26];
        int[] txtCount = new int[26];
        int txtHash = 0;
        int patHash = 0;
        for (int i=0; i<pat.length(); i++) {
            char ch = pat.charAt(i);
            int x = ch-'a';
            patCount[x]++;
            patHash += (x+1);
            
            ch = txt.charAt(i);
            x = ch-'a';
            txtCount[x]++;
            txtHash += (x+1);
        }
        if (patHash == txtHash) {
            if (isSame(pat, txt, 0)) {
                return true;
            }
        }
        for (int textCharInd = pat.length(); textCharInd<txt.length(); textCharInd++)
        {
            if (patHash == txtHash) {
                if (isSame(pat, txt, textCharInd-pat.length())) {
                    return true;
                }
            }
            char ch = txt.charAt(textCharInd);
            int x = ch-'a';
            txtCount[x]++;
            txtHash += (x+1);
            
            ch = txt.charAt(textCharInd-pat.length());
            x = ch-'a';
            txtHash = txtHash - (x+1);
            txtCount[x]--;
        }
        if (patHash == txtHash) {
            if (isSame(pat, txt, txt.length()-pat.length())) {
                return true;
            }
        }
        return false;
    }
    public static boolean isSame(String pat, String txt, int i) {
        int n = pat.length();
        for (int j = 0; j<n; j++) {
        	if (pat.charAt(j) != txt.charAt(j+i)) return false;
        }
        return true;
    }
    
    //Editorial..
    static boolean search2(String pat, String txt, int q)
    {
            int M = pat.length(); 
	        int N = txt.length(); 
	        int i, j; 
	        int p = 0; // hash value for pattern 
	        int t = 0; // hash value for txt 
	        int h = 1; 

	    // The value of h would be "pow(d, M-1)%q" 
	    for (i = 0; i < M-1; i++) 
		        h = (h*d)%q;

	    // Calculate the hash value of pattern and first 
	    // window of text 
	    for (i = 0; i < M; i++) 
	    { 
		    p = (d*p + pat.charAt(i))%q; 
		    t = (d*t + txt.charAt(i))%q; 
	    } 

	    // Slide the pattern over text one by one 
	    for (i = 0; i <= N - M; i++) 
	    { 

		    // Check the hash values of current window of text 
		    // and pattern. If the hash values match then only 
	    	// check for characters on by one 
		    if ( p == t ) 
		    { 
			    /* Check for characters one by one */
			    for (j = 0; j < M; j++) 
			    { 
				    if (txt.charAt(i+j) != pat.charAt(j)) 
					    break; 
			    } 

			// if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1] 
			if (j == M) 
				return true;
		    } 

		    // Calculate hash value for next window of text: Remove 
		    // leading digit, add trailing digit 
		    if ( i < N-M ) 
		    { 
			    t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q; 

			    // We might get negative value of t, converting it 
			    // to positive 
			    if (t < 0) 
			    t = (t + q); 
		    } 
	    }
	
	return false;
    }
}
