package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class yoda {

	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\yodainput.txt");
		Scanner read = new Scanner(in);
		//Scanner read = new Scanner(System.in);
		
		int num1 = read.nextInt();
		int num2 = read.nextInt();
		String num1leftovers = "";
		String num2leftovers = "";
		
		while(num1 > 0 && num2 > 0) {
			int num1mod = num1 % 10;
			int num2mod = num2 % 10;
			
			if(num1mod > num2mod) {
				num1leftovers = num1mod + num1leftovers;
			}
			else if(num2mod > num1mod) {
				num2leftovers = num2mod + num2leftovers;
			}
			else {
				num1leftovers = num1mod + num1leftovers;
				num2leftovers = num2mod + num2leftovers;
			}
			
			num1 /= 10;
			num2 /= 10;
		}
		
		String num1final = num1 + num1leftovers;
		String num2final = num2 + num2leftovers;
		
		if(num1leftovers.equals("") && num1 == 0) {
			System.out.println("YODA");
		}
		else {
			System.out.println(Integer.parseInt(num1final));
		}
			
		if(num2leftovers.equals("") && num2 == 0) {
			System.out.println("YODA");
		}
		else {
			System.out.println(Integer.parseInt(num2final));
		}
		
		
	}

}
