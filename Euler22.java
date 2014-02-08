package net.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * @author Brian
 * Project Euler Problem 22 : Names Scores
 * a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its 
 * alphabetical position in the list to obtain a name score.
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 * What is the total of all the name scores in the file?
 */
public class NamesScores {
	public static void main(String[] args) throws IOException {
		FileReader inFile = new FileReader("names.txt");
		BufferedReader in = new BufferedReader(inFile);
		String line = in.readLine();
		String[] temp = line.split("^\"|(\",\")|(\"$)");//remove begin and end quotes and "," between names
		List<String> list = new ArrayList<String>();
		for(int i=1; i<temp.length; i++)//store name into dynamic array list
			list.add(temp[i]);
		Collections.sort(list);//sort the list
		int sum=0;
		//calculate the point of the name and multiply by location of the name
		for(int i=0;i<list.size(); i++)
			sum+= nameScore(list.get(i)) *(i+1);
		System.out.println(sum);
	}//main
	
	public static int nameScore(String name){
		int score=0;
		for(int i=0; i<name.length();i++)
			score+=name.charAt(i)-64;//calculate the num of the letter in alphabet
		return score;
	}//nameScore Method
}//NamesScores class
