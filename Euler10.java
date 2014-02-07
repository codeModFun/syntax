package net.projecteuler;
/**
 * 
 * @author Brian
 * Project Euler Problem 10 : Summation of Primes
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 */
public class SummationOfPrimes {
	private static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		long sum=0;
		for(long i=2;i<2000000;i++){
			if(prime(i))
				sum+=i;
		}//end of for
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		System.out.println("Time completion: " + (endTime-startTime)*.001 +"s");
	}//end of main
	//Prime tester
	public static boolean prime(long n){
		long check = (long) Math.sqrt(n);//check for prime number up to square root of n
		for(long i=2; i<=check; i++){
			if(n%i==0)//if divisible by i, then not prime, return false
				return false;
		}
		return true;
	}//end of prime method
}//end of SummationOfPrimes class
