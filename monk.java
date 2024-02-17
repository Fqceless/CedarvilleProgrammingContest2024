package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class monk {

	public static void main(String[] args) throws FileNotFoundException {
		//File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\monkinput.txt");
		//Scanner read = new Scanner(in);
		Scanner read = new Scanner(System.in);
		
		int numAscents = read.nextInt();
		int numDescents = read.nextInt();
		int ascentsTime = 0;
		int descentsTime = 0;
		int height = 0;
		
		ArrayList<ArrayList<Integer>> AscentsList = new ArrayList<>();
		ArrayList<ArrayList<Integer>> DescentsList = new ArrayList<>();
		
		for(int i = 0; i < numAscents; i++) {
			AscentsList.add(new ArrayList<>());
			int temp = read.nextInt();
			AscentsList.get(i).add(temp);
			height += temp;
			
			temp = read.nextInt();
			ascentsTime += temp;
			AscentsList.get(i).add(temp);
		}
		
		for(int i = 0; i < numDescents; i++) {
			DescentsList.add(new ArrayList<>());
			DescentsList.get(i).add(read.nextInt());
			
			int temp = read.nextInt();
			descentsTime += temp;
			DescentsList.get(i).add(temp);
		}
		
		int currAscent = 0;
		int currDescent = 0;
		int currAscentTime = 0;
		int currDescentTime = 0;
		int currAscentSegHeight = 0;
		int currDescentSegHeight = height;
		float currAscentHeight = 0;
		float currDescentHeight = height;
		float currAscentSlope = 0;
		float currDescentSlope = 0;
		for(int i = 0; i <= Math.min(ascentsTime, descentsTime); i++) {
			if(i >= currAscentTime) {
				currAscentTime += AscentsList.get(currAscent).get(1);
				currAscentSegHeight += AscentsList.get(currAscent).get(0);
				currAscentSlope = AscentsList.get(currAscent).get(0) / (float)currAscentTime;
				currAscent++;
			}
			if(i >= currDescentTime) {
				currDescentTime += DescentsList.get(currDescent).get(1);
				currDescentSegHeight -= DescentsList.get(currDescent).get(0);
				currDescentSlope = DescentsList.get(currDescent).get(0) / (float)currDescentTime;
				currDescent++;
			}
			
			currAscentHeight += currAscentSlope;
			currDescentHeight -= currDescentSlope;
			
			if(currAscentHeight >= currDescentHeight) {
				break;
			}
		}
		
		if(currAscentHeight == currDescentHeight) {
			System.out.println(Math.min((float)currAscentTime, (float)currDescentTime));
			return;
		}
		
		currAscent--;
		currDescent--;
		
		int ascentStartX = currAscentTime - AscentsList.get(currAscent).get(1);
		int descentStartX = currDescentTime - DescentsList.get(currDescent).get(1);
		int ascentStartY = currAscentSegHeight - AscentsList.get(currAscent).get(0);
		int descentStartY = currDescentSegHeight + DescentsList.get(currDescent).get(0);
		int ascentEndX = currAscentTime;
		int ascentEndY = ascentStartY + AscentsList.get(currAscent).get(0);
		int descentEndX = currDescentTime;
		int descentEndY = descentStartY - DescentsList.get(currDescent).get(0);
		
		float ascentSlope = (float)(ascentEndY - ascentStartY) / (float)(ascentEndX - ascentStartX);
		float descentSlope = (float)(descentEndY - descentStartY) / (float)(descentEndX - descentStartX);
		
		float ascentIntercept = ascentStartY - ascentSlope * ascentStartX;
		float descentIntercept = descentStartY - descentSlope * descentStartX;
		
		float intercept = (descentIntercept - ascentIntercept) / (ascentSlope - descentSlope);
		
		System.out.println(Math.abs(intercept));
		

	}

}
