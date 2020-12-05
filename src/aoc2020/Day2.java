package aoc2020;

import java.util.ArrayList;

public class Day2 extends AOCPuzzle{
	
	public Day2() {
		super(2);
	}

	@Override
	public void solvePuzzle(ArrayList<String> input) {
		// TODO Auto-generated method stub
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
		for(String s : input) {
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

}
