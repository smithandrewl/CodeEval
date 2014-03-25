package com.smithandrewl.codeeval.java.longestword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
  CHALLENGE DESCRIPTION:

    In this challenge you need to find the longest word in a sentence. If the sentence has more than one word of the same length you should pick the first one.

  INPUT SAMPLE:

    Your program should accept as its first argument a path to a filename. Input example is the following

    some line with text
    another line
    Each line has one or more words. Each word is separated by space char.

  OUTPUT SAMPLE:

    Print the longest word in the following way.

    some
    another
 */
public class Main {
    public static void main(String[] args) {

        String filename = args[0];

        try {
            Scanner scanner = new Scanner(new FileInputStream(filename));

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                System.out.println(longestWord(line.split(" ")));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file " + filename);
        }

    }

    public static String longestWord(String[] words) {
        int longest      = 0;
        int longestIndex = 0;
        int current;

        for (int i = 0; i < words.length; i++) {
            current = words[i].length();

            if (current > longest) {
                longest      = current;
                longestIndex = i;
            }
        }

        return words[longestIndex];
    }
}
