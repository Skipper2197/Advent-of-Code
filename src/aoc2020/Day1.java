package aoc2020;

import java.util.ArrayList;

public class Day1 extends AOCPuzzle {

	public Day1() {
		super(1);
	}

	@Override
	public void solvePuzzle(ArrayList<String> input) {
		findSumOfTwo(input, 2020);
        findSumOfThree(input, 2020);
		
	}
	
    public static void findSumOfTwo(ArrayList<String> inputString, int target) {
    	ArrayList<Integer> input = convertToInt(inputString);
    	int multOfSum = 0;
    	int startPos = 0;
    	while(startPos < input.size()) {
    		for(int i = startPos+1; i < input.size(); i++) {
    			//System.out.println(input.get(startPos) + " " + input.get(i));
    			if(input.get(startPos) + input.get(i) == target) {
    				System.out.println( input.get(startPos) + " " + input.get(i));
    				multOfSum = input.get(startPos)*input.get(i);
    				System.out.println(multOfSum);
    				break;
    			}
    		}
    		startPos++;
    		//System.out.println(multOfSum);
    	}
    	
    }
    
    public static void findSumOfThree(ArrayList<String> inputString, int target) {
    	ArrayList<Integer> input = convertToInt(inputString);
    	int multOfSum = 0;
    	for(int i = 0; i < input.size(); i++) {
    		for(int j = i+1; j < input.size(); j++) {
    			for(int k = j+1; k < input.size(); k++) {
    				if(input.get(i) + input.get(j) + input.get(k) == target) {
    					multOfSum = input.get(i) * input.get(j) * input.get(k);
    					System.out.println(input.get(i) + " " + input.get(j) + " " + input.get(k));
    					System.out.println(multOfSum);
    				}
    			}
    		}
    	}
    	
    }
    
    private static ArrayList<Integer> convertToInt(ArrayList<String> input){
    	ArrayList<Integer> result = new ArrayList<Integer>();
        for(String s : input) {
            try {
                result.add(Integer.parseInt(s));
            } catch(Exception e) {
               e.printStackTrace();
            } 
        }       
        return result;

    }
	
}
