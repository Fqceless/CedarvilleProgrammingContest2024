package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mixedfractions {

	public static void main(String[] args) throws FileNotFoundException {
		//File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\mixedfractionsinput.txt");
		//Scanner read = new Scanner(in);
		Scanner read = new Scanner(System.in);
		int num1 = read.nextInt();;
		int num2 = read.nextInt();;
		
		while(num1 != 0 && num2 != 0) {
			System.out.println(num1/num2 + " " + num1%num2 + " / " + num2);
			
			num1 = read.nextInt();
			num2 = read.nextInt();
		}
		
	}

}
