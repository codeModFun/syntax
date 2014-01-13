
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.String;
import java.util.StringTokenizer;
/**
 * 
 * @author Brian Thanh Khuu
 * Project 1 - Genetics Algorithm Partition - Brute Force
 *
 */
public class partitionBrute {
	static int it;
	static int[] solutionArray0;
	static int[] solutionArray1;
	static int solutionSum0;
	static int solutionSum1;
	static int solution0Counter;
	static int solution1Counter;
	static int location;
	static int[] input;
/**
 * Main class to read from file, and calculate the partition answer by permutation and
 * display the result.
 * 	
 * @param args			args[0] is the input file	args[1] is the output file
 * @throws IOException	throws a no file found exception if there's no file
 */
	public static void main(String[] args) throws IOException{
		PrintStream out = new PrintStream(new FileOutputStream(args[1]));
		System.setOut(out);//converts system.out message from console to output source file
		readFile(args[0]);//read from file
		permutate("", input.length, input);//permutate function
		
		//display the result of answer
		if(solutionArray0!=null && solutionArray1!=null){
			System.out.println("Solution Found at Iteration " + location);
			System.out.print("Set 0: {");
	    	for(int i=0; i<solution0Counter;i++){
	    		System.out.print(" " + solutionArray0[i]);
	    	}
	    	System.out.println(" } Sum = " + solutionSum0);
	    	System.out.print("Set 1: {");
	    	for(int i=0; i<solution1Counter;i++){
	    		System.out.print(" " + solutionArray1[i]);
	    	}
	    	System.out.println(" } Sum = " + solutionSum1);
		}//end of if
		else
			System.out.println("No Solution");
	}//End of Main 
/**
 * this is the read from text file method, it will read from the text file one line at a time
 * and store the value into an integer array
 * 
 * @param fileName		the input source file
 * @throws IOException	if there are no files, throws an no file error
 */
	public static void readFile(String fileName) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String line = "";
		while((line= in.readLine()) != null){//terminate if there is no more line to read
			String[] inputArray=line.split(" ");//split the line data
			int lengthOfInputArray=inputArray.length;//the length of the array
			input=new int[lengthOfInputArray];//dynamically create the input array
			for(int i=0; i<lengthOfInputArray; i++){//store the data to another array of integers
				input[i]=Integer.parseInt(inputArray[i]);
			}//end of for
		}//end of while
	}//End of readFile
/**
 * This function will permutate the brute force algorithm method of all available binary string
 * possibilities and determine which solution would supply the answer that is equal to each other
 * 	
 * @param binaryString	the binaryString representation of the integer array
 * @param iterations	the number of iterations that is completed at the time
 * @param inputArray	the input array of actual data information
 */
	public static void permutate(String binaryString, int iterations, int[] inputArray) {
	    if(iterations == 0) {//when iterations length is 0, 1 permutation binarystring is complete
	    	it++;//count the number of completed iterations of results
	    	System.out.println("Iteration: "+ it);
	    	int[] sumArray0 = new int[inputArray.length]; //create the length to calculate sum array0
	    	int s0Counter=0,s1Counter=0;
	    	int sumOfArray0=0,sumOfArray1=0;
	    	int[] sumArray1 = new int[inputArray.length];//create the length to calculate sum array1
	    	//if number at location i is 0, store the number into the sumArray0, else store at sumArray1
	    	for(int i=0;i<inputArray.length;i++){ 
	    		int s = binaryString.charAt(i)-48;
	    		if(s==0){
	    			sumArray0[s0Counter]=inputArray[i];
	    			sumOfArray0+=inputArray[i];//calculate sum
	    			s0Counter++;//count the element in array0
	    		}//end of if
	    		else{
	    			sumArray1[s1Counter]=inputArray[i];
	    			sumOfArray1 += inputArray[i];//calculate sum
	    			s1Counter++;//count the element in the array1
	    		}//end of else
	    	}//end of for
	    	//print the results of the find
	    	System.out.print("Set 0: {");
	    	for(int i=0; i<s0Counter;i++){
	    		System.out.print(" " + sumArray0[i]);
	    	}//end of for
	    	System.out.println(" } Sum = " + sumOfArray0);
	    	System.out.print("Set 1: {");
	    	for(int i=0; i<s1Counter;i++){
	    		System.out.print(" " + sumArray1[i]);
	    	}//end of for
	    	System.out.println(" } Sum = " + sumOfArray1);
	    	//store the elements to a global saving location to be printed out later if necessary
	    	if(sumOfArray0==sumOfArray1){
	    		solutionArray0 = sumArray0;
	    		solutionArray1 = sumArray1;
	    		solutionSum0 = sumOfArray0;
	    		solutionSum1 = sumOfArray1;
	    		solution0Counter = s0Counter;
	    		solution1Counter = s1Counter;
	    		location = it;
	    	}//end of if
	    	System.out.println();
	    }//end of if
	    else {
	    	permutate("0" + binaryString, iterations-1, inputArray);//recursively permutate the binaryString
	    	permutate("1" + binaryString, iterations-1, inputArray);//recursively permutate the binaryString
	    }//end of else
	}//End of permutate method
}//end of PartitionBrute Class
