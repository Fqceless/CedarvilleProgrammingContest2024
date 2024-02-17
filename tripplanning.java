package progContest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class tripplanning {

	public static void main(String[] args) throws FileNotFoundException {
		//File in = new File("C:\\Users\\clafa\\eclipse-workspace2\\ProgContest\\src\\progContest\\tripplanninginput.txt");
		//Scanner read = new Scanner(in);
		Scanner read = new Scanner(System.in);
		int numCities = read.nextInt();
		int numRows = read.nextInt();
		int rowIndex = 0;
		HashMap<String, Integer> roadsMap = new HashMap<>();
		
		while(read.hasNext()){
			int city1 = read.nextInt();
			int city2 = read.nextInt();
			rowIndex++;
			
			if(city1 < city2) {
				roadsMap.put(city1 + "-" + city2, rowIndex);
			}
			else {
				roadsMap.put(city2 + "-" + city1, rowIndex);
			}
		}
		
		ArrayList<Integer> path = new ArrayList<>();
		
		for(int i = 1; i < numCities; i++) {
			if(roadsMap.containsKey(i + "-" + (i+1))) {
				path.add(roadsMap.get(i + "-" + (i+1)));
			}
		}
		
		if(roadsMap.containsKey(1 + "-" + numCities)) {
			path.add(roadsMap.get(1 + "-" + numCities));
		}
		
		if(path.size() == numCities) {
			for(Integer i : path) {
				System.out.println(i);
			}
		}
		else {
			System.out.println("impossible");
		}
		
	}
}
