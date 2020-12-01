package day1;

import java.util.*;
import java.io.*;

public class Main {

    public static ArrayList<Integer> input = new ArrayList<Integer>();

    public static void main(String[] args) {
        readFile("src/day1/input.txt");
        //findSumOfTwo(input, 2020);
        findSumOfThree(input, 2020);
    }

    public static void readFile(String fileName) {
        try {
            File inputFile = new File(fileName);
            Scanner myScanner = new Scanner(inputFile);
            while(myScanner.hasNextLine()) {
                String number = myScanner.nextLine();
                input.add(Integer.parseInt(number));
                //System.out.println(number);
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    
    public static void findSumOfTwo(ArrayList<Integer> input, int target) {
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
    
    public static void findSumOfThree(ArrayList<Integer> input, int target) {
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
 }


