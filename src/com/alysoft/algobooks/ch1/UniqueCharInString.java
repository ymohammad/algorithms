package com.alysoft.algobooks.ch1;

public class UniqueCharInString
{
	
	public static boolean bruteFourceIsUniqueChar(String str) {
		if (str == null || !str.isEmpty()) {
			return false;
		}
		
		for (int x=0; x<str.length(); x++) {
			for (int y=x+1; y<str.length(); y++) {
				if (str.charAt(x) == str.charAt(y)) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		//System.out.println("Is Unique MNASIN" + bruteFourceIsUniqueChar("MNASIN"));
		
		byte b = (byte)128;
		System.out.println("Bytel value is " + b);
	}

}
