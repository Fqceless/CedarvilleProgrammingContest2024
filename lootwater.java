package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class lootwater {

	public static void main(String[] args) throws FileNotFoundException {
		//File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\lootwaterinput.txt");
		//Scanner read = new Scanner(in);
		Scanner read = new Scanner(System.in);
		
		int numHeads = read.nextInt();
		int numKnights = read.nextInt();
		
		while(numHeads != 0 && numKnights != 0) {
			ArrayList<Integer> headsList = new ArrayList<>();
			ArrayList<Integer> knightsList = new ArrayList<>();
			
			for(int i = 0; i < numHeads; i++) {
				headsList.add(read.nextInt());
			}
			for(int i = 0; i < numKnights; i++) {
				knightsList.add(read.nextInt());
			}
			
			headsList.sort(null);
			knightsList.sort(null);

			boolean isDone = false;
			int currHead = 0;
			int currKnight = 0;
			int gold = 0;
			
			while(!isDone) {
				if(currHead >= headsList.size()) {
					System.out.println(gold);
					isDone = true;
					break;
				}
				else if(currKnight >= knightsList.size()) {
					System.out.println("Loowater is doomed!");
					isDone = true;
					break;
				}
				
				if(headsList.get(currHead) <= knightsList.get(currKnight)) {
					gold += knightsList.get(currKnight);
					currKnight++;
					currHead++;
				}
				else {
					currKnight++;
				}
			}
			numHeads = read.nextInt();
			numKnights = read.nextInt();
		}
	}
}
