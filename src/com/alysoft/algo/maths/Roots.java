package com.alysoft.algo.maths;

public class Roots
{
	public static void main(String[] args) {
		double a = 1d;
		double b = 2*(1.73);
		double c = 3d;
		System.out.println(">>> :" + getRoots(a, b, c));
		
		b = 2*(2.24);
		System.out.println(">>> :" + getRoots(a, b, c));
		
		b = 2*(4.22);
		System.out.println(">>> :" + getRoots(a, b, c));
		
		b = 2*(3.42);
		a = 752; 
		b = 904;
		c = 164;
		System.out.println(">>> :" + getRoots(a, b, c));
		System.out.println(f(11));
		System.out.println(345%10);
		System.out.println(foo(513, 2));
	}
	public static double getRoots(double a, double b, double c) {
		double d = b*b-4*a*c;
		if (d < 0) return -1;
		
		System.out.println(">> Real Root :" + d);
		double x = -b+Math.sqrt(d);
		double r = 2*a;
		x = x/r;
		System.out.println("Roots.getRoots() x1 :" + x);
		
		x = -b-Math.sqrt(d);
		r = 2*a;
		x = x/r;
		System.out.println("Roots.getRoots() x2 :" + x);
		
		return x;
	}
	public static int f(int n)
	{
	    if(n <= 1)
	        return 1;
	    if(n%2 == 0)
	        return f(n/2);
	    return f(n/2) + f(n/2+1);
	}
	public static int foo(int n, int r) {
		  if (n  > 0) return (n%r +  foo (n/r, r ));
		  else return 0;
		}
}
