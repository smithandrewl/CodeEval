package com.smithandrewl.codeeval.java.multiplylists;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));

            while(scanner.hasNextLine()) {
                processLine(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    public static void processLine(String line) {
        // Break the line into left and right chunks
        String[] pieces = line.split(Pattern.quote(" | "));

        // Break each chunk into an array of numeric Strings
        String[] leftNumbers = pieces[0].split(" ");
        String[] rightNumbers = pieces[1].split(" ");

        // For each pair of numeric Strings, convert them to numbers,
        // multiply them and print them
        for(int i = 0; i < leftNumbers.length; i++) {
            // Add the space between the numbers
            if(i != 0) {
                System.out.print(" ");
            }

            int first  = Integer.parseInt(leftNumbers[i]);
            int second = Integer.parseInt(rightNumbers[i]);

            System.out.print(first * second);
        }

        System.out.println();
    }
}
