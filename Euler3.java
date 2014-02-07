package net.projecteuler;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class LargestPrimeFactor {
	private static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.00");
		String input = JOptionPane.showInputDialog("Enter a num:");
		long num = Long.parseLong(input);
		int check =(int) (Math.sqrt(num));
		int lpf=0;
		for(int i=2; i<check; i++){
			if(num%i==0 && isPrime(i)){
				lpf = i;
			}
		}
		System.out.println(lpf);
		long endTime = System.currentTimeMillis();
		System.out.println("Time completion: " + df.format((endTime-startTime)*.0001) + "s");
	}//main
	
	public static boolean isPrime(int n){
		for(int i=2; i<=n/2; i++)
			if(n%i==0)
				return false;
		return true;
	}//isPrime Method
}//LargestPrimeFactor class
