//Solution for Project Euler problem 4 (projecteuler.net)

//The problem: A palindromic number reads the same both ways. 
//The largest palindrome made from the product of two 2-digit numbers 
//is 9009 = 91 × 99.
//Find the largest palindrome made from the product of two 3-digit numbers.

//@author Young Nguyen

public class LargestPalindrome {
	
	//method to check for palindrome; implemented recursively
	public static boolean isPalindrome (String ps) {
		boolean result = false;
		//if string is empty or has one character, it's a palindrome
		if (ps.length()==0 || ps.length()==1) {
			result = true;
		} else {
			//if first and last character matches, recursively check the string 
			//without first and last character
			if (ps.charAt(0)==ps.charAt(ps.length()-1)) {
				result = isPalindrome(ps.substring(1, ps.length()-1));
			}
		}
		return result;
	}
	
	//Check for the largest factor of a number that has 3 digits
	public static int largest3dFactor (int p) {
		int result=1;
		//decrementing from 999 to 100 ensures the factor found has 3 digits
		for (int i=999;i>100; i--) {
			//if the remainder is 0, we found a factor
			if (p%i==0) {
				result = i;
				break;
			}
		}
		return result;
	}
	
	public static void main (String[] args) {
		int f1 = 0;
		int f2 = 0;
		//decrementing from 999,999 to 100,000 ensures the number has 6 digits,
		//which is the maximum for a product of 2 3-digit numbers
		for (int i=999999; i>100000;i--) {
			String is = Integer.toString(i);
			//proceed with factorization if the number is a palindrome
			if (isPalindrome(is)) {
				//find the first largest 3-digit factor
				f1 = largest3dFactor(i);
				//get the 2nd 3-digit factor by dividing i by f1 
				f2 = i/f1;
				//final check: if f1 and f2 has 3 digits, we're done!
				if (Integer.toString(f1).length()==3 & Integer.toString(f2).length()==3) {
					break;
				}
			}
		}
		
		//print out f1 and f2
		System.out.println(f1);
		System.out.println(f2);
	}

}
