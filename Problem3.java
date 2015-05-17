//Solution for Project Euler problem 3 (projecteuler.net)

//The problem: The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143?

//@author Young Nguyen
public class BiggestPrimeDiv {
	public static void main(String[] args) {
		long n = 600851475143L;
		//start with smallest prime factor larger than 1
		int div = 2;
		//To find the largest prime factor, use the property that any number is composed
		//of prime numbers multiplied (for example, 12 is 2x2x3)
		//If n divides down to 1, we have found the largest factor for n, 
		//and with the property above, that factor is also prime
		while (n > 1) {
			//If n is divisible by div, keep dividing n
			if (n%div==0) {
				n = n/div;
			} else {
				//if n is not divisible by div, increment div
				div++;
				}
		}
		//print out the largest value of div found
		System.out.println("Largest prime factor found: "+div);
	}
}
