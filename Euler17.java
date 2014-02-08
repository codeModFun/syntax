package net.projecteuler;
/**
 * 
 * @author Brian
 * Project Euler Problem 17 : Number Letter Counts
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
 * The use of "and" when writing out numbers is in compliance with British usage.
 */
public class NumberLetterCounts {
		static String[] singles = { "", "one", "two", "three","four","five","six","seven","eight", "nine"};
		static String[] doubles = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen","sixteen", "seventeen","eighteen","nineteen" };
		static String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty","seventy", "eighty", "ninety"};
	
	public static void main(String[] args) {
		String answer = "";
		for(int i=1; i<=1000; i++){ 
			if (i<100)//generate 1-99
				answer+=doubleDigits(i);
			else if(i<1000){//generate 100-999
				answer+=doubleDigits(i/100 %10) + "hundred";
				if(i%100!=0)//check if there's a remainder after dividing by 100 to append 1-99 at end
					answer+="and"+doubleDigits(i%100);
			}
			else
				answer+= "onethousand";
		}
		System.out.println(answer.length());
	}//end of main
	
	public static String doubleDigits(int n){
		if(n<10)
			return singles[n];
		else if(n<20)
			return doubles[n-10];
		else
			return tens[n/10 -2] + doubleDigits(n%10);
	}//doubleDigits method
}//NumberLetterCounts class
