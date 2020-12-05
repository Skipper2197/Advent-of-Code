package aoc2020;

import java.util.ArrayList;

public class Day4 extends AOCPuzzle {
	
	public Day4( ) {
		super(4);
	}

	@Override
	public void solvePuzzle(ArrayList<String> input) {
		// TODO Auto-generated method stub
		ArrayList<String> passports = new ArrayList<String>();
		String temp = "";
		boolean isNotFirst = false;
		for(String s : input) {
			if(s.equals("")) {
				passports.add(temp);
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
		int valid = 0;
		for(String s : passports) {
			//System.out.println(s);
			//System.out.println();
			String[] passportParts = s.split(" ");
			//System.out.println(passportParts.length);
			if(passportParts.length == 8 && allAreValid(passportParts)) {
				valid++;
			} else if(passportParts.length == 7 && onlyMissingCID(passportParts) && allAreValid(passportParts)) {
				valid++;
			}
		}
		System.out.println(++valid);
		
	}
	
	public static boolean allAreValid(String[] passportParts) {
		int validCount = 0;
		for(String s : passportParts) {
			String id = s.substring(0,3);
			String value = s.substring(4);
			System.out.println(id + " " + value);
			switch(id) {
			case "byr":
				int year = Integer.parseInt(value);
				if(value.length() == 4 && year >= 1920 && year <= 2002) {
					validCount++;
					
				}
				break;
			case "iyr":
				int year2 = Integer.parseInt(value);
				if(value.length() == 4 && year2 >= 2010 && year2 <= 2020) {
					validCount++;
					
				}
				break;
			case "eyr":
				int year3 = Integer.parseInt(value);
				if(value.length() == 4 && year3 >= 2020 && year3 <= 2030) {
					validCount++;
					
				}
				break;
			case "hgt":
				int numLength = value.length()-2;
				boolean isCM = value.substring(numLength).equals("cm");
				//System.out.println(isCM);
				if(value.substring(0, numLength).equals("")) {
					break;
				}
				int num = Integer.parseInt(value.substring(0, numLength));
				//System.out.println(num);
				if(isCM && num >= 150 && num <= 193) {
					validCount++;
					
				} else if(!isCM && num >= 59 && num <= 76) {
					validCount++;
					
				}
				break;
			case "hcl":
				boolean valid = true;
				String value2 = value.substring(1);
				if(value.substring(0,1).equals("#") && value2.toCharArray().length == 6) {
					for(char c : value2.toCharArray()) {
						if(Character.digit(c, 16) == -1) {
							valid = false;
							break;
						}
					}
					if(valid) {
						validCount++;
						
					}
				}
				break;
			case "ecl":
				if(value.equals("amb") || value.equals("blu") || value.equals("brn") || value.equals("gry") || value.equals("grn") || value.equals("hzl") || value.equals("oth")) {
					validCount++;
					
				}
				break;
			case "pid":
				if(value.length() == 9 && value.matches("[0-9]+")) {
					validCount++;
					
				}
				break;
			case "cid":
				validCount++;
				break;
			}
		}
		return validCount == passportParts.length;
	}
	
	public static boolean onlyMissingCID(String[] passportParts) {
		for(String s : passportParts) {
			String id = s.substring(0,3);
			if(id.equals("cid")) {
				return false;
			}
		}
		return true;
	}

}
