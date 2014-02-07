package net.projecteuler;

public class SumSqDiff {
	public static void main(String[] args) {
		long sumOfSq=0;
		long sqOfSum=0;
		for(int i=1; i<=100; i++){
			sumOfSq+=i*i;
			sqOfSum+=i;
		}
		System.out.println((sqOfSum*sqOfSum) - sumOfSq);
	}
}
