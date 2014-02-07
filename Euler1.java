package net.projecteuler;

import java.text.DecimalFormat;
import java.util.Stack;

import javax.swing.JOptionPane;
/**
 * 
 * @author Brian
 * Euler Project Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 */

public class Mult3n5 {
	private static long startTime = System.currentTimeMillis();
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		String input = JOptionPane.showInputDialog("Enter a number to find the sum of the multiple of 3,5");
		int num = Integer.parseInt(input);
		for(int i=1; i<num; i++){
			if(i%3==0 || i%5==0){
				s.push(i);
				System.out.print(i+ " ");
			}
		}
		int sum=0;
		System.out.println();
		int size = s.size();
		for(int i=0; i< size; i++){
			sum += (int) s.pop();
		}
		System.out.println("Sum is: " + sum);
		DecimalFormat df = new DecimalFormat("#.00");
		long endTime = System.currentTimeMillis();
		double time = (endTime-startTime)*.001;
		System.out.println("Time: " + df.format(time));
	}
}//main
