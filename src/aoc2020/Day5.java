package aoc2020;

import java.util.ArrayList;

public class Day5 extends AOCPuzzle {
	
	public Day5() {
		super(5);
	}

	@Override
	public void solvePuzzle(ArrayList<String> input) {
		// TODO Auto-generated method stub
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		int maxID = 0;
		for(String s : input) {
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

}
