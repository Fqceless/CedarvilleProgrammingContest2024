package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ada {

	public static void main(String[] args) throws FileNotFoundException {
		//File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\adainput.txt");
		//Scanner read = new Scanner(in);
		Scanner read = new Scanner(System.in);
		
		int length = read.nextInt();
		ArrayList<ArrayList<Integer>> numList = new ArrayList<>();
		numList.add(new ArrayList<>());
		
		while(read.hasNext()) {
			numList.get(0).add(read.nextInt());
		}
		
		boolean isDone = false;
		int level = 0;
		int prevNum = Integer.MAX_VALUE;
		int currNum = Integer.MIN_VALUE;
		while(!isDone) {
			isDone = true;
			numList.add(new ArrayList<>());
			for(int i = 0; i < length - 1; i++) {
				numList.get(level + 1).add(numList.get(level).get(i + 1) - numList.get(level).get(i));
				currNum = numList.get(level).get(i + 1) - numList.get(level).get(i);
				
				if(currNum != prevNum && i > 0) {
					isDone = false;
				}
				prevNum = currNum;
			}
			level++;
			length--;
		}
		
		int ret = currNum;
		for(int i = numList.size() - 2; i >= 0; i--) {
			int currLength = numList.get(i).size();
			ret = numList.get(i).get(currLength - 1) + ret;
		}
		
		System.out.println(level + " " + ret);
		
	}

}
