package day5;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	
	public static ArrayList<String> boardingPasses = new ArrayList<String>();
	
	public static ArrayList<Integer> IDs = new ArrayList<Integer>();

	public static void main(String[] args) {
		readFile("src/day5/input.txt");
		//readFile("src/day5/testInput.txt");
		int maxID = 0;
		for(String s : boardingPasses) {
			int ID = (getRow(s) * 8) + getCol(s);
			IDs.add(ID);
			if(maxID < ID) {
				maxID = ID;
			}
		}
		System.out.println(maxID);
		
		int lastID = -1;
		IDs.sort(Integer::compareTo);
		for(int ID : IDs) {
			if(ID - lastID == 2 && lastID != -1) {
				System.out.println(ID-1);
				break;
			}
			lastID = ID;
		}
	}
	
	public static int getRow(String pass) {
		String binary = "";
		char[] passArr = pass.toCharArray();
		for(int i = 0; i < passArr.length-3; i++) {
			if(passArr[i] == 'F') {
				binary += "0";
			} else {
				binary += "1";
			}
		}
		//System.out.println(Integer.parseInt(binary, 2));
		return Integer.parseInt(binary, 2);
	}
	
	public static int getCol(String pass) {
		String binary = "";
		char[] passArr = pass.toCharArray();
		for(int i = passArr.length-3; i < passArr.length; i++) {
			if(passArr[i] == 'L') {
				binary += "0";
			} else {
				binary += "1";
			}
		}
		//System.out.println(Integer.parseInt(binary, 2));
		return Integer.parseInt(binary, 2);
	}
	
	public static void readFile(String fileName) {
        try {
            File inputFile = new File(fileName);
            Scanner myScanner = new Scanner(inputFile);
            String passport = "";
            while(myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                boardingPasses.add(line);
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
	
}
