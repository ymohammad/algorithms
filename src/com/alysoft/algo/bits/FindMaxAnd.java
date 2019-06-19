package com.alysoft.algo.bits;

public class FindMaxAnd
{
	 // Utility function to check number of elements
    // having set msb as of pattern
    public static int checkBit(int pattern, int arr[], int n) {
        int count = 0;
        for (int i = 0; i < n; i++){
            if ((pattern & arr[i]) == pattern){
                count++;
            }
        }
        return count;
    }
    
    // Function for finding maximum and value pair
    public static int maxAND (int arr[], int n) {
        int res = 0, count;
        // iterate over total of 30bits from msb to lsb
        for (int bit = 31; bit >= 0; bit--) {
            // find the count of element having set  msb
            count = checkBit(res | (1 << bit), arr, n);
            // if count >= 2 set particular bit in result
            if( count >= 2 ){
                res |= (1 << bit);
            }
        }
        return res;
    }
    
    public static int maxAND2 (int arr[], int n) {
        
        int maxVal = 0;
        for (int i=0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                int val = arr[i]&arr[j];
                maxVal = Math.max(maxVal, val);
            }
        }
        return maxVal;
         
     }
    public static void main(String[] args) {
    	//System.out.println(fun(5));
    	//get(6);
    	//System.out.println(count);
    	//count(3);
    	System.out.println(foo(513, 2));
    }
    static int count = 0;
    public static void get (int n)
    {
    	count++;
       if (n < 1) return;
       get(n-1);
       get(n-3);
       //System.out.println(n);
       
    }
    public static int fun (int n)
    {
      int x=1, k;
      if (n==1) return x;
      for (k=1; k<n; ++k)
         x = x + fun(k) * fun(n-k);
      return x;
    }
    public static void count(int n)
    {
        int d = 1;
        printf("%d ", n);
        printf("%d ", d);
        d++;
        if(n > 1) count(n-1);
        printf("%d ", d);
    }
    
    
    public static void printf(String f, int x) {
    	System.out.print(x + " ");
    }
    public static int foo(int n, int r) {
	  if (n  > 0) return (n%r +  foo (n/r, r ));
	  else return 0;
	}
}
