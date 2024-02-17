package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class abc {

	public static void main(String[] args) throws FileNotFoundException {
		//File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\abcinput.txt");
		//Scanner read = new Scanner(in);
		Scanner read = new Scanner(System.in);
		
		ArrayList<Integer> numList = new ArrayList<>();
		String order = "";
		
		numList.add(read.nextInt());
		numList.add(read.nextInt());
		numList.add(read.nextInt());
		
		read.nextLine();
		
		order = read.nextLine();
		
		numList.sort(null);
	
		System.out.println(numList.get(order.charAt(0) - 'A') + " " + numList.get(order.charAt(1) - 'A') + " " + numList.get(order.charAt(2) - 'A'));
		
		
		
		
	}

}
