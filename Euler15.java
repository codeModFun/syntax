package net.projecteuler;
/**
 * 
 * @author Brian
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, 
 * there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 */
public class LatticePaths {
	public static void main(String[] args) {
		int gridSize = 20;
		long numOfPath = 1;
		for(int i=0; i<gridSize; i++){
			numOfPath = numOfPath * (2*gridSize-i)/(i+1);//Combination 2n choose k = (2n - (k-1)) /k
		}
		System.out.println(numOfPath);
	}
}//class
