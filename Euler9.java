package net.projecteuler;
/**
 * 
 * @author Brian
 * Project Euler Problem 10 : Special Pythagorean Triplet
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 */
public class SpecialPythagoreanTriplet {
	private static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		System.out.println(triplet());
		long endTime = System.currentTimeMillis();
		System.out.println("Time Completion: " + (endTime-startTime)*.001 + "s");
	}//end of main
/**
 * Traverse a b c to find the pythagorean triplet a^2 + b^2 = c^2 where a+b+c = 1000
 * 
 * @return the product of a b c that equals to 1000
 */
	public static long triplet(){
		int c;
		for(int a=1;a<999;a++){//check a from 1-998
			for(int b=1; b<999-a;b++){//check b from 1 to 998-a since a+b cannot be >1000
				c=1000-a-b;//as a n b increase, c decrease since a+b+c cannot be >1000
				if((a*a + b*b) == c*c){//check if a,b,c is a pythagorean triplet
					return a*b*c;
				}//end of if
			}//end of inner for
		}//end of outer for
		return 0;
	}
}//end of SpecialPythagoreanTriplet class
