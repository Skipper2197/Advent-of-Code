package day2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static ArrayList<String> passwords = new ArrayList<String>();
	
	public static void main(String[] args) {
		readFile("src/day2/input.txt");
		/* Part One
		int valid = 0;
		for(String s : passwords) {
			String[] stuff = s.split(" ");
			String[] minMax = stuff[0].split("-");
			int min = Integer.parseInt(minMax[0]);
			int max = Integer.parseInt(minMax[1]);
			char letter = stuff[1].charAt(0);
			
			int count = 0;
			for(char c : stuff[2].toCharArray()) {
				if(c == letter) {
					count++;
				}
			}
			if(count >= min && count <= max) {
				valid++;
			}
		}
		System.out.println(valid);
		 */
		
		int valid = 0;
		for(String s : passwords) {
			String[] stuff = s.split(" ");
			String[] minMax = stuff[0].split("-");
			int pos1 = Integer.parseInt(minMax[0]);
			int pos2 = Integer.parseInt(minMax[1]);
			char letter = stuff[1].charAt(0);
			
			if(stuff[2].charAt(pos1-1) == letter ^ stuff[2].charAt(pos2-1) == letter) {
				valid++;
			}
		}
		System.out.println(valid);
	}

    public static void readFile(String fileName) {
        try {
            File inputFile = new File(fileName);
            Scanner myScanner = new Scanner(inputFile);
            while(myScanner.hasNextLine()) {
                String password = myScanner.nextLine();
                passwords.add(password);
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }


}
