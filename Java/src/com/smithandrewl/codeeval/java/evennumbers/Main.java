package com.smithandrewl.codeeval.java.evennumbers;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                int number = Integer.parseInt(line);

                String result = number % 2 == 0 ? "1" : "0";

                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
}
