package aoc2020;

import java.util.ArrayList;
import java.util.HashSet;

public class Day6 extends AOCPuzzle {

	public Day6() {
		super(6);
	}

	@Override
	public void solvePuzzle(ArrayList<String> input) {
		// TODO Auto-generated method stub
		ArrayList<String> f = new ArrayList<String>();
		String temp = "";
		boolean isNotFirst = false;
		for(String s : input) {
			if(s.equals("")) {
				f.add(temp);
				temp = "";
				isNotFirst = false;
			} else {
				if(isNotFirst) {
					temp += " " + s;
				} else {
					temp += s;
					isNotFirst = true;
				}
				
			}
		}
		f.add(temp);
		
		/* Part 1
		int yesQuestions = 0;
		for(String s : f) {
			String[] people = s.split(" ");
			HashSet<String> yesAnswers = new HashSet<String>();
			for(String a : people) {
				for(int i = 0; i < a.length(); i++) {
					yesAnswers.add(a.charAt(i)+"");
				}
				
			}
			yesQuestions += yesAnswers.size();
		}
		System.out.println(yesQuestions);
		*/
		
		int allYes = 0;
		for(String s : f) {
			String[] people = s.split(" ");
			boolean first = true;
			ArrayList<String> yesAnswersAll = new ArrayList<String>();
			for(String a : people) {
				if(first) {
					for(int i = 0; i < a.length(); i++) {
						yesAnswersAll.add(a.charAt(i) + "");
					}
				} else {
					
					for(int i = yesAnswersAll.size()-1; i >= 0; i--) {
						boolean contains = false;
						for(int j = 0; j < a.length(); j++) {
							if(yesAnswersAll.get(i).equals(a.charAt(j)+"")) {
								contains = true;
							}
						}
						if(!contains) {
							yesAnswersAll.remove(i);
						}
					}
				}
				first = false;
			}
			allYes += yesAnswersAll.size(); 
		}
		System.out.println(allYes);
		
	}
		

}
