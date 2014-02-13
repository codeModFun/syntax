package net.projecteuler;
/**
 * 
 * @author Brian
 * Project Euler Problem 5: Smallest Multipe
 * 2520 is the smallest number that can be divided by each of the numbers 
 * from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the 
 * numbers from 1 to 20?
 *
 */
public class SmallestMultiple {
	private static long startTime=System.currentTimeMillis();
	public static void main(String args[]) {
        int[] numbers = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 };
        
        int lcm = lcm(numbers[0], numbers[1]);
        for (int i = 2; i < numbers.length; i++)
            lcm = lcm(lcm, numbers[i]);
        System.out.println(lcm);
        long endTime = System.currentTimeMillis();
        System.out.println("Time Completion: " + (endTime-startTime)*.001 + "s");
	}
/**
 * Accepts 2 numbers and find the lowest common multiple between two numbers
 * 
 * @param n1	First integer to compare
 * @param n2	Second integer to compare
 * @return		the lowest common multiple of the 2 numbers
 */
 
	public static int lcm(int n1, int n2) {
        return n1 * n2 / (gcd(n1, n2));
	}//lcm method
 
/**
 * Accepts 2 numbers and find the greatest common divisor between two numbers
 * 
 * @param n1	First integer to compare
 * @param n2	Second integer to compare
 * @return		the greatest common divisor of the 2 numbers
 */
	public static int gcd(int n1, int n2) {
        return (n2 == 0) ? n1 : gcd(n2, n1 % n2);
	}//gcd method
 
}//Smallest Multiple class
