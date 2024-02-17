package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class iboard {

	public static void main(String[] args) throws FileNotFoundException {
		//File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\iboardinput.txt");
		//Scanner read = new Scanner(in);
		Scanner read = new Scanner(System.in);
		
		while(read.hasNext()) {
			String line = read.nextLine();
			int zeros = 0;
			int ones = 0;
			for(char c : line.toCharArray()) {
				String binary = Integer.toBinaryString((int)c);
				for(char b : binary.toCharArray()) {
					if(b == '0') {
						zeros++;
					}
					else {
						ones++;
					}
				}
				zeros += 7 - binary.length();
			}
			if(zeros % 2 == 0 && ones % 2 == 0) {
				System.out.println("free");
			}
			else {
				System.out.println("trapped");
			}
		}
	}
}
