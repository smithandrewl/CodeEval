package com.smithandrewl.codeeval.java.swapcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));

            while(scanner.hasNextLine()) {
                System.out.println(processLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    public static String processLine(String line) {
        StringBuilder builder = new StringBuilder(line.length());

        for(char chr : line.toCharArray()) {

            char res;

            if(Character.isUpperCase(chr)) {
                res = Character.toLowerCase(chr);
            } else if (Character.isLowerCase(chr)) {
                res = Character.toUpperCase(chr);
            } else {
                res = chr;
            }

            builder.append(res);
        }

        return builder.toString();
    }

}
