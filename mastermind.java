package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mastermind {

	public static void main(String[] args) throws FileNotFoundException {
		//File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\mastermindinput.txt");
		//Scanner read = new Scanner(in);
		Scanner read = new Scanner(System.in);
		
		int length = read.nextInt();
		String word = read.next();
		String guess = read.next();
		int r = 0;
		int s = 0;
		char[] letter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		for(int i = 0; i < length; i++) {
			char currWordChar = word.charAt(i);
			char currGuessChar = guess.charAt(i);
			
			if(currWordChar == currGuessChar) {
				word = word.substring(0, i) + word.substring(i + 1);
				guess = guess.substring(0, i) + guess.substring(i + 1);
				r++;
				length--;
				i--;
			}
		}
		
		int wordCount = 0;
		int guessCount = 0;
		for(char c : letter) {
			for(int i = 0; i < length; i++) {
				if(word.charAt(i) == c) {
					wordCount++;
				}
				if(guess.charAt(i) == c) {
					guessCount++;
				}
			}
			s += wordCount < guessCount ? wordCount : guessCount;
			wordCount = 0;
			guessCount = 0;
		}
		
		
		
		System.out.println(r + " "+ s);
		
	}

}
