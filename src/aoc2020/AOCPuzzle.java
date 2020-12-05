package aoc2020;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class AOCPuzzle {
	
	private static ArrayList<String> input = new ArrayList<String>();
	
	public AOCPuzzle(int day) {
		
		readFile("res/day" + day + ".txt");
		
		solvePuzzle(input);
		
	}
	
	public abstract void solvePuzzle(ArrayList<String> input);
	
    public static void readFile(String fileName) {
        try {
            File inputFile = new File(fileName);
            Scanner myScanner = new Scanner(inputFile);
            while(myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                input.add(line);
                //System.out.println(number);
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
    }

}
