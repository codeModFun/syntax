package net.projecteuler;

import java.math.BigInteger;
/**
 * 
 * @author Brian
 * Project Euler Problem 16 : Power Digit Sum
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 * 
 */
public class PowerDigitSum {
	public static void main(String[] args) {
		BigInteger digit = new BigInteger("2");
		BigInteger modValue= new BigInteger("10");
		digit=digit.pow(1000);
		BigInteger answer=BigInteger.ZERO;
		while(digit.compareTo(BigInteger.ZERO)>0){//terminate if digit is equal to zero
			System.out.println(digit.compareTo(BigInteger.ZERO));
			answer  =answer.add( digit.mod(modValue));//mod 10 to get last digit and add to answer
			digit = digit.divide(modValue);//remove the last digit
		}//while
		System.out.println(answer);
	}//main
}// PowerDigitSum class
