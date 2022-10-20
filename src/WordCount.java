import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) throws Exception {
        System.out.println("\n"
                + "Welcome to the word counter program!\nThis program can count words in an input file and write the results to an output file."
                + "\n");
        System.out.println("Please specify the name of your input file without a file extension." + "\n");
        System.out.print(">");
        Scanner inputScanner = new Scanner(System.in);
        String inputName = inputScanner.next();

        TreeMap<String, Integer> tree_map = new TreeMap<String, Integer>();
        try {
            File inputFile = new File(inputName + ".txt");
            Scanner fileScanner = new Scanner(inputFile);
            while (fileScanner.hasNextLine()) {
                String myString = fileScanner.nextLine();
                tree_map.put(myString, tree_map.getOrDefault(myString, 0) + 1);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("\n" + "An error has occurred. Please check your input file and try again.");
            e.printStackTrace();
        }
        System.out.println("\n" + "Words from input file: " + tree_map);
        try {
            System.out.println("\n" + "Please specify the name of your output file without a file extension.");
            System.out.print("\n" + ">");
            String outputName = inputScanner.next();
            File outputFile = new File(outputName + ".txt");
            if (outputFile.createNewFile()) {
                System.out.println("\n" + "File created: " + outputName + ".txt");
            } else {
                System.out.println("\n" + "File already exists.");
            }
            inputScanner.close();
        } catch (IOException e) {
            System.out.println("\n" + "An error has occurred. Please check your output file name and try again.");
            e.printStackTrace();
        }
        System.out.println("\n" + "Thank you for using the word counter tool. Goodbye!");
    }
}