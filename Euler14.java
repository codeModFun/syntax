package net.projecteuler;
/**
 * 
 * @author Brian
 * Project Euler Problem 14 : Longest Collatz Sequence
 * The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 */
public class LongestCollatzSequence {
	private static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		long biggestSequenceLength=0;
		long biggestSequenceNumber=0;
		long test=0;
		
		for(int i=2; i<1000000; i++){
			int count=1;
			test=i;
			while(test!=1){
				if(test%2==0){
					test=test/2;
				}else{
					test=test*3 +1;
				}//else
				count++;
			}//while
			if(count>biggestSequenceLength){
				biggestSequenceLength=count;
				biggestSequenceNumber=i;
			}//if
		}//for
		System.out.println(biggestSequenceNumber);
		long endTime = System.currentTimeMillis();
		System.out.println("Time Completion: " + (endTime-startTime)*.001 +"s");
	}//main
}//class
