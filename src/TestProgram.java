import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;


public class TestProgram {

	public static void main(String[] args) {
		//testInternMethod();
		//deepCopyTesting();
		//testMultiply(44917, 100000);
		//testArrays();
		//pushTest();
		testModulus();
	}
	public static void testModulus() {
		long x = 72057594037927936L;
		long y = x%60L;
		
		int z = (int)x%60;
		System.out.println(Math.pow(2,  50));
		
	}
	public static void pushTest() {
		Stack<Character> stack = new Stack<>();
		stack.push('a');
		stack.pop();
		stack.push('b');
		stack.push('c');
		stack.pop();
		stack.push('d'); stack.pop();stack.pop(); stack.push ('e');
		System.out.println(stack);
	}
	public static void testArrays() {
		int[] a = new int[10];
		int[][] b = new int[5][10];
		int[] is = b[0];
		System.out.println("Length :" + a.length);
		System.out.println("is length :" + is.length + " >> is[1]" + is[1]);
	}
	public static void testMultiply(long a, long b) {
		System.out.println("Multiply::" + (a*b));
	}
	public static void deepCopyTesting() {
		//Vector Deep Copy testing..
		Vector<Integer> vec1 = new Vector<Integer>();
		vec1.add(2);
		vec1.add(3);
		vec1.add(4);
		
		Vector<Integer> vec2 = (Vector<Integer>) vec1.clone();
		vec2.add(5);
		vec2.add(6);
		
		System.out.println("Vector 1" + vec1);
		System.out.println("Vector 2" + vec2);
	}
    public static void testInternMethod() {
        String s1 = "Test";
        String s2 = "Test";
        String s3 = new String("Test");
        final String s4 = s3.intern();
        System.out.println(s1 == s2); //true
        System.out.println(s2 == s3); //false
        System.out.println(s3 == s4); //false
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //true
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s3.equals(s4));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s3));
    }
    
    
	public static void main2 (String[] args)
	 {
	    // Input the number of test cases you want to run
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();

       // One by one run for all input test cases
       while (t > 0)
       {
           // Input the size of the array
           int n = sc.nextInt();

           String value = Integer.toString(n);
           int result = getCube(value.charAt(0)) + getCube(value.charAt(1)) + getCube(value.charAt(2));
           
           if (result == n) {
               System.out.println("Yes");
           } else {
               System.out.println("No");
           }
           t--;
       }
	 }
	 public static int getCube(char ch) {
	     return (int)Math.pow(Double.valueOf(ch+".0"), 3);
	 }
	 
	 public static void main3 (String[] args)
	 {
		 System.out.println("value :" + Math.pow(2, 8));
	    // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            double a = sc.nextInt();
            double b = sc.nextInt();
            int n = sc.nextInt();
 
            double r = b/a;
            System.out.println("R value :" + r);
            int result = (int)Math.floor(a * (Math.pow(r, (double)(n-1))));
            System.out.println(result);
            
            t--;
        }
	 }
	 
	 public static void main4 (String[] args)
	 {
	    // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Math.sqrt(t);
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = sc.nextInt();
 
            int convertedNumber = Integer.parseInt(Integer.toString(n), 2);
 
            // Compute and print result
            System.out.println(convertedNumber);
 
            t--;
        }
	 }

	 
	 public static void main1 (String[] args)
	 {
		 findPrime();
	 }
	 public static void findPrime ()
	 {
	    // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println ("No");
                return;
            }
            int sqrt = (int)Math.sqrt(n);
            
            while (sqrt > 1) {
                if (n%sqrt == 0) {
                    System.out.println("No");
                    return;
                }
                sqrt--;
            }
 
            System.out.println("Yes");
 
            t--;
        }
	 }
}
