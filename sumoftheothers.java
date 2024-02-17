package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class sumoftheothers {

	public static void main(String[] args) throws FileNotFoundException {
		//File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\sumoftheothersinput.txt");
		//Scanner read = new Scanner(in);
		Scanner read = new Scanner(System.in);

		while(read.hasNext()) {
			String line = read.nextLine();
			String[] nums = line.split(" ");
			ArrayList<Integer> numList = new ArrayList<>(); 
			for(int i = 0; i < nums.length; i++) {
				numList.add(Integer.parseInt(nums[i]));
			}
			
			for(int i = 0; i < numList.size(); i++) {
				int currNum = numList.get(i);
				int sum = 0;
				for(int j = 0; j < numList.size(); j++) {
					if(i != j) {
						sum += numList.get(j);
					}
				}
				if(sum == currNum) {
					System.out.println(currNum);
					break;
				}
			}
			
		}
	}

}
