import java.util.*;
import java.io.*;

class Main {

    public static ArrayList<Integer> input = new ArrayList<Integer>();

    public static void main(String[] args) {
        readFile("input.txt");
    }

    public static void readFile(String fileName) {
        try {
            File inputFile = new File(fileName);
            Scanner myScanner = new Scanner(inputFile);
            while(myScanner.hasNextLine()) {
                String number = myScanner.nextLine();
                input.add(int.parse);
                System.out.println(number);
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Something went wrong");
        }
    }
}

