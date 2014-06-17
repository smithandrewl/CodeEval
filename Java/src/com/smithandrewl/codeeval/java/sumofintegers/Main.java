package com.smithandrewl.codeeval.java.sumofintegers;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));

            int sum = 0;

            while(scanner.hasNext()) {
                sum += Integer.parseInt(scanner.nextLine());
            }

            System.out.println(sum);

        } catch(FileNotFoundException e) {
            System.err.printf("Could not open %s", args[0]);
        }
    }
}
