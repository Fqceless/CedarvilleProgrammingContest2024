package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class trainpassengers {

	public static void main(String[] args) throws FileNotFoundException {
		//File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\trainpassengersinput.txt");
		//Scanner read = new Scanner(in);
		Scanner read = new Scanner(System.in);
		
		int capacity = read.nextInt();
		int rows = read.nextInt();
		read.nextLine();
		
		int currPassengers = 0;
		int waiting = 0;
		boolean isImpossible = false;
		
		while(read.hasNext()) {
			int leaving = read.nextInt();
			int entering = read.nextInt();
			waiting = read.nextInt();
			read.nextLine();
			
			if(leaving > currPassengers) {
				isImpossible = true;
				break;
			}
			
			currPassengers = currPassengers + entering - leaving;
			if(currPassengers > capacity || currPassengers < 0 || (waiting > 0 && currPassengers < capacity)) {
				isImpossible = true;
				break;
			}
		}
		
		if(currPassengers > 0 || waiting > 0) {
			isImpossible = true;
		}
		
		if(isImpossible) {
			System.out.println("impossible");
		}
		else {
			System.out.println("possible");
		}
	}
}
