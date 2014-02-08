package net.projecteuler;

import java.math.BigInteger;
/**
 * 
 * @author Brian
 * Project Euler Problem 20 : Factorial Digit Sum
 * n! means n x (n - 1) x ... x 3 x 2 x 1
 * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 */

public class FactorialDigitSum {
	public static void main(String[] args) {
		BigInteger factorial = BigInteger.ONE;
		BigInteger n= new BigInteger("100");//nth factorial
		//populate the nth factorial number and store it in biginteger
		while(!n.equals(BigInteger.ZERO)){
			factorial = factorial.multiply(n);
			n=n.subtract(BigInteger.ONE);
		}//while
		BigInteger modValue=new BigInteger("10");
		BigInteger sum =BigInteger.ZERO;
		//get the remainder of the mod of 10 to add each individual digit, and then divide by 10
		while(!factorial.equals(BigInteger.ZERO)){
			sum=sum.add(factorial.mod(modValue));
			factorial=factorial.divide(modValue);
		}//while
		System.out.println(sum);
	}//main
}//FactorialDigitSum class
