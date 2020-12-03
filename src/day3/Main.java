package day3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static ArrayList<String> input = new ArrayList<String>();
	
	public static void main(String[] args) {
		readFile("src/day3/input.txt");
		
		char[][] map = new char[323][31];
		
		for(int i = 0; i < map.length; i++) {
			String line = input.get(i);
			char[] chars = line.toCharArray();
			for(int j = 0; j < chars.length; j++) {
				map[i][j] = chars[j];
			}
		}
		
		System.out.println(countTrees(1, 1, map) + " " + countTrees(3, 1, map) + " " + countTrees(5, 1, map) + " " + countTrees(7, 1, map) + " " + countTrees(1, 2, map));
		
		long total = countTrees(1, 1, map);
		total *= countTrees(3, 1, map);
		total *= countTrees(5, 1, map);
		total *= countTrees(7, 1, map);
		total *= countTrees(1, 2, map);
		
		System.out.println(total);
	}
	
	public static int countTrees(int slopeX, int slopeY, char[][] map) {
		int x = 0;
		int y = 0;
		
		int trees = 0;
		
		while(y < map.length) {
			char pos = map[y][x];
			
			if(pos == '#') {
				trees++;
			}
			
			//keeps the x in bounds of map to have sudo map extension
			x = (x + slopeX) % map[0].length;
			y += slopeY;
		}
		return trees;
	}
	
	 public static void readFile(String fileName) {
	        try {
	            File inputFile = new File(fileName);
	            Scanner myScanner = new Scanner(inputFile);
	            while(myScanner.hasNextLine()) {
	                String line = myScanner.nextLine();
	                input.add(line);
	            }
	        } catch (Exception e) {
	            //TODO: handle exception
	            e.printStackTrace();
	        }
	    }

}
