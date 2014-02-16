package com.smithandrewl.codeeval.java.decimaltobinary;

import java.io.*;

/*
DECIMAL TO BINARY
    Given a decimal (base 10) number, print out its binary representation.
INPUT SAMPLE:
    Your program should accept as its first argument a path to a filename
    containing whole decimal numbers greater or equal to 0, one per line.
    Ignore all empty lines. E.g.

    2
    10
    67
OUTPUT SAMPLE:
    Print the binary representation, one per line. E.g.

    10
    1010
    1000011
 */
public class Main {
    public static String decimalToBinary(int number) {
        if (number == 0) return "0";

        StringBuilder result = new StringBuilder();

        int num = number;

        while(num > 0) {
            result.append(num % 2);
            num /= 2;
        }

        // It is faster to reverse the string than to insert at the front
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;

            while ((line = in.readLine()) != null) {
                if (line.length() > 0) {
                    int number = Integer.parseInt(line);
                    System.out.println(decimalToBinary(number));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file");
        }
    }
}
