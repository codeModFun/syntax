package net.projecteuler;
/**
 * 
 * @author Brian
 * Project: Euler #4
 * A palindromic number reads the same both ways. The largest palindrome made from 
 * the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 */
public class LargestPalindromeProduct {
	public static void main(String[] args) {
		int num = 999;
		int largest=0;
		int answer = 0;
		for(int i=0; i<num; i++){
			for(int j=0;j<num;j++){
				largest=(num-i)*(num-j);
				if(isPalindrome(largest)){
					if(largest>answer){
						answer=largest;
					}
				}
			}
		}
		System.out.println(answer);
	}
	public static boolean isPalindrome(int n){
		int number=n;
		int reversedNumber = 0;
		while(number>0){
			reversedNumber=reversedNumber*10 + number%10;
			number=number/10;
		}
		if(reversedNumber==n){
			return true;
		}
		return false;
	}
}
