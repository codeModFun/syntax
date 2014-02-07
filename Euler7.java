package net.projecteuler;

import javax.swing.JOptionPane;

public class Prime10001 {
	public static void main(String[] args) {
		long start = 3;
		long counter =1;
		long end = Integer.parseInt(JOptionPane.showInputDialog("Find the nth prime #"));
		long prime=0;
		while(counter<end){
			if(isPrime(start)){
				prime = start;
				counter++;
				}
			start+=2;//check every odd number if it's prime, since even number/2 is not a prime
		}//while
		JOptionPane.showMessageDialog(null, "The "+ counter+"th prime number is "+ prime);
	}//main
	
	public static boolean isPrime(long n){
		long checker = (long) Math.sqrt(n);
		for(long i = 2; i<= checker; i++){
			if(n%i==0)
				return false;
		}//for
		return true;
	}//isPrime
}//main
