package turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        TurtleInterpreter interpreter;
        Scanner input;
        PrintStream output;
        switch (args.length){
            case 2:
                File inputFile1 = new File(args[0]);
                input = new Scanner(inputFile1);
                File outputFile = new File(args[1]);
                output = new PrintStream(outputFile);
                break;
            case 1:
                File inputFile2 = new File(args[0]);
                input = new Scanner(inputFile2);
                output = new PrintStream(System.out);
                break;
            case 0:
                input = new Scanner(System.in);
                output = new PrintStream(System.out);
                break;
            default:
                throw new RuntimeException("Invalid arguments");
        }
        new TurtleInterpreter(input, output);
    }
}
