package net.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 * @author Brian
 * Project Euler Problem 18 : Maximum Path Sum 1
 * 
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * *Note* : this method uses the bottom up traversal since the time complexity is shorter - 0(n^2) oppose to 0(2^n)
 */
public class MaximumPathSum1 {
	public static void main(String[] args) throws IOException {
		FileReader inFile = new FileReader("triangle1.txt");
		BufferedReader in = new BufferedReader(inFile);
		String line;
		String[] temp;
		int[][] array = new int[15][15];
		int row=0;
		//Storing the data of information given into an integer array
		while((line=in.readLine()) !=null){
			temp = line.split(" ");
			for(int col=0; col<temp.length; col++)
				array[row][col]= Integer.parseInt(temp[col]);
			row++;
		}//while
		//Traverse from the last row of the array, adding the highest sum with the previous row
		//until you reach location [0][0] in array.
		for(int i=row-1; i>=0; i--){
			for(int j=0;j<i;j++){
				if(array[i][j] + array[i-1][j] > array[i][j+1]+ array[i-1][j])
					array[i-1][j]=array[i][j]+array[i-1][j];
				else
					array[i-1][j]=array[i][j+1]+array[i-1][j];
			}//inner for
		}//outer for
		System.out.println(array[0][0]);
	}//main
}//triangle class
