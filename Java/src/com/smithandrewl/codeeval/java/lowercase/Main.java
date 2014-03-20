package com.smithandrewl.codeeval.java.lowercase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filename = args[0];

        try {
            Scanner scanner = new Scanner(new FileInputStream(filename));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line.toLowerCase());
            }

        } catch(FileNotFoundException e) {
            System.err.printf("File %s not found", filename);
        }
    }

}
