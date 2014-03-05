package com.smithandrewl.codeeval.java.capitalizewords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));

            while(scanner.hasNextLine()) {
                String   line  = scanner.nextLine();
                String[] words = line.split(" ");

               for(int i = 0; i < words.length; i++) {
                   if(i != 0) {
                       System.out.print(" ");
                   }

                   System.out.print(capitalize(words[i]));
               }

               System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static String capitalize(String word) {
        char firstUpper = Character.toUpperCase(word.charAt(0));
        String rest = word.substring(1, word.length());
        return String.format("%c%s", firstUpper, rest);
    }
}
